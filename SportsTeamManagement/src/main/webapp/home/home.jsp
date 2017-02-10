<html>
<head>
<title>Welcome to the Homepage</title>
</head>

<body>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>  
  <link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"> 

<h1>Hi</h1>
<p2>You're logged in!!</p2>
<p>&nbsp;</p>
<p><a href="/SportsTeamManagement/teams/createteam.jsp" class="btn btn-primary">Create a new team</a></p>
<p><a href="/SportsTeamManagement/teams/searchteams.jsp" class="btn btn-primary">Search/Modify teams</a></p>
<p><a href="/SportsTeamManagement/players/addplayer.jsp" class="btn btn-primary">Add a new player</a></p>
<p><a href="/SportsTeamManagement/players/searchplayer.jsp" class="btn btn-primary">Search/Modify players</a></p>
<p><a href="/SportsTeamManagement/deals/makedeal.jsp" class="btn btn-primary">Make a new deal</a></p>
<p><a href="/SportsTeamManagement/deals/searchdeal.jsp" class="btn btn-primary">Search/Modify deal</a></p>


<body ng-app="logoutApp">
<form >
			
		<div class="form-group">
			<button  ng-controller="logoutController" ng-click="dologout()" >Logout</button>
			
		</div>

	</form>	





<script>
var app = angular.module('logoutApp', []);

app.controller('logoutController', function($scope, $window) {

	$scope.dologout = function() {
		



    	$window.location.href = '/SportsTeamManagement/login/login.jsp';


	};
	
});

</script>



</body>
</html>


