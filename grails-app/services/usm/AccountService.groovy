package usm

import grails.transaction.NotTransactional
import grails.transaction.Transactional

import org.hibernate.ObjectNotFoundException

@Transactional
class AccountService {

	//-----------------------------------------------------
	
	@NotTransactional
	def getAll(String name) {
		Map mapFilters = [:]
		if (name != null) { mapFilters.put("name", name) }
		
		def listAccounts
		if (mapFilters.isEmpty()){
			listAccounts = Account.findAll()
		}else{
			listAccounts = Account.findAllWhere(mapFilters)
		}
		
		return listAccounts
	}
	
	@NotTransactional
	def get(long id) {
		def account = Account.load(id)
		return account
	}
	
    def save(Account account) {
		def savedAccount = account.save(flush: true)
		return savedAccount
    }
	
	def delete(long id) {
		def account = Account.load(id)
		account.delete()
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
	def getPermissions(long idAccount, long idSystem){	
		
		def listPermissions = null
		
		if (idSystem != null){
			listPermissions = Account.findAll("from Account as account" +
											  "join account.permissions as permision " +
				                              "with (account.id = ?) and (permission.system.id = ?)", [idAccount, idSystem])		
		}
		else{
			def account = Account.load(idAccount)
			listPermissions = account.permissions
		}
		
		return listPermissions
	}
	
	def addPermission(long idAccount, Permission permission){
		def account = Account.load(idAccount)
		account.addToPermissions(permission).save()
		return account.permissions
	}
	
	def quitPermission(long idAccount, long idPermission){
		def account = Account.load(idAccount)
		def permission = Permission.load(idPermission)
		account.deleteFromPermissions(permission).save()
		return account.permissions
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
	def getRoles(long idAccount, long idSystem){
		
		def listRoles = null
		
		if (idSystem != null){
			listRoles = Account.findAll("from Account as account" +
										 "join account.roles as role " +
										 "with (account.id = ?) and (role.system.id = ?)", [idAccount, idSystem])
		}
		else{
			def account = Account.load(idAccount)
			listRoles = account.roles
		}
		
		return listRoles
	}
	
	def addRole(long idAccount, Role role){
		def account = Account.load(idAccount)
		account.addToRoles(role).save()
		return account.roles
	}
	
	def quitRole(long idAccount, long idRole){
		def account = Account.load(idAccount)
		def role = Role.load(idRole)
		account.deleteFromRoles(role).save()
		return account.roles
	}
	
	//-----------------------------------------------------
}
