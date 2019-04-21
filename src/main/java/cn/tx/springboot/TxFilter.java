package cn.tx.springboot;

import javax.servlet.*;
import java.io.IOException;

public class TxFilter implements Filter{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拓薪教育前置通知");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("拓薪教育后置通知");
    }

    @Override
    public void destroy() {

    }
}
