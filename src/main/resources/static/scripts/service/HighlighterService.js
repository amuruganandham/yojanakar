(function(){
    var highlighterService = function($location){
        var show = function(path){
            return $location.path().substr(0, path.length) === path;
        };
        var getClass = function(path){
            return show(path) ? 'active' : '';
        }
        return {
            show : show,
            getClass : getClass
        };
    };
    var module = angular.module('yojanakar');
    module.factory("highlighterService", highlighterService);
}());