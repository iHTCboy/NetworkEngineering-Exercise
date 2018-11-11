
/**
 * ָ��ָ������������Ļ�Ծ����
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;
import java.util.Scanner;  
import java.io.*;  //���ļ������йص��࣬�����漰����IOException

public class TestAliveHosts
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("����Ҫ�������������ַ����Ϣ(��Ҫ����192.168.10.*��������192.168.10.1)��"); 
        String ipStr = scan.next();
        byte[] ip = stringToBytes(ipStr);
        ip[3] = 1;
        
        try
        {
            System.out.println("�����������������ɴ�");
            for (int i = 1; i < 255; i ++)
            {                
                InetAddress localAddress = InetAddress.getByAddress(ip);
                System.out.println("���ڼ���ַ��" + ip[3]);
                boolean flag = localAddress.isReachable(3000);   //�жϸõ�ַ�Ƿ�ɴ��ʱʱ����Ϊ5S����ʱ�䲻��̫��
                if (flag)
                {
                    System.out.println(localAddress.getHostName() + "/" + localAddress.getHostAddress()); 
                }
                
                //������һ��IP��ַ��Ӧ���ַ���
                //ip[3] = (byte) (ip[3] + 1);
                ip[3] ++;
            }
            
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
    
    /*
     * ���ַ�����ʽ��IP��ַת����byte���顣�����Ϊ"192.168.10.199"ʱ���γɵ�byte����Ϊ��-64; -88; 10; -57��
     */
    private static byte[] stringToBytes(String ipStr)
    {
        byte[] ip = new byte[4];   //����һ��byte���飬������Ž��
        
        ipStr = ipStr.replace('.', ':');  //��ipStr�е�����"."�ָ���ת����":"��������Ϊ"."������Ϊ��ͨ��������ʽ
        String[] data = ipStr.split(":");  //��ip��ַ�ֳ�4���ַ���
        for (int i = 0; i < data.length; i ++)
        {
            int value = stringToInt(data[i]);
            if (value <= 127)
                ip[i] = (byte) value;
            else
                ip[i] = (byte) (value - 256);
        }
        
        return ip;
    }
    
    /*
     * ��һ���ַ�����ʽ������ת���������������Ϊ��192��������192��
     */
    private static int stringToInt(String str)
    {
        int value = 0;
        for (int i = 0; i < str.length(); i ++)
        {
            value = value * 10 + str.charAt(i) - '0';
        }
        return value;
    }
}
