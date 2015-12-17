package midianet.exception;

public abstract class BussinesException extends Exception {

    protected BussinesException(final String mensagem, final Object... params) {
        super(ResourceManager.getMessage(mensagem, params));
    }

}
