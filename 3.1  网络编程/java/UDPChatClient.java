
/**
 * �򵥵Ļ���UDP��һ��һ�������֧��GUI�������ṩ�ͻ��˶˹��ܡ�
 * 
 * @author (YHZ) 
 * @version (2013-6-27)
 */

import java.io.*;   //�ļ�������
import java.net.*;  //���������
import java.awt.*;  //���󴰿ڹ��߰�
import java.awt.event.*;  //GUI�¼������
import javax.swing.*;  //Swing��

public class UDPChatClient extends JFrame implements ActionListener  //�̳�JFrame����ʵ��ActionListener
{
    //������GUI��ص�һЩ�ؼ�����
    private JTextField rcvPortField = new JTextField("   5050   ");   //���ն˿��ı���
    private JTextField sendPortField = new JTextField("   6060   ");   //���Ͷ˿��ı���
    private JTextField desIPField = new JTextField("         127.0.0.1        ");   //Ŀ��IP��ַ���ַ�����ʽ��ʾ
    private JButton beginBtn = new JButton("��ʼ");    //�������Button���Զ��ں�̨�������ݣ����ɷ�������
    private JTextArea msgArea = new JTextArea(15, 50);  //������ʾ��Ϣ���ı�����
    private JTextField sendField = new JTextField(50);   //������дҪ���͵���Ϣ���ı���
    private JButton sendBtn = new JButton("����");    //����󣬷��ͳ�sendField��ָ�����ı�
    
    //������һЩ������ԵĶ���
    private int rcvPort;  //���ն˿�
    private int sendPort;  //���Ͷ˿�
    private InetAddress IPAddress;   //IP��ַ
    private DatagramSocket sendSocket;  //���ڷ��͵�Socket������������ʼ����ť���ʼ��
    
    private static final int BUFSIZE = 1024;  //ÿ���ܹ����ͻ���յİ��Ĵ�С��UDP�����ְ������Է��Ͱ��Ĵ�С��ֵ����̫�󣨲��˳���1500�ֽڣ�
    
    public UDPChatClient()
    {
        makeFrame();
    }
    
    //����GUI����
    private void makeFrame()
    {
        setTitle("UDP Chat��������");
        
        //�������BorderLayout�����֣�ʹ�����е�North, Center��South
        JPanel northPanel = new JPanel(new FlowLayout());  //�Ϸ���Panel������ΪFlowLayout��ʽ�������˿ڡ�IP��beginBtn
        JScrollPane centerPane = new JScrollPane(msgArea);  //�м�Ϊһ��֧�ֹ������ı�����
        JPanel southPanel = new JPanel(new FlowLayout());   //�·���Panel������ΪFlowLayout��ʽ������sendField��sendBtn
        
        Container con = getContentPane();  //��ȡ����������
        con.setLayout(new BorderLayout());  
        con.add(northPanel, BorderLayout.NORTH);
        con.add(centerPane, BorderLayout.CENTER);
        con.add(southPanel, BorderLayout.SOUTH);
        
        //����northPanel
        northPanel.add(new JLabel("Դ�˿ںţ�"));
        northPanel.add(rcvPortField);
        northPanel.add(new JLabel("Ŀ�Ķ˿ںţ�"));
        northPanel.add(sendPortField);    
        northPanel.add(new JLabel("Ŀ��IP��"));
        northPanel.add(desIPField);
        northPanel.add(beginBtn);
        
        //����southPanel
        southPanel.add(sendField);
        southPanel.add(sendBtn);
        
        //������ؿؼ�������״̬
        msgArea.setEditable(false);  //�ı�����ֻ��������ʾ��������༭
        msgArea.setLineWrap(true); //�����Զ�����
        sendBtn.setEnabled(false);  //��beginBtn���֮ǰ����������sendBtn
        
        //��Ӽ����¼�
        beginBtn.addActionListener(this);
        sendBtn.addActionListener(this);
        sendField.addActionListener(this);  //�س��¼�
        
        pack();   //ʹ���ڽ����Ų�
        setLocationRelativeTo(null);  //ʹ���ھ���
        setVisible(true);  //ʹ���ڿɼ�
        
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == beginBtn)  //�����"��ʼ"��ť
        {            
            //��ȡָ���Ķ˿���IP��ַ��Ϣ
            rcvPort = Integer.parseInt(rcvPortField.getText().trim());
            sendPort = Integer.parseInt(sendPortField.getText().trim());
            try
            {
                IPAddress = InetAddress.getByName(desIPField.getText().trim());
            }
            catch (UnknownHostException exception)
            {
                msgArea.append("ָ����ַ������������");
                return;  //�����������������������շ�����
            }

            try
            {
                sendSocket = new DatagramSocket();  //��ʼ�����ô���ֻ��Ҫ�����ö���һ�Σ��ڵ�������͡����ٴ���Ҳ�ǿ��Եġ�
            }
            catch(SocketException exception)
            {
                msgArea.append("�޷�����Socket");
                return;  //�����������������������շ�����
            }
            
            //�������ղ���ʾ��Ϣ���߳�
            new UDPReceiveThread(msgArea, rcvPort);
            
            //���ÿ���״̬�仯���������޸Ķ˿ںż�IP��ַ�������ٴΡ���ʼ�������ԡ����͡�����
            rcvPortField.setEditable(false);
            sendPortField.setEditable(false);
            desIPField.setEditable(false);
            beginBtn.setEnabled(false);
            sendBtn.setEnabled(true);                
            
        }
        if (e.getSource() == sendBtn || e.getSource() == sendField)   //�����"����"��ť
        {
            //��������
            sendMsg();
        }
    }
    
    private void sendMsg()
    {
        byte[] outBuf = sendField.getText().trim().getBytes();  //��ȡҪ���͵�����
        DatagramPacket sendPkt = new DatagramPacket(outBuf, outBuf.length, IPAddress, sendPort);  //׼��Ҫ���͵İ���ÿ�ζ�Ҫָ��Ŀ��IP��ַ���˿ں�
        try
        {
            sendSocket.send(sendPkt);  //��������
        }
        catch(IOException e)
        {
            msgArea.append("��������ʧ��");
            return;
        }
        
        msgArea.append("��˵��" + sendField.getText().trim() + "\n");  //��ʾ�������͵���Ϣ
        sendField.setText(null);  //�����Ϳ��ÿ�
        
    }
}
