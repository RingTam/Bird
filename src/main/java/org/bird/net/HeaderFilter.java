package org.bird.net;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 类       名:
 * 说       明:
 * 修 改 记 录:
 * 版 权 所 有:   Copyright © 2016
 * 公       司:   深圳市旅联网络科技有限公司
 * version   0.1
 * date   2018/6/1
 * author   tanxiang(monster)
 */
public class HeaderFilter extends FilterBase {

    public HeaderFilter(String httpLine) {
        super(httpLine);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        Request req = (Request) request;
        String[] headerNameValue = httpLine.split(": ");
    }
}
