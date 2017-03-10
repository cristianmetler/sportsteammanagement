<!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js'></script>



<script type="text/javascript" src="script.js"></script>
	<script type="text/javascript" src="/SportsTeamManagement/login/loginorregister.js"></script>
  	<script type="text/javascript" src="/SportsTeamManagement/register/register.js"></script>
  
  
  </head>
  <body ng-app="modulprincipal">
    <div class='container'>
      <h1>Sports Team Management </h1>
      <ul class='nav navbar-nav'>
        <li><a ui-sref="login">Login</a></li>
        <li><a ui-sref="register">Register</a></li>
        <li><a ui-sref="logout">Logout</a></li>
      </ul>
      
    </div>

    

	<div ui-view=""></div>
	


    
    

    
  </body>

</html>