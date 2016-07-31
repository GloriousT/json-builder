package com.abb.e7

import org.junit.Test


class E7GroovyJsonTest {

    @Test
    public void shouldName() {
        def json = new E7GroovyJson(
                firstName: "Olya",
        )

        println json.getBuilder().toPrettyString()
    }
}
