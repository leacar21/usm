(function() {
  'use strict';


  angular
  .module('usm.controllers', ['usm.services'])
  .controller('AccountsController', AccountsController)
  .controller('SystemsController', SystemsController)
  .controller('ActivityController', ActivityController)
  .controller('AboutController', AboutController);

  function AccountsController (Account) {
    this.accounts = Account.query();
  }

  function SystemsController (System) {
    this.systems = System.query();
  }

  function ActivityController (System) {

  }

  function AboutController (System) {

  }

})();
