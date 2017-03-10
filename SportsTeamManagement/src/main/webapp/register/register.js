
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
    
