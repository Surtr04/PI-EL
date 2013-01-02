<?php defined('SYSPATH') or die('No direct script access.');
    require_once('tpl_functions.php');
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="pt" lang="pt">

<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<link rel="icon" type="image/png" href="<?php echo TPL::base();?>favicon.png" />
	<link rel="shortcut icon" type="image/png" href="<?php echo TPL::base();?>favicon.png" />
	<title><?php echo $titulo." - ". __('Maintenance Mode');?></title>
</head>
<body>
	<center><h1><?php echo __('MaintenanceMsg1') ?></h1><br /><h1><?php echo __('MaintenanceMsg2') ?></h1>
	<img src="<?php echo TPL::base();?>images/working.png" alt="<?php echo __('Working'); ?>"></img></center>
	<?php include_once(APPPATH."views/".$dtheme."/loginform.php"); ?>
</body>
</html>
