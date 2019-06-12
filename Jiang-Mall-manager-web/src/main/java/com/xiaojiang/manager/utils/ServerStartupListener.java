package com.xiaojiang.manager.utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @创建人:小江
 * @创建时间:2019/6/4 0004
 * @描述:启动监听类
 */
    public class ServerStartupListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext application = servletContextEvent.getServletContext();
        String path = application.getContextPath();
        //把数据写入到Context场景
        application.setAttribute("PATH",path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
