package com.yan.util;

import java.io.*;
import java.util.*;

// 文件相关操作
public class FileOperation {
    // 读取文件名称为filename中的内容，并将其中包含的所有词语放进words中
    public static List<String> readFile(String filename) {
        List<String> words = new ArrayList<>();
        if (filename == null) {
            System.out.println("filename is null or words is null");
            return words;
        }

        // 文件读取
        ClassLoader classLoader = FileOperation.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(filename);
        Scanner scanner = new Scanner(new BufferedInputStream(Objects.requireNonNull(inputStream)));

        // 简单分词
        // 这个分词方式相对简陋, 没有考虑很多文本处理中的特殊问题
        // 在这里只做demo展示用
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").next();

            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }

        return words;
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }
}