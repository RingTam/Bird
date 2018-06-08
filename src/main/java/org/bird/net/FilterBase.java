package org.bird.net;

import javax.servlet.Filter;

/**
 * 类名：拦截器基础
 * 作者：Monster
 * 时间：2017/12/2 18:10
 * 说明：
 */
public abstract class FilterBase implements Filter {

    /**
     * 请求行
     */
    protected String httpLine;

    /**
     * 构造方法
     * @param httpLine 请求行
     */
    public FilterBase(String httpLine) {
        this.httpLine = httpLine;
    }

}
