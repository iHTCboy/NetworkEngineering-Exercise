/*
*����URL���JEditorPane��ʵ�ֵ�һ���ǳ��򵥵��������֧�ֳ�����
*
* @author (yhz) 
* @version (2013-8-5)
*/
import java.awt.*; 
import javax.swing.*;
import java.awt.event.*; 
import javax.swing.event.*;  //��HyperlinkListener�õ�
import java.io.*; 
import java.net.*; 
import java.util.*; 

//ʵ��HyperlinkListener�ӿڣ�������Ӧ�û�����������¼�
public class SimpleWebBrowser extends JFrame implements HyperlinkListener, ActionListener
{ 
    private JTextField urlField = new JTextField(50); //��ַ��
    private JEditorPane contentEditor = new JEditorPane();//��ҳ��
  
    /**
    **���캯��
    **��ʼ��ͼ���û�����
    */
    public SimpleWebBrowser()
    {
        
        setTitle("�򵥵���ҳ�����");  //���ñ���
        Container con = getContentPane();  //��ȡ��������
        con.setLayout(new BorderLayout());  //���ô��ڵĲ���ΪBorderLayout��ȡ�Ϸ����м䡣     
       
        JPanel topPanel = new JPanel(new FlowLayout());  //�����Ϸ������ڷ���ʾ��Ϣ����ַ��������FlowLayout����
        topPanel.add(new JLabel("����URL��ַ"));
        topPanel.add(urlField);
        
        JScrollPane scrollPane = new JScrollPane (contentEditor); //ΪJEditorPanel���Ϲ�����
        contentEditor.setEditable(false);  //contentEditor���ɱ༭
        
        urlField.setText("http://202.193.80.32/Git/Index.asp");  //Ϊ�������
        
        con.add(topPanel, BorderLayout.NORTH);
        con.add (scrollPane, BorderLayout.CENTER);
                
        contentEditor.addHyperlinkListener(this); //ΪcontentEditor����¼�����
        urlField.addActionListener(this);  //��Ӧ��������urlFieldʱ���»س����¼�

        Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize();  //��ȡ���ڴ�С��
        setSize(scrSize); //���ô��ڴ�С��ռ��������Ļ
        setVisible(true);

    }
    
    /**
    **ʵ�ּ������ӿڵ�actionPerformed��������������urlFieldʱ���»س����󣬵��ô˷���
    */
    public void actionPerformed(ActionEvent e) 
    {
        try
        {
            URL url = new URL(urlField.getText().trim()); //�����û�����ĵ�ַ����URL����
            contentEditor.setPage(url);  //��ȡ����ʾ��ҳ���ݣ���ع�����setPage�����Զ����
        }
        catch (MalformedURLException ex)
        {
            System.out.println(ex);
        }
        catch (IOException ex1)
        {
            System.out.println(ex1);
        }        
    }
      
    /**
    **ʵ�ּ������ӿڵ�hyperlinkUpdate����,���û������ҳ�ϵ�����ʱ������Щ����
    */
    public void hyperlinkUpdate (HyperlinkEvent e) 
    { 
        if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)  //�û�����������¼�
        {
            try
            {
                URL url = e.getURL();  //��ȡ�û������URL
                contentEditor.setPage(url);  //����ҳ��
                urlField.setText(url.toString());  //���µ�ַ��
            }
            catch (MalformedURLException ex)
            {
                System.out.println(ex);
            }
            catch (IOException ex1)
            {
                System.out.println(ex1);
            }
        }

    } 

}