package org.smth.useful;

import org.smth.useful.core.Kitten;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class KittenAssertion extends AbstractAssert<KittenAssertion, Kitten> {

//    public KittenAssertion(Kitten actual) {
//        super(actual, KittenAssertion.class);
//    }
//
//    public static KittenAssertion assertThat(Kitten actual) {
//        return new KittenAssertion(actual);
//    }
//
    public KittenAssertion hasName(String expected) {
        isNotNull();

        Assertions.assertThat(actual.getName()).isEqualTo(expected);
        return this;
    }
//    ...
    // other assertions omitted



    public KittenAssertion(Kitten actual) {
        super(actual, KittenAssertion.class);
    }

    public static KittenAssertion assertThat(ValidatableResponse actual) {
        Kitten actualKitten = actual.statusCode(200)
                .extract().as(Kitten.class, ObjectMapperType.GSON);

        return new KittenAssertion(actualKitten);
    }
}