class Ring{
  private double innerRadius;
  private double outerRadius;

  public String color;
  
  public Ring()
  {}

  public Ring(double iRadius,double oRadius,String c){
    innerRadius=iRadius;
    outerRadius=oRadius;        //��ʼ����뾶
    color=c;
      }

  public double getInnerRadius(){
    return innerRadius;     //�����ڰ뾶
            }
  
  public double getOuterRadius(){
     return outerRadius;
        }
 
  public void setInnerRadius(double iRadius){
      innerRadius=iRadius;
    }

  public void setOuterRadius(double oRadius){
      outerRadius=oRadius;
    }

  public void setColor(String c){
    color=c;    //������ɫ
       }
public double inlong()               //�������ܳ�
{
    return (innerRadius)*2*3.1415;
}

public double outlong()              //�������ܳ�
{
    return (outerRadius*2*3.1415);
}

  public double getArea(){
    return (outerRadius*outerRadius-innerRadius*innerRadius)*3.1415;
                  }

  public static void main(String[] args){
    Ring ring=new Ring(5,8,"red");
    Ring ring1=new Ring(5,8,"red");
    Ring ring2=new Ring(5,8,"red");

    System.out.println("Բ�����ڰ뾶��"+ring.getInnerRadius());
    System.out.println("Բ������뾶��"+ring.getOuterRadius());
    System.out.println("Բ������ɫ��"+ring.color);
    System.out.println("Բ���������"+ring.getArea());
    System.out.println("Բ�������ܳ���"+ring1.inlong());
    System.out.println("Բ�������ܳ���"+ring2.outlong()+"\n");
    
    ring.setInnerRadius(4);
    ring.setOuterRadius(6);    //����Բ��ring����뾶Ϊ6
    ring.setColor("blue");
   
    System.out.println("Բ�����ڰ뾶��"+ring.getInnerRadius());
    System.out.println("Բ������뾶��"+ring.getOuterRadius());
    System.out.println("Բ������ɫ��"+ring.color);
    System.out.println("Բ���������"+ring.getArea());
    System.out.println("Բ�������ܳ���"+ring.inlong());
    System.out.println("Բ�������ܳ���"+ring.outlong());

           }
      }
