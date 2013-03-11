#!/usr/bin/perl

use BibTeX::toDB;

my $f = BibTeX::toDB->new($ARGV[0],'DBI:mysql:elcvs','mysqlu','Nvn48UGdVBxAyYMV');
$f->parse("article");
$f->parse("inproceedings");

$f->insertDB($ARGV[1]);