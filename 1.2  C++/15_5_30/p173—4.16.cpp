# include <iostream>
using namespace std;
class base
{
    public:
		base()   //��������base
		{
		   a=5;
		   cout<<66<<"base a="<<a<<endl;		
		}
	protected:
		int a;
};
class base1:virtual public base  //������base��base1�������
{
     public:
		int b1;
		base1()
		{
		   a=a+10;
		   cout<<"base1 a="<<a<<endl;		
		}
};
class base2:virtual public base  //������base��base2�����
{
     public:
		 int b2;
		 base2()
		 {
		   a=a+20;
		   cout<<"base2 a="<<a<<endl;		 
		 }
};
class derived:public base1,public base2
//derived��base1��base2�Ĺ�ͬ�����࣬��base�ļ��������
{
    public:
		int d;
		derived()
		{
		   cout<<"derived a="<<a<<endl;		
		}
};
int main()
{
   derived obj;
   return 0;
}