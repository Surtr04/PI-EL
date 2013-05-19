package BibTeX::toDB2;

use 5.016002;
use strict;
use warnings;
use DBI;
use File::Slurp;
use Data::Dumper;
use utf8::all;
use BibTeX::Parser;
use IO::File;
use Data::Structure::Util qw ( unbless );


require Exporter;

use constant {
	NO_USER => 0,
	SUCCESS => 1,
};

our @ISA = qw(Exporter);
our %EXPORT_TAGS = ( 'all' => [ qw() ] );
our @EXPORT_OK = ( @{ $EXPORT_TAGS{'all'} } );
our @EXPORT = qw();
our $VERSION = '0.01';


sub new {

	my ($class,$bibfile,$database,$user,$pass) = @_;
	

	my $self = {
		entries => 0,
		bibfile => $bibfile,
		database => DBI->connect($database,$user,$pass,{RaiseError => 1, AutoCommit => 1, mysql_auto_reconnect => 1, mysql_enable_utf8 => 1}),				
		parsedInfo => {},		
	};	

	$self->{database}->do("set character set utf8");
	$self->{database}->do('SET NAMES utf8');

	bless $self,$class;

	return $self;
}

sub trim {

	my $str = shift;

	$str =~ s/^\s+//;
	$str =~ s/\s+$//;

	return $str;
}


sub parseBibTeX {

	my ($self) = @_;

	my $fh = IO::File->new($self->{bibfile});
	my $parser = BibTeX::Parser->new($fh);

	while (my $entry = $parser->next ) {
		if ($entry->parse_ok) {
			
			$self->{entries}++;
			
			$self->{parsedInfo}->{$entry->key} = {};
			$self->{parsedInfo}->{$entry->key}->{entryType} = $entry->type;
			
			my @authors = $entry->author;			

			foreach(@authors) {
				$_ = $_->to_string;				
			}

						
			@{$self->{parsedInfo}->{$entry->key}->{authors}} = @authors;
			
			$self->{parsedInfo}->{$entry->key}->{year} = $entry->field("year");

			my @fields = $entry->fieldlist;

			foreach(@fields) {
				if (not $_ eq "authors") {
             		$self->{parsedInfo}->{$entry->key}->{$_} = $entry->field($_);
             	}
			}

		}
	}

}


sub insertDB {

	my ($self,$user) = @_;
	my $res = $self->{parsedInfo};
	my $dbh = $self->{database};


	my $sth;
	my $id;
	my $field_id;
	my $records;

	for my $key (keys $res) {
		
		my $entry = $res->{$key};

		($records) = $dbh->selectrow_array("SELECT id FROM publications as p where p.key=\'$key\';");

		if(not $records) {
			$sth = $dbh->prepare("insert into publications  (`type`, `key`, `title`, `year`) values (?,?,?,?)");
			
			
			$sth->bind_param(1,$entry->{"entryType"});
			$sth->bind_param(2,$key);
			$sth->bind_param(3,$entry->{"title"});
			$sth->bind_param(4,$entry->{"year"});

			$sth->execute;
			$id = $dbh->{ q{mysql_insertid} };

			my $aut = $entry->{author};			
			my @authors = split /\band\b/, $aut;					
			
			foreach my $author (@authors) {
				$sth = $dbh->prepare("insert into nonusers_publications (`publications_id`, `name`) values (?,?)");		
				$sth->bind_param(1,$id);
				$sth->bind_param(2,trim $author);
				print $author."\n";
				print $id."\n";
				$sth->execute;
			}

		}
		else {
			$sth = $dbh->prepare("update publications as p set p.type=?, p.key=?, p.title=?, p.year=? where p.id=?;");
			
			$sth->bind_param(1,$entry->{"entryType"});		
			$sth->bind_param(2,$key);
			$sth->bind_param(3,$entry->{"title"});
			$sth->bind_param(4,$entry->{"year"});
			$sth->bind_param(5,$records);

			$sth->execute;
			$id = $dbh->{ q{mysql_insertid} };	
			
		}
		
		foreach my $field (keys $entry) {
			($records) = $dbh->selectrow_array("SELECT id FROM bibfields as b where b.key=\'$field\';");
			if(not $records) {
				$sth = $dbh->prepare("insert into bibfields  (`key`) values (?)");
				$sth->bind_param(1,$field);	
				$sth->execute;

				$field_id = $dbh->{ q{mysql_insertid} };
				
				$sth = $dbh->prepare("insert into publications_fields  (`publications_id`, `fields_id`,`value`) values (?,?,?)");
				$sth->bind_param(1,$id);
				$sth->bind_param(2,$field_id);
				$sth->bind_param(3,$entry->{$field});
				$sth->execute;
				
			}
			else {				
				
				($field_id) = $dbh->selectrow_array("SELECT id FROM bibfields as b where b.key = \'$field\';");
				my ($id_pf) = $dbh->selectrow_array("SELECT id FROM publications_fields as p where p.publications_id=\'$id\' and p.fields_id=\'$field_id\';");
				
				$sth = $dbh->prepare("update publications_fields as p set p.value=? where p.id = ?");			
				$sth->bind_param(1,$entry->{$field});
				$sth->bind_param(2,$id_pf);
				$sth->execute;

			}
		}

	}

	

}

1;
__END__
# Below is stub documentation for your module. You'd better edit it!

=head1 NAME

BibTeX::toDB2 - Perl extension for blah blah blah

=head1 SYNOPSIS

  use BibTeX::toDB2;
  blah blah blah

=head1 DESCRIPTION

Stub documentation for BibTeX::toDB2, created by h2xs. It looks like the
author of the extension was negligent enough to leave the stub
unedited.

Blah blah blah.

=head2 EXPORT

None by default.



=head1 SEE ALSO

Mention other useful documentation such as the documentation of
related modules or operating system documentation (such as man pages
in UNIX), or any relevant external documentation such as RFCs or
standards.

If you have a mailing list set up for your module, mention it here.

If you have a web site set up for your module, mention it here.

=head1 AUTHOR

Rui Brito, E<lt>rmb@sa.di.uminho.ptE<gt>

=head1 COPYRIGHT AND LICENSE

Copyright (C) 2013 by Rui Brito

This library is free software; you can redistribute it and/or modify
it under the same terms as Perl itself, either Perl version 5.16.2 or,
at your option, any later version of Perl 5 you may have available.


=cut
