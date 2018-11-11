
/**
 * 多客户单服务器（MCSS）且收发有序示例程序之服务器端。
 * 服务器端在指定端口打开，当用户请求连接后，发送欢迎信息，然后接收客户发来的radius值，再将计算的面积值发给服务器，之后中断通信，关闭程序。
 * 服务器端必须先运行
 * 服务器调用了线程类ServerThread，为每一个客户连接提供通信支持
 * 
 * @author (yhz) 
 * @version (2013-6-25)
 */

import java.net.*;
import java.io.*;

public class MultiServer
{
    public static void main(String[] args)
    {
        try
        {
            int port = 5500;  //端口号，客户与服务器端要一致，其值要求在1025－65535之间，且要求本机没有在该端口运行的程序
            
            ServerSocket serverSocket = new ServerSocket(port);  //创建服务器套接字
            System.out.println("等待连接...");
            
            while (true)  //理论上服务器端不会终止，可通过强行关闭程序的方式终止程序
            {
                Socket toClient = serverSocket.accept();  //侦听来自客户端的连接请求; 程序将在此之后阻塞，直到有客户连接上来           
                
                Thread t = new ServerThread(toClient);  //为该连接创建一个线程；若有多个连接，则有多个线程运行
                t.start();   //启动线程
            }
            
            //serverSocket.close();   //关连serverSocket
            //System.out.println("程序终止");
        }
        catch(Exception e)   //在网络通信过程中可能会产生很多异常，这里简单化了异常处理，在真正的应用软件中是不合适的。
        {
            e.printStackTrace();
        }
    }
}
