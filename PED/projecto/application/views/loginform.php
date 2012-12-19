<?php defined('SYSPATH') or die('No direct script access.');
/*
	(C) António Silva e Rui Brito - 2012/2013
*/
	echo '<div style="margin: 0px auto 0px auto; padding: 15px; width: 290px; text-align:center; border:3px solid #F4F4F4; -moz-border-radius: 15px; border-radius: 15px;">
		<form method="POST" action="'.url::base().'auth/login" style="padding:10px;">
		Utilizador: <input type="text" name="username" size="15" style="margin-top:10px;"/><br />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Senha: <input type="password" name="password" size="15" style="margin-top:10px;"/><br/><br/>
		<div align="right">
			<p><input type="submit" value="Entrar" /></p>
		</div>
</form></div>'

?>