(function(){
    var app = angular.module('yojanakar');
    
    app.controller('ScheduleCtrl', function($scope, yojanakarService, $rootScope, $location) {
        if(!$rootScope.user){
            $location.path('/login');
        }
        //View data for AJAX calls
        var onScheduleSuccess = function(data){
            $scope.message = "The event " + data.event/*.eventName*/ + " has been scheduled successfully";
            $scope.schedule = null;
        };
        var onGetAllTournamentsSuccess = function(data){
            $scope.tournaments = data;
        };
        var onGetAllEventsSuccess = function(data){
            $scope.events = data;
        };
        var onError = function(error){
            $scope.error = error.message;
        };
        
        $scope.onSubmit = function(){
            yojanakarService.scheduleEvent($scope.schedule, onScheduleSuccess, onError);
        }
        $scope.getEventsForTournament = function(){
            yojanakarService.getAllEventsForTournament($scope.schedule.tournament, onGetAllEventsSuccess);
        }
        yojanakarService.getAllTournaments(onGetAllTournamentsSuccess);
        //$scope.scrutinies = ['MINIMAL', 'EASY', 'OPTIMAL', 'TOUGH', 'EXTREME'];
});
}());