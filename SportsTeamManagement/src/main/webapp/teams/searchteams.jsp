<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
</head>
<body ng-app="searchteamApp" ng-controller="searchteamController" >
<img ng-src="{{angularShield.png}}" />
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Search/update a team</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Team Name</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.teamName" >
    </div>
    <div class="form-group">
        <label>Sports Category</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.sportsCategory" >
    </div>
       <div class="form-group">
        <label>Rating Score</label>
        <input type="text" name="name" class="form-control" ng-model="teammodel.ratingScore" >
    </div>
		<button type="submit" class="btn btn-primary">Search team</button> 
		
<section>

<h1>Search results</h1>
    <label>Team Name</label>
    <input type="text" name="name" class="form-control" ng-model="deal.teamName" ng-disabled="true">
    
    
    
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
    <button type="button" class="btn btn-primary" ng-click="clearteamdetails()">Clear</button>
    		<button type="button" class="btn btn-primary" ng-click="updateteamdetails()">Update team in DB</button> 
		<button type="button" class="btn btn-primary" ng-click="deleteteam()">Delete team </button> 
		<button type="button" class="btn btn-primary" ng-click="findallteams()">Find all teams </button> 
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
    
    var addpl = angular.module('searchteamApp', []);
    // Controller function and passing $http service and $scope var.
    addpl
    
    
   
    
    
    .controller('searchteamController', function($scope, $http, $window,simpleFactory,$rootScope) {
    	
    	$rootScope.loginname = $window.localStorage.getItem("user") ;
    	
         $scope.submitForm = function() {


    	  
        $http({
          method  : 'POST',
          url     : '/SportsTeamManagement/searchteam',
          data    : $scope.teammodel ,
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
      	      $scope.deal = data;
      	      
          });
        

       
       
       
         };
         
         $scope.findallteams = function() {
          	$window.location.href = '/SportsTeamManagement/teams/findallteams.jsp';
          }
         
         $scope.dologout = function() {
        	 $window.localStorage.setItem("registration","");
        	 $window.localStorage.setItem("user","Please login or register, if you don't have a name");
         	$window.location.href = '/SportsTeamManagement/login/login.jsp';
         }
         
         
         
         $scope.backtohome = function() {
         	$window.location.href = '/SportsTeamManagement/home/home.jsp';
         }
         
         
         $scope.clearteamdetails = function() {
        	 $scope.deal={};
         }
         $scope.updateteamdetails = function() {
       	  
             $http({
               method  : 'POST',
               url     : '/SportsTeamManagement/updateteam',
               data    : $scope.deal ,
               headers : {'Content-Type': 'application/json'} 
              })
               .success(function(data) {
               });
             

              	 
         }
         
         
         $scope.deleteteam = function() {
        	 
        	 $http({
                 method  : 'POST',
                 url     : '/SportsTeamManagement/deleteteam',
                 data    : $scope.deal ,
                 headers : {'Content-Type': 'application/json'} 
                })
                 .success(function(data) {
                 });
               

                	 
           }
        	 
     
         
    }); 
  
  
  
</script>

  </body>  
</html>  
