package org.smth.useful.core;

import com.google.common.collect.ImmutableList;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.smth.useful.core.RetryingRequestSender;


public class RestService {

    private RetryingRequestSender retryingSender = new RetryingRequestSender(3, ImmutableList.of(200, 500, 502, 503));

    public ValidatableResponse get() {
        return retryingSender.send(() ->
                given().get("http://spockframework.github.io/spock/docs/1.1-rc-2/all_in_one.html")
        );
    }

    public ValidatableResponse post() {
        return retryingSender.send(() ->
                given().body("fizz: buzz").post("http://requestb.in/1mcdxx51"));
    }

    private RequestSpecification given() {
        return io.restassured.RestAssured.given().log().all();
    }

}

