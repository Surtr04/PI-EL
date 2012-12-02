#!/usr/bin/perl

use strict;

my $dir = shift;

my $base = $dir || 'musica/*.lyr';
my @lyr = glob $base;

my %meta; ## ficheiro --> str-metadados
my %oco;


for my $f (@lyr) {

	my $m = "";

	open (F,"<",$f) or die ("can't open $f ($!)");
	while(<F>) {
		last if (not $_ =~ /\S/);
		$m .= $_;
		# if($_ =~ /^([^:]+)/) {
		# 	$oco{$1}++;
		# }			
		if($_ =~ /^(\w+):/) {
			$oco{$1}++;
		}
	}
	$meta{$f}=$m;

	close F;
}


# for (keys %meta) {
# 	print "$_:\n","$meta{$_}\n", "===" x 10,"\n"
# }

for (sort {$oco{$a} <=> $oco{$b}} keys %oco) {
	print "$_:\n","$oco{$_}\n", "===" x 10,"\n"
}

