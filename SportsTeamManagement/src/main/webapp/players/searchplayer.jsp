<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
</head>
<body ng-app="addteamApp" ng-controller="addteamController" >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Search/update a player</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Player Name</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.playerName" >
    </div>
    <div class="form-group">
        <label>Team</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.teamName" >
    </div>
       <div class="form-group">
        <label>Sports Category</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.sportsCategory" >
    </div>
    <input type="checkbox" ng-checked="all">Subscribe to our site's weekly newsletter<br>
		<button type="submit" class="btn btn-primary">Search player</button> 
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
		<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
		</div>
		<h2 ng-repeat="player in data.PlayerEntity">{{player.userName}}</h2> 
<!-- <section ng-controller="displayPlayer"> -->
<!--     <label>Player Name</label> -->
<!--         <input type="text" name="name" class="form-control" ng-model="data.playerName" >   -->
<!--   </section> -->
		
		
</form>
</div>
</div>

    <script>
    // Defining angularjs application.
    
    var addpl = angular.module('addteamApp', []);
    // Controller function and passing $http service and $scope var.
    addpl.controller('addteamController', function($scope, $http, $window) {



         $scope.submitForm = function() {

       
    	  
        $http({
          method  : 'POST',
          url     : '/SportsTeamManagement/searchplayer',
          data    : $scope.playermodel ,
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function() {
        	  $http.get("http://localhost:8080/SportsTeamManagement/players/searchplayer")
      	    .then(function(response) {
      	      $scope.data = response.data;
          });
        

         
       
         
          });
         };
         
         
         $scope.dologout = function() {
         	$window.location.href = '/SportsTeamManagement/login/login.jsp';
         }
         
         
         
         $scope.backtohome = function() {
         	$window.location.href = '/SportsTeamManagement/home/home.jsp';
         }
         
    }); 
  
//     addpl.controller('displayPlayer', function($scope, $http) {

//     	  $http.get("http://localhost:8080/SportsTeamManagement/players/searchplayer")
//     	    .then(function(response) {
//     	      $scope.data = response.data;
//     	    });
//     	});
    	
  
  
</script>

  </body>  
</html>  
