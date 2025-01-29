package com.api.filters;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingFilter implements Filter {
    public static final Logger logger = LogManager.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext ctx) {
        // Log request
        logRequest(requestSpec);

        // Get response
        Response response = ctx.next(requestSpec, responseSpec);

        // Log response
        logResponse(response);

        return response;
    }

    private void logRequest(FilterableRequestSpecification requestSpec) {
        logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
        logger.info("Headers: {}", requestSpec.getHeaders());
    }

    private void logResponse(Response response) {
        logger.info("Response Status: {}", response.getStatusCode());
        logger.info("Response Body: {}", response.getBody().asString());
    }
}





