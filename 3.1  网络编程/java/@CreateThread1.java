/**
 * ͨ���̳�Thread�ഴ���̵߳ķ���ʾ�����Լ��̶߳���Ĵ�����ִ�з���ʾ��
 * 
 * @author (YHZ) 
 * @version (2013-6-25)
 */

class CreateThread1 extends Thread  //CreateThread1�Ķ���Ϊ�߳�
{
    /**
     * ���幹�캯�����������壬��ʹ��ϵͳĬ�ϵĹ��캯���������󣬸ù��캯���޲���
     */
    public CreateThread1(String name)  //name���������߳���
    {
        setName(name);  //�����߳���
    }
    
    /**
     * ��дrun�������÷������߳�����ʱ���Զ�ִ�У�������д�÷������򱨸�Ĭ�ϵ�run���������������幤��
     */
    public void run() 
    {
        System.out.println("���߳��ǣ�" + this);  //��ʾ�߳���Ϣ
    }
    
    public static void main(String args[])  //������CreateThread1
    {
        for (int i = 0; i < 3; i ++)
        {
            Thread t = new CreateThread1("�߳�" + (i + 1));  //�����߳�
            t.start();  //�����̣߳�����������ִ�У�����ʹ�߳̽��롰������״̬�����ԣ��̵߳ı���˳���봴��˳�򲢲�һ�¡�
        }
    }
}
