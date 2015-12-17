package midianet.exception;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Locale;

public class ResourceManager {
    private static ResourceBundle rb;

    private ResourceManager() {
    }

    private static ResourceBundle getMessages() throws InfraException {
        if (rb == null) {
            try {
                final ClassLoader cl = Thread.currentThread().getContextClassLoader();
                final InputStream is = cl.getResourceAsStream(String.format("midianet/messages_%s.properties", Locale.getDefault()));
                rb = new ResourceBundle(is);
            } catch (final Exception e) {
                throw new InfraException(e);
            }
        }
        return rb;
    }
    public static String getMessage(final String key, final Object... params) {
        try {
            final String m = getMessages().getString(key);
            return MessageFormat.format(m, params);
        } catch (final Exception e) {
            return key;
        }
    }

}