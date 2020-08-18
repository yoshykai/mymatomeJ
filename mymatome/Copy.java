package mymatome;

import java.util.*;

public class Copy{
  public static int[][] copy(int[][]n){
    int h = n.length;
    int r[][] = new int[h][];
    for(int i=0;i<h;i++){
      r[i] = n[i].clone();
    }
    return r;
  }
  public static <T> ArrayList<T> copy(ArrayList<T>n){
    return new ArrayList<T>(n);
  }
}
