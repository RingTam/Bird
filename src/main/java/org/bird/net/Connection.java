package org.bird.net;

import org.apache.log4j.Logger;
import org.bird.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * 类名：连接
 * 作者：Monster
 * 时间：2015/12/30 17:41
 * 说明：
 */
public class Connection implements Runnable {

    /**
     * 日志器
     */
    private static Logger logger = Logger.getLogger(Connection.class);
    /**
     * 套接字
     */
    private Socket socket;
    /**
     * 请求
     */
    private ServletRequest request;
    /**
     * 响应
     */
    private ServletResponse response;
    /**
     *
     */
    private HttpFilterChain httpFilterChain = new HttpFilterChain();

    /**
     * 构造方法
     *
     * @param socket 套接字
     */
    public Connection(Socket socket) {
        this.socket = socket;
    }

    /**
     * 运行
     */
    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            int lineIndex = 0;
            while ((line = br.readLine()) != null && StringUtils.isNotEmpty(line)) {
                if (lineIndex == 0) {
                    httpFilterChain.addFilter(new RequestLineFilter(line));
                } else {
                    httpFilterChain.addFilter(new HeaderFilter(line));
                }
                lineIndex++;
            }
            try {
                request = new Request();
                response = new Response();
                httpFilterChain.doFilter(request, response);
            } catch (ServletException e) {
                //Ignore
            }

            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(new OutputStreamWriter(os));
            String s = "<html>" + "<head>" + "<title>404</title>" + "</head>"
                    + "<body><h1>Error! 404 File Not Found</h1></body>" + "</html>";
            pw.println("HTTP/1.1 200 OK");
            pw.println("Connection: close");
            pw.println("Content-Type: text/html");
            pw.println("Content-Length: " + s.length());
            pw.println("Date: " + new Date(System.currentTimeMillis()).toString());
            pw.println("Server: Bird");
            pw.println();
            pw.print(s);
            pw.flush();
        } catch (IOException e) {
            //Ignore
        } finally {
            closeConnection();
        }
    }

    /**
     * 关闭连接
     */
    private void closeConnection() {
        if (socket != null) {
            try {
                if (!socket.isClosed() && socket.isConnected()) {
                    if (!socket.isOutputShutdown()) {
                        socket.shutdownOutput();
                    }
                    if (!socket.isInputShutdown()) {
                        socket.shutdownInput();
                    }
                    socket.close();
                }
            } catch (IOException e) {
                //Ignore
            }
        }
    }
}
