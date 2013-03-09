	
use strict;
use warnings;
use Data::Dumper;

use Test::More tests => 2;
#use BibTeX::toDB;
BEGIN { use_ok('BibTeX::toDB') };


my $f = BibTeX::toDB->new('jj.bib','DBI:mysql:sample','root','root');

is ($f->{entries},0,"entries test");

$f->parse("article");

print Dumper $f->{parsedInfo};