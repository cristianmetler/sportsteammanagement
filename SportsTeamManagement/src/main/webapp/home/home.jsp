<html>
<head>
<title>Welcome to the Homepage</title>
</head>

<body>

<script
src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js">
</script>

<h1>Hi {{authenticateUserRequest.username authenticateUserRequest.password}}!</h1>
<p>You're logged in!!</p>
<p>&nbsp;</p>
<p><a href="/SportsTeamManagement/teams/createteam.jsp" class="btn btn-primary">Create a new team</a></p>
<p><a href="/SportsTeamManagement/teams/viewteams.jsp" class="btn btn-primary">View existing teams</a></p>
<p><a href="/SportsTeamManagement/players/addplayer.jsp" class="btn btn-primary">Add a new player</a></p>
<p><a href="/SportsTeamManagement/players/viewplayer.jsp" class="btn btn-primary">View existing players</a></p>
<p><a href="/SportsTeamManagement/players/searchplayer.jsp" class="btn btn-primary">Search players</a></p>
<p><a href="/SportsTeamManagement/team/searchteams.jsp" class="btn btn-primary">Search teams</a></p>
<p><a href="/SportsTeamManagement/deals/makedeal.jsp" class="btn btn-primary">Make a new deal</a></p>
<p><a href="/SportsTeamManagement/deals/editdeal.jsp" class="btn btn-primary">Update an existing deal</a></p>
</body>
</html>