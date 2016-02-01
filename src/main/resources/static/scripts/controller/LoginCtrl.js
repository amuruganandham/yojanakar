(function(){
    var app = angular.module('yojanakar');
    
    app.controller('LoginCtrl', function($scope, $rootScope, $location, yojanakarService) {
        $rootScope.user = null;
       /* $rootScope.validateLogin = function(){
            if(!$rootScope.user){
                $location.path("/login");    
            } 
        }*/
        var onAuthenticationSuccess = function(data){
            $rootScope.user = data;
            $location.path("/home");
        }
        var onAuthenticationFailure = function(error){
            $scope.error = error.message;
        }
        
        $scope.onSubmit = function(){
            yojanakarService.authenticate($scope.user, onAuthenticationSuccess, onAuthenticationFailure);
        }
});
}());