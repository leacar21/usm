package usm

import grails.rest.*

@Resource(uri='/books', formats=['json', 'xml'])
class Book {

    String title
    Author author

    static constraints = {
        title blank: false
        author nullable: false
    }
}