
/**
 * ���ڴ�����ŷ���Ϣ���࣬���������ˣ��ż������⼰����
 * 
 * @author (YHZ) 
 * @version (2013-8-4)
 */
public class UserMailInfo
{
    private String account; //����������
    private String subject; //�ʼ�����
    private String content; //�ʼ�����
    
    public UserMailInfo(String account, String subject, String content)
    {
        this.account = account;
        this.subject = subject;
        this.content = content;
    }

    public String getSubject()
    {
        return subject;
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public String getContent()
    {
        return content;
    }
}
