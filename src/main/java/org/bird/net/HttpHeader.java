package org.bird.net;

import java.util.Enumeration;

/**
 * 类名：请求头
 * 作者：Monster
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

        private HttpHeader httpHeader;

        public NamesEnumeration(HttpHeader httpHeader) {
            this.httpHeader = httpHeader;
        }

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

        private HttpHeader httpHeader;
        private String name;

        public ValueEnumeration(HttpHeader httpHeader, String name) {
            this.httpHeader = httpHeader;
            this.name = name;
        }

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
