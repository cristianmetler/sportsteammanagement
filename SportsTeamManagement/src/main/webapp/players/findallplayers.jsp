<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
</head>
<body ng-app="findallplayersApp" ng-controller="findallplayersController" >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Find all players</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
		<button type="submit" class="btn btn-primary">Search players</button> 
		
<section>

<h1>Search results</h1>


<table>
<tr>
<td><label>Player Name</label></td>
<td><label>Age</label></td>
<td><label>Rank</label></td>
<td><label>Team Name</label></td>
<td><label>Sports Category</label></td>
<td><label>Income</label></td>
<td><label>Is married</label></td>
<td><label>Spouse Name</label></td>
<td><label>Has children</label></td>
<td><label>Children Details</label></td>
<td><label>Address</label></td>
<td><label>Rating Score</label></td>
<td><label>Email Address</label></td>
<td><label>Phone Number</label></td>





</tr>
  <tr ng-repeat="player in players | filter: nameText | orderBy: 'address'">
    <td>{{ player.playerName }}</td>
    <td>{{ player.age }}</td>
    <td>{{ player.rank }}</td>
    <td>{{ player.teamName }}</td>
    <td>{{ player.sportsCategory }}</td>
    <td>{{ player.income }}</td>
    <td>{{ player.isMarried }}</td>
    <td>{{ player.spouseName }}</td>
    <td>{{ player.hasChildren }}</td>
    <td>{{ player.childrenDetails }}</td>
    <td>{{ player.address }}</td>
    <td>{{ player.ratingScore }}</td>
    <td>{{ player.emailAddress }}</td>
    <td>{{ player.phoneNumber }}</td>
    
    
    
    
  </tr>
</table>

		<button type="button" class="btn btn-primary" ng-click="cleardetails()">Clear </button>
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
		<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
		</div>
    
    
    
    
     
  </section>
	
	<script>
	
	
	 var addpl = angular.module('findallplayersApp', []);
	    // Controller function and passing $http service and $scope var.
	    addpl.controller('findallplayersController', function($scope, $http, $window,$rootScope) {

	    	$rootScope.loginname = $window.localStorage.getItem("user") ;

	         $scope.submitForm = function() {

	       
	    	  
	        $http({
	          method  : 'GET',
	          url     : '/SportsTeamManagement/searchallplayers'
	         })
	          .success(function(data) {
	      	      $scope.players = data;
	          });
	        

	         $scope.cleardetails = function() {
	        	 $scope.players=[{}];
	         }
	         
	       
	       
	         };
	         
	         
	         $scope.dologout = function() {
	        	 $window.localStorage.setItem("registration","");
	        	 $window.localStorage.setItem("user","Please login or register, if you don't have a name");
	         	$window.location.href = '/SportsTeamManagement/login/login.jsp';
	         }
	         
	         
	         
	         $scope.backtohome = function() {
	         	$window.location.href = '/SportsTeamManagement/players/searchplayer.jsp';
	         }
	         
	         
	     
	         
	    }); 
	
	
	
	</script>	
		
		<style>
table, th , td {
  border: 1px solid grey;
  border-collapse: collapse;
  padding: 5px;
}
table tr:nth-child(odd) {
  background-color: #f1f1f1;
}
table tr:nth-child(even) {
  background-color: #ffffff;
}
</style>
		
		
</form>
</div>
</div>


<