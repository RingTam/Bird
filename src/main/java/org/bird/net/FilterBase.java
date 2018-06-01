package org.bird.net;

import javax.servlet.Filter;

/**
 * 类名：请求
 * 作者：Monster
 * 时间：2018/6/1 17:10
 * 说明：
 */
public abstract class FilterBase implements Filter {

    protected String httpLine;

    public FilterBase(String httpLine) {
        this.httpLine = httpLine;
    }

}
