// Code goes here

var app = angular.module('modulprincipal', ['ui.router']);

app.config(['$stateProvider', '$urlRouterProvider', '$locationProvider', function ($stateProvider, $urlRouterProvider, $locationProvider) {

    // For any unmatched url, redirect to root
    $urlRouterProvider.otherwise("/");

    $stateProvider
    .state('menuMaster', {
        abstract: true,
        templateUrl: 'MenuMaster.jsp'
    })
    .state('leftMaster', {
        abstract: true,
        templateUrl: 'LeftMaster.jsp'
    })
    .state('topLeftMaster', {
        abstract: true,
        templateUrl: 'TopLeftMaster.jsp'
    })

    .state('login', {
        url: '/login',
        templateUrl: '/SportsTeamManagement/login/login.jsp',
        controller : 'loginController'
    })
    .state('register', {
        url: '/register',
        templateUrl: '/SportsTeamManagement/register/register.jsp',
    })
        .state('home', {
        url: '/home',
        templateUrl: '/SportsTeamManagement/home/home.jsp',
    })
    .state('leftMaster.products', {
        url: '/products',
        templateUrl: 'products.jsp',
    })
    .state('topLeftMaster.customer', {
        url: '/customer',
        templateUrl: 'customers.jsp',
    });
}]);