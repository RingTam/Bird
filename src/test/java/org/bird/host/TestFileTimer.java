package org.bird.host;

import org.bird.FileDefinition;
import org.bird.hot.ResourceTimerTask;

import java.io.File;
import java.util.Date;
import java.util.Timer;

/**
 * @author Monster
 */
public class TestFileTimer {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Timer timer = new Timer();
        File webAppsFile = FileDefinition.getAppsFile();
        ResourceTimerTask task = new ResourceTimerTask(webAppsFile);
        timer.schedule(task, new Date(), 2000);
    }
}
