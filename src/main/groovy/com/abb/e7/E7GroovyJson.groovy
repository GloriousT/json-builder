package com.abb.e7

import groovy.json.JsonBuilder

class E7GroovyJson {

    def firstName = 'Guillame'
    def lastName


    def builder = new JsonBuilder()
    private def root = builder.people {
        person {
            firstName firstName
            lastName
            // Named arguments are valid values for objects too
            address {
                city: 'Paris'
                country: 'France'
                zip: 12345
            }
            married true
            // a list of values
            conferences 'JavaOne', 'Gr8conf'
        }
    }
//
//    println builder.toPrettyString ( )

}

