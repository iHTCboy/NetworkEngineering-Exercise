
/**
 * һ���򵥵Ķ�Access���ݿ���в������ࡣ
 * ���ݿ�����UserMailInfo��������MailInfo�����а��������ֶΣ�
 * �û�����(Account)���ı����ݣ����50���ַ���������
 * �ʼ�����(Subject)���ı����ݣ����50���ַ���
 * �ʼ�����(Content)���ı����ݣ����255���ַ���
 * 
 * @author (YHZ) 
 * @version (2013-8-4)
 */

import java.sql.*;  //JDBCʹ��
import java.util.*;

public class AccessDBOperation
{ 
    private Connection conn;  //���������ݿ����ӵ�Connection����
    private Statement stmt;  //����ִ��SQL����Statement����
   
    public AccessDBOperation()
    {
        init();

    }

    //��ʼ������Access���ݿ����ع����������������������ӣ�����Statement����
    public void init()
    {
        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  //����JDBC��ODBC����
            String url = "jdbc:odbc:Driver={MicroSoft Access Driver (*.mdb)};DBQ=.//database//UserMailInfo.mdb";  //����Access���ݿ��URL�����ݿ��ļ�����ڵ�ǰ�ļ����µ�database��
            Connection conn =  DriverManager.getConnection(url);  //����Ҫ�û���������
            stmt = conn.createStatement();  //����Statement��������ִ��SQL���.            
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("�޷�����JDBC��ODBC��������");
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    //ͨ������Access���ݿ�UserMailInfo,��ȡ���б�MailInfo�еļ�¼
    public List<UserMailInfo> getUserInfo()
    {
        if (stmt == null)
            return null;
            
        List<UserMailInfo> userInfo = new ArrayList<UserMailInfo>();
        String sql = "Select * from MailInfo";
        try
        {
            ResultSet rst = stmt.executeQuery(sql);  //ִ�в�ѯ��Ĳ��������ؽ�������rst��
            
            while(rst.next())  //����rst�еļ�¼
            {
                String account = rst.getString("Account");  //ȡ��ÿ�м�¼�е���Ϣ
                String subject = rst.getString("Subject");
                String content = rst.getString("Content");
                
                UserMailInfo user = new UserMailInfo(account, subject, content);
                userInfo.add(user);
            }
            
            rst.close();  //�رռ�¼��
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        
        return userInfo;        
    }
    
    //�ر����ݿ⡣����֮ǰ����ȷ����֮�������ResultSet�����Ѿ����ر�
    public void close()
    {
        try
        {
            if (stmt != null)  //�ȹر�Statement�����ٹر�Connection����
                stmt.close();
            if (conn != null)
                conn.close();                
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }        
    }
    
}
