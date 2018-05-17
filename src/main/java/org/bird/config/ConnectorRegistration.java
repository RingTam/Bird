package org.bird.config;

/**
 * 类名：连接器注册
 * 作者：Monster
 * 时间：2016/1/13 15:57
 * 说明：
 */
public class ConnectorRegistration {

    /**
     * 名称
     */
    private String name;
    /**
     * 容器名称
     */
    private String containerName;
    /**
     * 端口
     */
    private Integer port;
    /**
     * 执行者注册
     */
    private ExecutorRegistration executorRegistration;

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
     * 获取 容器名称
     *
     * @return 容器名称
     */
    public String getContainerName() {
        return containerName;
    }

    /**
     * 设置 容器名称
     *
     * @param containerName 容器名称
     */
    public void setContainerName(String containerName) {
        this.containerName = containerName;
    }

    /**
     * 获取 端口
     *
     * @return 端口
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 设置 端口
     *
     * @param port 端口
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 获取 执行者注册
     *
     * @return 执行者注册
     */
    public ExecutorRegistration getExecutorRegistration() {
        return executorRegistration;
    }

    /**
     * 设置 执行者注册
     *
     * @param executorRegistration 执行者注册
     */
    public void setExecutorRegistration(ExecutorRegistration executorRegistration) {
        this.executorRegistration = executorRegistration;
    }
}
