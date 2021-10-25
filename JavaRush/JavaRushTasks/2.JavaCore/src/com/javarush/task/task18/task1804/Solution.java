package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> byteMap = new HashMap<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        while (inputStream.available() > 0) {
            int currentByte = inputStream.read();
            if (byteMap.containsKey(currentByte)) {
                byteMap.replace(currentByte, byteMap.get(currentByte) + 1);
            } else {
                byteMap.put(currentByte, 1);
            }
        }
        inputStream.close();

        TreeSet<Integer> values = new TreeSet<>(byteMap.values());
        int minValue = values.first();

        for (Map.Entry line : byteMap.entrySet()) {
            if (line.getValue().equals(minValue)) {
                System.out.print(line.getKey() + " ");
            }
        }
    }
}
