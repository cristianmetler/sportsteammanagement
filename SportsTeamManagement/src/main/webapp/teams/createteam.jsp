<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
</head>
<body ng-app="addteamApp" ng-controller="addteamController" >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Add a new team</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Team Name</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.teamName" required>
    </div>
    
        <div class="form-group">
        <label>Founded in year:</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.foundedInYear" required>
    </div>
    
            <div class="form-group">
        <label>Sports Category</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.sportsCategory" required>
    </div>
    
            <div class="form-group">
        <label>Number of active players</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.numberOfPlayers" required>
    </div>
    
    
    
    
            <div class="form-group">
        <label>Income( $ )</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.income" required>
    </div>
    
    
    
    
    
    
            <div class="form-group">
        <label>Rating Score:</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.ratingScore" required>
    </div>
    

            <div class="form-group">
        <label>Phone Number</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.phoneNumber" required>
    </div>
    
     
                <div class="form-group">
        <label>Address</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.address" required>
    </div>
    
    
                <div class="form-group">
        <label>Email Address</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.emailAddress" required>
    </div>
    
    
    

    <input type="checkbox" ng-checked="all">Subscribe to our site's weekly newsletter<br>
		<button type="submit" class="btn btn-primary" >Add team</button> 
		<button type="button" class="btn btn-primary" ng-click="clear()">Clear </button> 
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
    addpl.controller('addteamController', function($scope, $http, $window,$rootScope) {
    	$rootScope.loginname = $window.localStorage.getItem("user") ;

      // calling our submit function.
        $scope.submitForm = function() { 
       
        $http({
          method  : 'POST',
          url     : '/SportsTeamManagement/addteam',
          data    : $scope.teammodel ,
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
        	  $window.location.href = '/SportsTeamManagement/home/home.jsp';
          });
        };
        
        $scope.dologout = function() {
        	$window.localStorage.setItem("registration","");
        	$window.localStorage.setItem("user","Please login or register, if you don't have a name");
        	$window.location.href = '/SportsTeamManagement/login/login.jsp';
        }
        
        $scope.clear = function() {
        	$scope.teammodel = {};
        }
        
        $scope.backtohome = function() {
        	$window.location.href = '/SportsTeamManagement/home/home.jsp';
        }
    }); 
  
    addpl.controller('Ctrl', function($scope) {
  $scope.emailFormat = /^[a-z]+[a-z0-9._]+@[a-z]+\.[a-z.]{2,5}$/;
});
   	
    	
  
  
</script>

  </body>  
</html>  