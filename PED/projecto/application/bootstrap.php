<?php defined('SYSPATH') or die('No direct script access.');

// -- Environment setup --------------------------------------------------------

// Load the core Kohana class
require SYSPATH.'classes/Kohana/Core'.EXT;

if (is_file(APPPATH.'classes/Kohana'.EXT))
{
	// Application extends the core
	require APPPATH.'classes/Kohana'.EXT;
}
else
{
	// Load empty core extension
	require SYSPATH.'classes/Kohana'.EXT;
}

/**
 * Set the default time zone.
 *
 * @link http://kohanaframework.org/guide/using.configuration
 * @link http://www.php.net/manual/timezones
 */
date_default_timezone_set('Europe/Lisbon');

/**
 * Set the default locale.
 *
 * @link http://kohanaframework.org/guide/using.configuration
 * @link http://www.php.net/manual/function.setlocale
 */
setlocale(LC_ALL, 'pt_PT.utf-8');

/**
 * Enable the Kohana auto-loader.
 *
 * @link http://kohanaframework.org/guide/using.autoloading
 * @link http://www.php.net/manual/function.spl-autoload-register
 */
spl_autoload_register(array('Kohana', 'auto_load'));

/**
 * Optionally, you can enable a compatibility auto-loader for use with
 * older modules that have not been updated for PSR-0.
 *
 * It is recommended to not enable this unless absolutely necessary.
 */
//spl_autoload_register(array('Kohana', 'auto_load_lowercase'));

/**
 * Enable the Kohana auto-loader for unserialization.
 *
 * @link http://www.php.net/manual/function.spl-autoload-call
 * @link http://www.php.net/manual/var.configuration#unserialize-callback-func
 */
ini_set('unserialize_callback_func', 'spl_autoload_call');

// -- Configuration and initialization -----------------------------------------

/**
 * Set the default language
 */
I18n::lang('pt-pt');

/**
 * Set Kohana::$environment if a 'KOHANA_ENV' environment variable has been supplied.
 *
 * Note: If you supply an invalid environment name, a PHP warning will be thrown
 * saying "Couldn't find constant Kohana::<INVALID_ENV_NAME>"
 */
 
Kohana::$environment = ($_SERVER['SERVER_NAME'] !== 'localhost') ? Kohana::PRODUCTION : Kohana::DEVELOPMENT;
 
if (isset($_SERVER['KOHANA_ENV']))
{
	Kohana::$environment = constant('Kohana::'.strtoupper($_SERVER['KOHANA_ENV']));
}

/**
 * Initialize Kohana, setting the default options.
 *
 * The following options are available:
 *
 * - string   base_url    path, and optionally domain, of your application   NULL
 * - string   index_file  name of your index file, usually "index.php"       index.php
 * - string   charset     internal character set used for input and output   utf-8
 * - string   cache_dir   set the internal cache directory                   APPPATH/cache
 * - integer  cache_life  lifetime, in seconds, of items cached              60
 * - boolean  errors      enable or disable error handling                   TRUE
 * - boolean  profile     enable or disable internal profiling               TRUE
 * - boolean  caching     enable or disable internal caching                 FALSE
 * - boolean  expose      set the X-Powered-By header                        FALSE
 */
Kohana::init(array(
	'base_url'   => '/PED/projecto',
	'index_file' => false,
	'errors'     => !Controller_Mymain::isProduction(),
	'profile'    => !Controller_Mymain::isProduction(),
    'caching'    => Controller_Mymain::isProduction(),
));

/**
 * Attach the file write to logging. Multiple writers are supported.
 */
Kohana::$log->attach(new Log_File(APPPATH.'logs'));

/**
 * Attach a file reader to config. Multiple readers are supported.
 */
Kohana::$config->attach(new Config_File);

/**
 * Enable modules. Modules are referenced by a relative or absolute path.
 */
Kohana::modules(array(
	'auth'       => MODPATH.'auth',       // Basic authentication
	// 'cache'      => MODPATH.'cache',      // Caching with multiple backends
	// 'codebench'  => MODPATH.'codebench',  // Benchmarking tool
	'database'   => MODPATH.'database',   // Database access
	// 'image'      => MODPATH.'image',      // Image manipulation
	// 'minion'     => MODPATH.'minion',     // CLI Tasks
	// 'orm'        => MODPATH.'orm',        // Object Relationship Mapping
	// 'unittest'   => MODPATH.'unittest',   // Unit testing
	// 'userguide'  => MODPATH.'userguide',  // User guide and API documentation
	));

Cookie::$salt = 'XjFbNc828ArDUYj'; 
	
/**
 * Set the routes. Each route must have a minimum of a name, a URI and a set of
 * defaults for the URI.
 */




Route::set('resget', 'get/<type>/<id>', 
    array( 
        'type' => '(img|doc)',
    ))
	->defaults(array(
		'controller' => 'resources',
		'action'     => 'get',
	));

Route::set('themeset', 'theme/<theme>',
    array(
        'theme' => '(blank|twitter)'
    ))
	->defaults(array(
		'controller' => 'themes',
		'action'     => 'change',
	));


Route::set('langs', 'langs/<lang>',
    array(
        'lang' => '(pt|en)'
    ))
	->defaults(array(
		'controller' => 'langs',
		'action'     => 'change',
	));

Route::set('zipcat', 'categories/downzip')
	->defaults(array(
		'controller' => 'sips',
		'action'     => 'zipcat',
	));

Route::set('bycat', 'sips/bycat/<id>')
	->defaults(array(
		'controller' => 'sips',
		'action'     => 'bycat',
	));

Route::set('pessoas', '<nome>(/<action>)', array('nome' => '(P|p)essoas')) //This route isn't possible. Only exists to main do redirect
	->defaults(array(
        'controller' => 'pessoas',
		'action'     => 'index',
    ));

Route::set('supervisores', 'supervisores(/<action>)')
	->defaults(array(
		'controller' => 'pessoas',
		'action'     => 'index',
        'tt'         => 'Supervisors',
        'perms'      => 'supervisors',
        'table'      => 'supervisores',
	));

Route::set('autores', 'autores(/<action>)')
	->defaults(array(
		'controller' => 'pessoas',
		'action'     => 'index',
        'tt'         => 'Authors',
        'perms'      => 'authors',
        'table'      => 'autores',
	));


Route::set('sips', 'sips(/<action>(/<catid>))')
	->defaults(array(
		'controller' => 'sips',
		'action'     => 'index',
        'catid'      => -1,
	));

Route::set('stats', 'stats(/<action>)')
	->defaults(array(
		'controller' => 'stats',
		'action'     => 'index',
	));

Route::set('stats_day', 'stats(/<action>)(/day/<year>.<month>.<day>)',
    array(
        'year' => '\d+',
        'month' => '\d+',
        'day' => '\d+'
    ))
	->defaults(array(
		'controller' => 'stats',
		'action'     => 'index',
        'type'       => 'day',
	));

Route::set('stats_month', 'stats(/<action>)(/month/<year>.<month>)',
    array(
        'year' => '\d+',
        'month' => '\d+',
    ))
	->defaults(array(
		'controller' => 'stats',
		'action'     => 'index',
        'type'       => 'month',
	));

Route::set('stats_year', 'stats(/<action>)(/year/<year>)',
    array(
        'year' => '\d+',
    ))
	->defaults(array(
		'controller' => 'stats',
		'action'     => 'index',
        'type'       => 'year',
	));



Route::set('categories', 'categories(/<action>)')
	->defaults(array(
		'controller' => 'categories',
		'action'     => 'index',
	));



Route::set('users', 'users(/<action>)')
	->defaults(array(
		'controller' => 'users',
		'action'     => 'index',
	));

Route::set('manut', 'manut(/<action>)')
	->defaults(array(
		'controller' => 'manut',
		'action'     => 'index',
	));

Route::set('groups', 'groups(/<action>)')
	->defaults(array(
		'controller' => 'groups',
		'action'     => 'index',
	));

Route::set('logs', 'logs(/<action>)')
	->defaults(array(
		'controller' => 'logs',
		'action'     => 'index',
	));

Route::set('auth', 'auth(/<action>)')
	->defaults(array(
        'controller' => 'auth',
        'action'     => 'index',
	));

Route::set('default', '(<controller>(/<action>(/<id>)))')
	->defaults(array(
		'controller' => 'main',
		'action'     => 'index',
	));
	



	


	