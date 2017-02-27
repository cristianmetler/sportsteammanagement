<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 

</head>
<body ng-app="findalldealsApp" ng-controller="findalldealsController" >
<div class="container">
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Find all deals</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
		<button type="submit" class="btn btn-primary">Search deals</button> 
		
<section>

<h1>Search results</h1>


<table>
<tr>
<td><label>Deal Name</label></td>
<td><label>Valability</label></td>
<td><label>Number of players bought</label></td>
<td><label>Number of players sold</label></td>
<td><label>Sports Cateogry</label></td>
<td><label>Amount Transactioned</label></td>

</tr>
  <tr ng-repeat="deal in deals  | filter: nameText | orderBy: 'amountTransactioned'">
    <td>{{ deal.desire }}</td>
    <td>{{ deal.valability }}</td>
    <td>{{ deal.numberOfPlayersBought }}</td>
    <td>{{ deal.numberOfPlayerssold }}</td>
    <td>{{ deal.sportsCategory }}</td>
    <td>{{ deal.amountTransactioned }}</td>
    
  </tr>
</table>

		<button type="button" class="btn btn-primary" ng-click="cleardetails()">Clear </button>
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
		<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
		</div>
    
    
    
    
     
  </section>
	
	<script>
	
	
	 var addpl = angular.module('findalldealsApp', []);
	    // Controller function and passing $http service and $scope var.
	    addpl.controller('findalldealsController', function($scope, $http, $window,$rootScope) {

	    	$rootScope.loginname = $window.localStorage.getItem("user") ;

	         $scope.submitForm = function() {

	       
	    	  
	        $http({
	          method  : 'GET',
	          url     : '/SportsdealManagement/findalldeals'
	         })
	          .success(function(data) {
	      	      $scope.deals = data;
	          });
	        

	         $scope.cleardetails = function() {
	        	 $scope.deals=[{}];
	         }
	         
	       
	       
	         };
	         
	         
	         $scope.dologout = function() {
	        	 $window.localStorage.setItem("registration","");
	        	 $window.localStorage.setItem("user","Please login or register, if you don't have a name");
	         	$window.location.href = '/SportsdealManagement/login/login.jsp';
	         }
	         
	         
	         
	         $scope.backtohome = function() {
	         	$window.location.href = '/SportsdealManagement/home/home.jsp';
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
