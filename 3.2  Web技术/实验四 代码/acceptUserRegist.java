package edu.hdu.web;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Servlet/acceptUserRegist")
public class acceptUserRegist extends HttpServlet 
{
	public String codeToString(String str)
	{
		//���������ַ����ĺ���
		String s=str;
		try
		{
		byte tempB[]=s.getBytes("ISO-8859-1");
		s=new String(tempB);
		return s;
		}
		catch(Exception e)
		{
		return s;
		}		
	}
	
	public void init(ServletConfig config) throws ServletException
	{
	   super.init(config);
	}
	public  void  doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
	{  //����mime
	response.setContentType("text/html;charset=GB2312");
	PrintWriter out=response.getWriter();
	out.println("<HTML><head><title>�������û�ע��</title></head><BODY>");
	out.println("�������û�ע�����ύ�����ݣ�<br>");
	out.println("�û����ǣ�"+codeToString(request.getParameter("username"))+"<br>");
	out.println("�����ǣ�"+codeToString(request.getParameter("userpassword"))+"<br>");
	out.println("�Ա��ǣ�"+codeToString(request.getParameter("sex"))+"<br>");
	out.println("���������ǣ�"+request.getParameter("year")+request.getParameter("month")

	+request.getParameter("day")+"<br>");
	out.println("���������ǣ�"+request.getParameter("email")+"<br>");
	out.println("��ͥסַ�ǣ�"+codeToString(request.getParameter("address"))+"<br>");
	out.println("</body> </html>");
	} 
}
	



