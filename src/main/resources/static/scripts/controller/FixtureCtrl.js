(function(){
    var app = angular.module('yojanakar');
    
    app.controller('FixtureCtrl', function($scope, yojanakarService) {
        $scope.noOfStages=[1,2,3,4,5,6,7];      

      
      $scope.getStagesForFixutre=function(){
          
 //$scope.schedules=$scope.fixtrue.schedules;
           $scope.shwday=0;
            $scope.schedules=[
        {
            "scheduleId": "S111",
            "stage": 1,
            "day": 1,
            "matchNumber": 1,
            "teamIds": [
                "t3",
                "t4"
            ]
        },
        {
            "scheduleId": "S112",
            "stage": 1,
            "day": 1,
            "matchNumber": 22,
            "teamIds": [
                "t1",
                "t2"
            ]
        },
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": -0,
            "matchNumber": 0,
            "teamIds": [
                "t5"
            ]
        }, 
                      
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 2,
            "matchNumber": 2,
            "teamIds": [
                "t5"
            ]
        },
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 2,
            "matchNumber": 2,
            "teamIds": [
                "t5",
                "t2"
            ]
        },
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 2,
            "matchNumber": 2,
            "teamIds": [
                "t5",
                "t2"
            ]
        },
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 2,
            "matchNumber": 2,
            "teamIds": [
                "t5",
                "t2"
            ]
        },  
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 2,
            "matchNumber": 2,
            "teamIds": [
                "t5",
                "t2"
            ]
        },
                
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 3,
            "matchNumber": 2,
            "teamIds": [
                "t5",
                "t2"
            ]
        }, 
        {
            "scheduleId": "S100",
            "stage": 1,
            "day": 3,
            "matchNumber": 2,
            "teamIds": [
                "t5",
                "t2"
            ]
        }
    ];
 
    };  
        
     
 
     
    $scope.showdayclick=function(i){
        $scope.shwday=i;
          
    };
               //alert end
  
    
});
}());