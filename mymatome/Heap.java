package mymatome;

import java.util.*;

public class Heap{
  ArrayList<Integer> a;
  int n;
  Heap(){
    a = new ArrayList<Integer>();
    n=0;
  }
  public void add(int x){
    a.add(x);n++;
    int w=n;
    while(w!=1){
      if(a.get(w-1)>a.get(w/2-1)){
        int k = a.get(w-1);
        a.set(w-1,a.get(w/2-1));
        a.set(w/2-1,k);
        w/=2;
      }else{
        break;
      }
    }
  }
  public void delete(){
    a.set(0,a.get(n-1));a.remove(n-1);n--;
    kouka(1);
  }
  public int max(){
    return a.get(0);
  }
  public int pop(){
    int k=max(); delete();
    return k;
  }
  private void kouka(int l){
    if(l*2>n){return;}
    int z = a.get(l-1),num=l;
    if(a.get(l*2-1)>z){
      z = a.get(l*2-1); num = l*2;
    }
    if(l*2+1<=n&&a.get(l*2)>z){
      z=a.get(l*2); num = l*2+1;
    }
    if(num!=l){
      int k = a.get(l-1); a.set(l-1,z); a.set(num-1,k);
      kouka(num);
    }
  }
}
