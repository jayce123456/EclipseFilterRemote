package com.bjsxt.filter;
//123
//
//
//abcdefg
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/*
 * 过滤器使用
 * 作用：
 * 		对服务器接受的请求和响应资源进行管理
 * 		保护servlet
 * 使用：
 * 		创建implements Fileter的class
 * 		override
 * 				init：服务器启动时执行,资源初始化
 * 				service:拦截请求的方法，需要在此方法中处理
 * 						需要手动放行	chain.doFilter(request, response);
 * 				destory:服务器关闭的时候
 * 		配置web.xml文件中的过过滤器
					 	<filter>
							<filter-name>myFilter</filter-name>
							<filter-class>com.bjsxt.filter.MyFilter</filter-class>
						</filter>
						<filter-mapping>
							<filter-name>myFilter</filter-name>
							<url-pattern>/*</url-pattern>
						</filter-mapping>
						
		过滤器的什么周期:服务器的启动--服务器关闭
		
		总结：
			1.过滤器有我们什么和配置，服务器根据请求的信息进行调用
		执行：
			浏览器发起请求到服务器，服务器接收到请求后，服务器根据URI信息在配置中找到对应的Filter
			的dofilter方法。做对应的处理，如果还有符合要求的过滤器继续执行。知道执行对应的servlet
			进行请求处理。servlet对请求处理完毕后，还会继续执行Filter.doFilter()
			
		案例：
			统一编码格式进行设置
			session管理
			权限管理
			资源管理（统一水印，和谐词汇）
			
			

 * 
 */
public class MyFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter   init()");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilter   doFilter()-----1");
		//设置请求编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//session
		HttpSession hs = ((HttpServletRequest) request).getSession();
		if(hs.getAttribute("user")==null) {
			((HttpServletResponse)response).sendRedirect("/a/login.jsp");
		}else {
			//放行 request有用
			chain.doFilter(request, response);			
			System.out.println("MyFilter   doFilter()------2");
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter   destory()");
		
	}

}
