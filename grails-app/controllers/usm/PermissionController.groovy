package usm

import grails.rest.RestfulController;

class PermissionController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	PermissionController(){
		super(Permission)
	}
	
	PermissionService permissionService
	
	//-----------------------------------------------------
	
	def index(String name){
		respond null, [status: 200]
	}

	def show(long id){
		def permission = permissionService.get(id)
		respond permission;
	}
	
	def save(Account account){
		respond null, [status: 200]
	}
	
	def update(Account account){
		respond null, [status: 200]
	}
	
	def delete(long id){
		respond null, [status: 200]
	}

	//-----------------------------------------------------
	
	def showAccessType(long idPermission){
		def accessType = permissionService.getAccessType(idPermission)
		respond accessType;
	}
}
