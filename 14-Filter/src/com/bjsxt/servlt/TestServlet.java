package com.bjsxt.servlt;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ts.do")
public class TestServlet extends	HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//���ñ����ʽ
		//��ȡ������Ϣ
		//����������Ϣ
		System.out.println("Filter httpServlet service()");
		//��Ӧ������
		
	}
}
