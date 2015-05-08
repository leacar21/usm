package usm

import grails.transaction.NotTransactional;
import grails.transaction.Transactional

@Transactional
class RoleService {

	@NotTransactional
    def getPermissions(long idRole){
		def role = Role.load(idRole)
		return role.permissions
	}
}
