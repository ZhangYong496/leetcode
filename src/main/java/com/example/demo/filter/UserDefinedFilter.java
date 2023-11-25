package com.example.demo.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author alexzhang
 */
@Slf4j
public class UserDefinedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("自定义过滤器开始初始化了！！！！");
    }

    @Override
    public void destroy() {
        log.info("过滤器被销毁了！！");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("开始执行过滤操作！！");
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String s = httpServletRequest.getRequestURL().toString();
        log.info("url : "+s);
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
