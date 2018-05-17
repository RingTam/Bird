package org.bird.sar;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：
 * 作者：Monster
 * 时间：2016/1/11 18:57
 * 说明：
 */
public class SarResources {

    public static final Map<String, WebSar> sars = new HashMap<>();

    private static final SarResources sarResources = new SarResources();

    private SarResources(){
    }

    public static SarResources getInstance() {
        return sarResources;
    }

    public void put(WebSar newSar) {
        WebSar sar = sars.get(newSar.getPath());
        if (sar == null) {
            sars.put(newSar.getPath(), newSar);
        } else {
            if (sar.getLastModified() != newSar.getLastModified()) {
                sars.put(newSar.getPath(), newSar);
            }
        }
    }

    public void remove(WebSar sar) {
        sars.remove(sar.getPath());
    }
}
