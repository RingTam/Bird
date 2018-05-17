package org.bird.net;

import org.apache.log4j.Logger;

import java.net.Socket;

/**
 * 类名：连接
 * 作者：Monster
 * 时间：2015/12/30 17:41
 * 说明：
 */
public class Connect implements Runnable {

    /**
     * 记录器
     */
    private static Logger logger = Logger.getLogger(Connect.class);
    /**
     * 套接字
     */
    private Socket socket;

    /**
     * 构造方法
     *
     * @param socket 套接字
     */
    public Connect(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
    }
}
