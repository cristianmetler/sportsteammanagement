<html>  
  <head>    
   <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js'></script> 
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 
  
     

  
  <script type="text/javascript" src="/SportsTeamManagement/login/loginorregister.js"></script>
  <script type="text/javascript" src="/SportsTeamManagement/login/script.js"></script>


</head>

<!-- <body ng-app="loginregisterApp"> -->
<body>
<div>
<div class="col-sm-8 col-sm-offset-2">
<div class="page-header"><h3>Welcome to the Sports Teams Management website</h3></div>

<p></p><p></p><p></p><p></p>
<h5> {{ loginname }} </h5>
<p></p><p></p><p></p>

<p></p><p></p><p></p><p></p>
<h5> {{ incorrectorlogin }} </h5>
<p></p><p></p><p></p>





<form >
		<div class="form-group">
			<label for="username">UserName</label>
			<input type="text" name="username" ng-model="authenticateUserRequest.username" required>
			
		</div>
	<div class="form-group">
			<label for="password">Password</label>
			<input type="text" name="password" ng-model="authenticateUserRequest.password" required>
		
		</div>
			
		<div class="form-group">
			<button  ng-controller="loginController" ng-click="dologin()" >Login</button>
			
		</div>

	</form>	
</div>

  </body>  
</html>  

