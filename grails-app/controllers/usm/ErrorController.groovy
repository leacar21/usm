package usm

import org.apache.commons.logging.LogFactory

class ErrorController {

	private static final log = LogFactory.getLog(this)
	
    def handleObjectNotFound() {
		response.sendError(404)
	}
	
}
