package com.example.demo;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * zuul的过滤组件
 * @author jettang
 *
 */
@Component
public class MyFilter extends ZuulFilter {

	/**
	 * 是否过滤
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //request getParameter
        System.out.println("=========my filter is working==========");
        //
		return null;
	}

	/**
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 */
	@Override
	public String filterType() {
		return "pre";
	}
	
	/**
	 * 过滤顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

}
