
/**
 * ���ͻ�����������SCSS�����շ�����ʾ������֮�ͻ��ˡ�
 * �ͻ�����������������ˣ����յ���ӭ��Ϣ�󣬷���radiusֵ���ٽ��շ��������ص����ֵ����ʾ���ж�ͨ�ţ��رճ���
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //�˿ںţ��ɷ���˾���
            
            Socket client = new Socket("localhost",port);  //�����׽��֣��˿ںű������������һ�£������ɹ��󣬻��Զ���������˽�������
            
            //������������������ڷ������������
            DataInputStream in = new DataInputStream(client.getInputStream()); //����������
            DataOutputStream out = new DataOutputStream(client.getOutputStream()); //����������
            
            String str = in.readUTF(); //�ȴ�������Ϣ���ڽ��յ���Ϣǰ��ʵ���ϴ�������״̬
            System.out.println(str);  //��ʾ����Ϣ
            
            Scanner scan = new Scanner(System.in);
            System.out.print("������뾶��ʵ������ ");
            double radius = scan.nextDouble();  //��ȡ����ֵ
            out.writeUTF("" + radius);   //�Ի����޹صķ�ʽ����������д����Ϣ����������Ϣ����ֻ�ܱ�֤��Ϣ�ŵ������У���һ�����ϻᷢ��
            out.flush();  //���������������л��棬������������þ��Ӵﵽ����������Ϣ��Ŀ�ġ�
            
            str = in.readUTF(); //�ȴ�������Ϣ���ڽ��յ���Ϣǰ��ʵ���ϴ�������״̬
            System.out.println("�뾶Ϊ" + radius + "��Բ�����Ϊ��" + str);
            
            in.close();  //�ر������������Ӧ�ڹر�socket֮ǰ
            out.close();
            
            client.close();  //�ر�����
            System.out.println("������ֹ");
        }
        catch(Exception e)   //������ͨ�Ź����п��ܻ�����ܶ��쳣������򵥻����쳣������������Ӧ��������ǲ����ʵġ�
        {
            e.printStackTrace();
        }
    }
}
