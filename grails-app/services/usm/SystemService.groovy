package usm

import grails.transaction.NotTransactional;
import grails.transaction.Transactional

@Transactional
class SystemService {

    //-----------------------------------------------------
	
	@NotTransactional
	def getAll(String name) {
		Map mapFilters = [:]
		if (name != null) { mapFilters.put("name", name) }
		
		def listSystems
		if (mapFilters.isEmpty()){
			listSystems = System.findAll()
		}else{
			listSystems = System.findAllWhere(mapFilters)
		}
		
		return listSystems
	}
	
	@NotTransactional
	def get(long id) {
		def system = System.load(id)
		return system
	}
	
    def save(System system) {
		def savedSystem = system.save(flush: true)
		return savedSystem
    }
	
	def delete(long id) {
		def system = System.load(id)
		system.delete()
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
	def getSystemOption(long idSystem){
		def system = System.load(idSystem)
		return listSystemOptions = system.systemOptions
	}
	
	def addSystemOption(long idSystem, SystemOption systemOption){
		def system = System.load(isSystem)
		system.addToSystemOptions(systemOption).save()
		return system.systemOptions
	}
	
	def quitSystemOption(long idSystem, long idSystemOption){
		def system = System.load(idSystem)
		def systemOption = SystemOption.load(idSystemOption)
		system.deleteFromSystemOptions(systemOption).save()
		return system.systemOptions
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
	def getAccessTypes(long idSystem){
		def system = System.load(idSystem)
		return listAccessTypes = system.accessTypes
	}
	
	def addAccessType(long idSystem, AccessType accessType){
		def system = System.load(isSystem)
		system.addToAccessTypes(accessType).save()
		return system.accessTypes
	}
	
	def quitAccessType(long idSystem, long idAccessType){
		def system = System.load(idSystem)
		def accessType = AccessType.load(idAccessType)
		system.deleteFromAccessTypes(accessType).save()
		return system.accessTypes
	}
	
	//-----------------------------------------------------
}
