<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: auto; padding: 15px; width: 290px; text-align:center; border:3px solid #F4F4F4; -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" action="'.TPL::base().'auth/login" style="padding:10px;">
		'.__('User').': <input type="text" name="username" size="15" style="margin-top:10px;"/><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;'.__('Password').': <input type="password" name="password" size="15" style="margin-top:10px;"/><br/><br/>
		<div align="right">
			<p><input type="submit" value="'.__('Enter').'" /></p>
		</div>
</form></div>'

?>