package org.smth.useful;

import org.smth.useful.core.Kitten;
import org.smth.useful.core.Puppy;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.ValidatableResponse;
import org.assertj.core.api.AbstractAssert;

public class ResponseAssertion extends AbstractAssert<ResponseAssertion, ValidatableResponse> {

    private ResponseAssertion(ValidatableResponse actual) {
        super(actual, ResponseAssertion.class);
    }

    public static ResponseAssertion assertThat(ValidatableResponse actual) {
        return new ResponseAssertion(actual);
    }

    public PuppyAssertion asPuppy() {
        Puppy puppy = (Puppy) asObject(200, Puppy.class);
        return new PuppyAssertion(puppy);
    }

    public KittenAssertion asKitten() {
        Kitten kitten = (Kitten) asObject(200, Kitten.class);
        return new KittenAssertion(kitten);
    }

//    public ErrorAssertion asErrorResponse(int statusCode) {
//        ErrorResponse error = (ErrorResponse) asObject(403, ErrorResponse.class);
//        return new ErrorAssertion(error);
//    }

    private Object asObject(int statusCode, Class clazz) {
        isNotNull();
        return actual.statusCode(statusCode)
                .extract().as(clazz, ObjectMapperType.GSON);
    }
}
