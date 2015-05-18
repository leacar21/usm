package usm

import grails.rest.RestfulController;

class RoleController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	def roleService
	
	RoleController(){
		super(Role)
	}

	//-----------------------------------------------------
	
	def index(String name){
		def listRoles = roleService.getAll(name)
		respond listRoles
	}

	def show(long id){
		def role = roleService.get(id)
		respond role
	}
	
	def save(Role role){
		def savedRole = roleService.save(role)
		respond savedRole
	}
	
	def delete(long id){
		roleService.delete(id)
		respond null, [status: 200]
	}

	//-----------------------------------------------------
	
	def showPermissions(long idRole){
		def permissions = roleService.getPermissions(idRole)
		respond permissions;
	}
	
	def addPermission(long idRole, Permission permission){
		def permissions = roleService.addPermission(idRole, permission)
		respond permissions;
	}
	
	def quitPermission(long idRole, long idPermission){
		def permissions = roleService.quitPermission(idRole, idPermission)
		respond permissions;
	}
	
}
