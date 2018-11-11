
/**
 * һ���򵥵��ļ�������
 * 
 * @author (YHZ) 
 * @version (2013-8-5)
 */

import java.io.*;
import java.net.*;

public class FileDownLoader
{
    private String urlSpec;  //��Ҫ���ص���Դ��URL����
    private String fileName;  //���ڴ�����ص���Դ���ļ���

    /**
     * Constructor for objects of class FileDownLoader
     */
    public FileDownLoader(String urlSpec, String fileName)
    {
        this.urlSpec = urlSpec;
        this.fileName = fileName;
    }

    /**
     * �����ļ�
     */
    public void download() throws MalformedURLException, IOException
    {
        URL url = new URL(urlSpec);
        URLConnection conn = url.openConnection();  //����˫������
        
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));  //����������     
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));  //���������
        
        int ch;
        while ((ch = br.read()) != -1)  //�����ļ�
        {
            bw.write(ch);
        }
        
        br.close();
        bw.close();

    }
}
