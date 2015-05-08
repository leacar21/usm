package usm

import grails.rest.RestfulController;

class RoleController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	def roleService
	
	RoleController(){
		super(Role)
	}

	def showPermissions(long idRole){
		def permissions = roleService.getPermissions(idRole)
		respond permissions;
	}
}
