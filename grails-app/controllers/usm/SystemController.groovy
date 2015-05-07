package usm

import grails.rest.RestfulController;

class SystemController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	SystemController(){
		super(System)
	}

    def index() { }
}
