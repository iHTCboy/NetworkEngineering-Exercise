/**
 * ��ȡ����IP��ַ��Ϣ
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;   //�����������Ҫ�õ��ð��������õ���InetAddress��UnknownHostException��

public class GetLocalHost
{
    public static void main(String[] args)
    {
        try
        {
            /*
             * getLocalHost����InetAddress�ľ�̬����������ֱ�����������øú���
             * getLocalHost���ڷ��ر���������ַ��Ϣ������Ϊ��ȫ���Բ��ɷ��ʣ�����127.0.0.1��
             * 
             */
            InetAddress localAddress = InetAddress.getLocalHost();
            /*
             * ʵ���ϵ��õ���localAddress.toString()�����ص��ַ�������������ʽ��������/����ֵ IP ��ַ��
             * �����������������档
             */
            System.out.println("������/IP��ַ��" + localAddress); 
            //System.out.println("��������" + localAddress.getHostName());
            //System.out.println("IP��ַ��" + localAddress.getHostAddress());
            
        }
        catch (UnknownHostException e)  //���������ܻ��������ָ������쳣��������Դ����Ҫ�����쳣����
        {
            e.printStackTrace();  //�����쳣ʱ��ֻ�Ǽ򵥵�����쳣��Ϣ
        }
    }
}
