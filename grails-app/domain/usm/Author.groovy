package usm

import grails.rest.*

@Resource(uri='/authors', formats=['json', 'xml'])
class Author {

    String name;

    static constraints = {
      name blank: false
    }
}
