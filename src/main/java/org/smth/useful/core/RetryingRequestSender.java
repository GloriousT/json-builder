package org.smth.useful.core;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.smth.useful.core.Request;

import java.util.List;

@AllArgsConstructor
public class RetryingRequestSender {

    private final int maxRetryAttempts;
    private List<Integer> errorCodes;

    public ValidatableResponse send(Request request) {
        ValidatableResponse validatableResponse;
        int attempt = 0;
        do {
            validatableResponse = request.execute()
                    .then().log().ifError();
            System.out.println(validatableResponse);
            attempt++;
            System.out.println("Sent request, attempt #" + attempt);
        } while (attempt < maxRetryAttempts && containsErrorCode(validatableResponse));

        return validatableResponse;
    }

    private boolean containsErrorCode(ValidatableResponse response) {
        return errorCodes.contains(response.extract().statusCode());
    }
}


