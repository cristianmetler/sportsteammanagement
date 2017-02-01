$scope.authenticate = function() {
    var data = {
        username: $scope.username,
        password: $scope.password
    };

    var successCallBack = function(response){
        // success response found from server
    };

    var errorCallBack = function(response){
        // error response found from server
    };

    $http.post('http://localhost:8080/login/', data).then(successCallBack, errorCallBack);
}