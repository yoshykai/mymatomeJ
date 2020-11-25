package mymatome;

public class BIT{
  int n;
  int ar[];
  public BIT(int x){
    n=x+1;
    ar = new int[n];
    for(int i=0;i<n;i++){ar[i]=0;}
  }

  public void update(int i,int x){
    i++;
    for(int ii=i;ii<n;ii+=(ii&-ii)){
      ar[ii]+=x;
    }
  }

  public int sum(int i){
    int k=0;
    for(int ii=i;ii>0;ii-=(ii&-ii)){
      k+=ar[ii];
    }
    return k;
  }

  private int twon(int x){
    int i=1;
    while(i<x){
      i*=2;
    }
    return i;
  }

  public void print(){
    Print.pr(ar);
  }
}
