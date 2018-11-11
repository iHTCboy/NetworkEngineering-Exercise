
/**
 * һ����΢���ӵ��ʼ�������������ͬʱ�����˷����ʼ�����ÿ���ʼ������⼰���ݿ��Բ�һ����
 * ��һ��Access���ݿ��еı������ÿ�������䡢�ⷢ�͵��ʼ������⼰����
 * ��Ҫ�����֤����֧�ַ��͸�����
 * 
 * @author (YHZ) 
 * @version (2013-8-4)
 */

import javax.mail.*; //��Session��Authenticator��Message��Address����Ҫ�õ�
import javax.mail.internet.*;  //��MimeMessage��InternetAddress����Ҫ�õ�
import java.util.*;  //��Properties��Date����Ҫ�õ�

public class ComplexMailSender
{
    private Session session = null;  //�����շ��ʼ���Session
    private String sender;  //���ͷ����䣬�������֤ʱ���û���
    private String password; //����ķ�������
    private String host; //֧�ַ����ʼ����ܵķ�����������;����ͨ������ʹ�õ��ʼ��������ṩ�İ�����Ϣ���ҵ�
    
    /**
     * ���캯������������Ϊ���û��������뼰�ʼ����ͷ�����������
     * һ�㶼����Ҫ���������֤�ģ�������δ���ǲ���Ҫ�����֤�������
     */
    public ComplexMailSender(String username, String password, String smtpHostName)
    {
        sender = username;
        this.password = password;
        host = smtpHostName;
        
        init(username, password, smtpHostName);
    }

    //����һ�����ڷ����ʼ���Sesseion,Session�ඨ���˻������ʼ��Ự��
    private void init(String username, String password, String smtpHostName) 
    {
        //Session����������java.util.Properties���������ʼ����������û�����������Ϣ������Ӧ�ó���Ҫʹ�õ��Ĺ�����Ϣ��
        Properties props = System.getProperties();  //Ҳ����ֱ�Ӵ�����props = new Properties();
        // ��ʼ��props����������ֵ�����ַ�����ʾ
        props.put("mail.smtp.auth", "true");     //��Ҫ��֤
        props.put("mail.smtp.port", "25");  //�����ʼ����Ͷ˿ڣ�ȱʡΪ25
        props.put("mail.smtp.host", smtpHostName);  //�������ڷ����ʼ����ʼ�����������smtp.glite.edu.cn
       
        Authenticator authenticator = new MailAuthenticator(username, password);   //�����֤��������Ҫ��֤������Ϊnull  
        session = Session.getInstance(props, authenticator);   //����Session
    }  

    
     /**
     * ֧�ָ�����˷���ͬһ���ʼ�(�ʼ�������������ͬ)
     * @param isText: isTextΪtrue��ʾ���ı���ʽ���ͣ�isTextΪflase��ʾ��HTML��ʽ����
     * @param userInfo��һ����¼������¼���е�ÿһ�а�����Ϣ�û����䡢�ʼ����⡢�ʼ�����
     */
    public void sendMultiMail(boolean isText, List<UserMailInfo> userInfo) throws MessagingException 
    {
        Message mailMsg = new MimeMessage(session);   //     
        Address from = new InternetAddress(sender);  //�������ͷ���ַ
        mailMsg.setFrom(from);   //���÷��ͷ�,Ҳ������mailMsg.setReplyTo(from)��
        
        Transport transport = session.getTransport("smtp");  //����һ�������ʼ�����Ķ���
        transport.connect(host, sender, password);  //�������ӣ�����Ҫ�������Ͷ���ʼ������Σ�������ʽ�Ƚϸ�Ч.
        
        for (UserMailInfo user : userInfo)
        {
            String account = user.getAccount();
            Address to = new InternetAddress(account); //�������յ�ַ
            mailMsg.setRecipient(Message.RecipientType.TO, to);  //���ý��շ�
        
            String subject = user.getSubject();
            mailMsg.setSubject(subject);  //��������        
            mailMsg.setSentDate(new Date());  //���÷���ʱ�䣨ϵͳʱ�䣩
        
            String content = user.getContent();
            if (isText)  //���ı���ʽ����
            {
                mailMsg.setText(content.toString());  //�����ʼ�������
            }
            else  //��HTML��ʽ����
            {
                mailMsg.setContent(content.toString(), "text/html;charset=utf-8");  //�����ʼ�������
            }
            transport.sendMessage(mailMsg, mailMsg.getAllRecipients());  //�����з�����Ť���ʼ�
        }


        transport.close();  //�Ͽ�����

    }
    
    public static void main(String[] args) throws MessagingException
    {
        ComplexMailSender sender = new ComplexMailSender("canoe@glite.edu.cn", "canoe982", "smtp.glite.edu.cn");       
        
        //�����û����Ͳ�ͬ�ʼ�
        AccessDBOperation db = new AccessDBOperation();
        List<UserMailInfo> user = db.getUserInfo();
        db.close();
        sender.sendMultiMail(false, user);
    }
}
