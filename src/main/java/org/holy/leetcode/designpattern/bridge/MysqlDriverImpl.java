package org.holy.leetcode.designpattern.bridge;

public class MysqlDriverImpl implements Driver {

    @Override
    public void getConnect() {
        System.out.println(" Mysql driver working ... ");
    }
}
