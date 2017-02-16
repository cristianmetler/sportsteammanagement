<html>  
  <head>    
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>      
    <body>
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
<p></p><p></p><p></p><p></p>
<h3> {{ loginname }} </h3>
<p></p><p></p><p></p>
</head>
<body ng-app="addplayerApp" ng-controller="addplayerController" >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h1>Add a new player</h1></div>
    <!-- FORM -->
    <form name="userForm" ng-submit="submitForm()">
    <div class="form-group">
        <label>Player Name</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.playerName" required>
    </div>
    
        <div class="form-group">
        <label>Age</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.age" required>
    </div>
    
            <div class="form-group">
        <label>Position in the team</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.rank" required>
    </div>
    
            <div class="form-group">
        <label>Team Name</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.teamName" required>
    </div>
    
            <div class="form-group">
        <label>Sports Category</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.sportsCategory" required>
    </div>
    
    
    
            <div class="form-group">
        <label>Income( $ )</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.income" required>
    </div>
    
    
    
    
        <div class="form-group">
        <label>Married</label>
        <input type="checkbox" ng-model="isMarried" ng-change="change()" >
        <label>Spouse name</label>
          <input type="text" name="text" ng-model="playermodel.spouseName"  ng-disabled="!isMarried">
    </div>
    
         <div class="form-group">
        <label>Children</label>
        <input type="checkbox" ng-model="hasChildren" ng-change="change1()">
        <label>Children names</label>
          <input type="text" name="text1" ng-model="playermodel.childrenDetails" ng-disabled="!hasChildren">
    </div>
    
    
    
    
    
            <div class="form-group">
        <label>Address</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.address" required>
    </div>
    
            <div class="form-group">
        <label>Rating Score (1-5 stars)</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.ratingScore" required>
    </div>
    

            <div class="form-group">
        <label>Phone Number</label>
        <input type="text" name="name" class="form-control" ng-model="playermodel.phoneNumber" required>
    </div>
    
    
        <div class="form-group">
        <label>Email Address</label>
        <input type="email" name="input" class="form-control" ng-model="playermodel.emailAddress" ng-pattern="emailFormat" required ng-controller="Ctrl">
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
    
    var addpl = angular.module('addplayerApp', []);
    // Controller function and passing $http service and $scope var.
    addpl.controller('addplayerController', function($scope, $http, $window,$rootScope) {
    	$rootScope.loginname = $window.localStorage.getItem("user") ;

      // calling our submit function.
        $scope.submitForm = function() {
    	  
       $scope.playermodel.isMarried = $scope.isMarried  ;
       $scope.playermodel.hasChildren = $scope.hasChildren ;
            
       
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
        
        $scope.dologout = function() {
        	$window.localStorage.setItem("user","Please login or register, if you don't have a name");
        	$window.location.href = '/SportsTeamManagement/login/login.jsp';
        }
        
        
        $scope.change = function () {
            if ($scope.isMarried == false) {
         	   $scope.playermodel.spouseName = "";  
            }
        }   
        
        $scope.change1 = function () {
        
            if ($scope.hasChildren == false) {
         	   $scope.playermodel.childrenDetails = "";  
            }
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
