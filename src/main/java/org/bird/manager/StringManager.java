package org.bird.manager;

import org.bird.util.UTF8Control;

import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 类名：字符串管理者
 * 作者：Monster
 * 时间：2016/1/11 11:04
 * 说明：
 */
public class StringManager {

    /**
     * 管理集合
     */
    private static final Hashtable<String, StringManager> managers = new Hashtable<>();
    /**
     * 资源捆绑
     */
    private final ResourceBundle bundle;
    /**
     * 区域
     */
    private final Locale locale;

    /**
     * 构造方法
     *
     * @param packageName 包名
     */
    private StringManager(String packageName) {
        ResourceBundle b = null;
        String bundleName = packageName + ".LocalStrings";
        try {
            b = ResourceBundle.getBundle(bundleName, Locale.getDefault(), new UTF8Control());
        } catch (Exception e) {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl != null) {
                b = ResourceBundle.getBundle(bundleName, Locale.getDefault(), cl, new UTF8Control());
            }
        }
        this.bundle = b;
        if (bundle != null) {
            locale = bundle.getLocale();
        } else {
            locale = null;
        }
    }

    /**
     * 获取 字符串管理者
     *
     * @param packageName 包名
     * @return 字符串管理者
     */
    public static synchronized StringManager getManager(String packageName) {
        StringManager mgr = managers.get(packageName);
        if (mgr == null) {
            mgr = new StringManager(packageName);
            managers.put(packageName, mgr);
        }
        return mgr;
    }

    /**
     * 获取 字符串
     *
     * @param key 键
     * @return 字符串
     */
    public String getString(String key) {
        if (key == null) {
            throw new IllegalArgumentException("key值不允许为空！");
        }
        String value;
        try {
            value = bundle.getString(key);
        } catch (Exception e) {
            value = key;
        }
        return value;
    }

    /**
     * 获取 字符串
     *
     * @param key  键
     * @param args 不定参
     * @return 字符串
     */
    public String getString(final String key, final Object... args) {
        MessageFormat mf = new MessageFormat(
                getString(key));
        mf.setLocale(locale);
        return mf.format(args, new StringBuffer(1024), null).toString();

    }

}
