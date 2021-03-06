<html lang="en" ng-app="cv_form">
	<head>
        <meta charset="utf-8">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js"></script>
		<script src="js/angular-ui.min.js"></script>
		<script src="js/ui-bootstrap-tpls-0.1.0.min.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/angular-ui.min.css" rel="stylesheet"/>
		<style type="text/css">
			html, body{
				height: 100%;
			}
			#tblUtilizacao td {
				border: solid;
				vertical-align: top;
			}
			.animations {
				list-style: none outside none;
				margin: 10px 0;
				padding: 0;
			}
			#tblUtilizacao ul{
				list-style-type: none;
			}
			.inline{
				display:inline;
			}
			.animations li {
			  transition: all 0.5s ease;
			  -o-transition: all 0.5s ease;
			  -moz-transition: all 0.5s ease;
			  -webkit-transition: all 0.5s ease;
			  /*background: lightblue;*/
			  max-height: 50px; /* 1000px works too */
			  overflow: hidden;
			  padding: 5px;
			}
			.animations li.ui-animate {
			  opacity: 0;
			  max-height: 0;
			  padding: 0 5px;
			}
			.animations li.ui-not-animate {
			  opacity: 1 !important;
			  max-height: 100% !important;
			  padding: 5px !important;
			}
			.sidebar-nav {
				padding: 9px 0;
				margin: 9px 9px;
			}
		</style>
		<script type="text/javascript">
			angular.module("cv_form", ['ui']);
		</script>
	</head>
	<body>
		<div class="row-fluid">
			<?php include('menu.php'); ?>
			<div class="span9">
				<form name="frmPrincipal" method="post" class="form-horizontal" action="full_import.php" enctype="multipart/form-data">
					<input type="hidden" id="toSave" name="toSave" value="0"/>
					<input type="hidden" id="byFile" name="byFile" value="1"/>
					<div class="control-group" style="margin-top: 9px;">
						<label class="control-label" for="bibtex">Pacote com o CV: </label>
						<input type='file' id='file' name='file'/>
					</div>
					<div class="form-actions">
						<button type="submit" class="btn btn-primary">Enviar</button>
						<button type="reset" class="btn">Cancelar</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>