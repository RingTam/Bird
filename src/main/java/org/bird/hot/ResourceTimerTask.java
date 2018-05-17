package org.bird.hot;

import org.bird.war.WebWarResource;
import org.bird.war.WebWar;

import java.io.File;
import java.util.TimerTask;

/**
 * 类名：Rar 时间者任务
 * 作者：Monster
 * 时间：2016/1/11 17:38
 * 说明：
 */
public class ResourceTimerTask extends TimerTask {

    /**
     * war 资源
     */
    public static final WebWarResource WAR_RESOURCE = WebWarResource.getInstance();
    /**
     * 文件
     */
    private File file;

    /**
     * 构造方法
     *
     * @param file 文件
     */
    public ResourceTimerTask(File file) {
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
        for (File warFile : warFiles) {
            String path = warFile.getPath();
            if (path.endsWith(".war")) {
                WAR_RESOURCE.add(new WebWar(path,
                        warFile.lastModified()));
            }
        }
    }
}
