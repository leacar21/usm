package usm

import grails.rest.RestfulController

class UserController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	UserController(){
		super(User)
	}
	
    UserService userService;
	
    def index(String firstName, String lastName){
		def listUsers = userService.getAll(firstName, lastName)
        respond listUsers;
    }

	def show(long id){
		def user = userService.get(id)
		respond user;
	}
	
//    def save(User user){
//		def savedUser = userService.save(user)
//		respond savedUser;
//    }
//	
//	  def update(User user){
//		def savedUser = userService.save(user)
//		respond savedUser;
//	  }
//	
//	  def delete(long id){
//		userService.delete(id)
//		respond null, [status: 200]
//	  }
}
