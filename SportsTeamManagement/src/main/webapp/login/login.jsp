<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>  
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 

<script>
var app = angular.module('loginregisterApp', []);

app.controller('loginController', function($scope, $http, $window,$rootScope) {
	

		$rootScope.loginname = "*Please login or register, if you don't have a name!";

	$rootScope.incorrectorlogin=$window.localStorage.getItem("registration");
	
	$scope.dologin = function() {
		var loginname ={};
// 		if($scope.authenticateUserRequest.username.length === 0) {
// 	         $scope.msg = "Enter an username";
// 	      }
// 	      if($scope.authenticateUserRequest.password.length === 0) {
// 	          $scope.msg = "Enter a password";
// 	       }


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



app.controller('registerController', function($scope, $http, $window) {


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


</script>




<body ng-app="loginregisterApp">
<div class="page-header"><h1>Welcome to the Sports Teams Management website</h1></div>

<p></p><p></p><p></p><p></p>
<h5> {{ loginname }} </h5>
<p></p><p></p><p></p>

<p></p><p></p><p></p><p></p>
<h5> {{ incorrectorlogin }} </h5>
<p></p><p></p><p></p>

</head>



<form >
		<div class="form-group">
			<label for="username">UserName</label>
			<input type="text" name="username" ng-model="authenticateUserRequest.username" ng-bind="msg">
			
		</div>
	<div class="form-group">
			<label for="password">Password</label>
			<input type="text" name="password" ng-model="authenticateUserRequest.password" ng-bind="msg">
		
		</div>
			
		<div class="form-group">
			<button  ng-controller="loginController" ng-click="dologin()" >Login</button>
			
		</div>
		<div class="form-group">
			<button ng-controller="registerController" ng-click="doregister()">Register</button>
		</div>
	</form>	


  </body>  
</html>  

