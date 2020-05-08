package com.bjsxt.filter;

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
 * ������ʹ��
 * ���ã�
 * 		�Է��������ܵ��������Ӧ��Դ���й���
 * 		����servlet
 * ʹ�ã�
 * 		����implements Fileter��class
 * 		override
 * 				init������������ʱִ��,��Դ��ʼ��
 * 				service:��������ķ�������Ҫ�ڴ˷����д���
 * 						��Ҫ�ֶ�����	chain.doFilter(request, response);
 * 				destory:�������رյ�ʱ��
 * 		����web.xml�ļ��еĹ�������
					 	<filter>
							<filter-name>myFilter</filter-name>
							<filter-class>com.bjsxt.filter.MyFilter</filter-class>
						</filter>
						<filter-mapping>
							<filter-name>myFilter</filter-name>
							<url-pattern>/*</url-pattern>
						</filter-mapping>
						
		��������ʲô����:������������--�������ر�
		
		�ܽ᣺
			1.������������ʲô�����ã������������������Ϣ���е���
		ִ�У�
			������������󵽷����������������յ�����󣬷���������URI��Ϣ���������ҵ���Ӧ��Filter
			��dofilter����������Ӧ�Ĵ���������з���Ҫ��Ĺ���������ִ�С�֪��ִ�ж�Ӧ��servlet
			����������servlet����������Ϻ󣬻������ִ��Filter.doFilter()
			
		������
			ͳһ�����ʽ��������
			session����
			Ȩ�޹���
			��Դ����ͳһˮӡ����г�ʻ㣩
			
			

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
		//������������ʽ
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//session
		HttpSession hs = ((HttpServletRequest) request).getSession();
		if(hs.getAttribute("user")==null) {
			((HttpServletResponse)response).sendRedirect("/a/login.jsp");
		}else {
			//���� request����
			chain.doFilter(request, response);			
			System.out.println("MyFilter   doFilter()------2");
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter   destory()");
		
	}

}
