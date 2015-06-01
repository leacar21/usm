(function() {
  'use strict';


  function AccountsController (Account) {
    this.accounts = Account.query();
  }

  function SystemsController (System) {
    this.systems = System.query();
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
