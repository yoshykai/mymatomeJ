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

  public static int pow(int x,int n){ //x^n
    int k = 1;
    while(n>1){
      if(n%2==1){
        k*=x;
      }
      x*=x;
      n/=2;
    }
    return k*x;
  }

  public static long safeMultiply(long left, long right){
    if (right > 0 ? left > Long.MAX_VALUE/right || left < Long.MIN_VALUE/right :
       (right < -1 ? left > Long.MIN_VALUE/right || left < Long.MAX_VALUE/right :
        right == -1 && left == Long.MIN_VALUE) ) {
          return -1;
    }
    return left * right;
  }

  public static long modpow(long x,long n,long mod){
    long r = 1;
    while(n>=1){
      if(1==(n&1)){
        r = r*x % mod;
      }
      x = x*x % mod;
      n/=2;
    }
    return r;
  }
  public static long modinv(long a,long mod){
    long x1=1,x2=0;
    long p=mod,q,t;
    while(a%p!=0){
      q = a/p;
      t = x1-q*x2;
      x1=x2; x2=t;
      t=a%p;
      a=p; p=t;
    }
    return x2<0 ? x2+mod : x2;
  }
}
