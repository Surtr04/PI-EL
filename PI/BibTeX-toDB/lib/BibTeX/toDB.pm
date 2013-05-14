package BibTeX::toDB;

use 5.016002;
use strict;
use warnings;
use DBI;
use File::Slurp;
use Data::Dumper;
use utf8::all;
use BibTeX::Parser;
use IO::File;

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
		bibfile => read_file($bibfile, array_ref => 1),
		database => DBI->connect($database,$user,$pass,{RaiseError => 1, AutoCommit => 1, mysql_auto_reconnect => 1}),				
		parsedInfo => {},
		allInfo => {},		
	};	

	bless $self,$class;

	return $self;
}

sub processAll {

	my ($self) = @_;	
	my @bib = @{$self->{bibfile}};	
	my $found = 0;	
			
	foreach(@bib) {



	}


}


sub parse {

	my ($self,$bibtype) = @_;		
	if ($bibtype eq "article") {
		parseArticle($self);		
	}
	if ($bibtype eq "techreport") {
		parseReport($self);		
	}

	if ($bibtype eq "inproceedings") {
		parseInproceedings($self);		
	}

				
			
}

sub trim {

	my $str = shift;

	$str =~ s/^\s+//;
	$str =~ s/\s+$//;

	return $str;
}


sub parseArticle {
	
	my ($self) = @_;	
	my @bib = @{$self->{bibfile}};	
	my $found = 0;	
			
		my @authors;				
		my $title;
		my $journal;
		my $year;
	
	foreach (@bib) {										
		
		$found = 1 if $_ =~ /\@article.*/;
		
		if($found) {

			if ($_ =~ m/^\}$/) {
				$found = 0;
				$self->{entries} += 1;
				foreach (@authors) {
					if (!defined $self->{parsedInfo}->{$_}) {
						$self->{parsedInfo}->{$_} = [];
						push $self->{parsedInfo}->{$_}, ["article",$title, $journal,$year];
					}
					else {
						push $self->{parsedInfo}->{$_}, ["article",$title, $journal,$year];	
					}
				}

				for my $i (0 .. $#authors) {
					delete $authors[$i];
				}					
			}				

			if ($_ =~ /author\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {																				
				my @tmp = split /and/, $1;

				for my $name (@tmp) {
					push @authors, trim($name);				
				}								
			}

			if ($_ =~ /title\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$title = $1;
			}

			if ($_ =~ /journal\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$journal = $1;
			}

			#year = {num}
			if ($_ =~ /year\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$year = $1;
			}

			#year = num
			if ($_ =~ /year\s*=\s*(\d+)/) {				
				$year = $1;
			}									 						 				 		
			
		}		
	}

}






sub parseReport {
	
	my ($self) = @_;	
	my @bib = @{$self->{bibfile}};	
	my $found = 0;	
			
		my @authors;				
		my $title;
		my $institution;
		my $year;
	
	foreach (@bib) {										
		
		$found = 1 if $_ =~ /\@techreport.*/;
		
		if($found) {

			if ($_ =~ m/^\}$/) {
				$found = 0;
				$self->{entries} += 1;
				foreach (@authors) {
					if (!defined $self->{parsedInfo}->{$_}) {
						$self->{parsedInfo}->{$_} = [];
						push $self->{parsedInfo}->{$_}, ["report",$title, $institution,$year];
					}
					else {
						push $self->{parsedInfo}->{$_}, ["report",$title, $institution,$year];	
					}
				}

				for my $i (0 .. $#authors) {
					delete $authors[$i];
				}					
			}				

			if ($_ =~ /author\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {																				
				my @tmp = split /and/, $1;

				for my $name (@tmp) {
					push @authors, trim($name);				
				}								
			}

			if ($_ =~ /title\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$title = $1;
			}

			if ($_ =~ /institution\s*=\s*(?:\{|\")?(.*)(?:\}|\")?\,/) {				
				$institution = $1;
			}

			#year = {num}
			if ($_ =~ /year\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$year = $1;
			}

			#year = num
			if ($_ =~ /year\s*=\s*(\d+)/) {				
				$year = $1;
			}									 						 				 		
			
		}		
	}



}



sub parseInproceedings {
	
	my ($self) = @_;	
	my @bib = @{$self->{bibfile}};	
	my $found = 0;	
			
		my @authors;				
		my $title;
		my $booktitle;
		my $year;
		my $url;
	
	foreach (@bib) {										
		
		$found = 1 if $_ =~ /\@inproceedings.*/;
		
		if($found) {

			if ($_ =~ m/^\}$/) {
				$found = 0;
				$self->{entries} += 1;
				foreach (@authors) {
					if (!defined $self->{parsedInfo}->{$_}) {
						$self->{parsedInfo}->{$_} = [];
						push $self->{parsedInfo}->{$_}, ["inproceedings",$title, $booktitle,$year,$url];
					}
					else {
						push $self->{parsedInfo}->{$_}, ["inproceedings",$title, $booktitle,$year,$url];	
					}
				}

				for my $i (0 .. $#authors) {
					delete $authors[$i];
				}					
			}				

			if ($_ =~ /author\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {																				
				my @tmp = split /and/, $1;

				for my $name (@tmp) {
					push @authors, trim($name);				
				}								
			}

			if ($_ =~ /title\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$title = $1;
			}

			if ($_ =~ /booktitle\s*=\s*(?:\{|\")?(.*)(?:\}|\")?\,/) {				
				$booktitle = $1;
			}

			#year = {num}
			if ($_ =~ /year\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {				
				$year = $1;
			}

			#year = num
			if ($_ =~ /year\s*=\s*(\d+)/) {				
				$year = $1;
			}

			if ($_ =~ /url\s*=\s*(?:\"|\{)(.*)(?:\"|\})/) {
				$url = $1;
			}								 						 				 		
			
		}		
	}



}

sub insertDB {

	my ($self,$user) = @_;
	my $res = $self->{parsedInfo};
	my $dbh = $self->{database};
	my $found = 0;
	my $usr_id;


	for my $aut (keys $res) {
		if ($aut eq $user) {
			$found = 1;
			last;
		}
	}
	return NO_USER if not $found;


	my $sth = $dbh->prepare("select * from info where name = ?");
	$sth->bind_param(1,$user);
	$sth->execute;

	while (my @tmp = $sth->fetchrow_array()) {
		$usr_id = $tmp[0]; #fetch user id
	}
	$res = $res->{$user};
	my $id;

	foreach (@$res) {		
		my @arr = @$_;			
		if ($arr[0] eq 'article') {
			$sth = $dbh->prepare("insert into publications  (`type`, `title`, `journal`, `year`) values (?,?,?,?)");
			$sth->bind_param(1,$arr[0]);
			$sth->bind_param(2,$arr[1]);
			$sth->bind_param(3,$arr[2]);
			$sth->bind_param(4,$arr[3]);						
			$sth->execute;
			$id = $dbh->{ q{mysql_insertid}};

			$sth = $dbh->prepare("insert into users_publications values ($usr_id,$id)");
			$sth->execute;
		}


		if ($arr[0] eq 'inproceedings') {
			$sth = $dbh->prepare("insert into publications  (`type`, `title`, `year`, `booktitle`,`url`) values (?,?,?,?,?)");
			$sth->bind_param(1,$arr[0]);
			$sth->bind_param(2,$arr[1]);
			$sth->bind_param(3,$arr[3]);
			$sth->bind_param(4,$arr[2]);		
			$sth->bind_param(5,$arr[4]);						
			$sth->execute;
			$id = $dbh->{ q{mysql_insertid}};

			$sth = $dbh->prepare("insert into users_publications values ($usr_id,$id)");
			$sth->execute;
		}	

	}
	

	$dbh->disconnect;

	return SUCCESS;

}




# Preloaded methods go here.

1;
__END__
# Below is stub documentation for your module. You'd better edit it!

=head1 NAME

BibTeX::toDB - Perl extension for blah blah blah

=head1 SYNOPSIS

  use BibTeX::toDB;
  blah blah blah

=head1 DESCRIPTION

Stub documentation for BibTeX::toDB, created by h2xs. It looks like the
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
