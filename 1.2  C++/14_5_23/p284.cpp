# include <iostream>
using namespace std;
template <typename T>//ģ������������TΪ���Ͳ���
class compare//��ģ����Ϊcompare
{
    public:
	  compare(T a,T b)
	  {
	     x=a;  y=b;
	  }
       T min();
	 private:
	   T x,y;
};
template<typename T>// ģ������
T compare<T>::min()//����ģ�����ⶨ���Ա����min����������ΪT
{
	return(x<y)?x:y;
}
int main()
{
   compare <int> com1(3,7);//����ģ�嶨�����com1����ʱT��int���
   cout<<"���е���Сֵ�ǣ�"<<com1.min()<<endl;
   return 0;

}