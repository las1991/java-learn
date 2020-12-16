package com.las.learn.se.string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class EncodingTest {

    @Test
    public void test() {
        String en = "A";
        String ch = "人";//嗀，兀，鎴、戝、枩、綘
        System.out.println("英文字母：" + en);
        printByteLength(en, "GB2312");
        printByteLength(en, "GBK");
        printByteLength(en, "GB18030");
        printByteLength(en, "ISO-8859-1");
        printByteLength(en, "UTF-8");
        printByteLength(en, "UTF-16");
        printByteLength(en, "UTF-16BE");
        printByteLength(en, "UTF-16LE");
        System.out.println();

        System.out.println("中文汉字：" + ch);
        printByteLength(ch, "GB2312");
        printByteLength(ch, "GBK");
        printByteLength(ch, "GB18030");
        printByteLength(ch, "ISO-8859-1");
        printByteLength(ch, "UTF-8");
        printByteLength(ch, "UTF-16");
        printByteLength(ch, "UTF-16BE");
        printByteLength(ch, "UTF-16LE");
    }

    /**
     * 打印不同字符集下Java字符串所占的字节数
     *
     * @param str          待操作的字符串
     * @param encodingName 字符集名称
     */
    public void printByteLength(String str, String encodingName) {
        System.out.print("字节数 : ");
        try {
            System.out.print(str.getBytes(encodingName).length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(";编码：" + encodingName);
    }
}
