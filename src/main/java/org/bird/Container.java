package org.bird;

/**
 * 类名：容器
 * 作者：Monster
 * 说明：
 */
public interface Container {

    /**
     * 获取 名称
     *
     * @return 名称
     */
    String getName();

    /**
     * 设置 名称
     *
     * @param name 名称
     */
    void setName(String name);

    /**
     * 获取 连接器名称
     *
     * @return 连机器名称
     */
    String getConnectorName();

    /**
     * 设置 连接器名称
     *
     * @param connectorName 连接器名称
     */
    void setConnectorName(String connectorName);

    /**
     * 添加 主机
     *
     * @param host 主机
     */
    void addHost(Host host);

    /**
     * 移除 主机
     *
     * @param host 主机
     */
    void removeHost(Host host);

    /**
     * 开始
     */
    void start();
}
