/*
��������������������
˵����
���õ����ã������뱻���õ�ֵһ����
��������������������
*/
# include<iostream>
using namespace std;
void f(int & m,int n)
{
    int temp;
	temp=m;
	m=n;
	n=temp;
	cout<<n<<endl;
	
}

  int main()
{
   int a=5,b=10;
   f(a,b);
   cout<<a<<"  "<<b<<endl;
   return 0;
}
 
/*
��������������������
�����

 5
10  10

��������������������
*/