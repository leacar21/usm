package usm

import grails.rest.RestfulController;

class PermissionController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	def permissionService
	
	PermissionController(){
		super(Permission)
	}

	def show(long id){
		def permission = permissionService.get(id)
		respond permission;
	}
	
	def getAccessType(long idPermission){
		def accessType = permissionService.getAccessType(idPermission)
		respond accessType;
	}
}
