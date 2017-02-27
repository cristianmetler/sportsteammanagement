<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 

</head>
<body ng-app="findallteamsApp" ng-controller="findallteamsController" >
<div class="container">
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Find all teams</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
		<button type="submit" class="btn btn-primary">Search teams</button> 
		
<section>

<h1>Search results</h1>


<table>
<tr>
<td><label>Team Name</label></td>
<td><label>Founded in Year</label></td>
<td><label>Sports Category</label></td>
<td><label>Number of active teams</label></td>
<td><label>Annual income</label></td>
<td><label>Rating Score</label></td>
<td><label>Address</label></td>
<td><label>Phone number</label></td>
<td><label>Email Address</label></td>

</tr>
  <tr ng-repeat="team in teams | filter: nameText | orderBy: 'address'">
    <td>{{ team.teamName }}</td>
    <td>{{ team.foundedInYear }}</td>
    <td>{{ team.sportsCategory }}</td>
    <td>{{ team.numberOfPlayers }}</td>
    <td>{{ team.income }}</td>
    <td>{{ team.ratingScore }}</td>
    <td>{{ team.address }}</td>
    <td>{{ team.phoneNumber }}</td>
    <td>{{ team.emailAddress }}</td> 
    
  </tr>
</table>

		<button type="button" class="btn btn-primary" ng-click="cleardetails()">Clear </button>
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
		<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
		</div>
    
    
    
    
     
  </section>
	
	<script>
	
	
	 var addpl = angular.module('findallteamsApp', []);
	    // Controller function and passing $http service and $scope var.
	    addpl.controller('findallteamsController', function($scope, $http, $window,$rootScope) {

	    	$rootScope.loginname = $window.localStorage.getItem("user") ;

	         $scope.submitForm = function() {

	       
	    	  
	        $http({
	          method  : 'GET',
	          url     : '/SportsTeamManagement/findallteams'
	         })
	          .success(function(data) {
	      	      $scope.teams = data;
	          });
	        

	         $scope.cleardetails = function() {
	        	 $scope.teams=[{}];
	         }
	         
	       
	       
	         };
	         
	         
	         $scope.dologout = function() {
	        	 $window.localStorage.setItem("registration","");
	        	 $window.localStorage.setItem("user","Please login or register, if you don't have a name");
	         	$window.location.href = '/SportsTeamManagement/login/login.jsp';
	         }
	         
	         
	         
	         $scope.backtohome = function() {
	         	$window.location.href = '/SportsTeamManagement/home/home.jsp';
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

  </body>  
</html> 