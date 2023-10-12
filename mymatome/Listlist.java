package mymatome;
import java.util.*;

public class Listlist<T>{
  ArrayList<ArrayList<T>> list;
  public Listlist(int n){
    list = new ArrayList<ArrayList<T>>();
    for(int i=0;i<n;i++){
      list.add(new ArrayList<T>());
    }
  }
  public void add(int index,T num){
    list.get(index).add(num);
  }
  public T get(int index,int indexs){
    return list.get(index).get(indexs);
  }
  public ArrayList<T> get(int index){
    return list.get(index);
  }
  public int size(){
    return list.size();
  }
  public int size(int index){
    return list.get(index).size();
  }
}
