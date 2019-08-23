package apirestfulgrails

import grails.converters.JSON

class BootStrap {

    def init = { servletContext ->

        def marca1 = new Marca(name: 'Nike').save(flush:true)
        def marca2 = new Marca(name: 'Adidas').save(flush:true)
        marca1.addToArticulo(new Articulo(name: "AirMax Motion", picture: "https://http2.mlstatic.com/zapatillas-nike-hombre-air-max-motion-D_NQ_NP_623100-MLA31352258175_072019-F.webp")).save()
        marca2.addToArticulo(new Articulo(name: "Superstar Classic", picture: "https://http2.mlstatic.com/zapatillas-adidas-superstar-clasicas-originales-en-caja-D_NQ_NP_973530-MLA31066451821_062019-F.webp")).save()

        marshaler()
    }
    def destroy = {
    }

    private void marshaler() {
        JSON.registerObjectMarshaller(Marca){
            marca -> [
                    id: marca.id,
                    name: marca.name,
                    articulos: marca.articulo.collect {
                        articulo -> [
                                id: articulo.id,
                                name: articulo.name,
                                picture: articulo.picture,
                                children_categories: []
                        ]
                    }
            ]
        }
    }
}
