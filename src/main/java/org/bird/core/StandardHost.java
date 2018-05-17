package org.bird.core;

import org.bird.Config;
import org.bird.Context;
import org.bird.Host;

/**
 * 类名：标准主机
 * 作者：Monster
 * 时间：2016/1/12 15:16
 * 说明：
 */
public class StandardHost implements Host {

    private Context context;

    private Config config;

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public Config getConfig() {
        return config;
    }

    @Override
    public void setConfig(Config config) {
        this.config = config;
    }

    @Override
    public void start() {
    }
}
