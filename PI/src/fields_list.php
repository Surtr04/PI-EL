<div class="control-group" ng-repeat="item in fields | orderBy:order | orderBy:order2" ng-class="item.classT">
	<label class="control-label" for="{{item.name}}">{{item.label}}: </label>
	<div class="controls" ng-switch="item.type">
		<div ng-switch-when="check" class="btn-group" data-toggle="buttons-radio">
			<input type="hidden" id="{{item.name}}" name="{{item.name}}" value="{{item.value}}"/>
			<button type="button" ng-click="item.value=vl.name" ng-repeat="vl in item.values" id="{{vl.name}}" class="btn">{{vl.value}}</button>
		</div>
		<table ng-switch-when="contacts">
			<tr><th>Tipo</th><th>Valor</th></tr>
			<tr ng-repeat="vl in item.values">
				<td>
					<select id="{{item.name}}T[]" name="{{item.name}}T[]" ng-model="vl.type">
						<option value="email">Email</option>
						<option value="phone">Telefone</option>
						<option value="fax">Fax</option>
					</select>
				</td>
				<td><input id="{{item.name}}V[]" name="{{item.name}}V[]" type="{{getType(vl.type)}}" ng-model="vl.value"/></td>
			</tr>
			<tr><td colspan="2"><button type="button" ng-click="item.values.push({type: 'email', value:''})" class="btn">Inserir novo contacto</button></td></tr>
		</table>
		<div ng-switch-when="list">
			<input id="{{item.name}}" type="text" ng-change="validateList(item.name, item.value, item.max)" name="{{item.name}}" ng-model="item.value" ng-list ng-required="item.required"/>
			&nbsp;&nbsp;<div class="alert alert-error inline" style="display: inline;" ng-show="errors[item.name]"><strong>Erro!</strong> Mais valores inseridos do que os permitidos (max: {{item.max}}).</div>
			&nbsp;&nbsp;(lista separada por vírgulas)
		</div>
		<textarea ng-switch-when="textarea" ng-required="item.required" ng-model="item.value"/>
		<input ng-switch-default id="{{item.name}}" name="{{item.name}}" type="{{item.type}}" ng-model="item.value" ng-required="item.required"/>
	</div>
</div>