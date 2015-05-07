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
	
	def getPermissions(long idAccount){
		def account = Account.load(idAccount)
		return account.permissions
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
	
	def getRoles(long idAccount){
		def account = Account.load(idAccount)
		return account.roles
	}
	
	def addRole(long idAccount, Role role){
		def account = Account.load(idAccount)
		account.addToRoless(role).save()
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
