<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
</head>
<body ng-app="adddealApp" ng-controller="adddealController" >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Search/update a deal</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Deal Name</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.dealName" required>
    </div>

<section>

<h1>Search results</h1>
    <label>Deal Name</label>
    <input type="text" name="name" class="form-control" ng-model="deal.desire" ng-disabled="true">
    
    
    
       <div class="form-group">
        <label>Founded in Year</label>
        <input type="text" name="name" class="form-control" ng-model="deal.foundedInYear" >
    </div>
    
            <div class="form-group">
        <label>Sports Category</label>
        <input type="text" name="name" class="form-control" ng-model="deal.sportsCategory" >
    </div>
    
            <div class="form-group">
        <label>Number of Active dealers</label>
        <input type="text" name="name" class="form-control" ng-model="deal.numberOfdealers" >
    </div>
    
            <div class="form-group">
        <label>Income ($)</label>
        <input type="text" name="name" class="form-control" ng-model="deal.income" >
    </div>
    
    
    
            <div class="form-group">
        <label>Rating Score</label>
        <input type="text" name="name" class="form-control" ng-model="deal.ratingScore" >
    </div>
   
            <div class="form-group">
        <label>Phone Number</label>
        <input type="text" name="name" class="form-control" ng-model="deal.phoneNumber" >
    </div>
    
        
            <div class="form-group">
        <label>Address</label>
        <input type="text" name="name" class="form-control" ng-model="deal.address" >
    </div>
    
    
        <div class="form-group">
        <label>Email Address</label>
        <input type="email" name="input" class="form-control" ng-model="deal.emailAddress" >
    </div>
    <button type="button" class="btn btn-primary" ng-click="cleardealdetails()">Clear</button>
    		<button type="button" class="btn btn-primary" ng-click="updatedealdetails()">Update deal in DB</button> 
		<button type="button" class="btn btn-primary" ng-click="deletedeal()">Delete deal </button> 
		<button type="button" class="btn btn-primary" ng-click="findalldeals()">Find all deals </button> 
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
		<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
		</div>
    
    
    
    
     
  </section>


   
</form>
</div>
</div>

    <script>
    // Defining angularjs application.
    
    var addpl = angular.module('adddealApp', []);
    // Controller function and passing $http service and $scope var.
    addpl.controller('adddealController', function($scope, $http, $window,$rootScope) {
    	$rootScope.loginname = $window.localStorage.getItem("user") ;

      // calling our submit function.
        $scope.submitForm = function() {
    	  
       
        $http({
          method  : 'POST',
          url     : '/SportsdealManagement/adddeal',
          data    : $scope.dealmodel ,
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
        	  $window.location.href = '/SportsdealManagement/home/home.jsp';
          });
        };
        
        
        $scope.dologout = function() {
        	$window.localStorage.setItem("user","Please login or register, if you don't have a name");
        	$window.localStorage.setItem("registration","");
        	$window.location.href = '/SportsdealManagement/login/login.jsp';
        }
        
        
        
        $scope.backtohome = function() {
        	$window.location.href = '/SportsdealManagement/home/home.jsp';
        }
    }); 
  

    	$scope.findalldeals = function() {
    		window.location.href = '/SportsTeamManagement/teams/findalldeals.jsp';
    	}
  
  
</script>

  </body>  
</html>  
