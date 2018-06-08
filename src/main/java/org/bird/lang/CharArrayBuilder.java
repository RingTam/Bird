package org.bird.lang;

import org.bird.util.CharacterUtils;

/**
 * 类名：字符数组构建器
 * 作者：Monster
 * 说明：
 */
public class CharArrayBuilder {

    /**
     * 字符数组
     */
    private char[] charArray;
    /**
     * 总计
     */
    private int count;
    /**
     * 容量
     */
    private int capacity = 16;

    /**
     * 构造方法
     */
    public CharArrayBuilder() {
        charArray = new char[capacity];
    }

    /**
     * 添加
     *
     * @param c 字符
     * @return 字符数组构造器
     */
    public CharArrayBuilder append(char c) {
        expandCapacity();
        charArray[count++] = c;
        return this;
    }

    /**
     * 扩展容量
     */
    private void expandCapacity() {
        if (count >= capacity) {
            capacity = capacity * 2;
            char[] arrayNew = new char[capacity];
            CharacterUtils.arrayCopy(charArray, arrayNew);
            charArray = arrayNew;
        }
    }

    /**
     * 到 字符串
     *
     * @return 字符串
     */
    public String toString() {
        return new String(charArray, 0, count);
    }

    /**
     * 长度
     *
     * @return 长度
     */
    public int length() {
        return count;
    }

    /**
     * 获取 字符数组
     *
     * @return 字符数组
     */
    public char[] getCharArray() {
        return CharacterUtils.arrayTrim(charArray);
    }
}
