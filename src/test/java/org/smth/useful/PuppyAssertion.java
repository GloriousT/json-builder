package org.smth.useful;

import org.smth.useful.core.Puppy;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

public class PuppyAssertion extends AbstractAssert<PuppyAssertion, Puppy> {

    public PuppyAssertion hasMeme(String expected) {
        isNotNull();

        Assertions.assertThat(actual.getMeme()).isEqualTo(expected);
        return this;
    }
//    ...
    // other assertions omitted



    public PuppyAssertion(Puppy actual) {
        super(actual, PuppyAssertion.class);
    }

    public static PuppyAssertion assertThat(ValidatableResponse actual) {
        Puppy actualKitten = actual.statusCode(200)
                .extract().as(Puppy.class, ObjectMapperType.GSON);

        return new PuppyAssertion(actualKitten);
    }
}