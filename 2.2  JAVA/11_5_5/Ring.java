class Ring{
  private double innerRadius;
  private double outerRadius;

  public String color;

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
