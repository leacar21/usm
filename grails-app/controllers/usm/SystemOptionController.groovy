package usm

import grails.rest.RestfulController;

class SystemOptionController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	def systemOptionService
	
	SystemOptionController(){
		super(SystemOption)
	}
	
	def show(long id){
		def systemOption = systemOptionService.get(id)
		respond systemOption;
	}
	
	def showAccessType(long idSystemOption){
		def accessTypes = systemOptionService.getAccessTypes(idSystemOption)
		return accessTypes
	}
}
