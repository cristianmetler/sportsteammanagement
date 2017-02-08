<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>  
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
</head>

<script>
var app = angular.module('loginregisterApp', []);

app.controller('loginController', function($scope, $http, $window) {

	$scope.dologin = function() {
		
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
    	$window.location.href = '/SportsTeamManagement/home/home.jsp';
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


// app.controller('checkcontroller', function ($scope) {
//     $scope.checkContent = function(){
//       if($scope.authenticateUserRequest.username.length === 0) {
//          $scope.msg = "Enter an username";
//       }
//       if($scope.authenticateUserRequest.password.length === 0) {
//           $scope.msg = "Enter a password";
//        }
//      }; 

// });



</script>



<body ng-app="loginregisterApp">
<div class="page-header"><h1>Welcome to the Sports Teams Management website</h1></div>
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
<h5>*If you don't have an account yet, please register.</h5>
	</form>	


  </body>  
</html>  

