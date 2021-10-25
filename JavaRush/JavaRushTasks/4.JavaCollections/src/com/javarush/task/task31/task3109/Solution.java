package com.javarush.task.task31.task3109;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("4.JavaCollections/src/com/javarush/task/task31/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = null;
        try {
            if (fileName.endsWith(".xml")) {
                properties = new Properties();
                FileInputStream fis = new FileInputStream(fileName);
                properties.loadFromXML(fis);
            } else {
                properties = new Properties();
                FileInputStream fis = new FileInputStream(fileName);
                properties.load(fis);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return properties;
    }
}
