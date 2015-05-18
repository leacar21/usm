package usm

import grails.transaction.NotTransactional
import grails.transaction.Transactional

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException

@Transactional
class RoleService {

	//-----------------------------------------------------
	
	@NotTransactional
	def getAll(String name) {
		Map mapFilters = [:]
		if (name != null) { mapFilters.put("name", name) }
		
		def listRoles
		if (mapFilters.isEmpty()){
			listRoles = Role.findAll()
		}else{
			listRoles = Role.findAllWhere(mapFilters)
		}
		
		return listRoles
	}
	
	@NotTransactional
	def get(long id) {
		def role = Role.load(id)
		return role
	}
	
	def save(Role role) {
		def savedRole = role.save(flush: true)
		return savedRole
	}
	
	def delete(long id) {
		def role = Role.load(id)
		role.delete()
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
    def getPermissions(long idRole){
		def role = Role.load(idRole)
		return role.permissions
	}
	
	def addPermission(long idRole, Permission permission){
		Role role = Role.load(idRole)
		role.addToPermissions(permission).save()
		return role.permissions
	}
	
	def quitPermission(long idRole, long idPermission){
		def role = Account.load(idRole)
		def permission = Permission.load(idPermission)
		role.removeFromPermissions(permission).save()
		permission.delete()
		return role.permissions
	}
	
	//-----------------------------------------------------
}
