package atg.fingerfood.hikaripoolbug.exception;

import java.util.UUID;

import static java.lang.String.format;

public class FooNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Unable to find a Foo with ID: %s";

    public FooNotFoundException(UUID id) {
        super(format(MESSAGE_TEMPLATE, id));
    }
}
