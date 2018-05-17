package org.bird;

import java.io.File;

/**
 * 类名：常量
 * 作者：Monster
 * 时间：2016/1/6 14:52
 * 说明：
 */
public class Constants {

    /**
     * 用户的当前工作目录
     */
    public static final String USER_DIR = System.getProperty("user.dir");
    /**
     * 配置工作目录
     */
    public static final String CONF_DIR = USER_DIR + File.separator + "conf";
    /**
     * Web应用工作目录
     */
    public static final String APPS_DIR = USER_DIR + File.separator + "apps";
}