#!/usr/bin/perl

use strict;

my $pasta = shift;

my $base = $pasta || '../../SPLN/el1213/pln/data/musica/*.lyr';

my @lyr = glob $base;

my %meta ; ## ficheiro --> string de metadados

my %oco; ## id --> int

my $index = "";


for my $f (@lyr) {
	my $m = "";
	open(F, "<", $f) or die ("Can't open $f ($!)\n");
	while(<F>){
		last if (not $_ =~ /\S/); ## last unless /\S/
		$m .= $_;
		if ($_ =~ /^([^:]+):([^\n]*)\n/){
			$oco{$1}++;
			if ($1 eq "title") {
				my $q = $2;
				$q =~ s{\s+}{ }g;
				$index .= "$q;<a href='$f'>$q</a><br/>\n";
			}
		}
	}
	$meta{$f} = $m;
	close F;
};

$index = join("\n",sort(split("\n",$index)));
$index =~ s{([^;])*;(.*)\n}{$2\n}g;
$index = "<html><head></head><body><h1>Índice</h1>" . $index . "</body></html>";
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
