package org.bird.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 类名：UTF8控制
 * 作者：Monster
 * 时间：2016/1/11 11:04
 * 说明：
 */
public class UTF8Control extends ResourceBundle.Control {

    /**
     * 新 捆绑
     * @param baseName
     * @param locale
     * @param format
     * @param loader
     * @param reload
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws IOException
     */
    @Override
    public ResourceBundle newBundle(String baseName, Locale locale, String format,
                                    ClassLoader loader, boolean reload)
            throws IllegalAccessException, InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        ResourceBundle bundle = null;
        if (format.equals("java.properties")) {
            final String resourceName = toResourceName(bundleName, "properties");
            final ClassLoader classLoader = loader;
            InputStream stream;
            try {
                stream = AccessController.doPrivileged(
                        (PrivilegedExceptionAction<InputStream>) () -> {
                            InputStream is = null;
                            if (reload) {
                                URL url = classLoader.getResource(resourceName);
                                if (url != null) {
                                    URLConnection connection = url.openConnection();
                                    if (connection != null) {
                                        // Disable caches to get fresh data for
                                        // reloading.
                                        connection.setUseCaches(false);
                                        is = connection.getInputStream();
                                    }
                                }
                            }
                            return is;
                        });
            } catch (PrivilegedActionException e) {
                throw (IOException) e.getException();
            }
            if (stream != null) {
                try {
                    bundle = new PropertyResourceBundle(new InputStreamReader(stream, "UTF-8"));
                } finally {
                    stream.close();
                }
            }
        } else {
            throw new IllegalArgumentException("unknown format: " + format);
        }
        return bundle;
    }
}
