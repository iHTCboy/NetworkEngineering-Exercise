/**
 * �����ʼ�����ǰ����֤���ࡣ
 * JavaMail APIͨ��ʹ����Ȩ���ࣨAuthenticator�����û���������ķ�ʽ������Щ�ܵ���������Դ���������Դ������ָ�ʼ���������
 * Authenticator��һ�������࣬���Ǳ��������Լ�����֤�࣬����дgetPasswordAuthentication()������
 * �ڴ���SessionʱҪ�õ�����Ķ���
 * ��Ҫ����javax.mail���������ǣ���1�����ظð������õ���װĿ¼lib�£���2����BlueJ�м��ظð���
 * @author (YHZ) 
 * @version (2013-7-10)
 */

import javax.mail.*;  //��Ҫ�õ����е�Authenticator��PasswordAuthentication

public class MailAuthenticator extends Authenticator 
{  
    private String username;    //��֤ʱ���ṩ���û���
    private String password;    //��֤ʱ��Ҫ�ṩ������

    //�������캯����������Ҫ�û���������ʱʹ��
    public MailAuthenticator()
    {
        username = null;
        password = null;
    }
    
    public MailAuthenticator(String username, String password) 
    {  
        this.username = username;
        this.password = password; 
    }  
    
    //����getPasswordAuthentication����������һ����ָ���û���������ʵ�ֵ���֤��ϸ����Java����ʵ��
    protected PasswordAuthentication getPasswordAuthentication() 
    {  
        return new PasswordAuthentication(username, password);  
    }  

} 

