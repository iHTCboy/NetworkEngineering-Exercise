import net.sf.hibernate.*;
import net.sf.hibernate.cfg.*;
public class Test {
public static void main(String[] args) {
try {
//����SessionFactoryʵ��
                      SessionFactory sf = new Configuration().configure().buildSessionFactory();
                       //����Sessionʵ��
                      Session session = sf.openSession();
                  Transaction tx = session.beginTransaction();
                    for (int i = 0; i < 200; i++) {
                          Customer customer = new Customer();
                          customer.setUsername("customer" + i);
                          customer.setPassword("customer");
                          //����customer�����ݿ���
session.save(customer); 
                    }
                    tx.commit(); //�ύ����
                    session.close(); //�ر�Session
} catch (HibernateException e) {
                  e.printStackTrace();
}
}
 }
