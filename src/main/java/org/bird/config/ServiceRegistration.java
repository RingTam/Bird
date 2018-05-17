package org.bird.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：服务注册
 * 作者：Monster
 * 时间：2016/1/12 17:27
 * 说明：
 */
public class ServiceRegistration {

    /**
     * 名称
     */
    private String name;
    /**
     * 重载
     */
    private Boolean reload;
    /**
     * 连接器注册 集合
     */
    private List<ConnectorRegistration> connectorRegistrations = new ArrayList<>();
    /**
     * 容器注册 集合
     */
    private List<ContainerRegistration> containerRegistrations = new ArrayList<>();

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
     * 获取 重载
     *
     * @return 重载
     */
    public Boolean getReload() {
        return reload;
    }

    /**
     * 设置 重载
     *
     * @param reload 重载
     */
    public void setReload(Boolean reload) {
        this.reload = reload;
    }

    /**
     * 获取 连接器注册 集合
     *
     * @return 连接器注册 集合
     */
    public List<ConnectorRegistration> getConnectorRegistrations() {
        return connectorRegistrations;
    }

    /**
     * 设置 连接器注册 集合
     *
     * @param connectorRegistrations 连接器注册 集合
     */
    public void setConnectorRegistrations(List<ConnectorRegistration> connectorRegistrations) {
        this.connectorRegistrations = connectorRegistrations;
    }

    /**
     * 添加 连接器注册
     *
     * @param connectorRegistration 连接器注册
     */
    public void addConnectorRegistration(ConnectorRegistration connectorRegistration) {
        connectorRegistrations.add(connectorRegistration);
    }

    /**
     * 获取 容器注册 集合
     *
     * @return 容器注册 集合
     */
    public List<ContainerRegistration> getContainerRegistrations() {
        return containerRegistrations;
    }

    /**
     * 设置 容器注册 集合
     *
     * @param containerRegistrations 容器注册 集合
     */
    public void setContainerRegistrations(List<ContainerRegistration> containerRegistrations) {
        this.containerRegistrations = containerRegistrations;
    }

    /**
     * 添加 容器注册
     *
     * @param containerRegistration 容器注册
     */
    public void addContainerRegistration(ContainerRegistration containerRegistration) {
        containerRegistrations.add(containerRegistration);
    }
}
