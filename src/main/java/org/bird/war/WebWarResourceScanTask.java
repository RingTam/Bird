package org.bird.war;

import java.io.File;
import java.util.TimerTask;

/**
 * 类名：网应用包资源扫描任务
 * 作者：Monster
 * 时间：2016/1/11 17:38
 * 说明：
 */
public class WebWarResourceScanTask extends TimerTask {

    /**
     * 网应用包资源
     */
    private WebWarResource webWarResource = WebWarResource.getInstance();
    /**
     * 文件
     */
    private File file;

    /**
     * 构造方法
     *
     * @param file 文件
     */
    public WebWarResourceScanTask(File file) {
        this.file = file;
    }

    /**
     * 运行
     */
    @Override
    public void run() {
        File[] warFiles = file.listFiles();
        if (warFiles == null) {
            return;
        }
        for (File f : warFiles) {
            if(f.isDirectory()) {
                continue;
            }
            String path = f.getPath();
            if (War.EXTENSION_NAME.equals(path)) {
                webWarResource.add(
                        new WebWar(path, f.lastModified()));
            }
        }
    }
}
