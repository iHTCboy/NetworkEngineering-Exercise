#include<iostream.h>
#include<malloc.h>
#include<stdio.h>
#include<stdlib.h>


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义链表】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


typedef struct Node      //typedef把Node定义成struct node类型(定义链表，是一个结构体)
{
	float coef;          //系数
	int index;           //指数
	struct Node *next;   //定义指向下一个节点的名称。【指针域，指向下一个系数不为0的子项】
}LinkList;



//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【插入函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


void  Insert(LinkList *p,LinkList *h)                      //把节点p插入到链表h中
{
   LinkList *q1,*q2;                                       //同步指针
   
   int flag=0;                                             //定义一个结束标志                     
       q1=h; 
	   if(p->coef==0)                                      //系数为0的话释放结点
		   free(p); 
	   else
	   {
	 	
	      if(q1->next==NULL)                               //第一次把头指针与第一个节点连接
		  {
		      q1->next=p;
		  }
	      else
		  {
		     q2=q1->next;
		     while(flag==0)                      //查找插入位置,当flag=1时，结果
			 {                            
    		     if(p->index<q2->index)          //判断链表的q2节点与当然要插入的p的index的值
				 {
				     if(q2->next==NULL)          //如果当前q2是链尾，则用【尾插法】，把p接到q2后面
					 {
					     q2->next=p;
				 	     flag=1;                 //flag=1，循环结束，完成插入
					 }
				     else                        //否则，由于不知道p2—>next的index的值与p的大小，所以移动q1、q2向后移动在判断【这里的判断，是重新循环的，即从新比较p与后面的q2的指数。】
					 {
					     q1=q2;                  //同步指针
					     q2=q2->next;            //使q1、q2保持一个节点的距离
					    
					 }
				 }
			    else if(p->index>q2->index)     //如果p的指数大于q2，则用【头插法】，把p插到链头
				{
                        p->next=q2;
					    q1->next=p;
                        flag=1;
				}
			    else                                             //指数相同的项，将系数相加
				{
			  		   q2->coef=p->coef+q2->coef;                //将指数相同的p、q2的系数相加，并赋给q2
					   if(q2->coef==0)                           //系数为0的话释放结点
					   {
						   q1->next=q2->next;
						   free(q2);
					   }
					   flag=1;                                   //flag=1，循环结束，完成插入
					   free(p);
				}
			 }
		  }
				   
	   }
}

//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【创建链表函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


LinkList  *Creat_L(LinkList *head,int m)                 //创建一个链表(CreateLinklist)，头指针为head、项数为m的一元多项式
{
    int i;
	LinkList *q;
	head=(LinkList *)malloc(sizeof(LinkList));           //申请一块大小为sizeof(LinkList)的内存。【(LinkList *)的作用：malloc返回值类型是 void* ， 而 head类型是linklist* ，不同类型指针无法互相赋值，为了解决这个语法限制，所以进行强制类型转换。malloc返回值类型是一个void *指针类型的地址，我们不知道该地址存放的是什么内容，不能访问它。所以需要在前面加(LinkList*)把它转换成LinkList类型的指针，这样程序就知道它存放的是什么内容了，就可以正确访问了。】
	head->next=NULL;                                     //令头指针的下一个节点为空
	for(i=1;i<=m;i++)                                    //按输入的项数作为循环次数
	{
        q=(LinkList *)malloc(sizeof(LinkList));           //建立新结点以接收数据
        q->next=NULL;                                     
      	printf("●请输入第%d项：",i);
		scanf("%fx^%d",&q->coef,&q->index);               //输入和系数
	   	Insert(q,head);                                   //调用Insert函数，插入结点
	}
	return head;
}



//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪【输出函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


void PRintf(LinkList *L)
{
    LinkList *p,*q;
	int i=0;                      //项数记数标记
	p=L->next;
	q=L->next;
	if(p==NULL)                   //若多项式为空，输出0，不要执行下面的while语句。【条件也可写为!p】（当p=0，!p为1，条件成立，执行内语句，否则相反）
	{            
		printf("0\n");
		return;
	}

	while(q)                         //当q不为null时，一直循环
	{
		if(q->coef==1)                //实现输出是，如果系数为1，则省略
	    	printf("x^");
	    else
		    printf("%gx^",q->coef);  //输出当然q指向的系数
		printf("%d",q->index);       //输出当然q指向的指数
        q=q->next;                   //循环语句，指向下一个结点
		if(q!=NULL)                  //作用：输出加号，连接各项式【条件也可写为p】
		{
		    printf("＋");
		}
	}
    while(p)                      //实现计算多项式的项数。【不能用q，因为q在上面的while中已经指向尾部】
	{
		p=p->next;
		i++;
	}
	printf("【共有%d项】",i);     //输出总项数
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【求和函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


LinkList *ADDlist(LinkList *pa,LinkList *pb)          //求解并建立多项式a+b，返回其头指针
{
	LinkList *pc,*pd,*pe;
	pe=(LinkList *)malloc(sizeof(LinkList));         //创建pe用来储存a+b的值
	pe->next=NULL;   
	for(pa=pa->next;pa;pa=pa->next)                 //把pa的一个一个地值赋给pd，在一个一个地把pd插入到pe中
	{
	   pd=(LinkList *)malloc(sizeof(LinkList));
       pd->coef=pa->coef;
	   pd->index=pa->index;
	   pd->next=NULL;
	   Insert(pd,pe); 	                            //调用Insert函数，一个一个地把pd插入到pe中
	
	}

/*
***************************************************************************************
     说明：
	        上面的代码，功能是创建一个链表，另外储存求和后和结果，防止pa，即a的内容被改写。
	        作用是不影响到其它的计算。

			【下面出现一样的代码，作用一样，不在说明。】
 
***************************************************************************************
*/
	int flag=0;
	while(flag==0)
	{
		if(pb->next==NULL)                              //pb为空，则返回pe,即链表a
			flag=1;
		else
		{
			pb=pb->next;                                //循环pb
			pc=(LinkList *)malloc(sizeof(LinkList));    //创建pc，把pb的值一个一个地赋给pc
			pc->coef=pb->coef;
			pc->index=pb->index;
			pc->next=NULL;
			Insert(pc,pe);                            //调用Insert函数，把pc一个一个地插入到pe

		}
	}
           return pe; 
}



//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【减法函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


LinkList *MinusList(LinkList *pa,LinkList *pb)
{
	LinkList *pc,*pd,*pe;
	pe=(LinkList *)malloc(sizeof(LinkList));         //创建pe用来储存a-b的值
	pe->next=NULL;   
	for(pa=pa->next; pa;pa=pa->next)                 //把pa的一个一个地值赋给pd，在一个一个地把pd插入到pe中
	{
	   pd=(LinkList *)malloc(sizeof(LinkList));
       pd->coef=pa->coef;
	   pd->index=pa->index;
	   pd->next=NULL;
	   Insert(pd,pe); 	                            //调用Insert函数，一个一个地把pd插入到pe中
	
	}

	int flag=0;
	while(flag==0)
	{
		if(pb->next==NULL)                          //pb为空，则返回pe,即链表a
			flag=1;
		else
		{
			pb=pb->next;
			pc=(LinkList *)malloc(sizeof(LinkList));
			pc->coef=-pb->coef;                      //把-pb的值赋给pc
			pc->index=pb->index;
			pc->next=NULL;
			Insert(pc,pe);                          //调用Insert函数，一个一个地把pd插入到pe中
		}
	}
             return pe;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【求值函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


float ValueLinkList(LinkList *pc,float x)             //输入x值，计算并返回多项式的值
{
	LinkList *p;
    int i;
    //int t;
	float sum=0,t;
    for(p=pc->next;p;p=p->next)                   //把pc指向下一个结点
	{
        t=1;
        for(i=p->index;i!=0;)                     //指数不为0，一直循环
		{ 
            if(i>0)                               //指数大于0，进行乘法
			{
	     		t*=x;                             //t*=x 相当于 t=t*x
				i--;

			}
            else                                  //指数小于0，进行除法
			{
				t/=x;                             //t/=x 相当于 t=t/x
				i++;
			}
		}
        sum+=p->coef*t;
	}
    return sum;
}

//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【求导函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


LinkList *Deri(LinkList *pa)  //求导
{	
	LinkList *pd,*pe;
	pe=(LinkList *)malloc(sizeof(LinkList));         //创建pe用来储存a-b的值
	pe->next=NULL;   
	for(pa=pa->next;pa;pa=pa->next)                 //把pa的一个一个地值赋给pd，在一个一个地把pd插入到pe中
	{
	   pd=(LinkList *)malloc(sizeof(LinkList));
       pd->coef=pa->coef;
	   pd->index=pa->index;
	   pd->next=NULL;
	   Insert(pd,pe); 	                            //调用Insert函数，一个一个地把pd插入到pe中
	
	}
	LinkList *p=pe;
	while (p->next!=NULL)                //p指向不为空
	{
		if(p->next->index==0)
			p->next=NULL;         //指数为零返回
		else 
		{
			p->next->coef*=p->next->index;          //系数乘以指数
			p->next->index--;                       //指数减一
			p=p->next;
		}
	}
return pe;
}

//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【乘积函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


LinkList *Multiply(LinkList *a,LinkList *b)
{
	LinkList *pa,*pb;
	pb=(LinkList *)malloc(sizeof(LinkList));         //创建pb用来储存a的值
	pb->next=NULL;   
	for(a=a->next;a;a=a->next)                 
	{
	   pa=(LinkList *)malloc(sizeof(LinkList));
       pa->coef=a->coef;
	   pa->index=a->index;
	   pa->next=NULL;
	   Insert(pa,pb); 	                            
	}

	LinkList *pc,*pd;
	pd=(LinkList *)malloc(sizeof(LinkList));      //创建pb用来储存b的值   
	pd->next=NULL;   
	for(b=b->next;b;b=b->next)                 
	{
	   pc=(LinkList *)malloc(sizeof(LinkList));
       pc->coef=b->coef;
	   pc->index=b->index;
	   pc->next=NULL;
	   Insert(pc,pd); 	                            
	}

       LinkList *pe,*pf;
	   pf=(LinkList *)malloc(sizeof(LinkList));      //创建pe用来储存ab的值   
	   pf->next=NULL; 

	   
	   LinkList *pg=pd;    //借pg保证，每循环一次，可以在把pd指回表头
	   while(pb=pb->next)   //两层循环条件是难点，保证链表移动，同时条件成立
		 {   
		        pd=pg;    //使pd每循环一次，都指回头指针。【重点】
           while(pd=pd->next)  
			 {  
		         pe=(LinkList *)malloc(sizeof(LinkList));
                 pe->coef=(pb->coef)*(pd->coef);             //系数是相乘的
		         pe->index=(pb->index)+(pd->index);          //指数是相加的
		         pe->next=NULL;
	             Insert(pe,pf);                              //两层循环，把一对多项式相乘的结果存到pf中
				 
		   }
	    }
    return pf;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【主函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡


void main()
{
   int i,j,m,n;
   float x;
   LinkList *pa=0,*pb=0,*pc,*pd;
   while(1)
  {
   printf(" ◢■■◣◢■■◣  ◢■ 　 ◢■■◣    ◢■■◣    ◢■■◣  ◢■         \n");
   printf(" 　　　■■　　■  　■　  　 　 ■    ■          　　　■  　■         \n");
   printf(" ◢■■◤■　　■　  ■　  ■■■■ 年 ■■■■ 月 ◢■■◤  　■  号     \n");
   printf(" ■　　　■　　■　　■　   　   ■    ■    ■    ■　　　 　 ■         \n");
   printf(" ◥■■■◥■■◤◥■■■◤◥■■◤    ◥■■◤    ◥■■■◥■■■◤     \n");
   printf("\n");
   printf("       ━━━━━━━━━【作者】━━━━━━━━━━━━━━             \n");
   printf("      ┃                                                    ┃            \n");
   printf("      ┃                ● 何天从                           ┃            \n");
   printf("      ┃                ● 网络工程专业 11-1班              ┃            \n");
   printf("      ┃                ● 学号：3110757101                 ┃            \n");
   printf("      ┃                ● 信息科学与工程学院               ┃            \n");
   printf("      ┃                ● 桂林理工大学                     ┃            \n");
   printf("      ┃                                                    ┃            \n");
   printf("       ━━━━━━━━━━━━━━━━━━━━━━━━━━━             \n");
   printf("\n");
   printf("┣━━━━━━━━【欢迎使用一元稀疏多项式计算器】━━━━━━━━━┫   \n");
   printf("┃                                                                  ┃   \n");
   printf("┃        ⑴〖输入多项式a〗             ⑺〖输出多项式a+b的值〗     ┃   \n");
   printf("┃        ⑵〖输入多项式b〗             ⑻〖输出多项式a-b的值〗     ┃   \n");
   printf("┃        ⑶〖输出多项式b〗             ⑼〖输出多项式的导数〗      ┃   \n");
   printf("┃        ⑷〖输出多项式b〗             ⑽〖输出多项式ab的值〗      ┃   \n");
   printf("┃        ⑸〖输出多项式a+b〗           ⑾〖清空屏幕〗              ┃   \n");
   printf("┃        ⑹〖输出多项式a-b〗           ⑿〖结束计算〗              ┃   \n");
   printf("┃                                                                  ┃   \n");
   printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
   printf("\n");
  while(1)
  {
	printf("\n       【请选择】操作：");
	scanf("%d",&i);
	printf("\n");
	switch(i)
	{
	case 1:
		{
            printf("   【请输入】多项式 a 的项数：");
            scanf("%d",&m);
            printf("\n");
            pa=Creat_L(pa,m);    //创建一个链表，头指针为pa、项数为m
		    break;
		}
	case 2:
		{
		   printf("   【请输入】多项式 b 的项数：");
           scanf("%d",&n); 
		   printf("\n");
		   pb=Creat_L(pb,n);    //创建一个链表，头指针为pb、项数为n
		   break;
		}	
	case 3:
		{
			printf("                【输出】多项式 a 的整数序列为：");			
		    PRintf(pa);              //调用PRintf函数，输出pa链表，即多项式a
			printf("\n");
		    break;
		}
	case 4 :
		{
			printf("                【输出】多项式 b 的整数序列为：");
			PRintf(pb);              //调用PRintf函数，输出pb链表，即多项式b
			printf("\n");
			break;
		}
	case 5:
		{
            pc=ADDlist(pa,pb);        //调用ADDlist函数，把pa和pb相加
			printf("                【输出】多项式 a+b 的整数序列为：");
			PRintf(pc);              //调用PRintf函数，输出pc链表，即多项式a+b
			printf("\n");
			break;
			
		}
	case 6:
		{
			pc=MinusList(pa,pb);      //调用ADDlist函数，把pa和pb作减法
			printf("                【输出】多项式 a-b 的整数序列为：");
			PRintf(pc);              //调用PRintf函数，输出pc链表，即多项式a-b
			printf("\n");
			break;
		}
	case 7:
		 {  
			 pc=ADDlist(pa,pb);     //先调用ADDlist函数，把pa和pb相加得到pc
			 printf("             【请先输入】X的值：x=");
			 scanf("%f",&x);
			 printf("\n                【输出】x=%d时，a+b=%f\n",(int)x,ValueLinkList(pc,x));
             break;	
	case 8:
		 {  
			 pc=MinusList(pa,pb);     //先调用MinusList函数，把pa和pb相减得到pc
			 printf("             【请先输入】X的值：x=");
			 scanf("%f",&x);
			 printf("\n                【输出】x=%d时，a-b=%f\n",(int)x,ValueLinkList(pc,x));
         break;}
	case 9:
		{   int k=1;                           //求导数

            printf("┣━━━━━━━━━【多项式的导数】━━━━━━━━━┫   \n");
            printf("┃                                                    ┃   \n");
			printf("┃              ⑴〖输出多项式a的导数〗               ┃   \n");
			printf("┃              ⑵〖输出多项式b的导数〗               ┃   \n");
			printf("┃              ⑶〖输出多项式a+b的导数〗             ┃   \n");
			printf("┃              ⑷〖输出多项式a-b的导数〗             ┃   \n");
			printf("┃              ⑸〖清屏，并返回求导数菜单〗          ┃   \n");
            printf("┃              ⑹〖返回计算器菜单〗                  ┃   \n");
			printf("┃              ⑺〖结束计算〗                        ┃   \n");
 			printf("┃                                                    ┃   \n");
			printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
		    printf("\n");
			while(k)
			{
			printf("\n       【请选择】操作：");
	        scanf("%d",&j);
	        printf("\n");
			switch(j)
			{
	           case 1:
		           {	  
					   printf("                【输出】多项式 a 的导数为：a'=");
					   pd=Deri(pa);               //调用Deri函数，求导数
					   PRintf(pd);             //调用PRintf函数，输出pc链表，即导数a'的表达式
					   printf("\n");
			           break;
			
				   }
	           case 2:
		           {
					   printf("                【输出】多项式 b 的导数为：b'=");
					   pd=Deri(pb);               //调用Deri函数，求导数
					   PRintf(pd);             //调用PRintf函数，输出pc链表，即导数b'的表达式
					   printf("\n");					   
					   break;
				   }
	           case 3:
		           {	          
					   pc=ADDlist(pa,pb);        //调用ADDlist函数，把pa和pb相加
					   printf("                【输出】多项式 a+b 的导数为：(a+b)'=");
					   pd=Deri(pc);               //调用Deri函数，求导数
					   PRintf(pd);             //调用PRintf函数，输出pc链表，即导数(a+b)'的表达式
					   printf("\n");
			           break;
				   }
	           case 4:
		           {	          
					   pc=MinusList(pa,pb);        //调用ADDlist函数，把pa和pb相减
					   printf("                【输出】多项式 a-b 的导数为：(a-b)'=");
					   pd=Deri(pc);               //调用Deri函数，求导数
					   PRintf(pd);             //调用PRintf函数，输出pc链表，即导数(a-b)'的表达式
					   printf("\n");
			           break;					   
				   }
			   case 5:
		             system("cls");    //清屏函数
					 printf("┣━━━━━━━━━【多项式的导数】━━━━━━━━━┫   \n");
					 printf("┃                                                    ┃   \n");
					 printf("┃              ⑴〖输出多项式a的导数〗               ┃   \n");
					 printf("┃              ⑵〖输出多项式b的导数〗               ┃   \n");
					 printf("┃              ⑶〖输出多项式a+b的导数〗             ┃   \n");
					 printf("┃              ⑷〖输出多项式a-b的导数〗             ┃   \n");
					 printf("┃              ⑸〖清屏，并返回求导数菜单〗          ┃   \n");
					 printf("┃              ⑹〖返回计算器菜单〗                  ┃   \n");
					 printf("┃              ⑺〖结束计算〗                        ┃   \n");
					 printf("┃                                                    ┃   \n");
					 printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
					 printf("\n");
			         break;
	           case 6:
	                	k=0;
						printf("┣━━━━━━━━【欢迎使用一元稀疏多项式计算器】━━━━━━━━━┫   \n");
						printf("┃                                                                  ┃   \n");
						printf("┃        ⑴〖输入多项式a〗             ⑺〖输出多项式a+b的值〗     ┃   \n");
						printf("┃        ⑵〖输入多项式b〗             ⑻〖输出多项式a-b的值〗     ┃   \n");
						printf("┃        ⑶〖输出多项式b〗             ⑼〖输出多项式的导数〗      ┃   \n");
						printf("┃        ⑷〖输出多项式b〗             ⑽〖输出多项式ab的值〗      ┃   \n");
						printf("┃        ⑸〖输出多项式a+b〗           ⑾〖清空屏幕〗              ┃   \n");
						printf("┃        ⑹〖输出多项式a-b〗           ⑿〖结束计算〗              ┃   \n");
						printf("┃                                                                  ┃   \n");
						printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
						printf("\n");
						break;	
			   case 7:
				   return;

		       default:
	                 	printf("\n               【输入有误】，请重新输入！\n");
			}
			}
			break;
		} 
	 case 10:
		 {	          
			    printf("                【输出】多项式 ab 的整数序列为：ab=");
				pd=Multiply(pa,pb);     //调用Multiply函数，求乘积ab
				PRintf(pd);             //调用PRintf函数，输出pd链表，即ab的乘积
				printf("\n");
				break;					   
		 }

	case 11:
		      system("cls");  //清屏函数
			  printf("┣━━━━━━━━【欢迎使用一元稀疏多项式计算器】━━━━━━━━━┫   \n");
			  printf("┃                                                                  ┃   \n");
			  printf("┃        ⑴〖输入多项式a〗             ⑺〖输出多项式a+b的值〗     ┃   \n");
			  printf("┃        ⑵〖输入多项式b〗             ⑻〖输出多项式a-b的值〗     ┃   \n");
			  printf("┃        ⑶〖输出多项式b〗             ⑼〖输出多项式的导数〗      ┃   \n");
			  printf("┃        ⑷〖输出多项式b〗             ⑽〖输出多项式ab的值〗      ┃   \n");
			  printf("┃        ⑸〖输出多项式a+b〗           ⑾〖清空屏幕〗              ┃   \n");
			  printf("┃        ⑹〖输出多项式a-b〗           ⑿〖结束计算〗              ┃   \n");
			  printf("┃                                                                  ┃   \n");
			  printf("┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫   \n");
			  printf("\n");
			  break;
	case 12:
		return;
		 
	   default:
	      	printf("\n               【输入有误】，请重新输入！\n");
		}
	}
}
}
}