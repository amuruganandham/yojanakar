(function(){
    var app = angular.module('yojanakar');
    app.controller('HeaderCtrl', function(highlighterService, $rootScope, $scope, $rootScope) {
    $scope.showHeader = $rootScope.user;
    var getClass = function(path){
        return highlighterService.getClass(path);
    };
    var show = function(path){
        return highlighterService.show(path);
    }
    return {
        getClass : getClass,
        show : show
    };
});
}());