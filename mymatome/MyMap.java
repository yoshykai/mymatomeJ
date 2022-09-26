package mymatome;

import java.util.*;

public class MyMap<T>{
  HashMap<T,Integer> map;
  boolean mFlg; //0以下を許容するか

  public MyMap(){
    this(false);
  }

  public MyMap(boolean flg){
    map = new HashMap<>();
    mFlg = flg;
  }

  public void put(T a){
    put(a,1);
  }

  public void put(T a,int n){
    map.put(a,n);
    delM(a);
  }

  public void add(T a){
    add(a,1);
  }

  public void add(T a,int n){
    if(map.containsKey(a)){
      map.replace(a,get(a)+n);
    }else{
      map.put(a,n);
    }
    delM(a);
  }

  private void delM(T a){
    if(mFlg&&get(a)<=0&&contain(a)){
      map.remove(a);
    }
  }

  public boolean contain(T a){
    return map.containsKey(a);
  }

  public int size(){
    return map.size();
  }

  public int get(T a){
    if(!contain(a)){
      return 0;
    }
    return map.get(a);
  }
}
