<html>
<head>
<title>Welcome to the Homepage</title>
</head>

<body>

<script
src="http://ajax.googleapis.com/ajax/libs/angularjs/1.2.15/angular.min.js">
</script>

<h1>Hi {{vm.user.firstName}}!</h1>
<p>You're logged in!!</p>
<h3>All registered users:</h3>
<ul>
    <li ng-repeat="user in vm.allUsers">
        {{user.username}} ({{user.firstName}} {{user.lastName}})
        - <a ng-click="vm.deleteUser(user.id)">Delete</a>
    </li>
</ul>
<p>&nbsp;</p>
<p><a href="#!/login" class="btn btn-primary">Create a new team</a></p>
<p><a href="#!/login" class="btn btn-primary">View existing teams</a></p>
<p><a href="#!/login" class="btn btn-primary">Add a new player</a></p>
<p><a href="#!/login" class="btn btn-primary">View existing players</a></p>
<p><a href="#!/login" class="btn btn-primary">Make a new deal</a></p>
<p><a href="#!/login" class="btn btn-primary">Update an existing deal</a></p>
</body>
</html>