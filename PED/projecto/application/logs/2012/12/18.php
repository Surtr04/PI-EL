<?php defined('SYSPATH') OR die('No direct script access.'); ?>

2012-12-18 15:32:49 --- CRITICAL: ErrorException [ 1 ]: Class 'Model_Utilizadores' not found ~ APPPATH\classes\Controller\users.php [ 16 ] in :
2012-12-18 15:32:49 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 15:33:48 --- CRITICAL: ErrorException [ 1 ]: Class 'Model_Users' not found ~ APPPATH\classes\Controller\users.php [ 16 ] in :
2012-12-18 15:33:48 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 16:04:29 --- CRITICAL: ErrorException [ 1 ]: Cannot call constructor ~ APPPATH\classes\Model\users.php [ 15 ] in :
2012-12-18 16:04:29 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 16:04:44 --- CRITICAL: ErrorException [ 1 ]: Call to undefined method Model_User::isSuper() ~ APPPATH\classes\Controller\users.php [ 17 ] in :
2012-12-18 16:04:44 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 16:07:20 --- CRITICAL: Database_Exception [ 42S02 ]: SQLSTATE[42S02]: Base table or view not found: 1146 Table 'ped.sip_utilizadores' doesn't exist [ SELECT * FROM sip_utilizadores ORDER BY username ASC LIMIT 0 OFFSET 25 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 16:07:20 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT * FROM s...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\users.php(29): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\users.php(17): Model_Users->cache(0)
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Users->action_index()
#4 [internal function]: Kohana_Controller->execute()
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Users))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 16:19:06 --- CRITICAL: ErrorException [ 1 ]: Class 'Model_Grupos' not found ~ APPPATH\classes\Controller\users.php [ 94 ] in :
2012-12-18 16:19:06 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 19:20:26 --- CRITICAL: Database_Exception [ 42S02 ]: SQLSTATE[42S02]: Base table or view not found: 1146 Table 'ped.sip_grupos' doesn't exist [ SELECT * FROM sip_grupos ORDER BY nome ASC ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 19:20:26 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT * FROM s...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php(34): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php(22): Model_Grupos->cache(0)
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\users.php(95): Model_Grupos->cacheAll()
#4 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\users.php(18): Controller_Users->initTable(Object(Model_Users))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Users->action_index()
#6 [internal function]: Kohana_Controller->execute()
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Users))
#8 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#9 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#10 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#11 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 19:32:27 --- CRITICAL: Kohana_Exception [ 0 ]: The requested route does not exist: groups ~ SYSPATH\classes\Kohana\Route.php [ 106 ] in C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php:212
2012-12-18 19:32:27 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php(212): Kohana_Route::get('groups')
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(41): Kohana_Route::url('groups', NULL, true)
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Controller_Mymain->createUrl('groups')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php:212
2012-12-18 19:33:07 --- CRITICAL: Kohana_Exception [ 0 ]: The requested route does not exist: groups ~ SYSPATH\classes\Kohana\Route.php [ 106 ] in C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php:212
2012-12-18 19:33:07 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php(212): Kohana_Route::get('groups')
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(41): Kohana_Route::url('groups', NULL, true)
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Controller_Mymain->createUrl('groups')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\users.php(10): Controller_Mymain->__construct(Object(Request), Object(Response))
#5 [internal function]: Controller_Users->__construct(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#8 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#9 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#10 {main} in C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php:212
2012-12-18 19:33:12 --- CRITICAL: Kohana_Exception [ 0 ]: The requested route does not exist: groups ~ SYSPATH\classes\Kohana\Route.php [ 106 ] in C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php:212
2012-12-18 19:33:12 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php(212): Kohana_Route::get('groups')
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(41): Kohana_Route::url('groups', NULL, true)
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Controller_Mymain->createUrl('groups')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Route.php:212
2012-12-18 19:33:56 --- CRITICAL: ErrorException [ 1 ]: Call to undefined method Kohana::config() ~ APPPATH\classes\Controller\groups.php [ 113 ] in :
2012-12-18 19:33:56 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 19:41:56 --- CRITICAL: ErrorException [ 2 ]: Missing argument 8 for Model_Users::formatUsr(), called in C:\Program Files\wamp\www\PED\projecto\application\classes\Model\users.php on line 27 and defined ~ APPPATH\classes\Model\users.php [ 33 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Model\users.php:33
2012-12-18 19:41:56 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\users.php(33): Kohana_Core::error_handler(2, 'Missing argumen...', 'C:\Program File...', 33, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\users.php(27): Model_Users->formatUsr('1', 'xpto', 'db069f1041ae868...', 'Xpto Silva', 'xpto@xpto.pt', '1', '0')
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\users.php(17): Model_Users->cache(0)
#3 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Users->action_index()
#4 [internal function]: Kohana_Controller->execute()
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Users))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Model\users.php:33
2012-12-18 19:48:51 --- CRITICAL: ErrorException [ 1 ]: Call to undefined method Kohana::config() ~ APPPATH\classes\Controller\groups.php [ 113 ] in :
2012-12-18 19:48:51 --- DEBUG: #0 [internal function]: Kohana_Core::shutdown_handler()
#1 {main} in :
2012-12-18 20:46:39 --- CRITICAL: Database_Exception [ 42S22 ]: SQLSTATE[42S22]: Column not found: 1054 Unknown column 'sip_p._id_perm' in 'where clause' [ SELECT sip_p.perm AS perm FROM sip_perms AS sip_p WHERE sip_p.id_grupo IS NULL AND sip_p._id_perm = 3 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:46:39 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT sip_p.pe...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(59): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Model_User->canDo(3, 'S')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:47:50 --- CRITICAL: Database_Exception [ 42S02 ]: SQLSTATE[42S02]: Base table or view not found: 1146 Table 'ped.sip_' doesn't exist [ SELECT sip_p.perm AS perm FROM sip_ AS sip_ WHERE sip_p.id_grupo IS NULL AND sip_p._id_perm = 3 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:47:50 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT sip_p.pe...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(59): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Model_User->canDo(3, 'S')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:48:36 --- CRITICAL: Database_Exception [ 42000 ]: SQLSTATE[42000]: Syntax error or access violation: 1064 You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'AS  FROM sip_ AS sip_ WHERE sip_p.id_grupo IS NULL AND sip_p._id_perm = 3' at line 1 [ SELECT  AS  FROM sip_ AS sip_ WHERE sip_p.id_grupo IS NULL AND sip_p._id_perm = 3 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:48:36 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT  AS  FRO...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(59): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Model_User->canDo(3, 'S')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:49:27 --- CRITICAL: Database_Exception [ 42000 ]: SQLSTATE[42000]: Syntax error or access violation: 1064 You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'FROM sip_perms WHERE id_grupo IS NULL AND id_perm = 3' at line 1 [ SELECT perm AS  FROM sip_perms WHERE id_grupo IS NULL AND id_perm = 3 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:49:27 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT perm AS ...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(59): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Model_User->canDo(3, 'S')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:49:28 --- CRITICAL: Database_Exception [ 42000 ]: SQLSTATE[42000]: Syntax error or access violation: 1064 You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'FROM sip_perms WHERE id_grupo IS NULL AND id_perm = 3' at line 1 [ SELECT perm AS  FROM sip_perms WHERE id_grupo IS NULL AND id_perm = 3 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:49:28 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT perm AS ...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(59): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Model_User->canDo(3, 'S')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:50:06 --- CRITICAL: Database_Exception [ 42000 ]: SQLSTATE[42000]: Syntax error or access violation: 1064 You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near 'FROM sip_perms WHERE id_grupo = -1 AND id_perm = 3' at line 1 [ SELECT perm AS  FROM sip_perms WHERE id_grupo = -1 AND id_perm = 3 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:50:06 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT perm AS ...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(59): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(64): Model_User->canDo(3, 'S')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\mymain.php(21): Controller_Mymain->fillMenus()
#4 [internal function]: Controller_Mymain->__construct(Object(Request), Object(Response))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(94): ReflectionClass->newInstance(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#8 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#9 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:51:03 --- CRITICAL: Database_Exception [ 42S22 ]: SQLSTATE[42S22]: Column not found: 1054 Unknown column 'password' in 'where clause' [ SELECT * FROM sip_users WHERE username = 'xpto' AND password = 'db069f1041ae868ddb3e519b6e251d536802b840e98262281f948cb257a34e15' LIMIT 1 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:51:03 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT * FROM s...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(26): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Auth\myauth.php(11): Model_User->tryLogin('xpto', 'db069f1041ae868...')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Auth\myauth.php(16): Auth_Myauth->isValidLogin('xpto', 'xpto')
#4 C:\Program Files\wamp\www\PED\projecto\modules\auth\classes\Kohana\Auth.php(92): Auth_Myauth->_login('xpto', 'xpto', false)
#5 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\main.php(19): Kohana_Auth->login('xpto', 'xpto')
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Main->action_login()
#7 [internal function]: Kohana_Controller->execute()
#8 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Main))
#9 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#10 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#11 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#12 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:51:09 --- CRITICAL: Database_Exception [ 42S22 ]: SQLSTATE[42S22]: Column not found: 1054 Unknown column 'password' in 'where clause' [ SELECT * FROM sip_users WHERE username = 'xpto' AND password = 'db069f1041ae868ddb3e519b6e251d536802b840e98262281f948cb257a34e15' LIMIT 1 ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:51:09 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT * FROM s...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\user.php(26): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Auth\myauth.php(11): Model_User->tryLogin('xpto', 'db069f1041ae868...')
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Auth\myauth.php(16): Auth_Myauth->isValidLogin('xpto', 'xpto')
#4 C:\Program Files\wamp\www\PED\projecto\modules\auth\classes\Kohana\Auth.php(92): Auth_Myauth->_login('xpto', 'xpto', false)
#5 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\main.php(19): Kohana_Auth->login('xpto', 'xpto')
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Main->action_login()
#7 [internal function]: Kohana_Controller->execute()
#8 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Main))
#9 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#10 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#11 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#12 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:53:59 --- CRITICAL: ErrorException [ 2 ]: Invalid argument supplied for foreach() ~ APPPATH\classes\Model\grupos.php [ 81 ] in C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php:81
2012-12-18 20:53:59 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php(81): Kohana_Core::error_handler(2, 'Invalid argumen...', 'C:\Program File...', 81, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\groups.php(36): Model_Grupos->getGrupoWithId(1)
#2 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Groups->action_ver()
#3 [internal function]: Kohana_Controller->execute()
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Groups))
#5 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#7 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#8 {main} in C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php:81
2012-12-18 20:56:47 --- CRITICAL: Database_Exception [ 42S22 ]: SQLSTATE[42S22]: Column not found: 1054 Unknown column 'nome' in 'order clause' [ SELECT * FROM sip_perms_tipo ORDER BY nome ASC ] ~ MODPATH\database\classes\Kohana\Database\PDO.php [ 151 ] in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251
2012-12-18 20:56:47 --- DEBUG: #0 C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php(251): Kohana_Database_PDO->query(1, 'SELECT * FROM s...', false, Array)
#1 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php(157): Kohana_Database_Query->execute()
#2 C:\Program Files\wamp\www\PED\projecto\application\classes\Model\grupos.php(120): Model_Grupos->getAllTPerms()
#3 C:\Program Files\wamp\www\PED\projecto\application\classes\Controller\groups.php(40): Model_Grupos->getAllPerms(1)
#4 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Controller.php(84): Controller_Groups->action_ver()
#5 [internal function]: Kohana_Controller->execute()
#6 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client\Internal.php(97): ReflectionMethod->invoke(Object(Controller_Groups))
#7 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request\Client.php(114): Kohana_Request_Client_Internal->execute_request(Object(Request), Object(Response))
#8 C:\Program Files\wamp\www\PED\projecto\system\classes\Kohana\Request.php(990): Kohana_Request_Client->execute(Object(Request))
#9 C:\Program Files\wamp\www\PED\projecto\index.php(113): Kohana_Request->execute()
#10 {main} in C:\Program Files\wamp\www\PED\projecto\modules\database\classes\Kohana\Database\Query.php:251