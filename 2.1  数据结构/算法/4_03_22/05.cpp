#include<stdio.h>
void main() 
{ 
 int t,i,j,m=0;    //定义循环变量i 和 j,  i用来遍历从100以内的所有数字， j 用来遍历从2 到 i/2
 for(i=3;i<=100;i++) 
 {
  t=1;    //t 作为标记， 如果在2到i/2间有  i的因数，那么将 t置为0，否则保持t=0
  
  for(j=2;j<=(i/2);j++) //遍历 2到 i/2
  { 
   if(i%j==0)  //如果 i对j 求余数 等于0， 那么说明 j是i的因数， 所以i不是素数， 便将t 置为零
    t=0; 
  }
  if(t==1)   //如果经过上面的筛选后 t 还是等于1 ，那么说明 i 是素数， 将其打印处理 即可。
  { 
	  m=m+1;
	  printf("%3d ",i); 
	  if (m%5==0)
		  printf("\n");
	 
  }
 }
printf("\n");
}

