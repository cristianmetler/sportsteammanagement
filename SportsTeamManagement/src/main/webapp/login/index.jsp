<!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js'></script>



	<script type="text/javascript" src="script.js"></script>
	
	
<!-- 	<script type="text/javascript" src="/SportsTeamManagement/login/loginorregister.js"></script> -->
<!--   	<script type="text/javascript" src="/SportsTeamManagement/register/register.js"></script> -->
  
  <script>
function loginController($scope, $http, $window, $rootScope) {
	
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
	
};

app.controller("loginController",loginController); 

function registerController($scope, $http, $window, $rootScope) {


    
    // calling our submit function.
      $scope.doregister = function() {
      $http({
        method  : 'POST',
        url     : '/SportsTeamManagement/register',
        data    : $scope.authenticateUserRequest, //forms user object
        headers : {'Content-Type': 'application/json'} 
       })
        .success(function(data) {
      	  if (data == null || data == "") {
      		  $rootScope.incorrectorlogin ="The user already exists, please register using another one";		  
      	  }
      	  else {
      		  $rootScope.incorrectorlogin ="User successfully registered, please login again";
      		  
          	  
      	  }
      	  $window.localStorage.setItem("registration", $rootScope.incorrectorlogin);
      	  $window.location.href = '/SportsTeamManagement/login/login.jsp';
        });
      };
  }; 

 app.controller('registerController',registerController);
  
  
 function Ctrl($scope) {
	   
$scope.text = 'me@example.com';
$scope.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
};
 
app.controller('Ctrl',Ctrl);
  

</script>
  </head>
  <body ng-app="modulprincipal">
    <div class='container'>
      <h1>Sports Team Management </h1>
      <ul class='nav navbar-nav'>
        <li><a ui-sref="login">Login</a></li>
        <li><a ui-sref="register">Register</a></li>
      </ul>
      
    </div>

    

	<div ui-view=""></div>
	


    
    

    
  </body>

</html>