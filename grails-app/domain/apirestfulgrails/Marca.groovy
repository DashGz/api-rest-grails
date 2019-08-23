package apirestfulgrails

import grails.rest.Resource

//@Resource(uri='/marcas')
@Resource
class Marca {

    String name
    static hasMany = [articulo:Articulo]

    static constraints = {
        name blank: false, nullable: false

    }
}
