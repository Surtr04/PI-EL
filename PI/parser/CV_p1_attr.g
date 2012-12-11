grammar CV_p1_attr;

options{
	language=Java;
	k=2;
}

@header{
	import java.util.GregorianCalendar;
}

@members{

	public void showError(String txt, int linha, int coluna){
		System.out.println("Error: '" + txt + "' in " + linha + ":"+coluna);
	}

}


cv 	returns [String valor]
	:	info {$cv.valor = $info.valor;} (form {$cv.valor += "\n" + $form.valor;})*
	{System.out.println($cv.valor);}
	;
	
info returns [String valor]
	: '@info {' name nationalities contacts birthdate gender natlang web '}'
	{
		$info.valor= "{\"info\":{\"name\":" + $name.valor + 
					 ",\"nationalities\":" + $nationalities.valor + 
					 ",\"contacts\":" + $contacts.valor +  
 					 ",\"birthdate\":" + $birthdate.valor +  
 					 ",\"gender\":" + $gender.valor + 
 					 ",\"natlang\":" + $natlang.valor + 
 					 ",\"web\":" + $web.valor + 
					 "}}";
	}
	;

nationalities returns [String valor]
	:	'Nationalities: [' a=SPID {$nationalities.valor="[\""+$a.text;} (',' b=SPID {$nationalities.valor+="\",\""+$b.text;})? ']' {$nationalities.valor+="\"]";}
	;
name returns [String valor]
	:	'Name: ' STRING
	{$name.valor=$STRING.text; }
	;

contacts returns [String valor]
	:	'PersonalContacts: [' a=contact{$contacts.valor="[{\"type\":"+$a.tipo+",\"value\":"+$a.valor+"}";} (',' b=contact{$contacts.valor+=",{\"type\":"+$b.tipo+",\"value\":"+$b.valor+"}";})* ']' {$contacts.valor += "]";};
	

contact returns [String tipo, String valor]
	:	'Phone:' STRING {$contact.tipo="\"p\""; $contact.valor=$STRING.text;}
	|	'Fax:' STRING {$contact.tipo="\"f\""; $contact.valor=$STRING.text;}
	|	'Email:' a=ID '@' b=ID '.' c=ID {$contact.tipo="\"e\""; $contact.valor= "\"" + $a.text + "@" + $b.text + "." + $c.text + "\"";}
	;	
	
birthdate returns [String valor]
	:	'Birthdate: ' data {$birthdate.valor = $data.valor;}
	;
	
data returns [String valor, GregorianCalendar data]
	:	d=INT '/' m=INT '/' y=INT 
	{
		$data.valor = "\"" + $d.text+"/"+$m.text+"/"+$y.text + "\"";
		$data.data = new GregorianCalendar($y.int, $m.int, $d.int);
	}
	;

gender returns [String valor]
	:	'Gender: ' ('M' {$gender.valor="\"m\"";} | 'F'{$gender.valor="\"f\"";})
	;

natlang returns [String valor]
	:	'NativeLang: [' a=SPID {$natlang.valor="[\""+$a.text;} (',' b=SPID {$natlang.valor+="\",\""+$b.text;})? ']' {$natlang.valor+="\"]";}
	;
	
web	returns [String valor]
	:	'Web: http' {$web.valor="\"http";} ('s' {$web.valor+="s";})? '://' a=ID{$web.valor+="://"+$a.text;} ('.'b=ID{$web.valor+="."+$b.text;})+ {$web.valor += "\"";}
	;

form returns [String valor]
	:	'@form {' a=begin b=end institutions degree result '}'
	{
		GregorianCalendar gc = $a.data;
		if (gc.after($b.data)) this.showError("Data de inicio superior ao fim (" + $a.valor + " > " + $b.valor + ")", 0, 0);
		$form.valor= "{\"form\":{\"begin\":" + $begin.valor + 
					 ",\"end\":" + $end.valor + 
					 ",\"institutions\":" + $institutions.valor +  
 					 ",\"degree\":" + $degree.valor +  
 					 ",\"result\":" + $result.valor + 
					 "}}";
	}
	;
	
begin returns [String valor, GregorianCalendar data]
	:	'Begin: ' data {$begin.valor = $data.valor;}
	;
	
end	returns [String valor, GregorianCalendar data]
	:	'End: ' data {$end.valor = $data.valor;}
	;

degree returns [String valor]
	:	'Degree: ' degreeType STRING {$degree.valor = "{\"type\":" + $degreeType.valor + ", \"value\":" + $STRING.text + "}"; }
	;

degreeType returns [String valor]
	:	'BSc' {$degreeType.valor="1";}
	|	'MSc' {$degreeType.valor="2";}
	|	'Phd' {$degreeType.valor="3";}
	;	
	
result returns [String valor]
	:	'Result: ' (INT {$result.valor=$INT.text; }|STRING {$result.valor= "\"" + $STRING.text + "\"";})
	;

institutions returns [String valor]
@init{ $institutions.valor = "{\"institutions\": ";}
	:	'Institutions: [' a=institution {$institutions.valor += "institutions: [" + $a.valor;} (',' b=institution {$institutions.valor = "," + $b.valor;})* ']' {$institutions.valor = "]";}
	|	'Institution: ' institution { $institutions.valor += "[" + $institution.valor + "]";}
	{ $institutions.valor = "}";}
	;
	
institution returns [String valor]
	:	name address country type
	{
		$institution.valor= "{\"institution\":{\"name\":" + $name.valor + 
					 ",\"address\":" + $address.valor + 
					 ",\"country\":" + $country.valor +  
 					 ",\"type\":" + $type.valor +  
					 "}}";
	}
	;
	
address returns [String valor]
	:	'Address: ' STRING {$address.valor=$STRING.text; }
	;

country returns [String valor]
	:	'Country: ' SPID  {$country.valor= "\"" +$SPID.text  + "\""; }
	;

type returns [String valor]
	:	'Type: ' SPID  {$type.valor= "\"" + $SPID.text  + "\""; }
	;

SPID
	:	(('A'..'Z')('a'..'z')*)+
	;

ID  :	('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'0'..'9'|'_')*
    ;


INT :	'0'..'9'+
    ;

WS  :   ( ' '
        | '\t'
        | '\r'
        | '\n'
        ) {$channel=HIDDEN;}
    ;

STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;
