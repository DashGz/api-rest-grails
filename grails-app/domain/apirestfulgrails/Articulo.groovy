package apirestfulgrails

import grails.rest.Resource

//@Resource(uri='/articulos')
@Resource
class Articulo {

    String name
    String picture

    static belongsTo = [marca:Marca]

    static constraints = {
        name blank: false, nullable: false
        picture blank: false, nullable: false
    }
}
