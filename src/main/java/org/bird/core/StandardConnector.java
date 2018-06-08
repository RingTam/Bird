package org.bird.core;

import org.apache.log4j.Logger;
import org.bird.Connector;
import org.bird.config.ExecutorRegistration;
import org.bird.net.Connection;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 类名：标准连接器
 * 作者：Monster
 * 说明：
 */
public class StandardConnector implements Connector {

    /**
     * 日志器
     */
    private static final Logger logger = Logger.getLogger(StandardConnector.class);
    /**
     * 名称
     */
    private String name;
    /**
     * 容器名称
     */
    private String containerName;
    /**
     * 执行者
     */
    private Executor executor;
    /**
     * 服务器套接字
     */
    private ServerSocket serverSocket;
    /**
     * 工作中
     */
    private volatile boolean working = true;

    /**
     * 获取 名称
     *
     * @return 名称
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * 设置 名称
     *
     * @param name 名称
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 容器名称
     *
     * @return 容器名称
     */
    @Override
    public String getContainerName() {
        return containerName;
    }

    /**
     * 设置 容器名称
     *
     * @param containerName 容器名称
     */
    @Override
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * 设置 服务器套接字
     *
     * @param port 端口
     */
    @Override
    public void setServerSocket(Integer port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    /**
     * 开始
     */
    @Override
    public void start() {
        logger.info(">>>>>端口：" + serverSocket.getLocalPort());
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executor;
        logger.info(">>>>>核心池大小：" + threadPoolExecutor.getCorePoolSize() +
                " >>>>>最大池大小：" + threadPoolExecutor.getMaximumPoolSize());
        while (working) {
            try {
                Socket socket = serverSocket.accept();
                executor.execute(new Connection(socket));
            } catch (IOException e) {
                //Ignore
            }
        }
    }

    /**
     * 获取 执行者
     *
     * @param executorRegistration 执行者 注册
     * @return 执行者
     */
    @Override
    public Executor getExecutor(ExecutorRegistration executorRegistration) {
        return new ThreadPoolExecutor(
                executorRegistration.getCorePoolSize(),
                executorRegistration.getMaximumPoolSize(),
                200, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
    }

    /**
     * 设置 执行者
     */
    @Override
    public void setExecutor(Executor executor) {
        this.executor = executor;
    }
}
