package org.bird.net;

import java.util.Enumeration;

/**
 * 类名：请求
 * 作者：Monster
 * 时间：2018/6/1 17:10
 * 说明：
 */
public class HttpHeader {

    public Enumeration<String> names() {
        return new NamesEnumeration(this);
    }

    public Enumeration<String> values(String name) {
        return new ValueEnumeration(this, name);
    }

    class NamesEnumeration implements Enumeration<String> {


        @Override
        public boolean hasMoreElements() {
            return false;
        }

        @Override
        public String nextElement() {
            return null;
        }
    }

    class ValueEnumeration implements Enumeration<String> {

        @Override
        public boolean hasMoreElements() {
            return false;
        }

        @Override
        public String nextElement() {
            return null;
        }
    }
}
