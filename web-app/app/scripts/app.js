(function () {
  'use strict';

  //------------------------------------------------------

  angular.module('usm', ['ngMaterial', 'ngRoute', 'usm.controllers']);

  //------------------------------------------------------

  function config ($locationProvider, $routeProvider) {
    $locationProvider.html5Mode(true);

    $routeProvider
      .when('/', {
        templateUrl: 'views/accounts.html',
        controller: 'AccountsController',
        controllerAs: 'accountsCtrl'
      })
      .when('/accounts', {
        templateUrl: 'views/accounts.html',
        controller: 'AccountsController',
        controllerAs: 'accountsCtrl'
      })
      .when('/systems', {
        templateUrl: 'views/systems.html',
        controller: 'SystemController',
        controllerAs: 'systemsCtrl'
      });
  }

  //------------------------------------------------------

  angular
    .module('usm')
    .config(config);

  //------------------------------------------------------

})();
