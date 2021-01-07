package org.holy.leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class NodePathValue {

    static class Node{
        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        int value;
        Node left;
        Node right;


    }

    public static int calcSum(Node root){
        List<Node> tempPath = new ArrayList<>();
        List<List<Node>> paths = new ArrayList<>();
        findPath(root, paths, tempPath);

        int sum = 0;
        for (int i = 0; i < paths.size(); i++){
            List<Node> path = paths.get(i);
            int tempSum = 0;
            for(Node node : path){
                tempSum += node.getValue();
            }
            if (sum < tempSum){
                sum = tempSum;
            }
        }
        return sum;
    }

    public static void findPath(Node node, List<List<Node>> paths, List<Node> tempPath) {
        tempPath.add(node);
        if (node.getLeft() == null && node.getRight() == null) {
            List<Node> list = new ArrayList<>();
            list.addAll(tempPath);
            paths.add(list);
            tempPath.remove(node);
        }

        if (node.getLeft() != null) {
            findPath(node.getLeft(), paths, tempPath);
        }

        if (node.getRight() != null) {
            if (node.getLeft() != null) {
                int index = tempPath.indexOf(node);
                tempPath = tempPath.subList(0, index + 1);
            }
            findPath(node.getRight(), paths, tempPath);
        }
    }

    public static void main(String args[]){


    }
}
