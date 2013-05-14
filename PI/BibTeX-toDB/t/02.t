use strict;
use warnings;
use Data::Dumper;
use utf8::all;

use Test::More tests => 1;
#use BibTeX::toDB;
BEGIN { use_ok('BibTeX::toDB') };

my $f = BibTeX::toDB->new('jj.bib','DBI:mysql:elcvs','root','root');

$f->parseArticle;
print Dumper $f->{parsedInfo};

