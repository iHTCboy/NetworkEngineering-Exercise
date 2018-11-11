#include <iostream.h>
#include <stdio.h>
#include <stdlib.h>
#include <malloc.h> 

typedef struct BiTNode
{
	char data;
    struct BiTNode *lchild,*rchild; 
    int LTag, RTag,flag;
 }BiTNode,*BiTree;

 void CreatBiTree(BiTree &T)           //����һ�ö�����
{
    char ch;
    cin>>ch;
    if(ch=='#')
        T=NULL;
    else
    {
        T=(BiTree)malloc(sizeof(BiTNode));
        if(!T)
            exit(0);
        T->data=ch;
        CreatBiTree(T->lchild);
        CreatBiTree(T->rchild);
    }
}

void PreOrderTraverse(BiTree &T)
{                                    //ǰ������ݹ�
	if(T)
	{  
		cout << T->data<<" ";
		PreOrderTraverse(T->lchild);
		PreOrderTraverse(T->rchild);
	}
}

void InorderTraverse(BiTree &T)
{                                   //��������ݹ�
	if(T)
	{  
	    InorderTraverse(T->lchild);
		cout << T->data<<" ";
		InorderTraverse(T->rchild);
	}
}

void PostTravel(BiTree &T)
{                                 //��������ݹ�
	if(T)
	{  
		PostTravel(T->lchild);
		PostTravel(T->rchild);
        cout << T->data<<" ";
	}
}

void preOrderTraverse(BiTree T)
{                                 //ǰ������ǵݹ�
	  BiTree S[20];
	  int top=-1;        
	  do
	  {
	         while(T!= NULL) 
	            {
	              cout << T->data<<" ";
	              top++;
				  S[top]=T; 
	              T=T->lchild;
	             }
	         if( top >-1 )
	          {
	             T=S[top]; 
				 top--; 
	             T = T->rchild; 
	           }
	  }while (( T != NULL ) ||(top>-1));
}

int inorderTraverse(BiTree T)
{                                //��������ǵݹ�
	BiTree s[20];
	int i=-1;
	while(T||i>-1)
	{
		if(T)
		{
			i++;
			s[i]=T;	
			T=T->lchild;
		}
		else
		{
			T=s[i];
			cout<<T->data<<" ";
			i--;
			T=T->rchild;
		}
	}
	return 0;
}

void postorder (BiTree T)
{                               //��������ǵݹ�
     BiTree s1[20];
	 int s2[20],top=0;
     do{
		 while (T!=NULL)
		 {
			 s1[top]=T; 
		     s2[top++]=0;  
             T=T->lchild;
		 }
		 while(top && s2[top-1]==1)
		 {
			 top--;
		     T=s1[top]; 
		     cout<<T->data<<" "; 
		 }  
         if(top>0)
		 {
			 s2[top-1]=1;
             T=s1[top-1]->rchild; 
		 }
	 }while (top>0); 
}


			
void main()  //������
{


   printf(" ����������������  ���� �� ��������    ��������    ��������  ����         \n");
   printf(" ����������������  ������  �� �� ��    ��          ��������  ����         \n");
   printf(" ������������������  ����  �������� �� �������� �� ��������  ����   ��    \n");
   printf(" ������������������������   ��   ��    ��    ��    �������� �� ��         \n");
   printf(" ����������������������������������    ��������    ������������������     \n");
   printf("\n");
   printf("       �����������������������ߡ�����������������������������\n");
   printf("      ��                                                    ��                 \n");
   printf("      ��                �� �����                           ��               \n");
   printf("      ��                �� ���繤��רҵ 11-1��              ��    \n");
   printf("      ��                �� ѧ�ţ�3110757101                 ��   \n");
   printf("      ��                �� ��Ϣ��ѧ�빤��ѧԺ               �� \n");
   printf("      ��                �� ��������ѧ                     �� \n");
   printf("      ��                                                    ��         \n");
   printf("       ������������������������������������������������������  \n");
   printf("\n");
   
            printf("\n");
            printf("�ǩ�����������������������������������������������������   \n");
            printf("��                                                    ��   \n");
			printf("��              �š�����һ�ö���������#��ʾ�գ�����   ��   \n");		
			printf("��              �ơ��������ݹ���������            ��   \n");
			printf("��              �ǡ��������ݹ���������            ��   \n");
			printf("��              �ȡ��������ݹ���������            ��   \n");
			printf("��              �ɡ��������ǵݹ���������          ��   \n");
            printf("��              �ʡ��������ǵݹ���������          ��   \n");
			printf("��              �ˡ��������ǵݹ���������          ��   \n");	
			printf("��              �̡������Ļ��                        ��   \n");	
			printf("��             (O)������������                        ��   \n");
 			printf("��                                                    ��   \n");
			printf("�ǩ�����������������������������������������������������   \n");
			printf("\n");


		   BiTree T;
   int e;
   while(e!=0)
   {
	   cout<<endl<<"       ����ѡ�񡿲�����";
	   cin>>e;
	   cout<<endl;
	   if(e==1)
	   {
		   cout <<"�������롿����һ�ö���������#��ʾ�գ���";
		   CreatBiTree(T);
           cout<<endl;
	   }
	   if(e==2)
	   {
		   cout << "   �����������ݹ���������";
	       PreOrderTraverse(T);
           cout<<endl;
	   }
	   if(e==3)     
	   { 
		   cout<< "   �����������ݹ���������";
		   InorderTraverse(T);
           cout<<endl;
		
	   }
	   if(e==4)
	   {
		   cout<<"   �����������ݹ���������";
		   PostTravel (T);
           cout<<endl;
	   }
	   if(e==5)
	   {
		   cout << "   �����������ǵݹ���������";
	             preOrderTraverse(T);
           cout<<endl;
	   }
	   if(e==6)     
	   { 
		   cout<< "   �����������ǵݹ���������"	;
		   inorderTraverse(T);	
	   }
	   if(e==7)
	   {
		   cout<<"   �����������ǵݹ���������";
		   postorder (T);
           cout<<endl;
	   }	   
	   if(e==8)
	   {
		    system("cls");  //��������
		    printf("�ǩ�����������������������������������������������������   \n");
            printf("��                                                    ��   \n");
			printf("��              �š�����һ�ö���������#��ʾ�գ�����   ��   \n");		
			printf("��              �ơ��������ݹ���������            ��   \n");
			printf("��              �ǡ��������ݹ���������            ��   \n");
			printf("��              �ȡ��������ݹ���������            ��   \n");
			printf("��              �ɡ��������ǵݹ���������          ��   \n");
            printf("��              �ʡ��������ǵݹ���������          ��   \n");
			printf("��              �ˡ��������ǵݹ���������          ��   \n");	
			printf("��              �̡������Ļ��                        ��   \n");	
			printf("��             (O)������������                        ��   \n");
 			printf("��                                                    ��   \n");
			printf("�ǩ�����������������������������������������������������   \n");
			printf("\n");
		    cout <<"�������롿����һ�ö���������#��ʾ�գ���";
	   }
	   if(e>8||e<0)
	   {
		   cout<<"   ������������������룡��";
           cout<<endl;
	   }
   }
  
}
