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
 * 说明：
 */
public class UTF8Control extends ResourceBundle.Control {

    /**
     * 新捆绑
     *
     * @param baseName 基础名
     * @param locale   语言环境
     * @param format   格式
     * @param loader   类加载器
     * @param reload   重载标识
     * @return 资源绑定
     * @throws IllegalAccessException 非法访问异常
     * @throws InstantiationException 实例化异常
     * @throws IOException            输入输出异常
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
