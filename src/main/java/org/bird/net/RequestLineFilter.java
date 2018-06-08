package org.bird.net;

import javax.servlet.*;
import java.io.IOException;

/**
 * 类名：请求
 * 作者：Monster
 * 说明：
 */
public class RequestLineFilter extends FilterBase {

    /**
     * 构造方法
     * @param httpLine 请求行
     */
    public RequestLineFilter(String httpLine) {
        super(httpLine);
    }

    /**
     * 做过滤
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException      输入输出异常
     * @throws ServletException 服务者异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

    }
}
