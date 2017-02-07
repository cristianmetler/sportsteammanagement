<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>  
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
</head>

<script>
var app = angular.module('loginregisterApp', []);

app.controller('loginController', function($scope, $http) {

	$scope.dologin = function() {



$http({
    method  : 'POST',
    url     : '/SportsTeamManagement/ceva/1',
    data    : $scope.authenticateUserRequest, //forms user object
    headers : {'Content-Type': 'application/json'} 
   })
    .success(function(data) {
      if (data.errors) {
        $scope.errorName = data.errors.username;
        $scope.errorUserName = data.errors.password;
      } else {
        $scope.message = data.message;
      }
    });

	};
	
});

app.controller('registerController', function($scope, $http) {


	$scope.doregister = function() {
		$http({
		    method  : 'POST',
		    url     : '/SportsTeamManagement/ceva/2',
		    data    : $scope.authenticateUserRequest, //forms user object
		    headers : {'Content-Type': 'application/json'} 
		   })
		    .success(function(data) {
		      if (data.errors) {
		        $scope.errorName = data.errors.username;
		        $scope.errorUserName = data.errors.password;
		      } else {
		        $scope.message = data.message;
		      }
		    });

			};
});


</script>



<body ng-app="loginregisterApp">
<div class="page-header"><h1>Welcome to the Sports Teams Management website</h1></div>
<form >
		<div class="form-group">
			<label for="username">UserName</label>
			<input type="text" name="username" ng-model="authenticateUserRequest.username" required>
		</div>
	<div class="form-group">
			<label for="password">Password</label>
			<input type="text" name="password" ng-model="authenticateUserRequest.password" required>
		
		</div>
			
		<div class="form-group">
			<button  ng-controller="loginController" ng-click="dologin()">Login</button>
		</div>
		<div class="form-group">
			<button ng-controller="registerController" ng-click="doregister()">Register</button>
		</div>
<h5>*If you don't have an account yet, please register.</h5>
	</form>	


  </body>  
</html>  

