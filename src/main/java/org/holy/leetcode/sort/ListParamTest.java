package org.holy.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListParamTest {
    public static void resetList(List dataList) {
        dataList.subList(2, 4).set(0, 40);
        dataList = new ArrayList(dataList);
        dataList.add(50);
    }

    public static void setOne(List dataList) {
        dataList.set(3, 100);
    }

    public static void main(String[] args) {
//        List<Integer> dataList = new ArrayList(Arrays.asList(10, 20, 30, null));
//        resetList(dataList);
//        setOne(dataList);
//        int sum = 0;
//        for (Integer v : dataList) {
//            sum += v;
//        }
//        System.out.println(sum);
        List<Integer> dataList = new ArrayList<>(Arrays.asList(10, 20, 30, null));
        System.out.println(dataList.subList(2,4).toString());
        dataList.subList(2,4).set(0,40);
//        dataList.add(10);
//        dataList.add(20);
//        dataList.add(null);
        System.out.println(dataList.toString());
    }
}