 var app1 = angular.module('loginregisterApp', []);


app1.controller('loginController', function($scope, $http, $window,$rootScope) {
	

		$rootScope.loginname = "*Please login or register, if you don't have a name!";

	$rootScope.incorrectorlogin=$window.localStorage.getItem("registration");
	
	$scope.dologin = function() {
		var loginname ={};

        $http({
            method  : 'POST',
            url     : '/SportsTeamManagement/ceva',
            data    : $scope.authenticateUserRequest, //forms user object
            headers : {'Content-Type': 'application/json'} 
           })
    .success(function(data) {
    	if (data != null && data != ""){
    		$rootScope.loginname = 	"Hi," + data.username + ", you are logged in";
    		$window.localStorage.setItem("user",$rootScope.loginname);
    		$window.location.href = '/SportsTeamManagement/home/home.jsp';	
    		
    	}
    	
    	else {
    		window.localStorage.setItem("registration","User does not exist, please login again");
        	$window.location.href = '/SportsTeamManagement/login/login.jsp';
    	}
    });

	};
	
});


app1.controller('registerController', function($scope, $http, $window) {


	$scope.doregister = function() {
		$http({
		    method  : 'GET',
		    url     : '/SportsTeamManagement/ggg',
		   })
		    .success(function(data) {
		    	 $window.location.href = '/SportsTeamManagement/register/register.jsp';
		    });

			};
});
