package org.bird.net;

/**
 * 类名：Http版本
 * 作者：Monster
 * 时间：2018/6/1 17:00
 * 说明：
 */
public enum HttpVersion {

    HTTP_0_9("HTTP/0.9"),
    HTTP_1_0("HTTP/1.0"),
    HTTP_1_1("HTTP/1.1"),
    HTTP_2_0("HTTP/2.0");

    private String s;

    HttpVersion(String s) {
        this.s = s;
    }
}
