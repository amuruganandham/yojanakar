(function() {
    var yojanakarService = function($http, $log) {
        var createTournament = function(tournament, onSuccess, onError) {
            var expectedResponse = {
                "tournamentId" : "1",
                "tournamentName": "Cricket",
                "organiserName": "John",
                "companyName": "Mindtree"
            };
            $http({
                method: 'POST',
                url: 'http://localhost:8080/tournament/' + tournament.name,
                data: tournament
            }).then(onSuccess(data), onError(error));
            
        };

        var getAllTournaments = function(onSuccess, onError) {
            var expectedResponse = [{
                "tournamentId": "1",
                "tournamentName": "Cricket",
                "organiserName": "John",
                "companyName": "Mindtree"
            }, {
                "tournamentId": "2",
                "tournamentName": "Table Tennis",
                "organiserName": "Doe",
                "companyName": "Mindtree"
            }];
            $http({
                method: 'GET',
                url: 'http://localhost:8080/tournament'	
            }).then(onSuccess(data), onError(error));
            $log.info('getAllTournaments');
        };
//--------------------------------------------------------
        var createEvent = function(event, onSuccess, onError) {
            var expectedResponse = "An event object containing all the event details";
            $http({
                method: 'POST',
                url: 'http://localhost:8080/event/' + event.tournamentId,
                data: event
            }).then(onSuccess(data), onError(error));
        };

        var getAllEventsForTournament = function(tournamentId, onSuccess, onError) {
            var expectedResponse = [{
                "eventId": "e1",
                "eventName": "Singles",
                "organiserName": "Org1",
                "playersPerTeam": 1,
                "matchesPerDay": 2,
                "eventType": "KO",
                "tournamentId": "1"
            }, {
                "eventId": "e2",
                "eventName": "Doubles",
                "organiserName": "Org1",
                "playersPerTeam": 1,
                "matchesPerDay": 2,
                "eventType": "GR",
                "tournamentId": "2"
            }];
            $http({
                method: 'GET',
                url: 'http://localhost:8080/event/' + tournamentId
            }).then(onSuccess(data), onError(error));
        };

        var createTeam = function(tournamentId, eventId,  team, players, onSuccess, onError) {
             var expectedResponse = "A team containing all players inside \"players\" key";
             team.players = players;
            $http({
                method: 'POST',
                url: 'http://localhost:8080/team' + tournamentId + '/' + eventId,
                data: team
            }).then(onSuccess(data), onError(error));
            
        }

        var getTeamsInEvent = function(tournamentId, eventId, teamId, onSuccess, onError) {
            var expectedResponse = "An array of teams with the players inside them";
            $http({
                method: 'GET',
                url: 'http://localhost:8080/team/' + tournamentId + '/' + eventId + '/' + teamId
            }).then(onSuccess(data), onError(error));
        }
        var scheduleEvent = function(schedule, onSuccess, onError) {
             var expectedResponse = "A true boolean if scheduled successfully";
            $http({
                method: 'POST',
                url: 'http://localhost:8080/schedule/',
                data: schedule
            }).then(onSuccess(data), onError(error));
        }

        var getFixture = function(tournamentId, eventId, onSuccess, onError) {
            var expectedResponse = "Complete schedule of fixtures";
            $http({
                method: 'GET',
                url: 'http://localhost:8080/schedule/' + tournamentId + '/' + eventId
            }).then(onSuccess(data), onError(error));
        }

        var authenticate = function(user, onSuccess, onError) {
            var expectedResponse = {name:"A", pass:"Aasdas", valid:"true/false"};
            $http({
                method: 'POST',
                url: 'http://localhost:8080/authenticate/',
                data: user
            }).then(onSuccess(data), onError(error));
        }

        return {
            createTournament: createTournament,
            getAllTournaments: getAllTournaments,
            createEvent: createEvent,
            getAllEventsForTournament: getAllEventsForTournament,
            createTeam: createTeam,
            getTeamsInEvent: getTeamsInEvent,
            scheduleEvent: scheduleEvent,
            getFixture: getFixture,
            authenticate: authenticate
        };
    };

    var module = angular.module('yojanakar');
    module.factory("yojanakarService", yojanakarService);
}());