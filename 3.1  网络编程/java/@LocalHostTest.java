import java.net.*;  
public class LocalHostTest
{
    public static void main(String[] args)
    {
        try
        {
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("������/IP��ַ��" + localAddress);            
        }
        catch (UnknownHostException e)  
        {
            e.printStackTrace();  
        }
    }
}
