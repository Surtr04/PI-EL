<?php defined('SYSPATH') OR die('No direct script access.'); ?>

2012-12-19 10:58:49 --- CRITICAL: ErrorException [ 4096 ]: Argument 1 passed to Kohana_Database_Query_Builder_Insert::values() must be of the type array, null given, called in C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php on line 98 and defined ~ MODPATH\database\classes\Kohana\Database\Query\Builder\Insert.php [ 80 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query\Builder\Insert.php:80
2012-12-19 10:58:49 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query\Builder\Insert.php(80): Kohana_Core::error_handler(4096, 'Argument 1 pass...', 'C:\Program File...', 80, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php(98): Kohana_Database_Query_Builder_Insert->values(NULL, 'Consumidor')
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\groups.php(102): Model_Grupos->insereGrupo('Consumidor', Array)
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Groups->action_insere2()
#4 [internal function]: Kohana_Controller->execute()
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Groups))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query\Builder\Insert.php:80
2012-12-19 11:03:40 --- CRITICAL: ErrorException [ 1 ]: Cannot use object of type Database_Query_Builder_Select as array ~ APPPATH\classes\Model\grupos.php [ 90 ] in :
2012-12-19 11:03:40 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-19 11:15:09 --- CRITICAL: ErrorException [ 1 ]: Call to undefined method Database_Result_Cached::array() ~ APPPATH\classes\Model\grupos.php [ 84 ] in :
2012-12-19 11:15:09 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-19 12:03:54 --- CRITICAL: ErrorException [ 1 ]: Call to a member function get() on a non-object ~ APPPATH\classes\Controller\users.php [ 25 ] in :
2012-12-19 12:03:54 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-19 12:10:24 --- CRITICAL: ErrorException [ 1 ]: Call to a member function getId() on a non-object ~ APPPATH\classes\Controller\mymain.php [ 30 ] in :
2012-12-19 12:10:24 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-19 12:11:21 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:11:21 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:12:27 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:12:27 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:12:28 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:12:28 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:12:29 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:12:29 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:25 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:25 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:26 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:26 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:27 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:27 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:27 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:13:27 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:23 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:23 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:25 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:25 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:25 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:25 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:26 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:15:26 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:16:25 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:16:25 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:21:53 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:21:53 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:21:54 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:21:54 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:21:54 --- CRITICAL: manutE [ 21 ]: I'm in maintenance mode ~ APPPATH\classes\Controller\mymain.php [ 34 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:21:54 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(15): Controller_Mymain->isManut()
#1 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#5 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#6 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php:15
2012-12-19 12:29:32 --- CRITICAL: ErrorException [ 1 ]: Call to a member function detect_uri() on a non-object ~ APPPATH\classes\Controller\mymain.php [ 30 ] in :
2012-12-19 12:29:32 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-19 12:38:55 --- CRITICAL: ErrorException [ 2 ]: include_once(C:\Program Files\wamp\www\PED\projecto\application\views/loginform.php): failed to open stream: No such file or directory ~ APPPATH\views\manut.php [ 13 ] in C:\Program Files\wamp\www\PED\projecto\application\views\manut.php:13
2012-12-19 12:38:55 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\views\manut.php(13): Kohana_Core::error_handler(2, 'include_once(C:...', 'C:\Program File...', 13, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\views\manut.php(13): include_once()
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\View.php(61): include('C:\Program File...')
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\View.php(348): Kohana_View::capture('C:\Program File...', Array)
#4 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(80): Kohana_View->render()
#5 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\manut.php(17): Controller_Mymain->render(Array)
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Manut->action_index()
#7 [internal function]: Kohana_Controller->execute()
#8 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Manut))
#9 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#10 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#11 C:\Program Files\wamp\www\PED\projecto\index.php(112): Kohana_Request->execute()
#12 {main} in C:\Program Files\wamp\www\PED\projecto\application\views\manut.php:13
2012-12-19 12:54:04 --- CRITICAL: ErrorException [ 1 ]: Class 'Moedl_User' not found ~ APPPATH\classes\Controller\mymain.php [ 71 ] in :
2012-12-19 12:54:04 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-19 14:52:55 --- CRITICAL: ErrorException [ 1 ]: Call to a member function get() on a non-object ~ APPPATH\classes\Controller\mymain.php [ 62 ] in :
2012-12-19 14:52:55 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :