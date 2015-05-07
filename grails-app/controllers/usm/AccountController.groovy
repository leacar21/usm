package usm

import grails.rest.RestfulController

class AccountController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	AccountController(){
		super(Account)
	}
	
	AccountService accountService;
	
	//-----------------------------------------------------
	
    def index(String name){
		def listAccount = accountService.getAll(name)
        respond listAccount;
    }

	def show(long id){
		def account = accountService.get(id)
		respond account;
	}
	
    def save(Account account){
		def savedAccount = accountService.save(account)
		respond account;
    }
	
	def update(Account account){
		def savedAccount = accountService.save(account)
		respond account;
	}
	
	def delete(long id){
		accountService.delete(id)
		respond null, [status: 200]
	}

	//-----------------------------------------------------
	
    def showUser(long idAccount){
        def account = accountService.get(idAccount)
		User user = account.user;
		respond user;

    }
	
	//-----------------------------------------------------
	
	def showPermissions(long idAccount){
		def permissions = accountService.getPermissions(idAccount)
		respond permissions;

	}
	
	def addPermission(long idAccount, Permission permission){
		def account = accountService.addPermission(idAccount, permission)
		respond account.permissions
	}
	
	def quitPermission(long idAccount, long idPermission){
		def account = accountService.quitPermission(idAccount, idPermission)
		respond account.permissions
	}
	
	//-----------------------------------------------------
	
	def showRoles(long idAccount){
		def roles = accountService.getRoles(idAccount)
		respond roles;
	}
	
	def addRole(long idAccount, Role role){
		def account = accountService.addRole(idAccount, role)
		respond account.roles
	}
	
	def quitRole(long idAccount, long idRole){
		def account = accountService.quitRole(idAccount, idRole)
		respond account.roles
	}
	
	//-----------------------------------------------------
	
}
