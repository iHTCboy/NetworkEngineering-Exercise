public class Circle {

	public static double pi;
	public static int sum;
	private double rad;
	
	Circle(double P,int S,double r)
	{
		pi=P;
		sum=S;
		rad=r;
	}
	
	static void szpi()
	{
		System.out.println("Բ����Ϊ��"+pi);
	}
	static void yuan()
	{
		System.out.println("Բ����Ϊ��"+sum);
	}
	void bj()
	{
		System.out.println("Բ�뾶Ϊ��"+rad);
	}
	
	public static void main(String[] args) {
		Circle t=new Circle(3.14,5,2.7);
		Circle.szpi();
		Circle.yuan();
		t.bj();

	}

}
