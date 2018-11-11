/**
 * 文件文件的复制
 */
import java.io.*;

public class Copy_Filebuf
{ 
    public static void main(String args[]) throws IOException
    { 
        String data=new String();
        FileReader fr=new FileReader("test.txt"); //test.txt要求已经存在，且位于当前工程所在文件夹下
        FileWriter fw=new FileWriter("hellobuf.txt"); //hellobuf.txt若不存在，则创建之；若存在，则清空之
        BufferedReader br=new BufferedReader(fr); //可用语句一步到位 BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedWriter bw=new BufferedWriter(fw);
        
        while((data=br.readLine())!=null)//从文件mouse.txt中读取一行
        {
            System.out.println(data);//输出到显示器
            bw.write(data);//将读取的数据写入文件hellobuf.txt
            bw.newLine();//写入一个换行符
        }
        bw.flush();//将缓冲区中数据全部输出到文件hellobuf.txt
        
        System.out.println("文件复制完成！请查看相关文件内容！");
        br.close();
        bw.close();   
    }
}
