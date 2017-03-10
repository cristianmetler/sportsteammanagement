<html>  
  <head>    
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js'></script>
</head>
<body >
<div class="container">
<div class="col-sm-8 col-sm-offset-2">
    <div class="page-header"><h3>Welcome to the registration page</h3></div>
    <!-- FORM -->
    <div class="form-group">
        <label>Username</label>
        <input type="text" name="name" class="form-control" ng-model="authenticateUserRequest.username" required>
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="text" name="username" class="form-control" ng-model="authenticateUserRequest.password" required>
    </div>
    <div class="form-group">
        <label>Email Address</label>
        <input type="email" name="input" class="form-control" ng-model="text" ng-pattern="emailFormat" required ng-controller="Ctrl">
    </div>
    <input type="checkbox" ng-checked="all">Subscribe to our site's weekly newsletter<br>
			<div class="form-group">
			<button  ng-controller="registerController" ng-click="doregister()" >Register</button>
			
	</div>
</div>
</div>

   <script type="text/javascript" src="/SportsTeamManagement/register/register.js"></script>
	<script type="text/javascript" src="/SportsTeamManagement/login/script.js"></script>
  </body>  
</html>  
