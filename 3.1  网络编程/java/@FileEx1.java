import java.io.*;  //�ļ�����Ҫ�õ�

public class FileEx1
{
    public static void main(String args[]) throws IOException  //�쳣���������һ�ַ������׳��쳣��������ֱ�Ӵ���
    {
        File dir=new File("d:\\book");  //��һ����б������ת��;�����ֻ�Ǵ���File���󣬶�������Ŀ¼���ļ���
        File f=new File(dir,"a.txt");

    //  File path=new File("d:\\book\a.txt");
        File f2=new File("d:\\book\\b.txt");
        System.out.println("");
        System.out.println("----------"+f+"���й���Ϣ----------");
        System.out.println("exist:        "+f.exists());
        System.out.println("name:         "+f.getName());
        System.out.println("path:         "+f.getPath());
        System.out.println("absolute path:"+f.getAbsolutePath());
        System.out.println("is a file:    "+f.isFile());
        System.out.println("is a directory:"+f.isDirectory());
        System.out.println("length:        "+f.length());
        System.out.println("can read:      "+f.canRead());
        System.out.println("can write:     "+f.canWrite());
        File newf=new File("c.txt");
        System.out.println("-----------rename"+f+"-----------------");
        f.renameTo(newf);
        System.out.println("name:                 "+newf.getName());
        System.out.println(f+" exist:  "+f.exists());
        System.out.println(newf+" exist:    "+newf.exists());
        System.out.println("compare f to f2:   "+f.equals(f2));
        newf.delete();
        System.out.println(newf+"   exist:     "+newf.exists());

    }
}
