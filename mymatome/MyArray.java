package mymatome;

import java.util.*;

public class MyArray{
  public static int[] append(int a[],int b[]){ //配列の結合
    int c[] = new int[a.length+b.length];
    int s=a.length,l=b.length;
    for(int i=0;i<s;i++){
      c[i]=a[i];
    }
    for(int i=0;i<l;i++){
      c[i+s]=b[i];
    }
    return c;
  }
  public static int[] append(int a[],int b){ //配列に値を追加する
    int c[] = new int[a.length+1];
    int s=a.length;
    for(int i=0;i<s;i++){
      c[i]=a[i];
    }
    c[s] = b;
    return c;
  }
  public static <T> ArrayList<T> append(ArrayList<T>a,ArrayList<T>b){ //リストの結合
    ArrayList<T> c = new ArrayList<T>(a);
    c.addAll(b);
    return c;
  }

  public static int[] makeArray(ArrayList<Integer> array){ //List->配列
    Integer[] result=new Integer[array.size()];
    array.toArray(result);
    return Trans.Itoi(result);
  }
  public static ArrayList<Integer> makeList(int[] array){ //配列->List
    Integer[]ar = Trans.itoI(array);
    List<Integer> re = Arrays.asList(ar);
    ArrayList<Integer> result = new ArrayList<Integer>(re);
    return result;
  }
  public static void exchange(int a[],int i,int j){
    int k=a[i];a[i]=a[j];a[j]=k;
  }
  public static void exchange(long a[],int i,int j){
    long k=a[i];a[i]=a[j];a[j]=k;
  }
  public static <T>void exchange(T a[],int i,int j){
    T k=a[i];a[i]=a[j];a[j]=k;
  }
  public static <T>void exchange(ArrayList<T>a,int i,int j){
    T k=a.get(i);a.set(i,a.get(j));a.set(j,k);
  }
  public static void reverse(int a[]){ //配列を逆順に
    int n=a.length;
    for(int i=0;i<n/2;i++){
      exchange(a,i,n-i-1);
    }
  }
  public static void reverse(long a[]){
    int n=a.length;
    for(int i=0;i<n/2;i++){
      exchange(a,i,n-i-1);
    }
  }
  public static <T>void reverse(T a[]){ 
    int n=a.length;
    for(int i=0;i<n/2;i++){
      exchange(a,i,n-i-1);
    }
  }
}
