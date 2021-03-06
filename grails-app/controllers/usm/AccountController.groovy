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
        respond listAccount
    }

	def show(long id){
		def account = accountService.get(id)
		respond account
	}
	
    def save(Account account){
		def savedAccount = accountService.save(account)
		respond savedAccount
    }
	
	def update(Account account){
		def savedAccount = accountService.save(account)
		respond savedAccount
	}
	
	def delete(long id){
		accountService.delete(id)
		respond null, [status: 200]
	}

	//-----------------------------------------------------
	
    def showUser(long idAccount){
        def account = accountService.get(idAccount)
		User user = account.user
		respond user

    }
	
	//-----------------------------------------------------
	
	def showPermissions(long idAccount, long idSystem){
		def permissions = accountService.getPermissions(idAccount, idSystem)
		respond permissions
	}
	
	def addPermission(long idAccount, Permission permission){		
		def permissions = accountService.addPermission(idAccount, permission)
		respond permissions
	}
	
	def quitPermission(long idAccount, long idPermission){
		def permissions = accountService.quitPermission(idAccount, idPermission)
		respond permissions
	}
	
	//-----------------------------------------------------
	
	def showRoles(long idAccount, long idSystem){
		def roles = accountService.getRoles(idAccount, idSystem)
		respond roles
	}
	
	def addRole(long idAccount, Role role){
		def roles = accountService.addRole(idAccount, role)
		respond roles
	}
	
	def quitRole(long idAccount, long idRole){
		def roles = accountService.quitRole(idAccount, idRole)
		respond roles
	}
	
	//-----------------------------------------------------
	
}
