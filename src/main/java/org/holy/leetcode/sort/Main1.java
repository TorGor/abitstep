package org.holy.leetcode.sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {
    /**请完成下面这个process函数，实现题目要求的功能**/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来^-^
     **/
    private static int process(ModelItem[] items) {
        int result;

        for(ModelItem item : items){

        }
        return -1;
    }

    public static class BoxTemplate{
        int price=2000;
        int length=100;
        int width=100;
        int height=100;
    }

    public static class ModelItem{
        int price;
        int length;
        int width;
        int height;
    }


//    public static void main(String args[]) {
//        Scanner scanner = new Scanner(System.in);
//        BoxTemplate boxTemplate = new BoxTemplate();
//        ModelItem[] items;
//        boxTemplate.price = 2000;
//        while (scanner.hasNext()) {
//            boxTemplate.length = scanner.nextInt();
//            boxTemplate.width = scanner.nextInt();
//            boxTemplate.height = scanner.nextInt();
//            int itemNum = scanner.nextInt();
//            items = new ModelItem[itemNum];
//            for (int i = 0; i < itemNum; i++) {
//                ModelItem item = new ModelItem();
//                item.price = scanner.nextInt();
//                item.length = scanner.nextInt();
//                item.width = scanner.nextInt();
//                item.height = scanner.nextInt();
//                items[i] = item;
//            }
//            long startTime = System.currentTimeMillis();
//            int boxMinNum = Integer.MAX_VALUE;
//            System.out.println(process(items));
//        }
//    }

    public static void main(String[] args) {

//        Integer a = new Integer(3);
//
//        Integer b = 3;
//
//        int c = 3;
//
//        Integer d = 3;
//
//        Integer e = 300;
//
//        Integer f = 300;
//
//        System.out.println(a == b);
//
//        System.out.println(a == c);
//
//        System.out.println(b == d);
//
//        System.out.println(e == f);
//
        int[] arrs = {1,2,3};

//        int[] arr = (int[]) JSONObject.parseObject("").get("");
        System.out.println(Arrays.stream(arrs).sum());
    }


    class Pair{

        int x;

        int y;

    }

    List<Pair> countPair(int[] num, int diff) {
        // 请编写实现
        List<Pair> result = new ArrayList<>();
        for(int i=0;i<num.length;i++){
            int a = num[i];
            for(int j = i+1;j < num.length;j++ ){

            }
//            num[i]
        }
        return result;
    }
}
