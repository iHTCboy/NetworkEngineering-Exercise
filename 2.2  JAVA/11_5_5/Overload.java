class Overload{
  
  int m,n;
  Overload(){
     m=0;
     n=0;
           }

  Overload(int a,int b){
     m=a;    //��ʼ������m
     n=b;    //��ʼ������n
           }

  int add(){
     System.out.println("�޲����ӷ�"+m+"+"+n+"="+(m+n));
     return m+n;
         }

  int add(int a,int b){
     System.out.println("���ͼӷ�"+a+"+"+b+"="+(a+b));
     return a+b;
         } 

  double add(double a,double b){
     System.out.println("ʵ�ͼӷ�"+a+"+"+b+"="+(a+b));
     return a+b;
         } 

  double add(int a,int b,double c){
      double sum;
     System.out.println("��ϼӷ�"+a+"+"+b+"+"+c+"="+(a+b+c));
     sum=a+b+c;
     return sum;    //���ؼӷ�����Ľ��
         } 

  public static void main(String args[]){
     int ix,iy;
     double dx,dy;
     Overload ov=new Overload();   //����һ��Overload����ov����ʼ��

     ix=ov.add();
     iy=ov.add(3,6);

     dx=ov.add(2.1,5.3);   //����ʵ�ͼӷ���������Ϊ2.1,5.3
     dy=ov.add(3,6,2.2);
        }
   }
