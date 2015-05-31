(function () {
  'use strict';

  angular.module('usm.services', ['ngResource']);

  function Account ($resource, BaseUrl) {
    return $resource(BaseUrl + '/accounts/:accountId', { accountId: '@_id' });
  }

  function System ($resource, BaseUrl) {
    return $resource(BaseUrl + '/systems/:systemId', { systemId: '@_id' });
  }

  function User ($resource, BaseUrl) {
    return $resource(BaseUrl + '/users/:userId', { userId: '@_id' });
  }

  angular
    .module('usm.services')
    .constant('BaseUrl', 'http://localhost:8080')
    .factory('Account', Account)
    .factory('System', System)
    .factory('User', User);

})();
