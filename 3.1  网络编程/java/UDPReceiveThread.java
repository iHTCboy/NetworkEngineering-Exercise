
/**
 * ֧��UDP���ں�̨�������ݵ��߳�
 * 
 * @author (yhz) 
 * @version (2013-6-27)
 */

import java.io.*;   //�ļ�������
import java.net.*;  //���������
import javax.swing.*;  //Swing��

public class UDPReceiveThread extends Thread
{
    private JTextArea msgArea;  //������ʾ���յ���Ϣ������
    private DatagramPacket receivePkt;  //���ڽ��յ�Packet
    private DatagramSocket receiveSocket;  //���ڽ��յ�Socket
    private static final int BUFSIZE = 1024;  //ÿ���ܹ����ͻ���յİ��Ĵ�С��UDP�����ְ������Է��Ͱ��Ĵ�С��ֵ����̫�󣨲��˳���1500�ֽڣ�

    public UDPReceiveThread(JTextArea msgArea, int receivePort) //receivePortΪ��Ҫ�����Ķ˿ڣ���Դ�˿�
    {
        this.msgArea = msgArea;
        byte[] inBuf = new byte[BUFSIZE];
        receivePkt = new DatagramPacket(inBuf, inBuf.length);
        
        try
        {
            receiveSocket = new DatagramSocket(receivePort);
            setPriority(Thread.MIN_PRIORITY);  //�����̵߳����ȼ�Ϊ������ȼ�
            start();  //�����߳�
        }
        catch(SocketException e)
        {
            msgArea.append("�޷����ӵ�ָ���˿�");
        }
    }
    
    public void run()
    {
        while (true)
        {
            try
            {
                receiveSocket.receive(receivePkt);  //���հ����ŵ�receivePkt��
                //ȡ�����ݡ�receivePkt.getData()�õ������ֽ����飬��Ҫת�����ַ���
                String msg = new String(receivePkt.getData(), 0, receivePkt.getLength());
                msgArea.append("�Է�˵��" + msg + "\n"); //��ʾ����
            }
            catch (IOException e)
            {
                msgArea.append("�������ݴ���\n");
            }
        }
    }
}
