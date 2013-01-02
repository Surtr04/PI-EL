<?php defined('SYSPATH') OR die('No direct access allowed.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/

return array
(
	'default' => array(
		'type'       => 'PDO',
		'connection' => array(
			'dsn'        => 'mysql:host=localhost;dbname=ped',
			'username'   => 'pedman',
			'password'   => 'D}60za7vEi_-OfF',
			'persistent' => FALSE,
		),
		'table_prefix' => 'sip_',
		'charset'      => 'utf8',
		'caching'      => FALSE,
	),
);
