package org.smth.useful.core;

import io.restassured.response.Response;

@FunctionalInterface
public interface Request {

    Response execute();
}
