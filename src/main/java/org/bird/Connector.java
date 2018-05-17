package org.bird;

import org.bird.config.ExecutorRegistration;

import java.io.IOException;
import java.util.concurrent.Executor;

/**
 * 类名：
 * 作者：Monster
 * 时间：2016/1/12 15:00
 * 说明：
 */
public interface Connector {

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
     * 获取 容器名称
     *
     * @return 容器名称
     */
    String getContainerName();

    /**
     * 设置 容器名称
     *
     * @param containerName 容器名称
     */
    void setContainerName(String containerName);

    /**
     * 设置 服务器套接字
     *
     * @param port 端口
     */
    void setServerSocket(Integer port) throws IOException;

    /**
     * 开始
     */
    void start();

    /**
     * 获取 线程池执行者
     *
     * @param executorRegistration 线程池执行者 注册
     * @return 线程池执行者
     */
    Executor getExecutor(ExecutorRegistration executorRegistration);

    /**
     * 设置 线程池执行者
     */
    void setExecutor(Executor executor);
}
