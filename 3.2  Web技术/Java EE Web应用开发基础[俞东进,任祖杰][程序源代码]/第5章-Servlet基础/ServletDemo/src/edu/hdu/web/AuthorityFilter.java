package edu.hdu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class AuthorityFilter
 */
@WebFilter("/AuthorityFilter")
public class AuthorityFilter implements Filter {

	private FilterConfig config;
    public AuthorityFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		this.config=null;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       //��ȡ��Filter�����ò���
       String encoding = config.getInitParameter("encoding");
       //����request�����õ��ַ���
       request.setCharacterEncoding(encoding);
       HttpServletRequest requ = (HttpServletRequest)request;
       HttpSession session = requ.getSession(true);
       //��ȡ�ͻ������ҳ��
	   String requestPath = requ.getServletPath();
     //���session��Χ��userΪnull��������û�е�¼
     //���û�����Ĳ��ǵ�¼ҳ��
    //���û�����ļȲ��ǵ�¼ҳ�棬Ҳ���Ǵ����¼��Servletҳ��
       if( session.getAttribute("user") == null&& !requestPath.endsWith("/login.html")&& !requestPath.endsWith("/LoginServlet"))
       {
          ((HttpServletResponse) response).sendRedirect("/ServletDemo/login.html");
           return;
       }
       else
       {
    	   chain.doFilter(request, response);
       }

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		this.config=config;
	}

}
