#include<string.h>
#include <iostream>
using namespace std;
//-------��--------
class String1
{public:
     String1(){};
     ~String1(){};
     void Insert(string t,int pos);     //��������
     void Delete(int pos,int num);   //ɾ������
     void Creat();                  //�������ַ�������
     void Display();                //������
  private:
     char *str;                     //��������
     int size;                      //����
 };
//------�������ַ�������--------
void String1:: Creat()
 {
	//char *s=new char[20];  
char *s="follow me sunshine";	
//cin>>s;
    size=strlen(s);                    //���㳤��
    str=new char[size];               //�½���ʱstr
if(str==0)  
cout<<"û�����뵽�ռ䣡";
    strcpy(str,s);                      //��s�������ݸ��Ƹ�str
 }
//--------���----------
void String1::Display()
{ int i;
  for(i=0;i<size;i++)  
cout<<str[i];
  cout<<endl;
}
//---��������:�ڴ�����s��posλ�ú����һ����t---
//
void String1::Insert(string t,int pos)    
{




}
//------ɾ��:ɾ�����е�һ���Ӵ�-------
 void  String1:: Delete(int pos,int num)
{ 





}
//--------������---------
 int main(int argc, char* argv[])
{  int pos,num,k;
   string s,s1,t;
   do{  cout<<"\n\n    1.�����ַ���"  ;
        cout<<"\n\n    2.�����Ӵ�s1";
        cout<<"\n\n    3.ɾ���Ӵ�";
        cout<<"\n\n    4.��������";
        cout<<"\n******************************** ";
        cout<<"\n    ���������ѡ��(1,2,3,4)";  cin>>k;
  switch(k){
       case 1:{cout<<"������һ���ַ�����";
               s.Creat();
               cout<<"�ַ���Ϊ��      ";     s.Display();
              }break;
      case 2:{ cout<<"�������Ӵ�����λ��pos"<<endl;
                cin>>pos;
                cout<<"������Ҫ������Ӵ�:  ";   cin>>s1;
                s.Insert(s1,pos);
                cout<<"�������ַ���Ϊ��  ";  s.Display();
              }break;
       case 3:{ cout<<"������Ҫɾ���Ӵ��Ŀ�ʼλ��pos���Ӵ�����num"<<endl;
               cin>>pos>>num;
               s.Delete(pos,num);
               cout<<"ɾ������ַ���Ϊ��  ";
               s.Display();
             }break;
     default:break;
  }
 //switch
     cout<<"\n--------------------------------- ";
}while(k>=1&&k<5);
  cout<<"\n          �ټ�!";
  cout<<"\n     ������������ء�";
  return 0;
}
