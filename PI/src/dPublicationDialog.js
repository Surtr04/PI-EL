function dPublicationDialogCtrl($scope, dialog, item, key){
	$scope.order = 'label';
	$scope.order2 = '!required';
	$scope.pub = item;
	$scope.key = key;
	$scope.alltypes = ['article', 'book', 'booklet', 'conference', 'inbook', 'incollection', 'inproceedings', 'manual', 'mastersthesis', 'misc', 'phdthesis', 'proceedings', 'techreport', 'unpublished'];
	$scope.ftype = $scope.pub.__type;
	$scope.fields = [];
	$scope.errors = {};
	$scope.allFields = {address:{optional : ['book', 'booklet', 'conference', 'inbook', 'incollection', 'inproceedings', 'manual', 'mastersthesis', 'phdthesis', 'proceedings', 'techreport', 'unpublished'], 
								 required: [],
								 name: "address", label : "Morada", type: "text"
								 },
				  author : 		{optional : ['booklet', 'manual', 'misc' ], 
								 required: ['article', 'book', 'conference', 'inbook', 'incollection', 'inproceedings', 'mastersthesis', 'phdthesis', 'techreport', 'unpublished'],
								 name: "author", label : "Autores", type: "list"
								 },
				  booktitle:	{optional: [],
								 required: ['incollection', 'conference', 'inproceedings'],
								 name: "booktitle", label : "Título do livro", type: "text"
								 },
				  chapter:		{optional: ['incollection'],
								 required: ['inbook', ],
								 name: "chapter", label : "Capítulo", type: "text"
								 },
				  crossref:		{optional: [],
								 required: [],
								 name: "crossref", label : "Referência cruzada", type: "text"
								 },
				  edition:		{optional: ['book', 'inbook', 'incollection', 'manual'],
								 required: [],
								 name: "edition", label : "Edição", type: "text"
								 },
				  editor:		{optional: ['incollection', 'conference' ,'inproceedings', 'proceedings'],
								 required: ['book', 'inbook'],
								 name: "editor", label : "Editor", type: "text"
								 },
				  eprint:		{optional: [],
								 required: [],						 
								 name: "eprint", label : "Edição eletrócnica", type: "url"
								 },
				  howpublished:	{optional: ['booklet', 'misc'],
								 required: [],
								 name: "howpublished", label : "Como foi publicado", type: "text"
								 },
				  institution:	{optional: [],
								 required: ['techreport'],
								 name: "institution", label : "Instituição", type: "text"
								 },
				  journal:		{optional: [],
								 required: ['article'],
								 name: "journal", label : "Periódico", type: "text"
								 },
				  month:		{optional: [],
								 required: [],
								 name: "month", label : "Mês", type: "text"
								 },
				  note:			{optional: [],
								 required: [],
								 name: "note", label : "Notas", type: "textarea"
								 },
				  number:		{optional: ['article', 'book', 'conference', 'inbook', 'incollection', 'inproceedings', 'proceedings', 'techreport'],
								 required: [],
								 name: "number", label : "Número", type: "text"
								 },
				  organization:	{optional: ['inproceedings', 'manual', 'proceedings'],
								 required: [],
								 name: "organization", label : "Organização", type: "text"
								 },
				  pages:		{optional: ['article', 'conference', 'incollection', 'inproceedings'],
								 required: ['inbook'],
								 name: "pages", label : "Páginas", type: "text"
								 },
				  publisher:	{optional: ['conference', 'inproceedings', 'proceedings'],
								 required: ['book', 'inbook'],
								 name: "publisher", label : "Editora", type: "text"
								 },
				  school:		{optional: [],
								 required: ['mastersthesis', 'phdthesis'],
								 name: "school", label : "Escola", type: "text"
								 },
				  series:		{optional: ['book', 'conference', 'inbook', 'incollection', 'inproceedings', 'proceedings'],
								 required: [],
								 name: "series", label : "Série", type: "text"
								 },
				  type:			{optional: ['inbook', 'incollection', 'mastersthesis', 'phdthesis', 'techreport'],
								 required: [],
								 name: "type", label : "Descrição de tipo", type: "text"
								 },
				  url:			{optional: [],
								 required: [],
								 name: "url", label : "Url", type: "url"
								 },
				  volume:		{optional: ['article', 'book', 'conference', 'inbook', 'incollection', 'inproceedings', 'proceedings'],
								 required: [],
								 name: "volume", label : "Volume", type: "text"
								 },
				  year:			{optional: ['booklet', 'manual', 'misc', 'unpublished'],
								 required: ['article', 'book', 'conference', 'inbook', 'incollection', 'inproceedings', 'mastersthesis', 'phdthesis', 'proceedings', 'techreport'  ],
								 name: "year", label : "Ano", type: "text"
								 }
	};
	$scope.refreshFieldList = function(){
		for(var i = 0; i < $scope.fields.length; i++){
			item = $scope.fields[i];
			if (item.value != '' && item.value != undefined)
				$scope.allFields[item.name].value = item.value;
		}
		$scope.fields = [];
		for(var i in $scope.allFields){
			item = $scope.allFields[i];
			if (!(item.optional == undefined || item.required == undefined || (item.required.length == 0 && item.optional.length == 0) || ($scope.ftype != undefined && (item.required.indexOf($scope.ftype) != -1 || item.optional.indexOf($scope.ftype) != -1)))) continue;
			$scope.fields.push({name: item.name, label: item.label, type: item.type, required: $scope.isRequired(item), classT: ($scope.isRequired(item) ? 'success' : ''), value: item.value});
		}
	}
	$scope.isRequired = function(item){
		return (item.required != undefined && $scope.ftype != undefined && item.required.indexOf($scope.ftype) != -1);
	}
	$scope.closeDialog = function(result){
		$scope.pub.__type = $scope.ftype;
		for(var i = 0; i < $scope.fields.length; i++){
			item = $scope.fields[i];
			if (item.value != '' && item.value != undefined)
				$scope.pub[item.name] = item.value;
		}
		dialog.close({item: $scope.pub, key: $scope.key , result: result});
	};
	$scope.validateList = function(name, list, max){if (max > 0 && list.length > max) $scope.errors[name] = true; else $scope.errors[name] = false;}
	$scope.windowWidth = function(){ return $(document).width();}
	$scope.windowHeight = function(){ return $(document).height();}
	
	
	/*Contructor code*/
	$scope.refreshFieldList();
	for(var i = 0; i < $scope.fields.length; i++){
		item = $scope.fields[i];
		item.value = $scope.pub[item.name];
	}
}