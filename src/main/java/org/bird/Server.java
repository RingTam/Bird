package org.bird;

import org.bird.config.ServiceRegistration;

import java.io.IOException;
import java.util.List;

/**
 * 类名：服务器
 * 作者：Monster
 * 说明：
 */
public interface Server {

    /**
     * 设置 服务 集合
     *
     * @param serviceRegistrations 服务注册 集合
     * @throws IOException 输入输出异常
     */
    void setServices(List<ServiceRegistration> serviceRegistrations) throws IOException;

    /**
     * 移除 服务
     *
     * @param serviceRegistration 服务注册
     */
    void removeService(ServiceRegistration serviceRegistration);

    /**
     * 开始
     */
    void start();


}
