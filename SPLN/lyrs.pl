#!/usr/bin/perl

use strict;

my $pasta = shift;

my $base = $pasta || 'el1213/pln/data/musica/*.lyr';

my @lyr = glob $base;

my %meta ; ## ficheiro --> string de metadados

my %oco; ## id --> int

my $index = "<html><head></head><body><h1>Índice</h1>";


for my $f (@lyr) {
	my $m = "";
	open(F, "<", $f) or die ("Can't open $f ($!)\n");
	while(<F>){
		last if (not $_ =~ /\S/); ## last unless /\S/
		$m .= $_;
		if ($_ =~ /^([^:]+):(.*)\n/){
			$oco{$1}++;
			if ($1 eq "title") {
				$index .= "<a href='$f'>$2</a><br/>";
			}
		}
	}
	$meta{$f} = $m;
	close F;
};

$index .= "</body></html>";
open (F, ">", "index.html");
print F $index;
close F;
#for(keys %meta){
#	print "---$_---\n$meta{$_}\n", "===" x 10, "\n";
#}

for(sort {$oco{$b} <=> $oco{$a}} keys %oco){
	print "$_: $oco{$_}\n";
}


__END__
