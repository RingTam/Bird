package org.bird.core;

import org.bird.Server;
import org.bird.Service;
import org.bird.config.ServiceRegistration;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 类名：标准服务器
 * 作者：Monster
 * 说明：
 */
public class StandardServer implements Server {

    /**
     * 服务 集合
     */
    private List<Service> services = new CopyOnWriteArrayList<>();

    /**
     * 设置 服务 集合
     *
     * @param serviceRegistrations 服务注册 集合
     * @throws IOException 输入输出异常
     */
    public void setServices(List<ServiceRegistration> serviceRegistrations) throws IOException {
        for (ServiceRegistration serviceRegistration : serviceRegistrations) {
            Service service = new StandardService();
            service.setName(serviceRegistration.getName());
            service.setReload(serviceRegistration.getReload());
            service.setConnectors(serviceRegistration.getConnectorRegistrations());
            service.setContainers(serviceRegistration.getContainerRegistrations());
            services.add(service);
        }
    }

    /**
     * 移除 服务
     *
     * @param serviceRegistration 服务注册
     */
    @Override
    public void removeService(ServiceRegistration serviceRegistration) {
        for (Service service : services) {
            if (service.getName().equals(
                    serviceRegistration.getName())) {
                services.remove(service);
            }
        }
    }

    /**
     * 开始
     */
    @Override
    public void start() {
        for (Service service : services) {
            service.start();
        }
    }
}
