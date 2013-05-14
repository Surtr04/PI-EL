use strict;
use warnings;
use Data::Dumper;
use utf8::all;

use Test::More tests => 1;
#use BibTeX::toDB;
BEGIN { use_ok('BibTeX::toDB2') };

my $f = BibTeX::toDB2->new('jj.bib','DBI:mysql:elcvs','root','root');

$f->parseBibTeX;
$f->insertDB;

