package org.bird.war;

import org.bird.FileDefinition;

import java.io.File;
import java.io.IOException;

/**
 * 类名：网应用包
 * 作者：Monster
 * 时间：2016/1/11 14:11
 * 说明：
 */
public class WebWar extends War {

    /**
     * web apps 文件
     */
    private static final File appsFile = FileDefinition.getAppsFile();
    /**
     * 路径
     */
    private String path;
    /**
     * 最后一次修改时间
     */
    private long lastModified;

    /**
     * 构造方法
     *
     * @param path         路径
     * @param lastModified 最后一次修改时间
     */
    public WebWar(String path, long lastModified) {
        this.path = path;
        this.lastModified = lastModified;
    }

    /**
     * 构造方法
     *
     * @param path 路径
     */
    public WebWar(String path) {
        this.path = path;
    }

    /**
     * 获取 路径
     *
     * @return 路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 获取 最后一次修改时间
     *
     * @return 最后一次修改时间
     */
    public long getLastModified() {
        return lastModified;
    }

    /**
     * 解压
     *
     * @throws IOException 输入输出异常
     */
    public void unpack() throws IOException {
        super.unpack(new File(path));
    }
}
