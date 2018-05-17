package org.bird.war;

import java.util.HashMap;
import java.util.Map;

/**
 * 类名：应用包资源
 * 作者：Monster
 * 时间：2016/1/11 18:57
 * 说明：
 */
public class WebWarResource {

    /**
     * 网应用包集合
     */
    private static final Map<String, WebWar> webWars = new HashMap<>();
    /**
     * 网应用资源
     */
    private static final WebWarResource webWarResource = new WebWarResource();

    /**
     * 私有构造方法
     */
    private WebWarResource(){
    }

    /**
     * 获取实例
     * @return 网应用资源
     */
    public static WebWarResource getInstance() {
        return webWarResource;
    }

    /**
     * 放入
     * @param newWebWar 新网应用包
     */
    public void add(WebWar newWebWar) {
        WebWar webWar = webWars.get(newWebWar.getPath());
        if (webWar == null) {
            webWars.put(newWebWar.getPath(), newWebWar);
        } else {
            if (webWar.getLastModified() != newWebWar.getLastModified()) {
                webWars.put(newWebWar.getPath(), newWebWar);
            }
        }
    }

    /**
     * 移除
     * @param webWar 网网应用包
     */
    public void remove(WebWar webWar) {
        webWars.remove(webWar.getPath());
    }
}
