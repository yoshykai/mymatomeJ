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
  public static void sortA(long n[]){
    Arrays.sort(n);
  }
  public static void sortD(long n[]){
    Arrays.sort(n);
    MyArray.reverse(n);
  }
  public static <T extends Comparable<T>> void sortA(T n[]){
    Arrays.sort(n);
  }
  public static <T extends Comparable<T>> void sortD(T n[]){
    Arrays.sort(n);
    MyArray.reverse(n);
  }
  public static <T extends Comparable<T>> void sortA(ArrayList<T> n){
    Collections.sort(n);
  }
  public static <T extends Comparable<T>> void sortD(ArrayList<T> n){
    Collections.sort(n,Collections.reverseOrder());
  }
  public static void sortA(int n[][],int i){
    Arrays.sort(n,(a, b) -> Integer.compare(a[i], b[i]));
  }
  public static void sortD(int n[][],int i){
    Arrays.sort(n,(a, b) -> Integer.compare(b[i], a[i]));
  }
}
