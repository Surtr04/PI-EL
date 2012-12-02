grammar lyrFiles;

options{
	k=2;
}


lyr	:	meta musica;



meta:	(title|author|comm|chorddef|type|time|lyrics|singer|in|from)*;

musica
	:	TEXT*
	;

time:	't: ' TEXT
	;

type:	'type: ' TEXT
	;
	
chorddef
	:	'chorddef:' TEXT
	;

lyrics
	:	'lyrics: ' TEXT
	;


comm:	'comm: ' TEXT
	;
	
title
	:	'title: ' TEXT
	;
	
author
	:	'author: ' TEXT
	;
	
singer
	:	'singer: ' TEXT
	;
	
in	:	'in: ' TEXT
	;

from:	'from: ' TEXT
	;
	
TEXT:	.* '\n';
ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;

INT :	'0'..'9'+
    ;

