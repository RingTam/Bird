package org.bird.host;

import org.bird.FileDefinition;
import org.bird.war.WebWarResourceScanTask;

import java.io.File;
import java.util.Date;
import java.util.Timer;

/**
 * @author Monster
 */
public class TestWebWarScan {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        File webAppsFile = FileDefinition.getAppsFile();
        WebWarResourceScanTask task = new WebWarResourceScanTask(webAppsFile);
        timer.schedule(task, new Date(), 2000);
    }
}
