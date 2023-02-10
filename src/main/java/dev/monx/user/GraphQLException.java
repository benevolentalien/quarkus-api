package dev.monx.user;

import java.util.Collections;
import java.util.List;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

public class GraphQLException extends RuntimeException implements GraphQLError {

    private final ExceptionsEnum exception;

    public GraphQLException (ExceptionsEnum exception) {
        this.exception = exception;
    }

    @Override
    public String getMessage() {
        return exception.getMessage();
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }

    @Override
    public List<SourceLocation> getLocations() {
        return Collections.emptyList();
    }
    
}
