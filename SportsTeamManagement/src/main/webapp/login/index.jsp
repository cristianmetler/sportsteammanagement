<!DOCTYPE html>
<html>

  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.5.8/angular.js'></script>
    <script src='https://cdnjs.cloudflare.com/ajax/libs/angular-ui-router/0.3.1/angular-ui-router.min.js'></script>

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
<!--     <div ng-app="modulprincipal"> -->
<!--    <div ng-controller="loginController"> -->
<!--    <span ng-bind="moduleName"></span> -->
</div>
<!--         <div ng-app="masters"> -->
<!--    <div ng-controller="registerController"> -->
<!--    <span ng-bind="moduleName"></span> -->
<!-- </div> -->



    <div ui-view=""></div>
    
    
    
    <script type="text/javascript" src="/SportsTeamManagement/login/loginorregister.js"></script>
   
    <script>
   
    
    
    var app = angular.module('modulprincipal', ['ui.router']);
    	
    //	,'loginregisterApp'
    	

//     var app1 = angular.module('loginregisterApp', []);
//     app1.controller('loginController', ['$scope', function($scope) {
//         $scope.moduleName = 'loginregisterApp';
//      }]);

//     angular.module('loginregisterApp')
//     .controller('registerController', ['$scope', function($scope)) {
//        $scope.moduleName = 'loginregisterApp';
//     }]);
    
    
    app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider','$controllerProvider', function ($stateProvider, $urlRouterProvider, $locationProvider,$controllerProvider) {

    	
    	 $controllerProvider.allowGlobals();
        // For any unmatched url, redirect to root
        $urlRouterProvider.otherwise("/");

        $stateProvider
        .state('menuMaster', {
            abstract: true,
            templateUrl: 'MenuMaster.html'
        })
        .state('leftMaster', {
            abstract: true,
            templateUrl: 'LeftMaster.html'
        })
        .state('topLeftMaster', {
            abstract: true,
            templateUrl: 'TopLeftMaster.html'
        })

        .state('login', {
            url: '/login',
            templateUrl: '/SportsTeamManagement/login/login.jsp',
        })
        .state('register', {
            url: '/register',
            templateUrl: '/SportsTeamManagement/register/register.jsp',
        })
        .state('leftMaster.products', {
            url: '/products',
            templateUrl: 'products.html',
        })
        .state('topLeftMaster.customer', {
            url: '/customer',
            templateUrl: 'customers.html',
        });
    }]);
    
    

    
    
    </script>
    
  </body>

</html>