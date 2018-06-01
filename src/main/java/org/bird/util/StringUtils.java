package org.bird.util;

/**
 * 类名：字符串工具类
 * 作者：Monster
 * 时间：2015/12/22 18:47
 * 说明：
 */
public class StringUtils {

    /**
     * 连接
     *
     * @param array     字符串数组
     * @param separator 分隔符
     * @return 连接后字符串
     */
    public static String join(Object[] array, String separator) {
        if (array == null) {
            return null;
        }
        StringBuilder builder = new StringBuilder();
        int realLength = array.length - 1;
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i]);
            if (i < realLength) {
                builder.append(separator);
            }
        }
        return builder.toString();
    }

    /**
     * 是空
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = true
     * StringUtils.isEmpty("aa")      = false
     * StringUtils.isEmpty(" aa ")    = false
     *
     * @param cs 字符序列
     * @return 是否
     */
    public static boolean isEmpty(CharSequence cs) {
        return cs == null ||
                cs.length() == 0 ||
                cs.toString().trim().length() == 0;
    }

    /**
     * 是空
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty("")        = false
     * StringUtils.isNotEmpty(" ")       = false
     * StringUtils.isNotEmpty("aa")      = true
     * StringUtils.isNotEmpty(" aa ")    = true
     *
     * @param cs 字符序列
     * @return 是否
     */
    public static boolean isNotEmpty(CharSequence cs) {
        return cs != null &&
                cs.length() > 0 &&
                cs.toString().trim().length() > 0;
    }


    /**
     * 值 由
     *
     * @param chars      字符数组
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     * @return 字符串
     */
    public static String valueOf(char[] chars, int startIndex, int endIndex) {
        StringBuilder sb = new StringBuilder();
        while (startIndex < endIndex) {
            sb.append(chars[startIndex]);
            startIndex++;
        }
        return sb.toString();
    }
}
