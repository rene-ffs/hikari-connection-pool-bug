package atg.fingerfood.hikaripoolbug.exception;

import java.util.UUID;

import static java.lang.String.format;

public class BarNotFoundException extends RuntimeException {
    private static final String MESSAGE_TEMPLATE = "Unable to find a Bar with ID: %s";

    public BarNotFoundException(UUID id) {
        super(format(MESSAGE_TEMPLATE, id));
    }
}
