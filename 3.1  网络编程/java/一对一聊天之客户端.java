
/**
 * ���пͻ��������һ��һ�����ʾ������֮�ͻ��ˡ�û���ṩGUI���档
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatClient
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //�˿ںţ��ɷ���˾���
            
            final Socket client = new Socket("localhost",port);  //�����׽��֣��˿ںű������������һ�£������ɹ��󣬻��Զ���������˽�������
            System.out.println("��������...");   //��ΪScanner������֮ǰ�����������Ϣ
            
            //������������������ڷ������������
            final DataInputStream in = new DataInputStream(client.getInputStream()); //����������
            final DataOutputStream out = new DataOutputStream(client.getOutputStream()); //����������
            Scanner scan = new Scanner(System.in);
            
            //���ڲ���ķ�ʽ����һ���̣߳����ڽ��ղ���ʾ��Ϣ
            Thread t = new Thread(new Runnable()  //ʹ�����ڲ���ķ�ʽ��Ҳ���Ǳ���ģ����Խ��౾����Ϊһ���̣߳����߶���һ���µ��߳��ࡣ
            {
                public void run()
                {
                    try
                    {
                        while (true)
                        {
                            String str1 = in.readUTF();  //���ղ���ʾ����
                            System.out.println("�Է�˵�� " + str1);                           
                            Thread.sleep(500);   //��Ϣ0.5S����������Ϣ����ʱ�䣻ʵ����Ӱ�첻����Ϊ�������������ϵĽ������ݵģ��м䱾��ͻ��м��
                            
                            if (str1.toLowerCase().contains("bye"))  //���Ͱ���bye����Ϣ���ж�����
                            {
                                in.close();  //�ر������������Ӧ�ڹر�socket֮ǰ
                                out.close();
                                
                                client.close();  //�ر�����Socket
                                System.out.println("���������������ֹ");
                                System.exit(0);                             
                            }
                        }
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
            
            //������Ϣ����
            while (true)
            {
                String str = scan.next(); //�����û��Ӽ����������Ϣ
                out.writeUTF(str);  //������Ϣ
                out.flush();
            }                
        }
        catch(Exception e)   //������ͨ�Ź����п��ܻ�����ܶ��쳣������򵥻����쳣������������Ӧ��������ǲ����ʵġ�
        {
            e.printStackTrace();
        }
    }
}
