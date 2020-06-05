package org.lol.json.exc;

/**
 * @since 1.0
 */
public class JsnException extends RuntimeException {
    private static final long serialVersionUID = 2644083736857840440L;

    public JsnException() {
        super();
    }

    public JsnException(String message) {
        super(message);
    }

    public JsnException(String message, Throwable cause) {
        super(message, cause);
    }
}
