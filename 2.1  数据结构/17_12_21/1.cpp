#include <iostream>
using namespace std;
typedef int KeyType;       // �ؼ��ֵ�����
const int MAXSIZE=100;     // ���������
struct ElemType            //ѧ���ļ�¼��Ϣ
{ KeyType  key ;        //ѧ��
char name[10];         //����
int english;          //�ɼ�
int math;             //�ɼ�
} ;
class SqHash
{ public:
ElemType *ht;     //������
int length;       //���С�����ȣ�
//KeyType   p;      // �����������Ĵ�����
public:
	SqHash( int n1,int p1);
	~SqHash(){delete []ht;  length=0;};
	//int  find( KeyType k );
	int  sort1();
	void  creat_hash();
	void PrintOut();
int max_key(KeyType i,  KeyType  position);
void  swap(KeyType  max, KeyType position);

};
//-------------------------------------------------------------


SqHash::SqHash(int n1,int p1)
{ int num=0; 
length=n1;  p=p1;
ht=new ElemType[length];
for(int i=0;i<length;i++)ht[i].key=-1;
}
void  SqHash::creat_hash()
{ int i=0,j,K,en,ma;char na[10];
cout<<"\n  ����һ�������ѧ�ţ��ؼ���ֵ����-1��������"; cin>>K;
while(K!=-1&&num<length)
{ 
cout<<"\n  ������ѧ����������Ӣ��ɼ��͸����ɼ���";    cin>>na>>en>>ma;
	ht[i].key=K;
	strcpy(ht[i].name,na);     //�ô�������ֵ
	ht[i].english=en;
	ht[i].math=ma;              //������ѧ����¼K
	cout<<"\n   ����ɹ���" ; num++;
	cout<<"\n  ����һ�������ѧ�ţ��ؼ���ֵ����-1��������"; cin>>K;
}
}

//��ѯĳ�ؼ��ֵļ�¼
int  SqHash:: sort1( )
{ 


}

void  SqHash::PrintOut()
{ int i,j;
for (i=0;i<length; i++)
{
	if(ht[i].key!=-1)
		cout<<"\n  i="<<i<<"   ѧ�ţ�"<<ht[i].key<<"  ������"<<ht[i].name
		<<"   Ӣ��ɼ���"<<ht[i].english<<"   �����ɼ���"<<ht[i].math;
}
}
int main()
{  int p0,n0;
cout<<"\n  ������nֵ��nֵӦ�Ǽ�¼������.3-1.5��)"; cin>>n0;
cout<<"\n  ������Pֵ��Ӧ�ǲ�����n �Ĵ���������"; cin>>p0;
SqHash  ha(n0,p0);  ElemType a;
int k; char ch;
do { cout<<"\n\n\n";
cout<<"\n       1. ������ ";
cout<<"\n       2. ��ѧ����¼����";
cout<<"\n       3. �����";
cout<<"\n       4. ����";
cout<<"\n=======================================";
cout<<"\n       ��������ѡ��(1,2,3,4):"; cin>>k;
switch(k)
{ case 1:{  ha.creat_hash();
}  break;
case 2:{  cout<<"\n  ����ѧ�����ݣ�";  
	int i=ha.sort1();
	if(i==-1) 
		cout<<"\n���򲻳ɹ�"<<endl ;
	else
		cout<<"����ɹ���";
	   }   break;
case 3:{ ha.PrintOut(); }  break;
}
}while(k>=1&&k<=3);
getchar();        return 0;
}

