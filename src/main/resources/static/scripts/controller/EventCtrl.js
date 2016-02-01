(function(){
    var app = angular.module('yojanakar');
    
    app.controller('EventCtrl', function($scope, yojanakarService, $location, $rootScope) {
        if(!$rootScope.user){
            $location.path('/login');
        }
        $scope.editorTitle = "Create";
        $scope.editEventBoolean = false;
        
        //View data for AJAX calls
        var onEventCreationSuccess = function(data){
            $scope.message = "The Event " + data.eventName + " has been created successfully";
            $scope.event = null;
            $scope.editEventBoolean = false;
        };
        var onGetAllEventsSuccess = function(data){
            $scope.events = data;
        };
        var onGetAllTournamentsSuccess = function(data){
            $scope.tournaments = data;
        };
        var onError = function(error){
            $scope.error = error.message;
            $scope.editEventBoolean = false;
        };
        
        $scope.onSubmit = function(){
            $scope.editEvent = false;
            yojanakarService.createEvent($scope.event, onEventCreationSuccess, onError);
        }
        $scope.getEventsForTournament = function(){
            yojanakarService.getAllEventsForTournament($scope.viewEvent.tournamentId, onGetAllEventsSuccess);
        }
        yojanakarService.getAllTournaments(onGetAllTournamentsSuccess);
        $scope.editEvent = function(event){
            $scope.editorTitle = "Edit";
            $scope.editEventBoolean = true;
            $scope.event = event;
        }
});
}());