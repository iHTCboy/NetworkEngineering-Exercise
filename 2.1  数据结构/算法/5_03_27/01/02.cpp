#include <stdio.h>
int a[10],s=0;
void main()
{ int put(int k);
put(1); // ���õݹ麯��put(1) 
printf(" ��������%d���⡣\n",s);
}
// �ű�����ʽ�ݹ麯�� 
#include <stdio.h>
int put(int k)
{ int i,j,u,m1,m2,m3;
if(k<=9)
{ for(i=1;i<=9;i++) // ̽����k������ȡֵi 
{ a[k]=i;
for(u=0,j=1;j<=k-1;j++)
if(a[k]==a[j]) 
u=1; // �����ظ�����,����u=1 
if(u==0) // ����k�����ֿ�Ϊi 
{ if(k==9 && a[1]<a[4]) // ���ѣ������֣������ʽ 
{m1=a[2]*10+a[3];m2=a[5]*10+a[6];
m3=a[8]*10+a[9];
if(a[1]*m2*m3+a[4]*m1*m3==a[7]*m1*m2)
{ s++; printf(" <->: ",s);  // ���һ���� 
printf("%d/%d+%d/%d",a[1],m1,a[4],m2);
printf("=%d/%d ",a[7],m3);
if(s%2==0) printf("\n");
}
}
else put(k+1); // �������������֣������ put(k+1) 
}
}
}
return s;
} 
