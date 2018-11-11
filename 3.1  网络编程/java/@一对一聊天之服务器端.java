
/**
 * ���пͻ��������һ��һ�����ʾ������֮�������ˡ�û���ṩGUI���档
 * �������˱���������
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class ChatServer
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //�˿ںţ��ͻ����������Ҫһ�£���ֵҪ����1025��65535֮�䣬��Ҫ�󱾻�û���ڸö˿����еĳ���
            
            final ServerSocket serverSocket = new ServerSocket(port);  //�����������׽���
            System.out.println("�ȴ�����...");
            
            final Socket toClient = serverSocket.accept();  //�������Կͻ��˵���������; �����ڴ�֮��������ֱ���пͻ���������           
            System.out.println("�����������ԣ�" + toClient.getInetAddress());  //��ʾ���ӵĿͻ���Ϣ
            
            //������������������ڷ������������
            final DataInputStream in = new DataInputStream(toClient.getInputStream()); //����������������Ϊfinal���������ڲ�����ʹ��
            final DataOutputStream out = new DataOutputStream(toClient.getOutputStream()); //����������
            Scanner scan = new Scanner(System.in);
                       
            String str = "��ӭ" + toClient.getInetAddress().getHostAddress() + "���뷢�ԡ�";  //׼����ӭ��Ϣ
            out.writeUTF(str);   //�Ի����޹صķ�ʽ����������д����Ϣ����������Ϣ����ֻ�ܱ�֤��Ϣ�ŵ������У���һ�����ϻᷢ��
            out.flush();  //���������������л��棬������������þ��Ӵﵽ����������Ϣ��Ŀ�ġ�
           
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
                                
                                toClient.close();  //�ر�����Socket�������ڹر�serverSocket֮ǰ����
                                serverSocket.close();   //����serverSocket
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
                str = scan.next(); //�����û��Ӽ����������Ϣ
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
