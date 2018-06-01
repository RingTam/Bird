package org.bird.net;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名：请求
 * 作者：Monster
 * 时间：2018/6/1 17:10
 * 说明：
 */
public class HttpFilterChain implements FilterChain {

    int index = 0;

    private List<Filter> filters = new ArrayList<>();

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if (index == filters.size()) {
            return;
        }
        index++;
        Filter filter = filters.get(index);
        filter.doFilter(request, response, this);
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }
}
