package org.bird.war;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：
 * 作者：Monster
 * 时间：2016/1/11 18:57
 * 说明：
 */
public class WarResources {

    public static final Map<String, WebWar> wars = new HashMap<>();

    private static final WarResources WAR_RESOURCES = new WarResources();

    private WarResources(){
    }

    public static WarResources getInstance() {
        return WAR_RESOURCES;
    }

    public void put(WebWar newWar) {
        WebWar war = wars.get(newWar.getPath());
        if (war == null) {
            wars.put(newWar.getPath(), newWar);
        } else {
            if (war.getLastModified() != newWar.getLastModified()) {
                wars.put(newWar.getPath(), newWar);
            }
        }
    }

    public void remove(WebWar war) {
        wars.remove(war.getPath());
    }
}
