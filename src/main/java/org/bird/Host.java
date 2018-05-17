package org.bird;

/**
 * 类名：主机
 * 作者：Monster
 * 时间：2016/1/12 15:08
 * 说明：
 */
public interface Host {

    void setContext(Context context);

    Context getContext();

    void setConfig(Config config);

    Config getConfig();

    void start();
}
