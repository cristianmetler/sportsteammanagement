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
    <div class="page-header"><h1>Make a new deal</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">

     <div class="form-group">
        <label>deal name</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.desire" required>
    </div>


    
     <div class="form-group">
        <label>Valability (years)</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.valability" required>
    </div>
    
    
        <div class="form-group">
        <label>Number of players bought</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.numberOfPlayersBought" required>
    </div> 

        <div class="form-group">
        <label>Number of players sold</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.numberOfPlayerssold" required>
    </div> 

        <div class="form-group">
        <label>Sports Cateogory</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.sportsCategory" required>
    </div> 


        <div class="form-group">
        <label>Amount Transactioned ( $ )</label>
        <input type="text" name="name" class="form-control" ng-model="dealmodel.amountTransactioned" required>
    </div> 




    <input type="checkbox" ng-checked="all">Subscribe to our site's weekly newsletter<br>
		<button type="submit" class="btn btn-primary" >Add deal</button> 
		<button type="button" class="btn btn-primary" ng-click="backtohome()">Back </button> 
				<div class="form-group">
			<button  ng-click="dologout()" >Logout</button>
			
		</div>
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
        	  $window.location.href = '/SportsTeamManagement/home/home.jsp';
          });
        };
        
        
        $scope.dologout = function() {
        	$window.localStorage.setItem("registration","");
        	$window.localStorage.setItem("user","Please login or register, if you don't have a name");
        	$window.location.href = '/SportsdealManagement/login/login.jsp';
        }
        
        
        
        $scope.backtohome = function() {
        	$window.location.href = '/SportsTeamManagement/home/home.jsp';
        }
    }); 
  

    	
  
  
</script>

  </body>  
</html>  
