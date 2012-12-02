
use strict;
use Getopt::Long;
use File::Spec;
use File::Copy;

my $byAuthor;
my $bySinger;
my $musicDir;
my $archive;

Getopt::Long::Configure('bundling');
GetOptions('a' => \$byAuthor,'s' => \$bySinger, 'd:s' => \$archive);


sub trim {
	my $str = shift;
	$str =~ s/^\s+//g;

	return $str;
}


if($byAuthor) {

	if($archive) {
		mkdir $archive or die "couldn't create archive directory";
	}
	else {		
		mkdir "archive" or die "couldn't create archive directory";
		$archive = "archive";
	}
	my $archive_path = File::Spec->rel2abs($archive);

	my $dir = File::Spec->rel2abs(shift);	
	
	if($dir eq ""){
		die "no music directory was specified";		
	}

	chdir $dir;

	my @files = <*>;

	for my $file (@files) {
		open FILE, "<", $file;
		my $file_path = File::Spec->rel2abs($file);
		
		while (<FILE>) {
			if ($_ =~ m/author:(.*)/g) {
				my $curr_auth = trim($1);
				chdir $archive_path;				
				
				unless (-d $curr_auth) {
					mkdir $curr_auth;
				}			

				copy($file_path,$archive_path . "/$curr_auth");				
				last;
			}

		}		
		chdir $dir;
	
	}
	

}

if($bySinger) {

	if($archive) {
		mkdir $archive or die "couldn't create archive directory";
	}
	else {		
		mkdir "archive" or die "couldn't create archive directory";
		$archive = "archive";
	}
	my $archive_path = File::Spec->rel2abs($archive);

	my $dir = File::Spec->rel2abs(shift);	
	
	if($dir eq ""){
		die "no music directory was specified";		
	}

	chdir $dir;

	my @files = <*>;

	for my $file (@files) {
		open FILE, "<", $file;
		my $file_path = File::Spec->rel2abs($file);
		
		while (<FILE>) {
			if ($_ =~ m/singer:(.*)/g) {
				my $curr_sing = trim($1);
				chdir $archive_path;				
				
				unless (-d $curr_sing) {
					mkdir $curr_sing;
				}			

				copy($file_path,$archive_path . "/$curr_sing");				
				last;
			}

		}		
		chdir $dir;
	
	}

}