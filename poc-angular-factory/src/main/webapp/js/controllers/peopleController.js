/* Controllers */

var app = angular.module('pocAngular.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function() {
        $templateCache.removeAll();
    });
});

app.controller('peopleListCtrl', ['$scope', 'PeoplesFactory', '$location',
    function($scope, PeoplesFactory, $location) {


        /* callback for ng-click 'editPeople': */
        $scope.editPeople = function(peopleId) {
            $location.path('/update/' + peopleId);
        };

        /* callback for ng-click 'deletePeople': */
        $scope.deletePeople = function(peopleId) {
            var data = {id: peopleId};
            PeoplesFactory.delete({},data);
            $scope.peoples = PeoplesFactory.query();
        };

        /* callback for ng-click 'createPeople': */
        $scope.createNewPeople = function() {
            $location.path('/create');
        };

        $scope.peoples = PeoplesFactory.query();
        $scope.text = 'Opa pegou esse aqui';
    }]);


app.controller('peopleDetailCtrl', ['$scope', '$routeParams', 'PeoplesFactory', '$location',
    function($scope, $routeParams, PeoplesFactory, $location) {

        //$scope.people = PeoplesFactory.show({id: $routeParams.id});



        /* callback for ng-click 'updatePeople': */
        $scope.updatePeople = function() {
            PeoplesFactory.update($scope.people);
            $location.path('/list');
        };

        /* callback for ng-click 'cancel': */
        $scope.cancel = function() {
            $location.path('/list');
        };

        $scope.people = PeoplesFactory.show({id: $routeParams.id});

    }]);

app.controller('peopleCreationCtrl', ['$scope', 'PeoplesFactory', '$location',
    function($scope, PeoplesFactory, $location) {

        /* callback for ng-click 'createNewPeople': */
        $scope.createNewPeople = function() {
            PeoplesFactory.create($scope.people);
            $location.path('/list');
        }
    }]);


