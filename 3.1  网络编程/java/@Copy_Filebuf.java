/**
 * �ļ��ļ��ĸ���
 */
import java.io.*;

public class Copy_Filebuf
{ 
    public static void main(String args[]) throws IOException
    { 
        String data=new String();
        FileReader fr=new FileReader("test.txt"); //test.txtҪ���Ѿ����ڣ���λ�ڵ�ǰ���������ļ�����
        FileWriter fw=new FileWriter("hellobuf.txt"); //hellobuf.txt�������ڣ��򴴽�֮�������ڣ������֮
        BufferedReader br=new BufferedReader(fr); //�������һ����λ BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter bw=new BufferedWriter(fw);
        
        while((data=br.readLine())!=null)//���ļ�mouse.txt�ж�ȡһ��
        {
            System.out.println(data);//�������ʾ��
            bw.write(data);//����ȡ������д���ļ�hellobuf.txt
            bw.newLine();//д��һ�����з�
        }
        bw.flush();//��������������ȫ��������ļ�hellobuf.txt
        
        System.out.println("�ļ�������ɣ���鿴����ļ����ݣ�");
        br.close();
        bw.close();   
    }
}
