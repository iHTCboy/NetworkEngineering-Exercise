# include <iostream>
using namespace std;
int  main()
{
    int a,b,c,d,t;
	cout<<"�����ĸ�����:"<<endl;
	cin>>a>>b>>c>>d;
	cout<<"���ĸ�����С����Ľ��Ϊ��"<<endl;
	if(a>b)
	{
		t=a;
		a=b;
		b=t;	
	}
    if(a>c)
	{
	    t=a;
		a=b;
		b=t;
	}
    if (a>d) 
	{t=a;a=d;d=t;} 
	if (b>c) 
	{t=b;b=c;c=t;}
	if (b>d) 
	{t=b;b=d;d=t;}
	if (c>d) 
	{t=c;c=d;d=t;}
	
	cout<<a<<"<"<<b<<"<"<<c<<"<"<<d<<endl;

    return 0;
}