package mymatome;

public class Mymath{
  public static int gcd(int a,int b){
    if(a<b){
      int c=a;a=b;b=c;
    }
    if(b==0){return a;}
    while(a%b!=0){
      int c = a%b;
      a=b;b=c;
    }
    return b;
  }
  public static int lcm(int a,int b){
    return a*b/gcd(a,b);
  }

  public static double dist(double a[],double b[]){
    int n = a.length;
    double sum = 0;
    for(int i=0;i<n;i++){
      double tmp = a[i]-b[i];
      sum+=tmp*tmp;
    }
    return Math.sqrt(sum);
  }
  public static double dist(double x1,double y1,double x2,double y2){
    return dist(new double[]{x1,y1},new double[]{x2,y2});
  }

  public static double atan(double x1,double y1,double x2,double y2){
    return Math.atan2(x2-x1,y2-y1);
  }

  public static double dtor(double a){ //度数法->弧度法
    return a*Math.PI/180;
  }
  public static double rtod(double a){ //弧度法->度数法
    return a*180/Math.PI;
  }

  public static int sqrt(double a){
    return (int)Math.floor(Math.sqrt(a));
  }

  public static double log(double a,double x){ //底aのlog(x)
    return Math.log10(x)/Math.log10(a);
  }
}
