#include <stdio.h> 
#include <math.h> 
#include <stdlib.h> 
int sum=0;/*��¼�����ĸ���*/ 
int Place(int k,int *x) 
/*�ж��¼���Ļʺ����ڵ�λ�� k �Ƿ��������ʺ��λ�ó�ͻ���˺���������Ϊ�Ƿ���м�֦���ж�����*/ 
{ 
int j; 
for(j=1;j<k;j++) 
if( (abs(k-j) == abs(x[j]-x[k])) || (x[j]==x[k]) )/*x[i]��ʾ�ʺ� i �������̵ĵ� i �еĵ�x[i]��*/ 
return 0;/*�ܹ����������ʺ󣬷��� 0 */ 
return 1;/*���ܹ����������ʺ󣬷��� 1 */ 
} 

void Backtrack(int t,int n,int *x) 
/*�ݹ�������*/ 
{ 
int i; 
if(t>n) 
{ 
sum++; 
/*���һ������*/ 
printf("����%d��",sum); 
for(i=1;i<=n;i++) 
printf("(%d,%d) ",i,x[i]); 
printf("\n"); 
} 
else 
for(i=1;i<=n;i++) 
{ 
x[t]=i; 
if(Place(t,x)) Backtrack(t+1,n,x);/*����¼����t���ʺ����ڵ�λ�� i û���������ʺ��λ�ó�ͻ��������ռ���������̽��t+1���ʺ��λ�ã����򲻽��������������ö������������м�֦*/ 
} 
} 

main() 
{ 
int n,*x; 
int i; 
printf("������ʺ�ĸ�����"); 
scanf("%d",&n); 
x=(int *)malloc((n+1)*sizeof(int));/*x[0]δʹ��*/ 
printf("����ÿ����������ʾ����%d���ʺ��������ϵ�����\n\n",n); 
Backtrack(1,n,x);/*���*/ 
printf("�ܹ���%d�ַ���\n",sum); 
}
