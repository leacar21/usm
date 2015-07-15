(function () {
  'use strict';

  //------------------------------------------------------

  angular.module('usm', ['ngMaterial', 'ngRoute', 'usm.controllers', 'usm.templates']);

  //------------------------------------------------------

  function config ($locationProvider, $routeProvider) {
    //$locationProvider.html5Mode(true);

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
        controller: 'SystemsController',
        controllerAs: 'systemsCtrl'
      })
      .when('/activity', {
        templateUrl: 'views/activity.html',
        controller: 'ActivityController',
        controllerAs: 'activityCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutController',
        controllerAs: 'aboutCtrl'
      }).otherwise({redirectTo: '/'});
  }

  //------------------------------------------------------

  function configTheme($mdThemingProvider) {
    $mdThemingProvider.theme('default')
      .primaryPalette('blue')
      .accentPalette('orange');
  }

  //------------------------------------------------------

  angular
    .module('usm')
    .config(config)
    .config(configTheme);

  //------------------------------------------------------

})();
