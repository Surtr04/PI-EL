<div class="modal-header">
	<h1 ng-bind="pub.title"></h1>
</div>
<div class="modal-body" ng-style="{maxHeight: (windowHeight() - (170 + (0.2*windowHeight()))) + 'px', minHeight: windowHeight() / 2}">
	<div class="form-horizontal">
		<div class="control-group">
			<label class="control-label" for="key">Identificação: </label>
			<div class="controls"><input id="key" name="key" type="text" ng-model="key" required/></div>
		</div>
		<div class="control-group">
			<label class="control-label" for="type">Tipo de Publicação: </label>
			<div class="controls"><input autocomplete="off" id="type" name="type" type="text" ng-change="refreshFieldList()" ng-model="ftype" typeahead="state for state in alltypes | filter:$viewValue" required/></div>
		</div>
		<div class="control-group">
			<label class="control-label" for="title">Título: </label>
			<div class="controls"><input id="title" name="title" type="text" ng-model="pub.title" required/></div>
		</div>
		<hr style="width: 40%; margin-left: 30%;">
		<!--<div ng-repeat="(key,fields) in showIn">-->
		<div ng-include="'fields_list.php'"></div>
		<!--</div>-->
	</div>
</div>
<div class="modal-footer">
	<button ng-click="closeDialog(true)" class="btn btn-primary">Confirmar</button>
	<button ng-click="closeDialog(false)" class="btn">Cancelar</button>
</div>
