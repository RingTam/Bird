package org.bird.config;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.bird.Constants;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * 类名：服务器配置
 * 作者：Monster
 * 说明：
 */
public class ServerConfig {

    /**
     * 日志器
     */
    private static final Logger logger = Logger.getLogger(ServerConfig.class);
    /**
     * XMl简易应用程序接口 读者
     */
    private static SAXReader reader = new SAXReader();

    /**
     * 配置 默认日志
     */
    public static void configureDefaultLog() {
        PropertyConfigurator.configure(Constants.CONF_DIR +
                File.separator + "log4j.properties");
    }

    /**
     * 读取 配置
     */
    public static Document getDefaultDocument() {
        Document document = null;
        File file = new File(Constants.CONF_DIR, "server.xml");
        try {
            document = reader.read(file);
        } catch (DocumentException e) {
            logger.error(">>>>>读取文件[" + file.getPath() + "]失败，获取文档为空！");
        }
        return document;
    }

    /**
     * 获取 服务器注册
     *
     * @param document 文档
     * @return 服务器注册
     */
    public static ServerRegistration getServerRegistration(Document document) {
        Element elementServer = document.getRootElement();
        //创建服务器注册
        ServerRegistration serverRegistration = new ServerRegistration();
        List elementServices = elementServer.elements();
        for (int i = 0; i < elementServices.size(); i++) {
            Element elementService = (Element) elementServices.get(i);
            serverRegistration.addServiceRegistration(getServiceRegistration(elementService));
        }
        return serverRegistration;
    }

    /**
     * 获取 服务注册 集合
     *
     * @param elementService 元素服务
     * @return 服务注册 集合
     */
    public static ServiceRegistration getServiceRegistration(Element elementService) {
        //创建服务注册
        ServiceRegistration serviceRegistration = new ServiceRegistration();
        serviceRegistration.setReload(Boolean.valueOf(
                elementService.attributeValue("reload")));
        serviceRegistration.setName(elementService.attributeValue("name"));
        //获取元素集合，往下遍历
        List elementConnectorOrContainers = elementService.elements();
        for (int j = 0; j < elementConnectorOrContainers.size(); j++) {
            Element elementConnectorOrContainer = (Element) elementConnectorOrContainers.get(j);
            if ("Connector".equals(elementConnectorOrContainer.getName())) {
                //创建连接器注册
                ConnectorRegistration connectorRegistration = new ConnectorRegistration();
                connectorRegistration.setName(
                        elementConnectorOrContainer.attributeValue("name"));
                connectorRegistration.setContainerName(
                        elementConnectorOrContainer.attributeValue("containerName"));
                connectorRegistration.setPort(Integer.valueOf(
                        elementConnectorOrContainer.attributeValue("port")));
                //获取元素集合，往下遍历
                List elementExecutors = elementConnectorOrContainer.elements();
                for (int k = 0; k < elementExecutors.size(); k++) {
                    //创建线程池执行者注册
                    ExecutorRegistration executorRegistration =
                            new ExecutorRegistration();
                    Element elementExecutor = (Element) elementExecutors.get(k);
                    executorRegistration.setCorePoolSize(Integer.valueOf(
                            elementExecutor.attributeValue("corePoolSize")));
                    executorRegistration.setMaximumPoolSize(Integer.valueOf(
                            elementExecutor.attributeValue("maximumPoolSize")));
                    connectorRegistration.setExecutorRegistration(executorRegistration);
                }
                serviceRegistration.addConnectorRegistration(connectorRegistration);
            } else if ("Container".equals(elementConnectorOrContainer.getName())) {
                //创建容器注册
                ContainerRegistration containerRegistration = new ContainerRegistration();
                containerRegistration.setName(
                        elementConnectorOrContainer.attributeValue("name"));
                containerRegistration.setConnectorName(
                        elementConnectorOrContainer.attributeValue("connectorName"));
                serviceRegistration.addContainerRegistration(containerRegistration);
            }
        }
        return serviceRegistration;
    }
}
