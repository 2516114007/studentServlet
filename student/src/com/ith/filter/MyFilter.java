package com.ith.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter implements Filter{
	public void BasicsFilter() {
        // 容器（服务器）启动时执行
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        /* 容器（服务器）时执行 */
        System.out.println("======== 初始化方法 ========");
        // 获取的是web.xml中配置Filter时设置的值，参数为设置值得名称，若参数不存在，则返回空
        String initParam = fConfig.getInitParameter("param");
        System.out.println("param ========" + initParam);
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        /* 在访问的时候执行 */
        System.out.println("======= 开始执行doFilter ========");
        // 转发到下一个组件，进行后续的处理（组件可以是一个过滤器，也可以是一个servlet）
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        chain.doFilter(request, response);
        System.out.println("======= 结束执行doFilter ========");
        
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

}
