<?php
set_time_limit(0); //Can take a while

require_once('oaipmh/OAIPMHClient.php');
require_once('bd.php');

// This function can be used to suppress warnings from the simplexml parser.
// The client will throw exceptions on errors anyway.
libxml_use_internal_errors(true);

// This is the base-url of the OAI-PMH handler.
$baseUrl = 'http://repositorium.sdum.uminho.pt/oai/oai';

// Creating a new OAI-PMH Client, using the verbose option.
// Verbose will make the client print the requests.
$client = new OAIPMHClient($baseUrl, true);

// Call the Identify method.
$identityResponse = $client->Identify();

//$resp = $client->ListMetadataFormats();

//$resp = $client->ListIdentifiers('oai_dc');

//$resp = $client->ListRecords('oai_dc');

$prefix = 'oai_dc';
$token = null;
$today = new DateTime();
$to = $today->format('Y-m-d');
$today->modify('-1 month');
$from = $today->format('Y-m-d');


do{
	$resp = $client->ListRecords($prefix, $token, $from, $to);
	$token = (string)$resp->ListRecords->resumptionToken;
	$takeCareOfPubs($resp);
	//Clean everything
	$from = null;
	$to = null;
	$prefix = null;
}while ($token != "");


/*$resp = simplexml_load_file('oai.xml');
$aux = $resp->xpath('//resumptionToken');
var_dump((string)$resp->ListRecords->resumptionToken);
var_dump(count($aux));
if (count($aux) > 0) $token = (string)$aux[0]; else $token = null;
var_dump($token);*/
//$resp->asXML('oai.xml');
echo htmlentities($resp->asXML());

// Print the repository name.
printf("Connected to %s", $identityResponse->Identify->repositoryName);
function takeCareOfPubs($resp){
	return;
}

