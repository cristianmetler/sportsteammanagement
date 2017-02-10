<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
</head>
<body ng-app="addteamApp" ng-controller="addteamController" >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Add a new team</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Player Name</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.playerName" required>
    </div>

    <input type="checkbox" ng-checked="all">Subscribe to our site's weekly newsletter<br>
		<button type="submit" class="btn btn-primary" >Add player</button> 
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
			
		<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
			
		</div>
</form>
</div>
</div>

    <script>
    // Defining angularjs application.
    
    var addpl = angular.module('addteamApp', []);
    // Controller function and passing $http service and $scope var.
    addpl.controller('addteamController', function($scope, $http, $window) {


      // calling our submit function.
        $scope.submitForm = function() {
    	  
       
        $http({
          method  : 'POST',
          url     : '/SportsTeamManagement/addplayer',
          data    : $scope.playermodel ,
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
        	  $window.location.href = '/SportsTeamManagement/home/home.jsp';
          });
        };
        
        
       $scope.dologout = function () {
    	   $window.location.href = '/SportsTeamManagement/login/login.jsp'; 
       }
        
        
        $scope.backtohome = function() {
        	$window.location.href = '/SportsTeamManagement/home/home.jsp';
        }
    }); 
  

    	
  
  
</script>

  </body>  
</html>  
