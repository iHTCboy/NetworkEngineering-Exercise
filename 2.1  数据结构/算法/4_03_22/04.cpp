#include<stdio.h>
void main()
{
    int x,y,z,j=0;
    printf("possible plans to buy 100 fowls with 100 wen:\n");
    for(x=0;x<=20;x++)               /*���ѭ�����Ƽ�����*/
        for(y=0;y<=33;y++)           /*�ڲ�ѭ�����Ƽ�ĸ��y��0~33�仯*/
        {
            z=100-x-y;             /*�����ѭ�������£�������z��ֵ��x,y��ֵ����Լ*/
            if(z%3==0&&5*x+3*y+z/3==100)
                                   /*��֤ȡzֵ�ĺ����Լ��õ�һ���ĺ�����*/
			 printf("%2d:cock=%2d  hen=%2d  chicken=%2d \n",++j,x,y,z);
			  
			
        }
}
