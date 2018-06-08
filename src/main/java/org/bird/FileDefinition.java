package org.bird;

import java.io.File;

/**
 * 类名：文件定义
 * 作者：Monster
 * 说明：
 */
public class FileDefinition {
    /**
     * 获取 web apps 文件
     *
     * @return 文件
     */
    public static File getAppsFile() {
        return new File(Constants.APPS_DIR);
    }

}
