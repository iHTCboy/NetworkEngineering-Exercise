package edu.hdu.spring.aop;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.registry.infomodel.User;

import org.springframework.validation.BindException;
public class UserController extends AbstractCommandController {
    protected ModelAndView handle(HttpServletRequest request,
            HttpServletResponse response, Object command, BindException be)
            throws Exception {
        User user = (User)command;//�Զ���װ��User����
        System.out.println(user);
        //����springMVC-servlet.xml���ã���ͼ��ת��ת���success.jsp
        return new ModelAndView("success");
    }
}
