#include <iostream>
using namespace std;
typedef int KeyType;       // �ؼ��ֵ�����
const int MAXSIZE=100;     // ���������
struct ElemType            //ѧ���ļ�¼��Ϣ
{
KeyType  key ;        //ѧ��
char name[10];         //����
int english;            //�ɼ�
int math;             //�ɼ�
} ;
class List
{ 
public:
ElemType *ht;     //������
int length;       //���С�����ȣ�
//KeyType   p;      // �����������Ĵ�����
public:
	List( int n1,int p1);
	~List(){delete []ht;  length=0;};
	//int  find( KeyType k );
	int  search( KeyType k );
	//void  creat_hash();
	void PrintOut();
};
//-------------------------------------------------------------
List::List(int n1,int p1)
{ 
int num=0; 
length=n1;  p=p1;
ht=new ElemType[length];
for(int i=0;i<length;i++)ht[i].key=-1;
}
void  List::creat_hash()
{ 
int i,j,K,en,ma;char na[10];
cout<<"\n  ����һ�������ѧ�ţ��ؼ���ֵ����-1��������"; cin>>K;
while(K!=-1&&num<length)
{ 
cout<<"\n  ������ѧ����������Ӣ��ɼ��͸����ɼ���";
cin>>na>>en>>ma;
	ht[i].key=K;
	strcpy(ht[i].name,na);     //�ô�������ֵ
	ht[i].english=en;
	ht[i].math=ma;              //������ѧ����¼K
	cout<<"\n   ����ɹ���" ; num++;
	cout<<"\n  ����һ�������ѧ�ţ��ؼ���ֵ����-1��������";
cin>>K;
}
}

//��ѯĳ�ؼ��ֵļ�¼
int  List::search( KeyType k )
{ 


}

void  List::PrintOut()
{ int i,j;
for (i=0;i<length; i++)
{
	if(ht[i].key!=-1)
		cout<<"\n  i="<<i<<"   ѧ�ţ�"<<ht[i].key<<"  ������"<<ht[i].name
		<<"   Ӣ��ɼ���"<<ht[i].english<<"   �����ɼ���"<<ht[i].math;
}
}
int main()
{  
int p0,n0;
cout<<"\n  ������nֵ��nֵӦ�Ǽ�¼������.3-1.5��)";
cin>>n0;
cout<<"\n  ������Pֵ��Ӧ�ǲ�����n �Ĵ���������"; 
cin>>p0;
List  ha(n0,p0);  
ElemType a;
int k; char ch;
do { cout<<"\n\n\n";
cout<<"\n       1. ������ϣ�� ";
cout<<"\n       2. �ڹ�ϣ���в���ĳλѧ��";
cout<<"\n       3. �����ϣ��";
cout<<"\n       4. ����";
cout<<"\n==============================";
cout<<"\n       ��������ѡ��(1,2,3,4):"; cin>>k;
switch(k)
{ 
case 1:{  ha.creat_hash();
}  break;
case 2:{  
cout<<"\n  ����������ҵ�ѧ��ѧ�ţ�";  cin>>a.key;
	int i=ha.search(a.key);
	if(i==-1) 
		       cout<<"\n  ��ѧ��"<<a.key<<"  �����ڣ�" ;
else
		   cout<<"\n  i="<<i<<"   ѧ�ţ�"<<ha.ht[i].key<<"  ������"<<ha.ht[i].name
		<<"   Ӣ��ɼ���"<<ha.ht[i].english<<"   �����ɼ���"<<ha.ht[i].math;
	   }   break;
case 3:{ ha.PrintOut(); }  break;
}
}while(k>=1&&k<=3);
getchar();        
return 0;
}