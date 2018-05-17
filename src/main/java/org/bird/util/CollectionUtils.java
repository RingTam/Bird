package org.bird.util;

import java.util.List;

/**
 * 类名：集合工具类
 * 作者：Monster
 * 时间：2016/1/6 17:49
 * 说明：
 */
public class CollectionUtils {

    /**
     * 连接
     *
     * @param strings   字符集合
     * @param separator 分隔符
     * @return 连接后字符串
     */
    public static String join(List<String> strings, String separator) {
        StringBuilder sb = new StringBuilder();
        int size = strings.size();
        for (int i = 0; i < size; i++) {
            String s = strings.get(i);
            sb.append(s);
            if (i < size - 1) {
                sb.append(separator);
            }
        }
        return sb.toString();
    }
}
