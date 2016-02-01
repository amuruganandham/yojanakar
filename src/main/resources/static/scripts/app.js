(function(){
    var app = angular.module("yojanakar", ["ngRoute", "ui.bootstrap", "ngAnimate", "angular.filter"]);
    
    app.config(function($routeProvider){
        $routeProvider
            .when('/tourney/create', {
                templateUrl: "views/tournament.html",
                controller: "TourneyCtrl"
            })
            .when('/tourney/viewAll', {
                templateUrl: "views/tournament.html",
                controller: "TourneyCtrl"
            })
            .when('/event/create', {
                templateUrl: "views/event.html",
                controller: "EventCtrl"
            })
            .when('/event/viewEvents', {
                templateUrl: "views/event.html",
                controller: "EventCtrl"
            })
            .when('/schedule', {
                templateUrl: "views/scheduler.html",
                controller: "ScheduleCtrl"
            })
            .when('/fixture',{
                templateUrl: "views/fixture.html",
                controller: "FixtureCtrl"
            })
            .when('/team/create',{
                templateUrl: "views/team.html",
                controller: "TeamCtrl"
            })
            .when('/team/viewTeam',{
                templateUrl: "views/team.html",
                controller: "TeamCtrl"
            })
            .when('/home', {
                templateUrl: "views/home.html"
            })
            .when('/about', {
                templateUrl: "views/about.html"
            })
            .when('/contact', {
                templateUrl: "views/credits.html"
            })
            .when('/login', {
                templateUrl: "views/login.html",
                controller: "LoginCtrl"
            })
            .otherwise({redirectTo:"/login"});
    });
}());