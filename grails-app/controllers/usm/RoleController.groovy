package usm

import grails.rest.RestfulController;

class RoleController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	RoleController(){
		super(Role)
	}

    def index() { }
}
