package usm

import grails.transaction.NotTransactional;
import grails.transaction.Transactional

@Transactional
class PermissionService {

    @NotTransactional
	def get(long id) {
		def permission = Permission.load(id)
		return permission
	}
	
	@NotTransactional
	def getAccessType(long idPermission) {
		def permission = Permission.load(idPermission)
		return permission.accessType
	}
}
