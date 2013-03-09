	
use strict;
use warnings;
use Data::Dumper;

use Test::More tests => 1;
#use BibTeX::toDB;
BEGIN { use_ok('BibTeX::toDB') };


my $f = BibTeX::toDB->new('my.bib','DBI:mysql:sample','root','root');
$f->parse("article");

print Dumper $f->{parsedInfo};