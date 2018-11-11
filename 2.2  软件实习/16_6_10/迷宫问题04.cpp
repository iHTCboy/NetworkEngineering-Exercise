#include <stdio.h>
#include <malloc.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>

#define TRUE        1
#define FALSE       0
#define OK          1
#define ERROR       0
#define INFEASIBLE -1
#define NULL       0 

#define WALL  0         
#define PATH  1         
#define RIGHT -1        
#define DOWN -2       
#define LEFT -3        
#define UP   -4        
#define BACK -5        
#define DESTINATION -6


typedef int Status;
typedef int MazeType[10][10];
typedef int ElemType;

typedef struct{
	int x;
	int y;
}PosType;//�Թ��е�λ������

typedef struct
{
	int ord;
	PosType seat;
	int di;
}SElemType;//ջԪ������

typedef struct
{
	SElemType *base;
	SElemType *top;
	int stacksize;
}Stack;//ջ����





#define STACK_INIT_SIZE  1000
#define STACKINCREMENT   100
 typedef struct
 {
     SElemType *base; //ջ��ָ��
     SElemType *top;  //ջ��ָ��
     int   stacksize; //ջ����
 }SqStack;

Status InitStack(SqStack &S)
{
//�����ջS  
 S.base=(SElemType*)malloc(STACK_INIT_SIZE*sizeof(SElemType));
  if(!S.base)exit(OVERFLOW);    //�洢����ʧ��
  S.top=S.base;   //��ջ
  S.stacksize=STACK_INIT_SIZE;
  return(OK);
}//InitStack  ���Ӷ�"O(1)"


Status Push(SqStack &S, SElemType e){
//����eΪջ��Ԫ��
   if(S.top-S.base==S.stacksize){//ջ����Ӧ���·���ռ�
     S.base=(SElemType *)
         realloc(S.base,(S.stacksize+STACKINCREMENT)*sizeof(SElemType));
     if(!S.base)exit(OVERFLOW);
     S.top=(S.base+S.stacksize);//ʹ��S.top����ָ��ջ��,��realloc
     S.stacksize+=STACKINCREMENT;
   }
   *S.top ++=e;    //topָ�������λ��    
   return(OK);
}//Push ,���Ӷ�O(1)


Status Pop(SqStack &S,SElemType &e){
    //��ջ������ջ��Ԫ�س�ջ����e������ֵ
    if(S.top==S.base)return ERROR;
    e=*(--S.top);     //ջ��Ԫ��Ϊ*(S.top-1)
     return OK;
} //���Ӷ�O(1)

Status StackEmpty(SqStack S)
{                                                             //�ж�ջ�Ƿ�Ϊ��
	if(S.top==S.base)	return TRUE;
	else		return FALSE;
}

Status GetTop(SqStack &S,SElemType &e)
{                                                                    //����ջ��Ԫ��
	e=*S.top;
	return OK;
}

Status StackTraverse(SqStack S,Status (*visit)(SElemType)){
	//��ջ��Ԫ�ص�ջ��Ԫ������ִ��visit������ͨ���������ջ��Ԫ��
	SElemType *p=S.base;	
	if(S.base==S.top)printf("��ջ\n");
	else
		while(p<S.top){(*visit)(*p);++p;}
	return OK;
}

Status PrintSElem(SElemType e){
	printf("step:%d to (%d,%d)\n",e.ord,e.seat.x,e.seat.y);
	return OK;
}



Status InitMaze(MazeType &maze){//�����Թ�,"0"��ʾͨPATH��"1"��ʾ��ͨWALL
	PosType m;
	srand(time(NULL));
	for(m.y=0;m.y<=9;m.y++)	{maze[0][m.y]=WALL;maze[9][m.y]=WALL;}
    for(m.x=1;m.x<=8;m.x++)	{maze[m.x][0]=WALL;maze[m.x][9]=WALL;}
    for(m.x=1;m.x<=8;m.x++)
		for(m.y=1;m.y<=8;m.y++)
			maze[m.x][m.y]=rand()%2;
	return OK;
}//MakeMaze

Status  OutputMaze(MazeType maze)
{
    int i,j;
	for(i=0;i<=9;i++)
	{
		printf("\t");
		for(j=0;j<=9;j++)
		{

			switch(maze[i][j])
				{
					case RIGHT	    : printf("��");	break;
				    case DOWN   	: printf("��");	break;
			     	case LEFT	    : printf("��");	break;
				    case UP		    : printf("��");	break;
			        case PATH       : printf("  "); break;
				    case BACK	    : printf("@");	break;
					case WALL	    : printf("��");	break;
					case DESTINATION: printf("*"); break;
			}
		}
		printf("\n" );
	}
	return OK;
}
		
Status FootPrint(MazeType &maze,PosType curpos,int di)
{
	
	switch(di)
	{
		
	    case RIGHT	    : maze[curpos.x][curpos.y]=RIGHT;	    break;
        case UP         : maze[curpos.x][curpos.y]=UP;          break;
		case DOWN	    : maze[curpos.x][curpos.y]=DOWN;	    break;
		case LEFT   	: maze[curpos.x][curpos.y]=LEFT;	    break;
		case BACK       : maze[curpos.x][curpos.y]=BACK;        break;

	}
	return OK;
}
		

PosType Nextpos(PosType pos,int di)
{
	switch(di){
	      case 1  :pos.x=pos.x,pos.y++;     break;
		  case 2  :pos.x++,pos.y=pos.y;     break;
		  case 3  :pos.x=pos.x,pos.y--;     break;
		  case 4  :pos.x--,pos.y=pos.y;     break;
	}
	return pos;
}


Status PassMaze(MazeType &maze,PosType start,PosType end,SqStack &S){//�ҳ��Թ���һ��ͨ·
    PosType curpos;
	SElemType e;
	int curstep=1;
	curpos=start;
    if(maze[curpos.x][curpos.y]!=PATH) { printf("��ǰ�Թ�û�����\n"); return FALSE;}
	do{   
	    if(maze[curpos.x][curpos.y]==PATH){//��ǰλ�ÿ�ͨ
			e.ord=curstep;
			e.seat=curpos;
			e.di=1;
			Push(S,e);
			if(curpos.x==end.x&&curpos.y==end.y){maze[curpos.x][curpos.y]=DESTINATION;return OK;}
			else{				   
				maze[curpos.x][curpos.y]=RIGHT;//����������
				curpos=Nextpos(curpos,1);
				curstep++;
			}
		}
		else{//��ǰλ�ò�ͨ
			GetTop(S,e);			
			while(!StackEmpty(S)&&e.di==4){
				maze[e.seat.x][e.seat.y]=BACK;
				Pop(S,e);
				curstep--;
				if(StackEmpty(S))break;
				GetTop(S,e);
			}
			if(e.di<4){  //ջ��λ���������������ѡ��
			    Pop(S,e); e.di++; Push(S,e);
				maze[e.seat.x][e.seat.y]=-e.di;   //ע��ǰ�������ټ���e.di��Ϊ�෴��
                curpos=Nextpos(e.seat,e.di);
			}
		}
	}while(!StackEmpty(S));
    return FALSE;
}




Status OutPutWay(SqStack &S,SqStack &Q)
{
	
	SElemType e;
	InitStack(Q);
	if(StackEmpty(S)) return FALSE;
	else 
		while(!StackEmpty(S))
		{
			Pop(S,e);
			Push (Q,e);		
		}
		printf("����·����:\n");
        while (!StackEmpty(Q))
		{
			Pop(Q,e);
			printf("��%2d����(%2d,%2d)\n",e.ord,e.seat.x,e.seat.y);
		}
		return OK;
}


void main(){
    MazeType maze;
	PosType start,end;
	SqStack S,Q;
	InitStack(S);
	InitMaze(maze);
	printf("��ʼ�Թ�Ϊ��\n");
	OutputMaze(maze);
	printf("�����Թ������λ�������(0,0)��(9,9): ");
    scanf("%d,%d",&start.x,&start.y);
	printf("�����Թ��ĳ���λ�������(0,0)��(9,9): ");
	scanf("%d,%d",&end.x,&end.y);
	if(PassMaze(maze,start,end,S)){
		printf("�Թ���ͨ,·���ټ�����:\n");
	    OutputMaze(maze);
		printf("����·��Ϊ��\n");
		StackTraverse(S,PrintSElem);
	}
	else{
		printf("�Թ�����ͨ,·���ټ�����:\n");
	    OutputMaze(maze);
	}

	printf("---------------�����������ּ�����------------------");
	int pause;
	scanf("%d",&pause);
}
