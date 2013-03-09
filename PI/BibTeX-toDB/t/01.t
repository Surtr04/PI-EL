	
use strict;
use warnings;
use Data::Dumper;

use Test::More tests => 4;
#use BibTeX::toDB;
BEGIN { use_ok('BibTeX::toDB') };

my $f = BibTeX::toDB->new('jj.bib','DBI:mysql:sample','root','root');

is($f->{entries},0,"entries init");

$f->parse("article");
is($f->{entries},17,"entries article");

$f->parse("techreport");
is($f->{entries},28,"entries techreport");

$f->parse("inproceedings");
print Dumper $f->{parsedInfo};