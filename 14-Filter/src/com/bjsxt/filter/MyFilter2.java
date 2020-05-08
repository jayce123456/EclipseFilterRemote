package com.bjsxt.filter;
//github.com/jayce123456/EclfOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter2   implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("filter22222  before");
		chain.doFilter(request, response);
		System.out.println("filter22222 after");
		
	}

	@Override
	public void destroy() {
		
	}

}
