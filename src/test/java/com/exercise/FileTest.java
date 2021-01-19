package com.exercise;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTest {

    @Test
    public void getTxt() {
        String address = "D:\\科达资料\\政法委\\insertSql\\nrf.txt";
        toArrayByFileReader1(address);
    }

    public static List<String> toArrayByFileReader1(String name) {
        // 使用ArrayList来存储每行读取到的字符串
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            FileReader fr = new FileReader(name);
            BufferedReader bf = new BufferedReader(fr);
            String str;
            // 按行读取字符串
            while ((str = bf.readLine()) != null) {
                arrayList.add(str);
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对ArrayList中存储的字符串进行处理
        int length = arrayList.size();
        List<String> insertSqlList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            String all = arrayList.get(i);
            String[] arrList = all.split("\\s+");
            if (arrList.length == 1) {
                insertSqlList.add(getData(arrList, 0, 0));
            } else if (arrList.length == 3) {
                insertSqlList.add(getData(arrList, 1, 2));
            } else if (arrList.length == 5) {
                insertSqlList.add(getData(arrList, 1, 2));
                insertSqlList.add(getData(arrList, 3, 4));
            } else if (arrList.length == 7) {
                insertSqlList.add(getData(arrList, 1, 2));
                insertSqlList.add(getData(arrList, 3, 4));
                insertSqlList.add(getData(arrList, 5, 6));
            } else if (arrList.length == 9) {
                insertSqlList.add(getData(arrList, 1, 2));
                insertSqlList.add(getData(arrList, 3, 4));
                insertSqlList.add(getData(arrList, 5, 6));
                insertSqlList.add(getData(arrList, 7, 8));
            }
        }
        // 返回数组
        System.out.print(insertSqlList);
        String path = "D:\\科达资料\\政法委\\insertSql\\finshed\\nrf2.txt";
        try {
            writeFileContext(insertSqlList, path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return insertSqlList;
    }

    public static String getData(String[] arrList, int start, int end) {
        StringBuilder builder = new StringBuilder();
        builder.append("INSERT INTO `corpus_word`(`word`, `syntactic`, `freq`, `corpus_type`, `created_by`, `created_time`, `updated_by`, `updated_time`, `version`) VALUES (");
        String word = arrList[0];
        String syntactic = "nrf";
        String freq = "1";
        if (start != 0) {
            syntactic = arrList[start];
            freq = arrList[end];
        }
        builder.append("'").append(word).append("',");

        builder.append("'").append(syntactic).append("',");
        builder.append(freq).append(",");
        builder.append("'").append("B").append("',");
        builder.append("'").append("anonymous").append("',");
        builder.append("NOW()").append(",");
        builder.append("'").append("anonymous").append("',");
        builder.append("NOW()").append(",");
        builder.append(0).append(");");
        return builder.toString();
    }

    /**
     * 将list按行写入到txt文件中
     *
     * @param strings
     * @param path
     * @throws Exception
     */
    public static void writeFileContext(List<String> strings, String path) throws Exception {
        File file = new File(path);
        //如果没有文件就创建
        if (!file.isFile()) {
            file.createNewFile();
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        for (String l : strings) {
            writer.write(l + "\r\n");
        }
        writer.close();

    }
}
