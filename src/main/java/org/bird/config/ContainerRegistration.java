package org.bird.config;

/**
 * 类名：容器注册
 * 作者：Monster
 * 说明：
 */
public class ContainerRegistration {

    /**
     * 名称
     */
    private String name;
    /**
     * 连接器名称
     */
    private String connectorName;

    /**
     * 获取 名称
     *
     * @return 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 连接器名称
     *
     * @return 连接器名称
     */
    public String getConnectorName() {
        return connectorName;
    }

    /**
     * 设置 连接器名称
     *
     * @param connectorName 连接器名称
     */
    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }
}
