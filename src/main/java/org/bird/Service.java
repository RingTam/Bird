package org.bird;

import org.bird.config.ConnectorRegistration;
import org.bird.config.ContainerRegistration;

import java.io.IOException;
import java.util.List;

/**
 * 类名：服务
 * 作者：Monster
 * 时间：2016/1/12 14:46
 * 说明：
 */
public interface Service extends Runnable {

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
     * 设置 重载
     *
     * @param reload 重载
     */
    void setReload(boolean reload);

    /**
     * 设置 连接器 集合
     *
     * @param connectorRegistrations 连接器注册 集合
     * @throws IOException 输入输出异常
     */
    void setConnectors(List<ConnectorRegistration> connectorRegistrations) throws IOException;

    /**
     * 设置 容器集合
     *
     * @param containerRegistrations 容器注册 集合
     */
    void setContainers(List<ContainerRegistration> containerRegistrations);

    /**
     * 开始
     */
    void start();
}
