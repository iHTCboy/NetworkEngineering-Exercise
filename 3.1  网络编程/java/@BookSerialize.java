
/**
 * һ���򵥵Ĳ��Գ������ڶ�Book��Ķ���������л�����
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.io.*;

public class BookSerialize
{
	public static void main(String args[]) throws IOException,ClassNotFoundException
	{
	    Book book = new Book(123, "Test"); //Bookʵ����Serializable �ӿڵ���
	    
	    ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("book.dat"));
	    oos.writeObject(book);  //д��book����
	    oos.close(); 
	    book=null;
	    ObjectInputStream ois=new ObjectInputStream(new FileInputStream("book.dat"));    
	    book=(Book)ois.readObject(); //��ȡ֮ǰ�洢��book����
	    ois.close(); 
 	    
	    System.out.print(book);
	    //˼��1��book.dat���ļ��ļ����Ƕ������ļ���
	    //˼��2�����Ҫ��ȡ���book������ô�죿
	}
}

