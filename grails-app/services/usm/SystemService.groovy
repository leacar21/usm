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
		def system = System.get(id)

		// Deslinkeo los Account de los Roles a eliminar
		system.roles.each{ role ->
			def listAccount = Account.findAll()//{ account -> account.roles.contains(role)}
			listAccount.each{ account ->
				account.removeFromRoles(role)
			}
		}
		
		// Deslinkeo los Account y Roles de los Permissions a eliminar
		def listPermissionsToDelete = []
		Account.findAll().each{ account ->
			def listPermissions = account.permissions.findAll{ permission -> permission.system.id = system.id }
			listPermissions.each{ permission
				account.removeFromPermissions(permission)
				listPermissionsToDelete.add(permission)
			}
		}
		Role.findAll().each{ role ->
			def listPermissions = role.permissions.findAll{ permission -> permission.system.id = system.id }
			listPermissions.each{ permission
				role.removeFromPermissions(permission)
				listPermissionsToDelete.add(permission)
			}
		}
		
		// Elimino los Permissions
		Iterator itrP = listPermissionsToDelete.iterator()
		while(itrP.hasNext()){
			def permission = itrP.next()
			itrP.remove()
			permission.delete()
		}

		// Obtengo los AccessTypes, para luego eliminarlos
		def listAccessTypesToDelete = system.accessTypes
		
		// Elimino el Systems (que elimina en cascada Roles y SystemOptions)
		system.delete()
		
		// Elimino los AccessTypes
		Iterator itrAT = listAccessTypesToDelete.iterator()
		while(itrAT.hasNext()){
			def accessType = itrAT.next()
			itrAT.remove()
			accessType.delete()
		}
		
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
	def getSystemOptions(long idSystem){
		def system = System.load(idSystem)
		return system.systemOptions
	}
	
	def addSystemOption(long idSystem, SystemOption systemOption){
		def system = System.load(idSystem)
		system.addToSystemOptions(systemOption).save()
		return system.systemOptions
	}
	
	def quitSystemOption(long idSystem, long idSystemOption){
		def system = System.load(idSystem)
		def systemOption = SystemOption.load(idSystemOption)
		system.removeFromSystemOptions(systemOption).save()
		return system.systemOptions
	}
	
	//-----------------------------------------------------
	
	@NotTransactional
	def getAccessTypes(long idSystem){
		def system = System.load(idSystem)
		return system.accessTypes
	}
	
	def addAccessType(long idSystem, AccessType accessType){
		def system = System.load(idSystem)
		system.addToAccessTypes(accessType).save()
		return system.accessTypes
	}
	
	def quitAccessType(long idSystem, long idAccessType){
		def system = System.load(idSystem)
		def accessType = AccessType.load(idAccessType)
		system.removeFromAccessTypes(accessType).save()
		return system.accessTypes
	}
	
	//-----------------------------------------------------
}
