//Extending Object
Object.size = function(obj) {
    var size = 0, key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
};

function InfoCtrl($scope){
	$scope.order = 'pos';
	$scope.fields =  [{name: "name", label : "Nome", value: "Nelson Jose Costa Luis", type: "text"},
					  {name: "nacionalities", label : "Nacionalidades", value: ["Portuguese","Canadian"], type: "list", max:2, required: true},
					  {name: "contacts", label : "Contactos Pessoais", values: [{type:"email", value:"nelson@uminho.pt"},{type:"phone", value:"259225225"}], type: "contacts"},
					  {name: "birthdate", label : "Data de Nascimento", value: "05/03/1980", type: "date"},
					  {name: "gender", label : "Sexo", value: "M", values: [{name:"M", value:"Masculino"},{name:"F", value:"Feminino"}], type:"check"},
					  {name: "nativelang", label : "Linguagens Nativas", value: ["Portuguese", "English"], type: "list", max:0, required: true},
					  {name: "web", label : "Endereço Web", value: "http://di.uminho.pt", type: "url"},
					];
	$scope.formation = [
						{begin:'15/09/1995', end:'15/07/1998', degreeT:'BSc', degree:'Engharia Informática', result: '16', inst: {text: "Universidade do Minho", name: "Universidade do Minho", address: "Gualtar", country: "Portugal", type: "Public University"}},
						{begin:'15/09/1998', end:'15/07/2000', degreeT:'MSc', degree:'Engharia Informática', result: '17', inst: {text: "Universidade do Minho", name: "Universidade do Minho", address: "Gualtar", country: "Portugal", type: "Public University"}}
						];
	$scope.institutions = { __new__ : {text: "--Nova--", name: "", address: "", country: "", type: ""},
							id2: {text: "Universidade do Minho", name: "Universidade do Minho", address: "Gualtar", country: "Portugal", type: "Public University"}};
	$scope.selectedIns = [];
	$scope.errors = {};
	$scope.getType = function(txt){ return (txt == 'email' ? 'email' : 'text');}
	$scope.validateList = function(name, list, max){if (max > 0 && list.length > max) $scope.errors[name] = true; else $scope.errors[name] = false;}
	$scope.putIns = function(item, index){ 
		var inst = $scope.institutions[$scope.selectedIns[index]];
		item.inst.name = inst.name;
		item.inst.address = inst.address;
		item.inst.country = inst.country;
		item.inst.type = inst.type;
	}
	$scope.addFormation = function(){
		$scope.formation.push({begin:'', end:'', degreeT:'', degree:'', result: '', inst: {}}); 
		$scope.selectedIns.push('__new__');
	}
	
}
function PublicationsCtrl($scope, $dialog){
	$scope.deletes = [];
	$scope.publast = 0;
	$scope.publications = { }; //: {title: 'A new demo', __type: 'article'}
	$scope.addPublication = function(vtitle, vtype){
		if (vtitle == undefined) vtitle = '';
		if (vtype == undefined) vtype = '';
		var name = "pub" + $scope.publast;
		$scope.publast++;
		$scope.publications[name] = {title: vtitle, __type: vtype};
		return name;
	}
	
	$scope.closeAlert = function(index) {
		$scope.deletes.splice(index, 1);
	};
	$scope.tryRemoveKey = function(key){
		if ($scope.deletes.indexOf(key) == -1)
			$scope.deletes.push(key);
		//$scope.alerts.push({type: 'error', msg:'Tem a certeza que deseja eliminar a publicação com a chave "'+key+'"? <a href="#" ng-click="removeKey(key)" class="btn btn-primary btn-mini">Sim</a>'});
	}
	$scope.removeKey = function(key, index){
		console.log(key);
		if (index != undefined) $scope.closeAlert(index);
		delete $scope.publications[key];
		
	}
	$scope.editKey = function(key){
		var d = $dialog.dialog({
			backdropFade:true,
			dialogFade:true,
			backdrop: true,
			keyboard: false,
			backdropClick: true,
			templateUrl: 'dialogPublication.php',
			resolve: {item: function(){ return angular.copy($scope.publications[key]);}, key: function(){ return angular.copy(key);}},
			controller: 'dPublicationDialogCtrl'
		});
		d.open().then(function(r){
			if (r != undefined && r.result) $scope.editPub(key, r.key, r.item);
		});
		return;
	}
	$scope.editPub = function(oldkey, newkey, item){
		if (item.title == '' || item.title == undefined || item.__type == undefined || item.__type == '') return;
		if (oldkey != newkey && $scope.publications[newkey] != undefined) newkey = oldkey;
		delete $scope.publications[oldkey];
		$scope.publications[newkey] = item;
	}
	$scope.uiAddPublication = function(){
		$scope.editKey($scope.addPublication('Nova Publicação', 'misc'));
	}
	
	/*Constructor Code*/
	$scope.addPublication('A new demo', 'article');
	$scope.addPublication('Other demo', 'book');
	
}
function ActivitiesCtrl($scope){
	$scope.activities = [
							{key: 'ex1', begin: '01/01/2012', end: '31/12/2012', desc: 'Exemplo de uma actividade', inst: {text: "Universidade do Minho", name: "Universidade do Minho", address: "Gualtar", country: "Portugal", type: "Public University"},  org : {type: '', name: '', address: ''}, partners: ["J. J. Almeida", "Bruno Fernandes"], activity: { type: "conference", isorg: false, name: 'JOIN - Jornadas de Informática da Universidade do Minho', place: 'Universidade do Minho - Gualtar', work: 'Mobile Applications And Cloud Computing'}},
							{key: 'ex2', begin: '01/05/2011', end: '31/06/2011', desc: 'Actividade de 2 meses', inst: {text: "Universidade Lusíada", name: "Universidade Lusíada", address: "Famalicão", country: "Portugal", type: "Private University"},  org : {type: '', name: '', address: ''}, partners: [], activity: { type: "other", isorg: false, info: 'Exemplo de uma actividade mais específica que deve ser descrita pelo utilizador'}}
						];
	$scope.types = [{name: "conference", text:"Conferência"}, 
					{name: "internship", text:"Estágio"},
					{name: "phd_monitoring", text:"Acompahnamento de PhD"},
					{name: "msc_monitoring", text:"Acompanhamento de MSc"},
					{name: "other", text:"Outro"},
				   ]
	
	$scope.selectedIns = [];
	$scope.institutions = { __new__ : {text: "--Nova--", name: "", address: "", country: "", type: ""},
							id2: {text: "Universidade do Minho", name: "Universidade do Minho", address: "Gualtar", country: "Portugal", type: "Public University"}};
	$scope.putIns = function(item, index){ 
		var inst = $scope.institutions[$scope.selectedIns[index]];
		item.inst.name = inst.name;
		item.inst.address = inst.address;
		item.inst.country = inst.country;
		item.inst.type = inst.type;
	}
	
	
	
	$scope.addActivity = function(){
		$scope.activities.push({key: '', begin: '', end: '', desc: '', inst: {},  org : {type: '', name: '', address: ''}, partners: [], activity: { type: "other", isorg: false}});
	}
	
}
function BtnsForm($scope){
	$scope.save = 1;
	$scope.turn = function(val){$scope.save = val;}
}