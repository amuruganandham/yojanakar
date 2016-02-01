(function(){
    var app = angular.module('yojanakar');
    
    app.controller('TeamCtrl', function($scope, $timeout, yojanakarService, $log, $rootScope, $location) {
        if(!$rootScope.user){
            $location.path('/login');
        }
        //View data for AJAX calls
        var onTeamCreationSuccess = function(data){
            $scope.message = "The Team " + data.teamName + " has been created successfully";
            $scope.team = null;
            $scope.players = null;
            $scope.editTeamBoolean = false;
        };
        var onGetAllTournamentsSuccess = function(data){
            $scope.tournaments = data;
        };
        var onGetAllEventsSuccess = function(data){
            $scope.events = data;
        };
        var onGetTeamsInEventSuccess = function(data){
            $scope.teams = data;
        };
        var onError = function(error){
            $scope.error = error.message;
        };
        
        $scope.onSubmit = function(){
            var event = angular.fromJson($scope.team.event);
            if(event.playersPerTeam != $scope.players.length){
                $scope.error = "The team to be registered for this event should contain " + event.playersPerTeam + " players";
            }else{
                yojanakarService.createTeam($scope.team, $scope.players, onTeamCreationSuccess, onError);
                $scope.toggle();
            }
            
        }
        $scope.getEventsForTournament = function(){
            var team = $scope.viewTeam ? $scope.viewTeam : $scope.team; 
            yojanakarService.getAllEventsForTournament(team.tournamentId, onGetAllEventsSuccess);
        }
        yojanakarService.getAllTournaments(onGetAllTournamentsSuccess);
        
        $scope.editorTitle = "Create";
        $scope.teamMode = true;
        $scope.playerMode = false;
        $scope.players = [];
        $scope.addNewPlayer = function(){
            $scope.addNew = true;
            $scope.enableSubmit = false;
            $scope.error = null;
        };
        $scope.savePlayer = function(){
            $scope.error = null;
            var player = $scope.player;
            if(player.experienceLevel && player.expertiseLevel && player.height && player.playerName && player.popularityLevel && player.weight){
                $scope.players.push($scope.player);
                $scope.player = null;
                $scope.addNew = false;
                $scope.enableSubmit = true;
            }
        };
        $scope.editPlayer = function(player){
            $scope.error = null;
            $scope.addNew = true;
            $scope.player = player;
        };
        $scope.removePlayer = function(player){
            $scope.error = null;
            var index = $scope.players.indexOf(player);
            if(index > -1){
                $scope.players.splice(index, 1);
            }
        };
        $scope.getTeamsInEvent = function(){
            yojanakarService.getTeamsInEvent($scope.viewTeam.eventId, onGetTeamsInEventSuccess);
        };
        $scope.editTeam = function(team){
            $scope.editorTitle = "Edit";
            $scope.team = team;
            $scope.editTeamBoolean = true;
            $scope.players = team.players;
        }
        $scope.toggle = function(){
            if($scope.teamMode){
                $log.info($scope.team);
                $scope.teamMode = !$scope.teamMode;
                $timeout(function(){
                    $scope.playerMode = !$scope.playerMode;
                },500);
            }else{
                $scope.playerMode = !$scope.playerMode;
                $timeout(function(){
                    $scope.teamMode = !$scope.teamMode;
                },500);
            }
        }
});
}());