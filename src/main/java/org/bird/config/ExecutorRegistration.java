package org.bird.config;

/**
 * 类名：线程池执行者注册
 * 作者：Monster
 * 时间：2016/1/13 15:57
 * 说明：
 */
public class ExecutorRegistration {

    /**
     * 核心池大小
     */
    private Integer corePoolSize;
    /**
     * 最大池大小
     */
    private Integer maximumPoolSize;

    /**
     * 获取 核心池大小
     *
     * @return 核心池大小
     */
    public Integer getCorePoolSize() {
        return corePoolSize;
    }

    /**
     * 设置 核心池大小
     *
     * @param corePoolSize 核心池大小
     */
    public void setCorePoolSize(Integer corePoolSize) {
        this.corePoolSize = corePoolSize;
    }

    /**
     * 获取 最大池大小
     *
     * @return 最大池大小
     */
    public Integer getMaximumPoolSize() {
        return maximumPoolSize;
    }

    /**
     * 设置 最大池大小
     *
     * @param maximumPoolSize 最大池大小
     */
    public void setMaximumPoolSize(Integer maximumPoolSize) {
        this.maximumPoolSize = maximumPoolSize;
    }
}
