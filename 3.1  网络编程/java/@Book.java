
/**
 * һ���򵥵�Book�࣬ʵ����Serializable�ӿ�
 * 
 * @author (yhz) 
 * @version (2013-6-24)
 */

import java.io.*; //Serializable�ڸð��ڶ���

public class Book implements Serializable 
{
    private int code;  //���
    private String name;  //����
    
    public Book(int code, String name)
    {
        this.code = code;
        this.name = name;
    }
    
    public String toString()
    {
        return "Code: " + code + "; name: " + name;
    }
}
