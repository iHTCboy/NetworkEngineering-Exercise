# include <iostream>
using namespace std;
class Time
{
  public:
	  Time(int h,int m,int s):hour(h),minutes(m),seconds(s){}
	{
	  hours=h;
	  minutes=m;
	  seconds=s;	
	}

	voed display()
   {
      cout<<"����ʱ��:"<<hours<<"ʱ"<<minutes<<"��";
	  cout<<seconds<<"��"<<endl;
   }
  protected:
	  int hours,minutes,seconds;
};

class Date
��
    public:
		Date(int m,int d,int y):month(mo),day(d),year(y){}
		{
		  month=mo;
		  day=d;
		  year=y;
		}
		void display()
	 {
		 cout<<"��������:"<<year<<"��"<<month<<"��";
		 cout<<day<<"��"<<endl;	 
	 }
   protected:
	   int month,day,year;
��;

class Birthtime :public Time,public Date
{
	Birthtime(int mo,int d,int y,int h,int m,int s):Date(m,d,y),Time(h,m,s){}

	void display2()
	{
	  //cout<<"����"<<Childname<<endl;
	  Date.display();
	  Time.display();
	}
  // private:
    //	char Childname;
};
void main()
{
  Birthtime t(4,14,1991,13,14,520);
  t.display2();

}
