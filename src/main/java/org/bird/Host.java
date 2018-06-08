package org.bird;

/**
 * 类名：主机
 * 作者：Monster
 * 说明：
 */
public interface Host {

    /**
     * 获取 上下文
     *
     * @return 上下文
     */
    Context getContext();

    /**
     * 设置 上下文
     *
     * @param context 上下文
     */
    void setContext(Context context);

    /**
     * 获取 配置
     *
     * @return 配置
     */
    Config getConfig();

    /**
     * 设置 配置
     *
     * @param config 配置
     */
    void setConfig(Config config);

    /**
     * 开始
     */
    void start();
}
