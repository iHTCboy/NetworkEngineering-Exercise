/**
 * 任务一个Java进程，都会创建一个主线程，本程序是对该线程进行简单操作的示例
 * 
 * @author (YHZ) 
 * @version (2013-6-25)
 */

class MainThreadTester 
{
    public static void main(String args[]) 
    {
        Thread t= Thread.currentThread(); //获取当前线程对象，即主线程
        System.out.println("当前线程是: " + t);  //显示当前线程信息
        t.setName("MyJavaThread"); //更改线程名
        System.out.println("当前线程名是: " + t.getName()); //显示当前线程名
        try 
        { 
            for(int i=0;i<3;i++)
            { 
                System.out.println(i);
                Thread.sleep(1500);   //线程睡眠1.5S，该操作可能产生InterruptedException异常
            }
        }
        catch(InterruptedException e)
        { 
            System.out.println("主线程被中断"); 
        }
    }
}
