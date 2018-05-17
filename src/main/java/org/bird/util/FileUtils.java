package org.bird.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 类名：文件工具类
 * 作者：Monster
 * 时间：2016/1/11 14:27
 * 说明：
 */
public class FileUtils {

    /**
     * 结束标志
     */
    private static final int EOF = -1;

    /**
     * 写
     *
     * @param os 输出
     * @param is 输入
     * @throws IOException 输入输出异常
     */
    public static void write(OutputStream os, InputStream is) throws IOException {
        int len;
        while ((len = is.read()) != EOF) {
            os.write(len);
        }
        close(os, is);
    }

    /**
     * 关闭 （防止内存溢出）
     *
     * @param os 输出
     * @param is 输入
     */
    public static void close(OutputStream os, InputStream is) {
        close(os);
        close(is);
    }

    /**
     * 关闭 （防止内存异常溢出）
     *
     * @param is 输入
     */
    public static void close(InputStream is) {
        try {
            is.close();
        } catch (Exception e) {
            //Ignore
        }
    }

    /**
     * 关闭 （防止内存异常）
     *
     * @param os 输出
     */
    public static void close(OutputStream os) {
        try {
            os.close();
        } catch (Exception e) {
            //Ignore
        }
    }

    /**
     * 预览格式扩展
     */
    public static final String[] IMAGE_EXTENSIONS = {
            "jpg", "gif", "png", "jpeg", "bmp", "pdf"
    };

    /**
     * 是否，预览格式扩展
     *
     * @param str 字符串
     * @return 是否
     */
    public static boolean isImageExtension(String str) {
        int length = str.length();
        for (String extension : IMAGE_EXTENSIONS) {
            if (extension.equalsIgnoreCase(str.substring(
                    length - extension.length(), length))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 文件命名中，不能存在的特殊字符
     */
    public static final String[] SPECIAL_SYMBOLS = {
            "\\", "/", ":", "*", "?", "\"", "<", ">", "|"
    };

    /**
     * 是否包含，命名中不能存在的特殊字符
     * @param str 字符串
     * @return 是否
     */
    public static boolean ofContainsSymbol(String str) {
        for (String symbol : SPECIAL_SYMBOLS) {
            if (str.contains(symbol)) {
                return true;
            }
        }
        return false;
    }
}
