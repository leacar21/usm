package usm

import grails.transaction.NotTransactional;
import grails.transaction.Transactional

@Transactional
class UserService {

    @NotTransactional
	def getAll(String firstName, String lastName) {
		if (firstName == null) { firstName = "" }
		if (lastName == null) { lastName = "" }
		
		def listUsers = User.findByFirstNameLikeAndLastNameLike('$firstName%','$lastName%')
		return listUsers
	}
	
	@NotTransactional
	def get(long id) {
		def user = User.load(id)
		return user
	}
}
