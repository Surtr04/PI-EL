<?php
	session_start();
	$_SESSION['id'] = 1;
?>
<!DOCTYPE html>
<html lang="en" ng-app="cv_form">
	<head>
        <meta charset="utf-8"/>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.0/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.0.4/angular.min.js"></script>
		<script src="js/angular-ui.min.js"></script>
		<script src="js/ui-bootstrap-tpls-0.3.0.min.js"></script>
		<script src="js/ng-grid-2.0.5.min.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet"/>
		<link href="css/angular-ui.min.css" rel="stylesheet"/>
		<link href="css/ng-grid.css" rel="stylesheet"/>
		
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
		<script type="text/javascript">angular.module("cv_form", ['ui', 'ui.bootstrap', 'ngGrid']);</script>
		<script type="text/javascript" src="interface.js"></script>
		<script type="text/javascript" src="dPublicationDialog.js"></script>

	</head>
	<body>
		<div class="row-fluid">
			<?php include('menu.php'); ?>
			<div class="span9">
				<form name="frmPrincipal" method="post" class="form-horizontal" action="full_import.php" enctype="multipart/form-data">
					<div class="tabbable"> 
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab1" data-toggle="tab">Informação e Formação</a></li>
							<li><a href="#tab2" data-toggle="tab">Actividades</a></li>
							<li><a href="#tab3" data-toggle="tab">Publicações</a></li>
						</ul>
						<div class="tab-content">
							<div class="tab-pane active animations" id="tab1" ng-controller="InfoCtrl">
								<div ng-include="'fields_list.php'"></div>
								<div class="control-group">
									<div class="controls">
										<button type="button" ng-click="addFormation()" class="btn">Inserir nova formação</button>
										<h2>Formação</h2>
									</div>
								</div>
								<!--<div class="control-group">-->
									<div class="control-group well" ng-repeat="item in formation" ui-animate>

										<span class="controls"><b>Instituição:</b></span>
										<select ng-change="putIns(item, $index)" ng-model="selectedIns[$index]">
											<option ng-repeat="(key,inst) in institutions" value="{{key}}">{{inst.text}}</option>
										</select>
										<div class="control-group" style="padding:20px;">
											<label class="control-label" for="insName[]">Nome: </label>
											<div class="controls"><input id="insName[]" name="insName[]" type="text" ng-model="item.inst.name"/></div>
											
											<label class="control-label" for="insAddress[]">Morada: </label>
											<div class="controls"><input id="insAddress[]" name="insAddress[]" type="text" ng-model="item.inst.address"/></div>
											
											<label class="control-label" for="insCountry[]">País: </label>
											<div class="controls"><input id="insCountry[]" name="insCountry[]" type="text" ng-model="item.inst.country"/></div>
											
											<label class="control-label" for="insType[]">Tipo: </label>
											<div class="controls"><input id="insType[]" name="insType[]" type="text" ng-model="item.inst.type"/></div>
											
										</div>

									
										<label class="control-label" for="fBegin[]">Início: </label>
										<div class="controls"><input id="fBegin[]" name="fBegin[]" type="date" ng-model="item.begin"/></div>
										
										<label class="control-label" for="fEnd[]">Fim: </label>
										<div class="controls"><input id="fEnd[]" name="fEnd[]" type="date" ng-model="item.end"/></div>
										

										
										<label class="control-label" for="degreeT[]">Grau: </label>
										<div class="controls"><input id="degreeT[]" name="degreeT[]" type="text" ng-model="item.degreeT"/></div>
										
										<label class="control-label" for="degree[]">Título: </label>
										<div class="controls"><input id="degree[]" name="degree[]" type="text" ng-model="item.degree"/></div>
										
										<label class="control-label" for="result[]">Resultado: </label>
										<div class="controls"><input id="result[]" name="result[]" type="text" ng-model="item.result"/></div>
									</div>
								<!--</div>-->
							</div>
							<div class="tab-pane" id="tab2" ng-controller="ActivitiesCtrl">
								<div class="control-group animations">
									<div class="controls">
										<button type="button" ng-click="addActivity()" class="btn">Inserir nova actividade</button>
										<h2>Actividades</h2>
									</div>
									<div class="control-group well" ng-repeat="item in activities" ui-animate>
										<label class="control-label" for="aKey[]">Identificação: </label>
										<div class="controls"><input id="aKey[]" name="aKey[]" type="text" ng-model="item.key"/></div>
										
										<label class="control-label" for="aBegin[]">Início: </label>
										<div class="controls"><input id="aBegin[]" name="aBegin[]" type="date" ng-model="item.begin"/></div>
										
										<label class="control-label" for="aEnd[]">Fim: </label>
										<div class="controls"><input id="aEnd[]" name="aEnd[]" type="date" ng-model="item.end"/></div>
										
										
										<span class="controls"><b>Instituição:</b></span>
										<select ng-change="putIns(item, $index)" ng-model="selectedIns[$index]">
											<option ng-repeat="(key,inst) in institutions" value="{{key}}">{{inst.text}}</option>
										</select>
										<div class="control-group" style="padding:20px;">
											<label class="control-label" for="insName[]">Nome: </label>
											<div class="controls"><input id="insName[]" name="aInsName[]" type="text" ng-model="item.inst.name"/></div>
											
											<label class="control-label" for="insAddress[]">Morada: </label>
											<div class="controls"><input id="insAddress[]" name="aInsAddress[]" type="text" ng-model="item.inst.address"/></div>
											
											<label class="control-label" for="insCountry[]">País: </label>
											<div class="controls"><input id="insCountry[]" name="aInsCountry[]" type="text" ng-model="item.inst.country"/></div>
											
											<label class="control-label" for="insType[]">Tipo: </label>
											<div class="controls"><input id="insType[]" name="aInsType[]" type="text" ng-model="item.inst.type"/></div>
											
										</div>
										
										<label class="control-label" for="description[]">Descrição: </label>
										<div class="controls"><textarea id="description[]" name="description[]" ng-model="item.desc"></textarea></div>
										
										
										<label class="control-label" for="partners[]">Parceiros: </label>
										<div class="controls">
											<input id="partners[]" type="text" name="partners[]" ng-model="item.partners" ng-list>
											&nbsp;&nbsp;(lista separada por vírgulas)
										</div>
										
										<label class="control-label" for="aType[]">Tipo: </label>
										<div class="controls">
											<select id="aType[]" name="aType[]" ng-model="item.activity.type">
												<option ng-repeat="t in types" value="{{t.name}}">{{t.text}}</option>
											</select>
										</div>
										
										<div ng-switch="item.activity.type">
											<div ng-switch-when="conference">
												<label class="control-label" for="isOrganizator[]">Organizador: </label>
												<div class="controls">
													<div class="btn-group" data-toggle="buttons-radio">
														<input type="hidden" id="isOrganizator[]" name="isOrganizator[]" value="{{item.activity.isorg}}"/>
														<button type="button" ng-click="item.activity.isorg='true'" class="btn">Sim</button>
														<button type="button" ng-click="item.activity.isorg='false'" class="btn active">Não</button>
													</div>
												</div>	
												<label class="control-label" for="aConfName[]">Nome: </label>
												<div class="controls"><input id="aConfName[]" name="aConfName[]" type="text" ng-model="item.activity.name"/></div>
												
												<label class="control-label" for="aConfPlace[]">Local: </label>
												<div class="controls"><input id="aConfPlace[]" name="aConfPlace[]" type="text" ng-model="item.activity.place"/></div>
												
												<label ng-hide="item.activity.isorg" class="control-label" for="aConfWork[]">Nome do trabalho: </label>
												<div ng-hide="item.activity.isorg" class="controls"><input id="aConfWork[]" name="aConfWork[]" type="text" ng-model="item.activity.work"/></div>
												
											</div>
											<div ng-switch-when="internship">
												<label class="control-label" for="aCompanyName[]">Nome da empresa: </label>
												<div class="controls"><input id="aCompanyName[]" name="aCompanyName[]" type="text" ng-model="item.activity.name"/></div>
											
												<label class="control-label" for="aCompanyAddress[]">Morada da empresa: </label>
												<div class="controls"><input id="aCompanyAddress[]" name="aCompanyAddress[]" type="text" ng-model="item.activity.address"/></div>
											
												<label class="control-label" for="aCompanyCountry[]">País do estágio: </label>
												<div class="controls"><input id="aCompanyCountry[]" name="aCompanyCountry[]" type="text" ng-model="item.activity.country"/></div>
												
												<label class="control-label" for="aCompanyType[]">Tipo de Empresa: </label>
												<div class="controls"><input id="aCompanyType[]" name="aCompanyType[]" type="text" ng-model="item.activity.ctype"/></div>
											</div>
											<div ng-switch-when="phd_monitoring">
												<label class="control-label" for="student[]">Estudante de PhD: </label>
												<div class="controls"><input id="student[]" name="student[]" type="text" ng-model="item.activity.student"/></div>
												
												<label class="control-label" for="phdTitle[]">Titulo da Tese: </label>
												<div class="controls"><input id="phdTitle[]" name="phdTitle[]" type="text" ng-model="item.activity.title"/></div>
												
											</div>
											<div ng-switch-when="msc_monitoring">
												<label class="control-label" for="student[]">Estudante de MSc: </label>
												<div class="controls"><input id="student[]" name="student[]" type="text" ng-model="item.activity.student"/></div>
												
												<label class="control-label" for="mscTitle[]">Titulo da Tese: </label>
												<div class="controls"><input id="mscTitle[]" name="mscTitle[]" type="text" ng-model="item.activity.title"/></div>
												
											</div>
											<div ng-switch-when="other">
												<label class="control-label" for="aInfo[]">Descrição: </label>
												<div class="controls"><textarea id="aInfo[]" name="aInfo[]" ng-model="item.activity.info"></textarea></div>
											</div>
										</div>
										
									</div>
								</div>
							</div>
							<div class="tab-pane" id="tab3" ng-controller="PublicationsCtrl">
								<div>
								  <alert ng-repeat="del in deletes" type="'error'">
									Tem a certeza que pretende eliminar a publicação com a chave '{{del}}'? 
									<a href="#" ng-click="removeKey(del, $index)" class="btn btn-primary btn-mini">Sim</a>
									&nbsp;<a href="#" ng-click="closeAlert($index)" class="btn btn-mini">Cancelar</a>
								  </alert>
								</div>
								<div ng-repeat="(key,item) in publications" ui-animate>
									<p>
										<a ng-click="editKey(key)">{{item.title}} - ({{key}})</a>&nbsp;
										<span class="label">{{item.__type}}</span>
										<a href="#" ng-click="tryRemoveKey(key)" class="btn btn-danger btn-mini"><i class="icon-white icon-remove"></i></a>
									</p>
									<!-- Hidden values to all publications, with its fields-->
									<input type="hidden" id="pKey[]" name="pKey[]" value="{{key}}"/>
									<input ng-repeat="(nkey, val) in item" type="hidden" id="#pub${{key}}${{nkey}}" name="#pub${{key}}${{nkey}}" value="{{val}}"/>
								</div>
								<button type="button" ng-click="uiAddPublication()" class="btn">Adicionar Publicação</button>
								
								<!--<label class="control-label" for="bibtex">Ficheiro de BibTeX: </label>
								<input type='file' id='bibtex' name='bibtex'/>-->
							</div>
						</div>
					</div>
					<div class="form-actions">
						<div class="controls">
						<label class="control-label" for="toSave">Gravar em: </label>
						<div ng-controller="BtnsForm" class="btn-group" data-toggle="buttons-radio">
							<input type="hidden" id="toSave" name="toSave" value="{{save}}"/>
							<button type="button" ng-click="turn(0)" class="btn">Ficheiro</button>
							<button type="button" ng-click="turn(1)" class="btn active">Base de Dados</button>
						</div>
						</div>
						<button type="submit" class="btn btn-primary">Enviar</button>
						<button type="reset" class="btn">Cancelar</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>