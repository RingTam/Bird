package org.bird.util;

/**
 * 类名：字符工具
 * 作者：Monster
 * 说明：
 */
public class CharacterUtils {

    /**
     * 查找，字符在字符数组中的下标
     *
     * @param chars      字符数组
     * @param searchChar 字符
     * @return 下标
     */
    public static int indexOf(char[] chars, char searchChar) {
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == searchChar) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从开始下标，查找字符在字符数组中的下标
     *
     * @param chars      字符数组
     * @param searchChar 字符
     * @return 下标
     */
    public static int indexOf(char[] chars, int beginIndex, char searchChar) {
        for (int i = beginIndex; i < chars.length; i++) {
            if (chars[i] == searchChar) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 从末尾下标，从后往前查找字符在字符数组中的下标
     *
     * @param chars      字符数组
     * @param searchChar 字符
     * @return 下标
     */
    public static int lastIndexOf(char[] chars, char searchChar) {
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == searchChar) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在开始下标，从后往前查找字符在字符数组中的下标
     *
     * @param chars      字符数组
     * @param searchChar 字符
     * @return 下标
     */
    public static int lastIndexOf(char[] chars, int beginIndex, char searchChar) {
        for (int i = chars.length - 1; i >= beginIndex; i--) {
            if (chars[i] == searchChar) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 字符数组反转
     *
     * @param chars      字符数组
     * @param beginIndex 开始下标
     * @param endIndex   结束下标
     */
    public static char[] reverse(char[] chars, int beginIndex, int endIndex) {
        while (beginIndex < endIndex) {
            char temp = chars[beginIndex];
            chars[beginIndex] = chars[endIndex];
            chars[endIndex] = temp;
            beginIndex++;
            endIndex--;
        }
        return chars;
    }


    /**
     * 从开始下标到结束下标之前查找，在给定的字符数组中，存在对应字符
     *
     * @param chars      字符数组
     * @param startIndex 开始下标
     * @param endIndex   开始下标
     * @param searchChar 字符
     * @return 是否
     */
    public static boolean arrayIsExist(char[] chars, int startIndex, int endIndex, char searchChar) {
        while (startIndex < endIndex) {
            if (chars[startIndex] == searchChar) {
                return true;
            }
            startIndex++;
        }
        return false;
    }

    /**
     * 从开始下标到结束下标之前查找，在给定的字符数组中，存在对应两个字符
     *
     * @param chars       字符数组
     * @param startIndex  开始下标
     * @param endIndex    开始下标
     * @param searchChar1 字符
     * @param searchChar2 字符
     * @return 是否
     */
    public static boolean arrayIsExist(char[] chars, int startIndex, int endIndex, char searchChar1, char searchChar2) {
        while (startIndex < endIndex) {
            if (startIndex + 1 < endIndex &&
                    chars[startIndex] == searchChar1 &&
                    chars[startIndex + 1] == searchChar2) {
                return true;
            }
            startIndex++;
        }
        return false;
    }

    /**
     * 数组 拷贝
     *
     * @param source 源字符数组
     * @param target 目标字符数组
     * @return 目标字符数组
     */
    public static char[] arrayCopy(char[] source, char[] target) {
        for (int i = 0; i < source.length; i++) {
            target[i] = source[i];
        }
        return target;
    }

    /**
     * 数组 非空
     *
     * @param chars 字符数组
     * @return 是否
     */
    public static boolean arrayNotEmpty(char[] chars) {
        for (char c : chars) {
            if (c != '\u0000') { //<-- ' '
                return true;
            }
        }
        return false;
    }

    /**
     * 数组 去空
     *
     * @param chars 字符数组
     * @return 去空后的数组
     */
    public static char[] arrayTrim(char[] chars) {
        int newLength = indexOf(chars, '\u0000'); //<-- ' '
        if (newLength == -1) {
            return null;
        }
        char[] charsNew = new char[newLength];
        int newIndex = 0;
        for (int i = 0; i < newLength; i++) {
            charsNew[newIndex++] = chars[i];
        }
        return charsNew;
    }

    /**
     * 从开始下标到结束下标之前查找，在给定的字符数组中，存在对应字符个数
     *
     * @param chars      字符数组
     * @param startIndex 开始下标
     * @param endIndex   开始下标
     * @param searchChar 字符
     * @return 是否
     */
    public static int countOf(char[] chars, int startIndex, int endIndex, char searchChar) {
        int count = 0;
        while (startIndex < endIndex) {
            if (chars[startIndex] == searchChar) {
                count++;
            }
            startIndex++;
        }
        return count;
    }

    /**
     * 从开始下标到结束下标之前查找，在给定的字符数组中，存在对应两个字符个数
     *
     * @param chars       字符数组
     * @param startIndex  开始下标
     * @param endIndex    开始下标
     * @param searchChar1 字符
     * @param searchChar2 字符
     * @return 是否
     */
    public static int countOf(char[] chars, int startIndex, int endIndex, char searchChar1, char searchChar2) {
        int count = 0;
        while (startIndex < endIndex) {
            if (startIndex + 1 < endIndex &&
                    chars[startIndex] == searchChar1 &&
                    chars[startIndex + 1] == searchChar2) {
                count++;
            }
            startIndex++;
        }
        return count;
    }

    /**
     * 起始于
     *
     * @param chars       字符数组
     * @param prefixChars 前缀字符数组
     * @return 是否
     */
    public static boolean startsWith(char[] chars, char[] prefixChars) {
        for (int i = 0; i < prefixChars.length; i++) {
            if (prefixChars[i] != chars[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 起始于
     *
     * @param chars       字符数组
     * @param prefixChars 前缀字符串
     * @return 是否
     */
    public static boolean startsWith(char[] chars, String prefixChars) {
        return startsWith(chars, prefixChars.toCharArray());
    }

    /**
     * 值 由
     *
     * @param chars      字符数组
     * @param startIndex 开始下标
     * @param endIndex   结束下标
     * @return 字符数组
     */
    public static char[] valueOf(char[] chars, int startIndex, int endIndex) {
        int i = 0;
        char[] charNew = new char[endIndex - startIndex];
        while (startIndex < endIndex) {
            charNew[i++] = chars[startIndex];
            startIndex++;
        }
        return charNew;
    }


    /**
     * 等于
     *
     * @param array1 字符数组1
     * @param array2 字符数组2
     * @return 是否
     */
    public static boolean equals(char[] array1, char[] array2) {
        int i = 0;
        int array1Len = array1.length;
        int array2Len = array2.length;
        if (array1Len != array2Len)
            return false;
        while (array1Len-- != 0) {
            if (array1[i] != array2[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
}
