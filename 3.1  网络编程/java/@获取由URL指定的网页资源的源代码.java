
/**
 * ��ȡ��URLָ������ҳ��Դ��Դ���룬������д��ָ�����ļ���
 * 
 * @author (yhz) 
 * @version (2013-8-5)
 */
import java.net.*;
import java.io.*;

public class Source
{
    public static void main(String args[])
    {
        URL url;
        try
        {
            url = new URL("http://202.193.80.32/Git/Index.asp");
        }
        catch(MalformedURLException e)
        {
            System.out.println(e);
            return;
        }
        
        try
        {
            InputStream in = url.openStream();  //ͨ��url����һ��������
            FileOutputStream out = new FileOutputStream(new File("test.txt"));   //����һ�������
            int c;
            while((c = in.read()) != -1)  //��ȡһ���ֽڵ�����
            {
                out.write(c);  //д��һ���ֽڵ�����
            }
            in.close();
            out.close();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
}
