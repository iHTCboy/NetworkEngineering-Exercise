package edu.hdu.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Servlet/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
            ServletConfig config=this.getServletConfig();
            request.setCharacterEncoding("GBK"); //����������������
            
			String username = request.getParameter("username");
			String password = request.getParameter("pass");
			response.setContentType("text/html;charset=GBK");  //���������������
			String encoding=config.getInitParameter("encoding");
			response.setContentType("text/html;charSet="+encoding);
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>��¼���</title></head>");
			out.println("<body> ��������û�����: " + username + "<br>");
			out.println("----------------------------------------<br>");
			out.println("�������������: " + password + "</body></html>");
                        //�������Ե�¼ʱ�Ĺ�����
			HttpSession session=request.getSession();
			session.setAttribute("user", username);
			out.close();
	}

}
