/**
 * ͨ��ʵ��Runnable�ӿڵķ�ʽ�����̵߳ķ���ʾ�����Լ��̶߳���Ĵ�����ִ�з���ʾ��
 * 
 * @author (YHZ) 
 * @version (2013-6-25)
 */

class CreateThread2 implements Runnable  //��ֻ��Ҫ��дrun���������߸����Ѿ����˻��࣬���ܴ�Thread��̳ж���ʱ����
{
    private String name; //�̵߳�����
    
    /**
     * ���幹�캯�����������壬��ʹ��ϵͳĬ�ϵĹ��캯���������󣬸ù��캯���޲���
     */
    public CreateThread2(String name)  //name���������߳���
    {
        this.name = name;  //����ʹ�÷���setName(name)����Ϊ����Ķ��󲢲���һ���߳�
    }
    
    /**
     * ��дrun�������÷������߳�����ʱ���Զ�ִ�У�������д�÷������򱨸�Ĭ�ϵ�run���������������幤��
     */
    public void run() 
    {
        System.out.println("���߳����ǣ�" + name);  //��ʾ�߳�����
    }
    
    public static void main(String args[])  //������CreateThread1
    {
        for (int i = 0; i < 3; i ++)
        {
            Thread t = new Thread(new CreateThread2("�߳�" + (i + 1)));  //�����߳�,Thread��һ��ʹ��Runnable�ӿڴ�������Ĺ��캯��
            t.start();  //�����߳�
        }
    }
}