package usm

import grails.rest.RestfulController;

class PermissionController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	PermissionController(){
		super(Permission)
	}

    def index() { }
}
