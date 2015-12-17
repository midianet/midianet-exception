package midianet.exception;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.PropertyResourceBundle;

public class ResourceBundle extends PropertyResourceBundle {

    public ResourceBundle(final InputStream is) throws IOException {
        super(getInputStream(is));
        if (is != null) {
            setParent(getBundleParent());
        }
    }

    private static java.util.ResourceBundle getBundleParent() {
        try {
            final ClassLoader cl = Thread.currentThread().getContextClassLoader();
            final InputStream is = cl.getResourceAsStream("midianet/exception/Measages_pt_BR.properties");
            return new PropertyResourceBundle(is);
        } catch (IOException e) {
            return ResourceBundle.getBundle("midianet.exception.Messages", new Locale("pt", "BR"));
        }
    }

    private static InputStreamReader getInputStream(final InputStream is) throws UnsupportedEncodingException {
        if (is == null) {
            final ClassLoader cl = Thread.currentThread().getContextClassLoader();
            return new InputStreamReader(cl.getResourceAsStream("midianet/exception/Messages_pt_BR.properties"),"UTF-8");
        } else {
            return new InputStreamReader(is, "UTF-8");
        }
    }

}