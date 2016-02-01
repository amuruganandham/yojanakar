(function(){
    var app = angular.module('yojanakar');
    
    app.controller('TourneyCtrl', function($scope, yojanakarService, $location, $rootScope) {
        if(!$rootScope.user){
            $location.path('/login');
        }
        //$rootScope.validateLogin();
        $scope.editTourney = false;
        $scope.editorTitle = "Create";
        
        //View data for AJAX calls
        var onTourneyCreationSuccess = function(data){
            $scope.message = "The Tournament " + data.tournamentName + " has been created successfully";
            $scope.tournament = null;
            $scope.editTourney = false;
        };
        var onGetAllTournamentsSuccess = function(data){
            $scope.tournaments = data
        };
        var onError = function(error){
            $scope.error = error.message;
            $scope.editTourney = false;
        };
        
        $scope.onSubmit = function(){
            yojanakarService.createTournament($scope.tournament, onTourneyCreationSuccess, onError);
        }
        if($location.path() === '/tourney/viewAll'){
            yojanakarService.getAllTournaments(onGetAllTournamentsSuccess);
        }
        
         $scope.editTournament = function(tournament){
            $scope.editorTitle = "Edit";
            $scope.editTourney = true;
            $scope.tournament = tournament;
        }
         
});
}());