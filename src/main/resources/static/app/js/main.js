var app = angular.module("Wafepa", ["ngRoute"]);


app.controller("ctrl", function($scope){
	$scope.message = "Hello JWD 29!";
});

app.controller("OtpisCtrl", function($scope, $http, $location,$window){
	var baseUrl="/api/otpisi";
	$scope.otpisi={};
	$scope.novOtpis={};
	$scope.ib={};
	$scope.izmena={};
	$scope.stvarno={};
	$scope.stvarno.provera=false;
	$scope.praznoca={};
	

	    $scope.brisanje= function (id){
	     if (confirm("Da li si siguran za brisanje iz baze?\nOtpis pod rednim brojem: " + id )) {
	      $scope.obrisi(id);
	    }
	    
	     }
	      
	
	$scope.izmeni = function(id){
		
		$http.put(baseUrl + "/" + id, $scope.izmena).then(
			function success(res){
				//alert("Uspeh");
				$scope.stvarno.provera=false;
				console.log(1);
				console.log($scope.izmena);
//				$window.location.reload();
				getOtpis();
			},
			function error(res){
				alert("Proveri datume!");
				console.log($scope.izmena);
			}
		);
	}
	
	$scope.dodaj = function(){
		$http.post(baseUrl,$scope.novOtpis).then(
			function success(){
				getOtpis();
				$scope.novOtpis.naziv="";
				$scope.novOtpis.kolicina="";
				$scope.novOtpis.datums="";
				$scope.novOtpis.bure="";
				
				
				console.log($scope.novOtpis);
			},
			function error(){
				alert("Proveri unose.")
				
			}
		);
		
	}
	
	

	
var getOtpis=function(){
	 
		
		var promise=$http.get(baseUrl);
		promise.then(
				function uspeh(res){
					$scope.otpisi=res.data;
					console.log($scope.otpisi);
					
					},
					function greska(){
						alert("Nesto je poslo po zlu");
					}
		
		);
		
		
	}
	getOtpis();
	$scope.proba=function(){
		console.log(3);
	}
	$scope.goToEdit = function(id){
//		$location.path("/kola/edit/" + id);
		$http.get(baseUrl + "/" + id).then(
				function success(res){
					$scope.stvarno.provera=true;
					$scope.ib=res.data;
					$scope.izmena.id=$scope.ib.id;
					$scope.izmena.naziv=$scope.ib.naziv;
					$scope.izmena.kolicina=$scope.ib.kolicina;					
					$scope.izmena.ds=$scope.ib.datums;
					$scope.izmena.bure=$scope.ib.bure;
					
					console.log($scope.izmena);
				},
				function error(res){
					alert("Something went wrong");
				}
			);
	}
	
	$scope.obrisi = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getOtpis();
			},
			function error(){
				alert("Ne mogu da obrisem.");
			}
		);
	}
	
	
});




app.controller("buradCtrl", function($scope, $http, $location,$window){
	var baseUrl="/api/buradi";
	$scope.burad={};
	$scope.novoBure={};
	$scope.ib={};
	$scope.izmena={};
	$scope.page=0;
	$scope.totalPages=1;
	$scope.stvarno={};
	$scope.stvarno.provera=false;
	$scope.pretragaBure={};
	
	$scope.reset=function(){
	$window.location.reload();
	}
	
	$scope.pretrazi=function(){
	
		$scope.page=0;
		getBurad();
	}
	
	$scope.go = function(direction){
		$scope.page = $scope.page + direction;
		getBurad();
	}
	
	$scope.izmeni = function(id){
		
		$http.put(baseUrl + "/" + id, $scope.izmena).then(
			function success(res){
				//alert("Uspeh");
				$scope.stvarno.provera=false;
				console.log(1);
				console.log($scope.izmena);
//				$window.location.reload();
				getBurad();
			},
			function error(res){
				alert("Proveri datume!");
				console.log($scope.izmena);
			}
		);
	}
	
	
	
	$scope.dodaj = function(){
		$http.post(baseUrl,$scope.novoBure).then(
			function success(){
				getBurad();
				$scope.novoBure.naziv="";
				$scope.novoBure.tezina="";
				$scope.novoBure.tp="";
				$scope.novoBure.ds="";
				$scope.novoBure.di="";
				$scope.novoBure.dk="";
				
				
				console.log($scope.novoBure);
			},
			function error(){
				alert("Proveri datume kacenja i istakanja.")
				console.log($scope.novoBure.naziv);
			}
		);
		console.log($scope.novoBure);
	}
	
	
var getBurad=function(){
	  var config = {params: {}};
	  config.params.page = $scope.page;
	config.params.naziv=$scope.pretragaBure.naziv;
	config.params.id=$scope.pretragaBure.id;
	config.params.dan=$scope.pretragaBure.dan;
	config.params.od=$scope.pretragaBure.od;
	config.params.doo=$scope.pretragaBure.doo;
		var promise=$http.get(baseUrl,config);
		promise.then(
				function uspeh(res){
					$scope.burad=res.data;
					$scope.totalPages = res.headers("totalPages");
					console.log($scope.burad);
					console.log($scope.totalPages);
					
					},
					function greska(){
						alert("Nesto je poslo po zlu");
					}
		
		);
		
		
	}
	
	getBurad();
	
var getPrazno=function(){
	 
		
		var promise=$http.get(baseUrl +  "/prazno");
		promise.then(
				function uspeh(res){
					$scope.praznoca=res.data;
					
					
					},
					function greska(){
						alert("Nesto je poslo po zlu");
					}
		
		);
		
		
	}
	getPrazno();
	$scope.proba=function(){
		console.log(3);
	}
	$scope.goToEdit = function(id){
//		$location.path("/kola/edit/" + id);
		$http.get(baseUrl + "/" + id).then(
				function success(res){
					$scope.stvarno.provera=true;
					$scope.ib=res.data;
					$scope.izmena.id=$scope.ib.id;
					$scope.izmena.naziv=$scope.ib.naziv;
					$scope.izmena.tezina=$scope.ib.tezina;					
					$scope.izmena.ds=$scope.ib.stigloS;
					$scope.izmena.di=$scope.ib.istocenoS;
					$scope.izmena.dk=$scope.ib.kacenjeS;
					$scope.izmena.tp=$scope.ib.tezinaPrazno;
					$scope.izmena.otpis=$scope.ib.otpis;
					$scope.izmena.dani=$scope.ib.dani;
					
					console.log($scope.izmena);
				},
				function error(res){
					alert("Something went wrong");
				}
			);
	}
	
	$scope.obrisi = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getBurad();
			},
			function error(){
				alert("Ne mogu da obrisem.");
			}
		);
	}
	
	
});


app.controller("kolaCtrl", function($scope, $http, $location){
	var baseUrl="/api/automobili";
	var baseUrlKompanija="/api/kompanije";
	$scope.novoAuto={};
	$scope.novoAuto.iznajmljen=false;
	$scope.auta=[];
	$scope.kompanije=[];
	$scope.page=0;
	$scope.totalPages=1;
	$scope.pretraga={};
	$scope.autaa={};
	$scope.praznoca={};
	
	$scope.bre=true;
var getAuta=function(){
		
		var config = { params: {}};
		
		if($scope.pretraga.model != ""){
			config.params.model = $scope.pretraga.model;
		}
		if($scope.pretraga.godiste != ""){
			config.params.godiste = $scope.pretraga.godiste;
		}
		
		if($scope.pretraga.dajId != ""){
			config.params.dajId = $scope.pretraga.dajId;
		}
		
		if($scope.pretraga.potrosnja != ""){
			config.params.potrosnja = $scope.pretraga.potrosnja;
		}
		
		if($scope.pretraga.velicina != ""){
			config.params.velicina = $scope.pretraga.velicina;
		}
		
		config.params.page = $scope.page;
		
		
		
		var promise=$http.get(baseUrl,config);
		promise.then(
				function uspeh(res){
					$scope.auta=res.data;
					$scope.totalPages = res.headers("totalPages");
					if($scope.auta[0]!=null){
					$scope.autaa.potrosnja=$scope.auta[0].potrosnja;
					for(i=0;i<$scope.auta.length;i++){
						if($scope.auta[i].potrosnja<=$scope.autaa.potrosnja){
							$scope.autaa=$scope.auta[i];
						}
					}
					$scope.bre=true;
				}else{$scope.autaa.potrosnja=0;
					$scope.bre=false;
					$scope.autaa.model="";
					
				}
					},
					function greska(){
						alert("Nesto je poslo po zlu");
					}
		
		);
		
		
	}
	
	getAuta();
	
	var getKompanije = function(){
		$http.get(baseUrlKompanija).then(
			function success(res){
				$scope.kompanije = res.data;
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	
	getKompanije();
	
	$scope.dodaj = function(){
		if($scope.novoAuto.id==null){
		$http.post(baseUrl, $scope.novoAuto).then(
			function success(){
				getAuta();
				console.log("d");
			},
			function error(){
				alert("Could not create.")
			}
		);
		}else{
			$http.put(baseUrl + "/" + $scope.novoAuto.id, $scope.novoAuto).then(
					function success(res){
						//alert("Uspeh");
						getAuta();
						
					},
					function error(res){
						alert("Something went wrong");
					}
				);
		}
		
	
	}
	
	
	$scope.filtriraj=function(){
		$scope.page=0;
		getAuta();
	}
	
	$scope.pretraziMe=function(){
		$scope.pretraga.model="s";
		getAuta();
		$scope.pretraga.model="";
	}
	
	
	
	$scope.go = function(direction){
		$scope.page = $scope.page + direction;
		getAuta();
	}

	$scope.obrisi = function(id){
		var promise = $http.delete(baseUrl + "/" + id);
		promise.then(
			function success(){
				getAuta();
			},
			function error(){
				alert("Could not delete the festivali.");
			}
		);
	}
	

	$scope.goToEdit = function(id){
//		$location.path("/kola/edit/" + id);
		$http.get(baseUrl + "/" + id).then(
				function success(res){
					$scope.novoAuto = res.data;
				},
				function error(res){
					alert("Something went wrong");
				}
			);
	}
	
	
	$scope.iznajmi=function(id){
		$http.post(baseUrl + "/" + id + "/iznajmi", id).then(
				function success(){
					getAuta();
				},
				function error(){
					alert("Could not create.")
				}
			);	
	}
	
	$scope.reset=function(){
		$scope.pretraga.model="";
		$scope.pretraga.godiste="";
		$scope.pretraga.potrosnja="";
		$scope.pretraga.dajId="";
		$scope.filtriraj();
	}
});



app.controller("editKolaCtrl", function($scope, $routeParams, $http, $location){
	
	//console.log($routeParams);
	var kolaId = $routeParams.aid;
	var baseUrl = "/api/automobili";
	
	$scope.novoAutoE = {};

	var getActivity = function(){
		
		$http.get(baseUrl + "/" + kolaId).then(
			function success(res){
				$scope.novoAutoE = res.data;
			},
			function error(res){
				console.log("Something went wrong!");
			}	
		);
	}
	
	getActivity();
	
	$scope.izmeni = function(){
		$http.put(baseUrl + "/" + kolaId, $scope.novoAutoE).then(
			function success(res){
				//alert("Uspeh");
				
				$location.path("/");
			},
			function error(res){
				alert("Something went wrong");
			}
		);
	}
	
});








app.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/', {
			templateUrl : '/app/html/partial/burad.html',
		})
		.when('/otpis', {
			templateUrl : '/app/html/partial/otpis.html',
		})
		.when('/pretraga', {
			templateUrl : '/app/html/partial/pretraga.html',
		})
		.when('/tstanje', {
			templateUrl : '/app/html/partial/trenutnostanje.html'
		})
		.otherwise({
			redirectTo: '/'
		});
}]);
