use 5.016002;
use ExtUtils::MakeMaker;
# See lib/ExtUtils/MakeMaker.pm for details of how to influence
# the contents of the Makefile that is written.
WriteMakefile(
    NAME              => 'BibTeX::toDB2',
    VERSION_FROM      => 'lib/BibTeX/toDB2.pm', # finds $VERSION
    PREREQ_PM         => {}, # e.g., Module::Name => 1.1
    ($] >= 5.005 ?     ## Add these new keywords supported since 5.005
      (ABSTRACT_FROM  => 'lib/BibTeX/toDB2.pm', # retrieve abstract from module
       AUTHOR         => 'Rui Brito <rmb@sa.di.uminho.pt>') : ()),
);
