package org.holy.leetcode.designpattern.bridge;

public class Client {

    public static void main(String[] args) {
        // 读操作使用 mysql
        Driver mysqlDriver = new MysqlDriverImpl();
        AbstactBridge readOption = new ReadOption();
        readOption.setDriver(mysqlDriver);
        readOption.crudOption();

        // 写操作使用 oracle
        Driver oracleDriver = new OracleDriverImpl();
        AbstactBridge writeOption = new WriteOption();
        writeOption.setDriver(oracleDriver);
        writeOption.crudOption();
    }
}
