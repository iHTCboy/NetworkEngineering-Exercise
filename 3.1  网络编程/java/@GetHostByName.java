
/**
 * ͨ����������������ȡ������Ϣ
 * 
 * @author (yhz) 
 * @version (2013-6-20)
 */
import java.net.*;
import java.util.Scanner;  //һ���ȽϺ��õ�������

public class GetHostByName
{
    public static void main(String[] args)
    {
        try
        {
            Scanner scan = new Scanner(System.in);  //����һ�������������Ķ���System.in�����׼�����豸��������
            
            System.out.print("�����������Ѱ��������");
            String name = scan.next();  //�Ӽ��̽���һ���ַ��������н���������name
            
            /*
             * ������������ȡ�������ڵĵ�ַ��Ϣ��Ҳ���Ի��Զ�������ĵ�ַ��Ϣ������Ҫ���缰DNS֧�֡�
             * Ҳ������IP��ַ���ַ�����ʽ��Ϊ��������"192.168.10.199"������ʱ�����Զ����Ҹ�IP��Ӧ����������
             * һ�����������������ܶ�Ӧ���IP��ַ����ʱ�����ص�һ��IP��ַ��
             * ���뷵��������Ӧ������IP��ַ������ʹ��getAllByName
             * ������Ϊnull��localhostʱ������ֵΪ127.0.0.
             */
            InetAddress localAddress = InetAddress.getByName(name);
            System.out.println("������/IP��ַ��" + localAddress); 
            
        }
        catch (UnknownHostException e)  //������������������ʱ����������쳣
        {
            e.printStackTrace(); 
        }
    }
}
