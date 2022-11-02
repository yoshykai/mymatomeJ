package mymatome;

import java.util.*;

public class Sort{
  public static void sortA(int n[]){
    Arrays.sort(n);
  }
  public static void sortD(int n[]){
    Arrays.sort(n);
    MyArray.reverse(n);
  }
  public static void sortA(ArrayList<Integer> n){
    Collections.sort(n);
  }
  public static void sortD(ArrayList<Integer> n){
    Collections.sort(n,Collections.reverseOrder());
  }
  public static void sortA(int n[][],int i){
    Arrays.sort(n,(a, b) -> Integer.compare(a[i], b[i]));
  }
  public static void sortD(int n[][],int i){
    Arrays.sort(n,(a, b) -> Integer.compare(b[i], a[i]));
  }
}
