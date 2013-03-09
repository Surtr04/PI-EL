package BibTeX::toDB;

use 5.016002;
use strict;
use warnings;
use DBI;
use encoding "iso 8859-1";

require Exporter;

our @ISA = qw(Exporter);
our %EXPORT_TAGS = ( 'all' => [ qw() ] );
our @EXPORT_OK = ( @{ $EXPORT_TAGS{'all'} } );
our @EXPORT = qw();
our $VERSION = '0.01';

sub new {

	my ($class,$bibfile,$database,$user,$pass) = @_;

	open FILE, "<", $bibfile;
	my @str;
	while (<FILE>) {
		chomp $_;
		push @str,$_ ;
	}

	my $self = {
		entries => 0,
		bibfile => \@str,
		database => DBI->connect($database,$user,$pass,{RaiseError => 1, AutoCommit => 0}),				
		parsedInfo => {},
	};

	bless $self,$class;

	return $self;
}


sub parse {

	my ($self,$bibtype) = @_;		
	if ($bibtype eq "article") {
		parseArticle($self);
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
	
		
		my $journal;
		my $year;	


	for my $line (@bib) {
		
		my @authors;	
		my $title;

		$found = 1 if $line =~ /\@article.*/;
		
		if($found) {

			if ($line =~ m/^\}$/) {
				$found = 0;
			}						
			if ($line =~ /author\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {																				
				my @tmp = split /and/, $1;

				for my $name (@tmp) {
					push @authors, trim($name);
				}				
				
			}

			if ($line =~ /title\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {
				$title = $1;
			}

			if ($line =~ /journal\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {
				$journal = $1;
			}

			if ($line =~ /year\s*=\s*(?:\{|\")(.*)(?:\}|\")/) {
				$year = $1;
			}

			for my $aut (@authors) {				
				$self->{parsedInfo}->{$aut} = $title;
			}
			
		}		
	}

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
