package midianet.exception;

public class InfraException extends Exception {
    private static final long serialVersionUID = -6472789855877680893L;

    public InfraException(final String message) {
        super(message);
    }

    public InfraException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InfraException(final Throwable cause) {
        super(cause);
    }

}