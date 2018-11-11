
/**
 * 一个线程类，为一个套接字提供通信工作
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */
import java.net.*;
import java.io.*;

public class ServerThread extends Thread  
{
    private Socket toClient;       //该参数需要由构造函数初始化，并在run方法中调用（关键该socket），因此必须定义为全局属性
    
    private DataInputStream in;  //定义输入输出流，在本例中，在构造函数中初始化，在run方法中调用，需要定义为属性
    private DataOutputStream out;  //若不定义为属性，则只能在run方法中定义、初始化并调用

    /**
     * 构造函数，参数为一个socket，初始化与该socket关联的输入输出流，当然也可以在run方法中处理
     */
    public ServerThread(Socket socket) throws IOException  //初始化输入输出流可能会产生IO异常
    {
        toClient = socket;
        in = new DataInputStream(toClient.getInputStream());  //初始化输入输出流，用于数据收发
        out = new DataOutputStream(toClient.getOutputStream());
    }

    /**
     * 重写run方法，在其中完成服务器针对一个客户端的收发工作，因为没有数据共享的问题，不需要考虑同步问题
     */
    public void run()
    {
        try
        {
            System.out.println("连接请求来自：" + toClient.getInetAddress());  //显示连接的客户信息
            
            String str = "欢迎" + toClient.getInetAddress().getHostAddress();  //准备欢迎信息
            out.writeUTF(str);   //以机器无关的方式向发送数据流写入消息，即发送消息，但只能保证消息放到缓存中，不一定马上会发送
            out.flush();  //涮新流，若流中有缓存，会立即输出；该句子达到立即发送消息的目的。
            
            str = in.readUTF(); //等待接收信息，在接收到信息前，实际上处于阻塞状态
            double radius = Double.parseDouble(str);  //将字符串转换成实数，要求该字符串实际上代表一个实数
            double area = Math.PI * radius * radius;  //计算圆的面积
            out.writeUTF("" + area);
            out.flush();
            
            in.close();  //关闭输入输出流，应在关闭socket之前
            out.close();
            toClient.close();  //关闭连接Socket，必须在关闭serverSocket之前调用
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
