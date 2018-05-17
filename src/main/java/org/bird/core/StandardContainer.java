package org.bird.core;

import org.bird.Container;
import org.bird.Host;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 类名：标准容器
 * 作者：Monster
 * 时间：2016/1/12 14:36
 * 说明：
 */
public class StandardContainer implements Container {

    /**
     * 名称
     */
    private String name;
    /**
     * 连接器名称
     */
    private String connectorName;
    /**
     * 主机 集合
     */
    private List<Host> hosts = new CopyOnWriteArrayList<>();

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
     * 获取 连接器名称
     *
     * @return 连机器名称
     */
    @Override
    public String getConnectorName() {
        return connectorName;
    }

    /**
     * 设置 连接器名称
     *
     * @param connectorName 连接器名称
     */
    @Override
    public void setConnectorName(String connectorName) {
        this.connectorName = connectorName;
    }

    /**
     * 添加 主机
     *
     * @param host 主机
     */
    @Override
    public void addHost(Host host) {
        hosts.add(host);
    }

    /**
     * 移除 主机
     *
     * @param host 主机
     */
    @Override
    public void removeHost(Host host) {
        hosts.remove(host);
    }

    /**
     * 开始
     */
    @Override
    public void start() {
        for (Host host : hosts) {
            host.start();
        }
    }
}
