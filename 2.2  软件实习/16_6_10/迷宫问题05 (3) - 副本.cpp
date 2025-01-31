#include<iostream>
using namespace std;

//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义迷宫数据结构】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

class T             //定义描述迷宫中当前位置的结构类型
{
       public:
       int x;          //x代表当前位置的行坐标
       int y;          //y代表当前位置的列坐标
       int dir;        //0:无效,1:东,2:南,3:西,4:北
};


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义链表结点】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

class LinkNode        //链表结点
{
            friend class Stack;   //将外部class Stack声明为LinkNode类的友元函数
    public:
            T data;
            LinkNode *next;
};


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【定义栈数据结构】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

class Stack
{
      private:
               LinkNode *top;             //指向第一个结点的栈顶指针
      public:
              Stack();                    //构造函数，置空栈
              ~Stack();                   //析构函数
			  void Push(T e);             //把元素data压入栈中
			  T Pop();                    //使栈顶元素出栈
			  T GetPop();                 //取出栈顶元素
			  void Clear();               //把栈清空
			  bool empty();               //判断栈是否为空，如果为空则返回1，否则返回0
};


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【初始化Stack()】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

Stack::Stack()          //构造函数，置空栈
{
       top=NULL;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【初始化~Stack()】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

Stack::~Stack()         //析构函数
{
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【压栈函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡
void Stack::Push(T e)          //把元素e压入栈中
{
       LinkNode *P;
       P=new LinkNode;
       P->data=e;               //链栈【头插法】，把e插到链头
       P->next=top;
       top=P;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【出栈函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

T Stack::Pop()                 //使栈顶元素出栈
{
       T Temp;
       LinkNode *P;
       P=top;
       top=top->next;         //链栈【头取法】，把top所指data赋给Temp
       Temp=P->data;
       delete P;
       return Temp;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【取栈顶元素函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

T Stack::GetPop()               //取出栈顶元素
{
        return top->data;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【清空栈函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

void Stack::Clear()                    //把栈清空
{
        top=NULL;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【判断栈空函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

bool Stack::empty()        //判断栈是否为空，如果为空则返回1，否则返回0
{
      if(top==NULL)
		  return 1;
      else 
		  return 0;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【函数声名】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

        int move[4][2]={{0,1},{1,0},{0,-1},{-1,0}};      //定义当前位置移动的4个方向.【分别先向东、南、西、北】
		bool Mazepath(int **maze,int m,int n);           //寻找迷宫maze中从（0，0）到（m,n）的路径，如果到则返回true,否则返回false
		void PrintPath(Stack p);                         //输出迷宫的路径
		void Restore(int **maze,int m,int n);            //恢复迷宫
		int** GetMaze(int &m,int &n);                    //获取迷宫，返回存取迷宫的二维指针




//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【主函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

int main()
{
        int m=0,n=0;              //定义迷宫的长和宽
        int **maze;               //定义二维指针存取迷宫
        maze=GetMaze(m,n);        //调用GetMaze(int &m,int &n)函数，得到迷宫
        if(Mazepath(maze,m,n))    //调用Mazepath(int **maze,int m,int n)函数获取路径
		{
            cout<<"迷宫路径探索成功!\n";
		} 
        else 
		{
             cout<<"路径不存在!\n";
		}
      return 0;
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【存储迷宫函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

int** GetMaze(int &m,int &n)             //返回存取迷宫的二维指针
{
        int **maze;                      //定义二维指针存取迷宫
        int i=0,j=0;
		cout<<"【请输入】迷宫的宽和高:";
		int a,b;
		cin>>a>>b;                       //输入迷宫的宽a和高b
		cout<<"请输入迷宫内容:\n";	     //m,n分别代表迷宫的行数m和列数n
		n=a;
		m=b; 
		maze=new int *[m+2];             //申请长度等于行数加2的二级指针【这句就是给一个指向指针的指针动态分配m+2个存放int类型指针的数组，用于动态申请二维数组。】
		for(i= 0;i<m+2;i++)              //申请每个二维指针的空间
			
		{
			maze[i]=new int[n+2];
		}
		for(i=1;i<=m;i++)                //输入迷宫的内容，0代表可通，1代表不通
		{
           for(j=1;j<=n;j++)
		   {
               cin>>maze[i][j];
		   } 
		}
        for(i=0;i<m+2;i++)
		{
              maze[i][0]=maze[i][n+1]=1;    //使纵向围墙为1，就是0列和6列纵向
		}
        for(i=0;i<n+2;i++) 
		{
             maze[0][i]=maze[m+1][i]=1;     //使横向围墙为1，就是0行和6行横向
		}
        return maze;                        //返回存贮迷宫的二维指针maze
}; 


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【寻找迷宫路径函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

bool Mazepath(int **maze,int m,int n)           //寻找迷宫maze中从（1，1）到（m,n）的路径，如果到则返回true,否则返回false
{
      Stack q,p;                                //定义栈p、q,分别存探索迷宫的过程和存储路径
      T Temp1,Temp2;       
      int x,y,loop;
      Temp1.x=1;
      Temp1.y=1;
      q.Push(Temp1);                             //将入口位置入栈
      p.Push(Temp1);
      maze[1][1]=-1;                             //标志入口位置已到达过
      while(!q.empty())                          //栈q非空，则反复探索
      {
         Temp2=q.GetPop();                       //获取栈顶元素
           if(!(p.GetPop().x==q.GetPop().x&&p.GetPop().y==q.GetPop().y)) 
		   {
                 p.Push(Temp2);                   //如果有新位置入栈，则把上一个探索的位置存入栈p  
		   } 
          for(loop=0;loop<4;loop++)               //探索当前位置的4个相邻位置
		  { 
              x=Temp2.x+move[loop][0];            //计算出新位置行x位置值（move分别=0、1、0、-1）
              y=Temp2.y+move[loop][1];            //计算出新位置列y位置值（move分别=1、0、-1、0）
              if(maze[x][y]==0)                       //判断新位置是否可达
			  {
                    Temp1.x=x;                    //把可行路径的行x、列y坐标赋给Temp
                    Temp1.y=y;
                    maze[x][y]=-1;                //标志新位置已到达过
                    q.Push(Temp1);                //新位置入栈【临时栈q】
			  }  
              if((x==m)&&(y==n))                  //成功到达出口
			  {
                    Temp1.x=m;                    //把出口的行x、列y坐标赋给Temp
					Temp1.y=n;
					Temp1.dir=0;
					p.Push(Temp1); 					  //把最后一个位置入栈p
					PrintPath(p);                     //输出路径
					Restore(maze,m,n);                //恢复路径
					return 1;                         //表示成功找到路径
			  } 
		  }
          if(p.GetPop().x==q.GetPop().x&&p.GetPop().y==q.GetPop().y)   //如果没有新位置入栈，则返回到上一个位置
		  {
                   p.Pop();
                   q.Pop();
		  }
	  }
           return 0;                       //表示查找失败，即迷宫无路经
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【输出路径函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡

void PrintPath(Stack p)                            //输出路径
{
	cout<<"【输出】迷宫的路径为：\n";
	cout<<"括号内的内容分别表示为(行坐标,列坐标,数字化方向,方向)\n";
 	Stack t;                                      //定义一个栈，按从入口到出口存取路径
 	int a,b;
 	T data;
 	LinkNode *temp;
 	temp=new LinkNode;                           //申请空间
	temp->data=p.Pop();                          //取栈p的顶点元素，即第一个位置
	t.Push(temp->data);                          //第一个位置入栈t
	delete temp;                                 //释放空间

 	while(!p.empty())                            //栈p非空，则反复回首转移
 	{
 		temp=new LinkNode;
 		temp->data=p.Pop();                      //获取下一个位置，得到行走方向
  		a=t.GetPop().x-temp->data.x;             //行坐标方向
  		b=t.GetPop().y-temp->data.y;             //列坐标方向
 		if(a==1) 
 		{
  			temp->data.dir=1;                    //方向向下，用1表示
  		}
  		else if(b==1) 
  		{
  			temp->data.dir=2;                    //方向向右，用2表示
  		}
 		else if(a==-1) 
  		{
  			temp->data.dir=3;                    //方向向上，用3表示
  		}
  		else if(b==-1) 
  		{
  	    	temp->data.dir=4;                    //方向向左，用4表示
  		}
  		t.Push(temp->data);                      //把新位置入栈
  		delete temp;
	}
 
	while(!t.empty())                           //栈非空，循环输出路径，包括行坐标、列坐标、下一个位置方向
	{
   		 data=t.Pop();
    		cout<<'('<<data.x<<','<<data.y<<','<<data.dir<<",";  //输出行x坐标，列y坐标
    		switch(data.dir)                                     //输出相应的方向 
    		{
    		case 1:cout<<"↓)\n";break;
    		case 2:cout<<"→)\n";break;
    		case 3:cout<<"↑)\n";break;
    		case 4:cout<<"←)\n";break;
    		case 0:cout<<")\n";break;
    		}
	} 
}


//╞╪╪╪╪╪╪╪╪╪╪╪╪╪╪【恢复函数】╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╪╡
void Restore(int **maze,int m,int n)       //恢复迷宫
{
 int i,j;
 for(i=0;i<m+2;i++)            //遍历指针
  for(j=0;j<n+2;j++)       
  {
   if(maze[i][j]==-1)         //恢复探索过位置，即把-1恢复为0
    maze[i][j]=0;
  }
}
