package mymatome;

public class Time{
  private static long t=-1;
  public static long nowTime(){ //今の時間を返す
    return System.currentTimeMillis();
  }
  public static void record(){ //計測開始
    t = nowTime();
  }
  public static long progress(){ //経過時間(時間はリセットされる)
    long s = t; t = nowTime();
    return t-s;
  }
}
