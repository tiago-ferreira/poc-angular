var services = angular.module('pocAngular.services', ['ngResource']);
// return $resource(baseUrl +'/poc-angular/service/people/findOne/1', {}, {
//var baseUrl = 'http://localhost\\:8084';
//return $resource(baseUrl + '/service/people', {}, {
//DELETE with parameters
//http://stackoverflow.com/questions/16167463/angular-js-delete-resource-with-parameter

services.factory('PeoplesFactory', function ($resource) {
    return $resource('/service/people/:id',{}, {
    	show: { method: 'GET'},
        query: { method: 'GET', isArray: true },
        create: {method: 'POST'},
        update: { method: 'PUT'},
        
        delete: { method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
            params:{id:'@id'} 
        }
    });
});