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
<img ng-src="{{angularShield.png}}" />
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
		<button type="submit" class="btn btn-primary">Search player</button> 
		
<section>

<h1>Search results</h1>
    <label>Player Name</label>
    <input type="text" name="name" class="form-control" ng-model="play.playerName" ng-disabled="true">
    
    
    
       <div class="form-group">
        <label>Age</label>
        <input type="text" name="name" class="form-control" ng-model="play.age" >
    </div>
    
            <div class="form-group">
        <label>Position in the team</label>
        <input type="text" name="name" class="form-control" ng-model="play.rank" >
    </div>
    
            <div class="form-group">
        <label>Team Name</label>
        <input type="text" name="name" class="form-control" ng-model="play.teamName" >
    </div>
    
            <div class="form-group">
        <label>Sports Category</label>
        <input type="text" name="name" class="form-control" ng-model="play.sportsCategory" >
    </div>
    
    
    
            <div class="form-group">
        <label>Income( $ )</label>
        <input type="text" name="name" class="form-control" ng-model="play.income" >
    </div>
    
    
    
    
        <div class="form-group">
        <label>Married</label>
        <input type="checkbox" ng-model="play.isMarried" >
        <label>Spouse name</label>
          <input type="text" name="text" ng-model="play.spouseName"  ng-disabled="!play.isMarried">
    </div>
    
         <div class="form-group">
        <label>Children</label>
        <input type="checkbox" ng-model="play.hasChildren">
        <label>Children names</label>
          <input type="text" name="text1" ng-model="play.childrenDetails" ng-disabled="!play.hasChildren">
    </div>
    
    
    
    
    
            <div class="form-group">
        <label>Address</label>
        <input type="text" name="name" class="form-control" ng-model="play.address" >
    </div>
    
            <div class="form-group">
        <label>Rating Score (1-5 stars)</label>
        <input type="text" name="name" class="form-control" ng-model="play.ratingScore" >
    </div>
    

            <div class="form-group">
        <label>Phone Number</label>
        <input type="text" name="name" class="form-control" ng-model="play.phoneNumber" >
    </div>
    
    
        <div class="form-group">
        <label>Email Address</label>
        <input type="email" name="input" class="form-control" ng-model="play.emailAddress" >
    </div>
    <button type="button" class="btn btn-primary" ng-click="clearplayerdetails()">Clear</button>
    		<button type="button" class="btn btn-primary" ng-click="updateplayerdetails()">Update player in DB</button> 
		<button type="button" class="btn btn-primary" ng-click="deleteplayer()">Delete player </button> 
		<button type="button" class="btn btn-primary" ng-click="findallplayers()">Find all players </button> 
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
    
    var addpl = angular.module('addteamApp', []);
    // Controller function and passing $http service and $scope var.
    addpl
    
    
    .factory('simpleFactory', function() {
    var factory = {};
    var customers = // default values
    	{playerName: 'joint doggy dogg',age: '45', rank: 'captain kirk',teamName: 'los angeles something', sportsCategory : 'basketball',
    		income: '900',isMarried: 'false', spouseName: '',hasChildren: 'false', childrenDetails: '',address: 'ceva',ratingScore: '5',
    		emailAddress: 'addressemail@yahoo.com', phoneNumber: '53453534534'};
    factory.getCustomers = function() {
    	return customers;
    };
    return factory;
    
    })
    
    
    .controller('addteamController', function($scope, $http, $window,simpleFactory,$rootScope) {
    	
    	$rootScope.loginname = $window.localStorage.getItem("user") ;
    	
        $scope.play =simpleFactory.getCustomers();
         $scope.submitForm = function() {


    	  
        $http({
          method  : 'POST',
          url     : '/SportsTeamManagement/searchplayer',
          data    : $scope.playermodel ,
          headers : {'Content-Type': 'application/json'} 
         })
          .success(function(data) {
      	      $scope.play = data;
      	      
          });
        

       
       
       
         };
         
         $scope.findallplayers = function() {
          	$window.location.href = '/SportsTeamManagement/players/findallplayers.jsp';
          }
         
         $scope.dologout = function() {
        	 $window.localStorage.setItem("user","Please login or register, if you don't have a name");
         	$window.location.href = '/SportsTeamManagement/login/login.jsp';
         }
         
         
         
         $scope.backtohome = function() {
         	$window.location.href = '/SportsTeamManagement/home/home.jsp';
         }
         
         
         $scope.clearplayerdetails = function() {
        	 $scope.play={};
         }
         $scope.updateplayerdetails = function() {
       	  
             $http({
               method  : 'POST',
               url     : '/SportsTeamManagement/updateplayer',
               data    : $scope.play ,
               headers : {'Content-Type': 'application/json'} 
              })
               .success(function(data) {
               });
             

              	 
         }
         
         
         $scope.deleteplayer = function() {
        	 
        	 $http({
                 method  : 'POST',
                 url     : '/SportsTeamManagement/deleteplayer',
                 data    : $scope.play ,
                 headers : {'Content-Type': 'application/json'} 
                })
                 .success(function(data) {
                 });
               

                	 
           }
        	 
     
         
    }); 
  
  
  
</script>

  </body>  
</html>  
