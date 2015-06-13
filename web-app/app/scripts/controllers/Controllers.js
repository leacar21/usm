(function() {
  'use strict';

  function AccountsController (Account) {
    this.accounts = Account.query();
  }

  function SystemsController (System) {

    this.selectedSystem = 'System1';
    this.selectedRole = 'Role1';

    this.selectedSystemId = 1;
    this.selectSystem = function(systemId){
      this.selectedSystemId = systemId;
    }

    this.systems = System.query();
    this.systemOptions =
      [
        { "id" : "1", "name" : "Option X1"},
        { "id" : "2", "name" : "Option X2"},
        { "id" : "3", "name" : "Option X3"}
      ];
    this.accessTypes =
      [
        { "id" : "1", "name" : "Read Only"},
        { "id" : "2", "name" : "Writer"},
        { "id" : "3", "name" : "Excecute"}
      ];
  }

  function ActivityController (System) {
    this.systems = System.query();
  }

  function AboutController (System) {
    this.systems = System.query();
  }

  angular
  .module('usm.controllers', ['usm.services'])
  .controller('AccountsController', AccountsController)
  .controller('SystemsController', SystemsController)
  .controller('ActivityController', ActivityController)
  .controller('AboutController', AboutController);

})();
