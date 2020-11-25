package mymatome;

public class Rand{
  public static int randI(int min,int max){ //min以上max以下の乱数を返す(整数値)
    return min+(int)(Math.random()*(max-min+1));
  }
  public static int randI(int max){ //0以上max以下の乱数を返す(整数値)
    return randI(0,max);
  }
  public static int[] randI(int size,int min,int max){ ////min以上max以下の乱数がsize個の配列を返す
    int[] a = new int[size];
    for(int i=0;i<size;i++){
      a[i] = randI(min,max);
    }
    return a;
  }
  public static long randL(long min,long max){ //min以上max以下の乱数を返す(整数値)
    return min+(long)(Math.random()*(max-min+1));
  }
  public static long randL(long max){ //0以上max以下の乱数を返す(整数値)
    return randL(0,max);
  }
  public static long[] randL(int size,long min,long max){ ////min以上max以下の乱数がsize個の配列を返す
    long[] a = new long[size];
    for(int i=0;i<size;i++){
      a[i] = randL(min,max);
    }
    return a;
  }
  public static double randD(double min,double max){ //min以上max未満の乱数を返す
    return min+(Math.random()*(max-min));
  }
  public static double randD(double max){ //0以上max未満の乱数を返す(整数値)
    return randD(0,max);
  }
  public static double[] randD(int size,double min,double max){ ////min以上max未満の乱数がsize個の配列を返す
    double[] a = new double[size];
    for(int i=0;i<size;i++){
      a[i] = randD(min,max);
    }
    return a;
  }
}
