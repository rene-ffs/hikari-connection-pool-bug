package atg.fingerfood.hikaripoolbug.exception;

import java.util.UUID;

import static java.lang.String.format;

public class FooBarNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Unable to find a FooBar with ID: %s";

    public FooBarNotFoundException(UUID id) {
        super(format(MESSAGE_TEMPLATE, id));
    }
}
