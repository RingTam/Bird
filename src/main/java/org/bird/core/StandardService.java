package org.bird.core;

import org.apache.log4j.Logger;
import org.bird.Connector;
import org.bird.Container;
import org.bird.Service;
import org.bird.config.ConnectorRegistration;
import org.bird.config.ContainerRegistration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 类名：标准服务
 * 作者：Monster
 * 时间：2016/1/12 14:58
 * 说明：
 */
public class StandardService extends Thread implements Service {

    /**
     * 日志器
     */
    private static final Logger logger = Logger.getLogger(StandardService.class);
    /**
     * 重载
     */
    private boolean reload;
    /**
     * 连接器 集合
     */
    private List<Connector> connectors = new CopyOnWriteArrayList<>();
    /**
     * 容器 集合
     */
    private List<Container> containers = new CopyOnWriteArrayList<>();

    /**
     * 设置 重载
     *
     * @param reload 重载
     */
    @Override
    public void setReload(boolean reload) {
        this.reload = reload;
    }

    /**
     * 设置 连接器 集合
     *
     * @param connectorRegistrations 连接器注册 集合
     * @throws IOException 输入输出异常
     */
    @Override
    public void setConnectors(List<ConnectorRegistration> connectorRegistrations) throws IOException {
        for (ConnectorRegistration connectorRegistration : connectorRegistrations) {
            Connector connector = new StandardConnector();
            connector.setName(connectorRegistration.getName());
            connector.setContainerName(connectorRegistration.getContainerName());
            connector.setServerSocket(connectorRegistration.getPort());
            connector.setExecutor(
                    connector.getExecutor(
                            connectorRegistration.getExecutorRegistration()));
            connectors.add(connector);
        }
    }

    /**
     * 设置 容器集合
     *
     * @param containerRegistrations 容器注册 集合
     */
    @Override
    public void setContainers(List<ContainerRegistration> containerRegistrations) {
        for (ContainerRegistration containerRegistration : containerRegistrations) {
            Container container = new StandardContainer();
            container.setName(containerRegistration.getName());
            container.setConnectorName(containerRegistration.getConnectorName());
            containers.add(container);
        }
    }

    /**
     * 运行
     */
    @Override
    public void run() {
        for (Connector connector : connectors) {
            connector.start();
        }
        for (Container container : containers) {
            container.start();
        }
    }

    /**
     * 开始
     */
    @Override
    public synchronized void start() {
        logger.info(">>>>>服务：" + getName());
        super.start();
    }
}

