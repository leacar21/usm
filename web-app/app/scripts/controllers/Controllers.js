(function() {
  'use strict';


  angular
  .module('usm.controllers', ['usm.services'])
  .controller('AccountsController', AccountsController)
  .controller('SystemsController', SystemsController);

  function AccountsController (Account) {
    this.accounts = Account.query();
  }s

  function SystemsController (System) {
    this.systems = System.query();
  }

})();
