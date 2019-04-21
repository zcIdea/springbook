package cn.tx.springboot;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TxListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("web容器的监听器启动了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
