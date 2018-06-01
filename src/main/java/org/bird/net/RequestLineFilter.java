package org.bird.net;

import javax.servlet.*;
import java.io.IOException;

/**
 * 类名：请求
 * 作者：Monster
 * 时间：2018/6/1 17:10
 * 说明：
 */
public class RequestLineFilter extends FilterBase {

    public RequestLineFilter(String httpLine) {
        super(httpLine);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

    }
}
