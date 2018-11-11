
/**
 * һ���򵥵��ʼ�����������Ҫ�����֤����֧�ַ��͸�����
 * 
 * @author (YHZ) 
 * @version (2013-7-11)
 */

import javax.mail.*; //��Session��Authenticator��Message��Address����Ҫ�õ�
import javax.mail.internet.*;  //��MimeMessage��InternetAddress����Ҫ�õ�
import java.util.*;  //��Properties��Date����Ҫ�õ�

public class SimpleMailSender
{
    private Session session = null;  //�����շ��ʼ���Session
    private String sender;  //���ͷ����䣬�������֤ʱ���û���
    private String password; //����ķ�������
    private String host; //֧�ַ����ʼ����ܵķ�����������;����ͨ������ʹ�õ��ʼ��������ṩ�İ�����Ϣ���ҵ�
    
    /**
     * ���캯������������Ϊ���û��������뼰�ʼ����ͷ�����������
     * һ�㶼����Ҫ���������֤�ģ�������δ���ǲ���Ҫ�����֤�������
     */
    public SimpleMailSender(String username, String password, String smtpHostName)
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
     * ֧�ָ�һ���˷���һ���ʼ�
     * @param isText: isTextΪtrue��ʾ���ı���ʽ���ͣ�isTextΪflase��ʾ��HTML��ʽ����
     * @param recipient: ���շ������ַ
     * @param subject: �ʼ�����
     * @param content: Ҫ���͵�����
     */
    public void sendSingleMail(boolean isText, String recipient, String subject, Object content) throws MessagingException 
    {
        //Message�����ڷ�װ�ʼ���Ϣ�����������ߡ������ߡ����⡢����ʱ�䡢���ݵȡ�
        //Message��һ�������࣬����ʹ��javax.mail.internet.MimeMessage�������
        //����MimeMessage����ʱ����Ҫ��Session������ΪMimeMessage���췽���Ĳ�������
        Message mailMsg = new MimeMessage(session);
        
        //Address���ڷ�װ���ͷ�����շ��ĵ�ַ��Ϣ���ṩ���������ɣ������Ը��ӱ���
        //Address��һ�������࣬����ʹ��javax.mail.internet.InternetAddress�������
        Address from = new InternetAddress(sender);  //�������ͷ���ַ
        mailMsg.setFrom(from);   //���÷��ͷ�,Ҳ������mailMsg.setReplyTo(from)��
        
        Address to = new InternetAddress(recipient);  //�������յ�ַ
        mailMsg.setRecipient(Message.RecipientType.TO, to);  //���ý��շ���RecipientType.TO��ʾ���շ���RecipientType.CC��ʾ���ͷ�
        
        mailMsg.setSubject(subject);  //��������        
        mailMsg.setSentDate(new Date());  //���÷���ʱ�䣨ϵͳʱ�䣩
        
        if (isText)  //���ı���ʽ����
        {
            mailMsg.setText(content.toString());  //�����ʼ�������
        }
        else  //��HTML��ʽ����
        {
            mailMsg.setContent(content.toString(), "text/html;charset=utf-8");  //�����ʼ�������
        }
        
        Transport.send(mailMsg);  //�����ʼ���ϵͳΪ�Զ��ڷ���ǰ�������ӣ����ڷ��ͽ������ͷ�����
    }

     /**
     * ֧�ָ�����˷���ͬһ���ʼ�(�ʼ�������������ͬ)
     * @param isText: isTextΪtrue��ʾ���ı���ʽ���ͣ�isTextΪflase��ʾ��HTML��ʽ����
     * @param recipients: ���շ������ַ���б�
     * @param subject: �ʼ�����
     * @param content: Ҫ���͵�����
     */
    public void sendMultiMail(boolean isText, List<String> recipients, String subject, Object content) throws MessagingException 
    {
        Message mailMsg = new MimeMessage(session);   //     
        Address from = new InternetAddress(sender);  //�������ͷ���ַ
        mailMsg.setFrom(from);   //���÷��ͷ�,Ҳ������mailMsg.setReplyTo(from)��
        
        int num = recipients.size();
        Address[] to = new Address[num]; //�������յ�ַ
        for (int i = 0; i < num; i ++)
        {
            to[i] = new InternetAddress(recipients.get(i));
        }
        mailMsg.setRecipients(Message.RecipientType.TO, to);  //���ý��շ������շ���һ���б��������������
        
        mailMsg.setSubject(subject);  //��������        
        mailMsg.setSentDate(new Date());  //���÷���ʱ�䣨ϵͳʱ�䣩
        
        if (isText)  //���ı���ʽ����
        {
            mailMsg.setText(content.toString());  //�����ʼ�������
        }
        else  //��HTML��ʽ����
        {
            mailMsg.setContent(content.toString(), "text/html;charset=utf-8");  //�����ʼ�������
        }
        
        //message.saveChanges(); // implicit with send()

        Transport transport = session.getTransport("smtp");  //����һ�������ʼ�����Ķ���
        transport.connect(host, sender, password);  //�������ӣ�����Ҫ�������Ͷ���ʼ������Σ�������ʽ�Ƚϸ�Ч.
        transport.sendMessage(mailMsg, mailMsg.getAllRecipients());  //�����з�����Ť���ʼ�
        transport.close();  //�Ͽ�����

    }
    
    public static void main(String[] args) throws MessagingException
    {
        SimpleMailSender sender = new SimpleMailSender("canoe@glite.edu.cn", "canoe982", "smtp.glite.edu.cn");
        
        //sender.sendSingleMail(true, "2002018@glut.edu.cn", "test", "fdsafdasfasf"); 
        
        //�����û�����ͬһ���ʼ�
        List<String> to = new ArrayList<String>();
        to.add("canoe@glite.edu.cn");
        to.add("18123408@qq.com");
        to.add("2002018@glut.edu.cn");
        sender.sendMultiMail(false, to, "test", "safdasfsafasf\ndsafddsafdsaf");
    }
}
