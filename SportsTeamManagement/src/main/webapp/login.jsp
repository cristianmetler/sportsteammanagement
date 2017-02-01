<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<body>

<div class="container">
    <h1>Authentification</h1>
    <form novalidate="novalidate" class="form-horizontal">
        <div class="control-group">
            <label class="control-label" for="inputFirstName">First name:</label>

            <div class="controls">
                <input type="text" id="inputFirstName" ng-model="username"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputLastName">Last name:</label>

            <div class="controls">
                <input type="text" id="inputLastName" ng-model="password"/>
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <a ng-click="cancel()" class="btn btn-small">login</a>
            </div>
        </div>
    </form>
</div>



</body>
</html>