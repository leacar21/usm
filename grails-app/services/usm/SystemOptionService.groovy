package usm

import grails.transaction.NotTransactional;
import grails.transaction.Transactional

@Transactional
class SystemOptionService {

	def systemOptionService
	
	@NotTransactional
	def get(long id) {
		def systemOption = SystemOption.load(id)
		return systemOption
	}
	
	@NotTransactional
	def getAccessTypes(long idSystemOption){
		SystemOption systemOption = SystemOption.load(idSystemOption)
		return systemOption.accessTypes
	}
}
