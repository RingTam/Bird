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

    /**
     * 上下文
     */
    private Context context;

    /**
     * 配置
     */
    private Config config;

    /**
     * 获取 上下文
     *
     * @return 上下文
     */
    @Override
    public Context getContext() {
        return context;
    }

    /**
     * 设置 上下文
     *
     * @return 上下文
     */
    @Override
    public void setContext(Context context) {
        this.context = context;
    }

    /**
     * 获取 配置
     *
     * @return 配置
     */
    @Override
    public Config getConfig() {
        return config;
    }

    /**
     * 设置 配置
     *
     * @return 配置
     */
    @Override
    public void setConfig(Config config) {
        this.config = config;
    }

    /**
     * 开始
     */
    @Override
    public void start() {
    }
}
