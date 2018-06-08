package org.bird.config;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名：服务器注册
 * 作者：Monster
 * 说明：
 */
public class ServerRegistration {

    /**
     * 服务注册 集合
     */
    private List<ServiceRegistration> serviceRegistrations = new ArrayList<>();

    /**
     * 获取 服务注册 集合
     *
     * @return 服务注册 集合
     */
    public List<ServiceRegistration> getServiceRegistrations() {
        return serviceRegistrations;
    }

    /**
     * 设置 服务注册 集合
     *
     * @param serviceRegistrations 服务注册 集合
     */
    public void setServiceRegistrations(List<ServiceRegistration> serviceRegistrations) {
        this.serviceRegistrations = serviceRegistrations;
    }

    /**
     * 添加 服务注册
     *
     * @param serviceRegistration 服务注册
     */
    public void addServiceRegistration(ServiceRegistration serviceRegistration) {
        serviceRegistrations.add(serviceRegistration);
    }
}
