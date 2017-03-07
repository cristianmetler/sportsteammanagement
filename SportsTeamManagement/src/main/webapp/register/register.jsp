<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
</head>
<body ng-app="registerApp" ng-controller="registerController">
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h3>Welcome to the registration page</h3></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Username</label>
        <input type="text" name="name" class="form-control" ng-model="authenticateUserRequest.username" required>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="text" name="username" class="form-control" ng-model="authenticateUserRequest.password" required>
    </div>
        <div class="form-group">
        <label>Email Address</label>
        <input type="email" name="input" class="form-control" ng-model="text" ng-pattern="emailFormat" required ng-controller="Ctrl">
    </div>
    <input type="checkbox" ng-checked="all">Subscribe to our site's weekly newsletter<br>
		<button type="submit" class="btn btn-primary">Register</button> 
</form>
</div>
</div>

    <script>
    // Defining angularjs application.
    var register = angular.module('registerApp', []);
    // Controller function and passing $http service and $scope var.
    register.controller('registerController', function($scope, $http, $window, $rootScope) {
      // create a blank object to handle form data.
        $scope.authenticateUserRequest= {};
      
      // calling our submit function.
        $scope.submitForm = function() {
        $http({
          method  : 'POST',
          url     : '/SportsTeamManagement/register',
          data    : $scope.authenticateUserRequest, //forms user object
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
        	  if (data == null || data == "") {
        		  $rootScope.incorrectorlogin ="The user already exists, please register using another one";
        		  $window.localStorage.setItem("registration", $rootScope.incorrectorlogin);
        		  $window.location.href = '/SportsTeamManagement/login/login.jsp';
        	  }
        	  else {
        		  $rootScope.incorrectorlogin ="User successfully registered, please login again";
        		  $window.localStorage.setItem("registration", $rootScope.incorrectorlogin);
            	  $window.location.href = '/SportsTeamManagement/login/login.jsp';  
        	  }
        	// 
          });
        };
    }); 
  
register.controller('Ctrl', function($scope) {
  $scope.text = 'me@example.com';
  $scope.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
});
    
    
  
</script>

  </body>  
</html>  
