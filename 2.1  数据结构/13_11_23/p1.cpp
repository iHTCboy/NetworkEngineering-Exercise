//ջ��˳��洢�ṹ��˳�����
#include<iostream.h>
//------------------------------ջ��˳��洢�ṹ---------------------------------------------
typedef int  ElemType;     // ����Ԫ�ص�����
const int MAXSIZE=100;     // ���������


struct Node
{
//�����������ݳ�Ա��������

      int entry;
      Node *next;  
   
//����������Ա�����������������أ�

   Node();  //Node�Ĺ��캯��
   Node(int item,Node *add_on=0);   //���ع��캯������ʼ�����ݳ�Ա
};


Node::Node()
 {
	 next=0;  //��next��ΪNULL����Ϊ������İ�ȫ��ʩ
}


Node::Node(int item,Node *add_on) 
{
	  entry=item;
      Next=add_on; //ָ��һ��NULL��Ĭ��ֵ��ʹ��������������õ�һ���������ܵ���Щ���캯��
}


class  Stack  //������ջ
  { 
        protected:
            Node *top_node; //����ջ�����ָ��
        public:
            Stack( void);                    //���캯��
          //~Stack(){};
            Bool  empty() ;                 //�ж���ջ�Ƿ�Ϊ��
            void  push(  ElemType &item);  //��ջ����ջ
            ElemType  pop();               //��ջ�ĳ�ջ
            ElemType  top(ElemType &item );
    };

//������������������������������������������������������������������������������

Stack:: Stack( void): top_node (0){ }

//������������������������������������������������������������������������������

bool  Stack:: Empty()
   { 
	    if (top_node==0)
             return 1;
        else return 0;

   }

//������������������������������������������������������������������������������

void  Stack::push(  ElemType &e)
{ 




}

//������������������������������������������������������������������������������

int Stack::pop()
 {




}

//������������������������������������������������������������������������������

int  Stack:: top ()
  {
	  if (top_node==0) 
		  return 0;
      else  
		  return top_node->entry;
 }

//������������������������������������������������������������������������������

int main(int argc, char* argv[])
{ 
	int i,k;
	ElemType e,x;
	Stack  as;
	cout<<"\n                           ˳���洢�ṹ��ʾ";
	do{
        cout<<"\n\n";
        cout<<"\n\n    1.����һ������Ԫ��e����ջ��";
        cout<<"\n\n    2.ɾ��һ��Ԫ�أ�������ֵ����ջ��";
        cout<<"\n\n    3..��������";
        cout<<"\n******************************** ";
        cout<<"\n    ���������ѡ��(1,2,3,4,5,6)";    cin>>k;
    switch(k)
	{
          case 1:{
			        cout<<"\n ��ջ������ e=?";
                    cin>>e;
                    as.push(e);
                    as.top()
              }break;
          case 2:{ 
			        cout<<"\n ��ջ";
                    x=as.pop();
                    cout<<"\n  ��ջԪ����ֵ= "<<x;
                  
             }break;
         default:break;
	} //switch
         cout<<"\n--------------------------------- ";
	}while(k>=1&&k<3);

  cout<<"\n          �ټ�!";
  cout<<"\n     ������������ء�";
  return 0;
}

