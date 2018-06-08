package org.bird.boot;

import org.apache.log4j.Logger;
import org.bird.Server;
import org.bird.config.ServerConfig;
import org.bird.config.ServerRegistration;
import org.bird.core.StandardServer;

import java.io.IOException;

/**
 * 类名：引导程序
 * 作者：Monster
 * 时间：2016/1/6 14:22
 * 说明：
 */
public class Bootstrap {

    /**
     * 日志器
     */
    private static final Logger logger = Logger.getLogger(ServerConfig.class);

    /**
     * 静态代码块
     */
    static {
        ServerConfig.configureDefaultLog();
    }

    /**
     * 主方法
     *
     * @param args 参数
     */
    public static void main(String[] args) throws IOException {
        ServerRegistration serverRegistration = ServerConfig.getServerRegistration(
                ServerConfig.getDefaultDocument());
        if (serverRegistration == null) {
            String message = "未注册Server，程序退出！";
            logger.error(message);
            throw new NullPointerException(message);
        }
        Server server = new StandardServer();
        server.setServices(serverRegistration.getServiceRegistrations());
        server.start();
    }
}
