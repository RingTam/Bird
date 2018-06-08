package org.bird.net;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名：Http过滤器通道
 * 作者：Monster
 * 说明：
 */
public class HttpFilterChain implements FilterChain {

    /**
     * 索引
     */
    int index = 0;
    /**
     * 过滤器
     */
    private List<Filter> filters = new ArrayList<>();

    /**
     * 做过滤
     *
     * @param request  请求
     * @param response 响应
     * @throws IOException      输入输出异常
     * @throws ServletException 服务者异常
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (index == filters.size()) {
            return;
        }
        index++;
        Filter filter = filters.get(index);
        filter.doFilter(request, response, this);
    }

    /**
     * 添加过滤器
     *
     * @param filter 过滤器
     */
    public void addFilter(Filter filter) {
        filters.add(filter);
    }
}
