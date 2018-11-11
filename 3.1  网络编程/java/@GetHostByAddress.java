
/**
 * ����IP��ַ��õ�ַ��Ϣ�����жϸõ�ַ�Ƿ�ɴ�
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;
import java.io.*;  //���ļ������йص��࣬�����漰����IOException

public class GetHostByAddress
{
    public static void main(String[] args)
    {
        try
        {
            /*
             * getByAddressֻ֧����byte�����ʾ��IP��ַ������֧���ַ�����ʽ��IP��ַ��
             * ����ͨ���ַ�����ʽ��IP��ַ��ȡ�������������ȵ���getByName���ٵ���getHostName�õ�������
             * byte��ȡֵ��ΧΪ-128-127�����Ե�IP��ַ�е�ĳλ����127ʱ��Ҫǿ��ת��Ϊbyte����
             */
            byte[] ip = new byte[] {(byte)192, (byte) 168, 10, (byte) 199};
            
            /*
             * getByAddress�������ָ��IP��ַ�������Ƿ���ڣ����ԣ����û�δָ��������ʱ��������Ϊ��
             */
            InetAddress localAddress = InetAddress.getByAddress(ip);
            System.out.println("������/IP��ַ��" + localAddress); 
            
            boolean flag = localAddress.isReachable(5000);   //�жϸõ�ַ�Ƿ�ɴ��ʱʱ����Ϊ5S����ʱ�䲻��̫��
            
            if (flag)
                System.out.println("�ɴ� " +  localAddress); 
            else 
                System.out.println("���ɴ� " +  localAddress); 
        }
        catch (UnknownHostException e)  //IP��ַ���Ϸ�ʱ�����쳣
        {
            e.printStackTrace(); 
        }
        catch (IOException e)  //����isReachable�����׳����쳣
        {
            e.printStackTrace(); 
        }
    }
}
