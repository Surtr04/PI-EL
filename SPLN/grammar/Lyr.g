grammar Lyr.g;

lyr	:	meta_fields+  ;

meta_fields 
	:	(title|from|author|singer|in|lyrics|music|type|comm|ed|chorddef|t|date|inbook|arrangement|about|book|youtube|note|mp3|seealso|writing);


title
	:	'title:'STRING;
	
from 
	:	'from:'STRING;
	
author
	:	'author:'STRING;
	
singer
	:	'singer:'STRING;
	
in	
	:	'in:'STRING;

lyrics
	:	'lyrics:'STRING;
	
music
	:	'music:'STRING;
	
type	
	:	'type:'STRING;
	
comm
	:	'comm'STRING;
	
ed	
	:	'ed:'STRING;
	
chorddef
	:	'chorddef:'STRING;
	
t 	
	:	't:'STRING;
	
date
	:	'date:'STRING;
	
inbook
	:	'inbook:'STRING;
	
arrangement
	:	'arrangement:'STRING;
	
about
	:	'about:'STRING;
	
book
	:	'book:'STRING;
	
youtube
	:	'youtube:'STRING;
	
note
	:	'youtube:'STRING;
	
mp3	
	:	'mp3:'STRING;
	
seealso
	:	'seealso:'STRING;
	
writing
	:	'writing:'STRING;							

	

STRING
	:	('a'..'z'|'A'..'Z'|'\s')+
	|
	;