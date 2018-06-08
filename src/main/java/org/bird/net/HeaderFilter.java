package org.bird.net;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 类名：头拦截器
 * 作者：Monster
 * 时间：2017/12/2 18:10
 * 说明：
 */
public class HeaderFilter extends FilterBase {

    /**
     * 构造方法
     * @param httpLine 请求行
     */
    public HeaderFilter(String httpLine) {
        super(httpLine);
    }

    /**
     * 做过滤
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException      输入输出异常
     * @throws ServletException 小服务程序异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Request req = (Request) request;
        String[] headerNameValue = httpLine.split(": ");
    }
}
