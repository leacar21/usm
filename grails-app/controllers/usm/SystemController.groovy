package usm

import grails.rest.RestfulController;

class SystemController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	SystemController(){
		super(System)
	}

	def systemService;
	
	//-----------------------------------------------------
	
	def index(String name){
		def listSystem = systemService.getAll(name)
		respond listSystem;
	}

	def show(long id){
		def system = systemService.get(id)
		respond system;
	}
	
	def save(System system){
		def savedSystem = systemService.save(system)
		respond savedSystem;
	}
	
	def update(System system){
		def savedSystem = systemService.save(system)
		respond savedSystem;
	}
	
	def delete(long id){
		systemService.delete(id)
		respond null, [status: 200]
	}
	
	//-----------------------------------------------------
	
	def showSystemOptions(long idSystem){
		def systemOptions = systemService.getSystemOptions(idSystem)
		respond systemOptions;
	}
	
	def addSystemOption(long idSystem, SystemOption systemOption){
		def systemOptions = systemService.addSystemOption(idSystem, systemOption)
		respond systemOptions
	}
	
	def quitSystemOption(long idSystem, long idSystemOption){
		def systemOptions = systemService.quitSystemOption(idSystem, idSystemOption)
		respond systemOptions
	}
	
	//-----------------------------------------------------
	
	def showAccessTypes(long idSystem){
		def accessTypes = systemService.getAccessTypes(idSystem)
		respond accessTypes;
	}
	
	def addAccessType(long idSystem, AccessType accessType){
		def accessTypes = systemService.addAccessType(idSystem, accessType)
		respond accessTypes
	}
	
	def quitAccessType(long idSystem, long idAccessType){
		def accessTypes = systemService.quitAccessType(idSystem, idAccessType)
		respond accessTypes
	}
		
	//-----------------------------------------------------
	
}
