package usm

import grails.rest.RestfulController;

class SystemOptionController extends RestfulController {

	static responseFormats = ['json', 'xml']
	
	SystemOptionController(){
		super(SystemOption)
	}

    def index() { }
}
