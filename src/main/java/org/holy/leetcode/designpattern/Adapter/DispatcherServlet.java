package org.holy.leetcode.designpattern.Adapter;

import java.util.ArrayList;
import java.util.List;

public class DispatcherServlet {

    private List<Adapter> handleAdapters = new ArrayList<>();

    public List<Adapter> initList() {
        this.handleAdapters.add(new SimpleControllerAdapter());
        this.handleAdapters.add(new HttpRequestControllerAdapter());
        return handleAdapters;
    }

    /**
     *
     */
    public void doDispatch() {
        initList();
        Controller controller = new SimpleController();

        Adapter handler = getHandler(controller);
        handler.handle(controller);

    }

    /**
     * 获取当前的适配器
     *
     * @return
     */
    private Adapter getHandler(Object controller) {
        for (Adapter handler : handleAdapters) {
            if (handler.support(controller)) {
                return handler;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new DispatcherServlet().doDispatch();
    }

}
