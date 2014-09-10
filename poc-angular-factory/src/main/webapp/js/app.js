
$app = angular.module('pocAngular', ['pocAngular.services','pocAngular.controllers']);


$app.config(['$routeProvider','$httpProvider',function ($routeProvider,$httpProvider) {
  $routeProvider.
  when('/', {controller: 'peopleListCtrl', templateUrl: 'views/people/list.html'}).
  when('/update/:id', {controller: 'peopleDetailCtrl', templateUrl: 'views/people/update.html'}).
  when('/create', {controller: 'peopleCreationCtrl', templateUrl: 'views/people/create.html'}).
  otherwise({redirectTo: '/'});

  /* CORS... */
  /* http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api */
  $httpProvider.defaults.useXDomain = true;
  delete $httpProvider.defaults.headers.common['X-Requested-With'];
//   $httpProvider.defaults.headers.put['Content-Type'] = 'application/json';

}]);