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
			'username'   => 'root',
			'password'   => '03010301',
			'persistent' => FALSE,
		),
		'table_prefix' => 'sip_',
		'charset'      => 'utf8',
		'caching'      => FALSE,
	),
);
