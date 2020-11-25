package mymatome;

public abstract class SegmentTree{
  private int n,leafN;
  private int ar[];
  private int temp;
  public SegmentTree(int x,int temp){
    n=x;this.temp=temp;
    leafN = twon(n);
    ar = new int[leafN*2-1];
    for(int i=0;i<leafN*2-1;i++){ar[i]=temp;}
  }

  public abstract int func(int a,int b);

  public void update(int i,int x){
    int now = i+leafN-1;
    ar[now] = x;
    while(now>0){
      now = (now-1)/2;
      ar[now] = func(ar[now*2+1],ar[now*2+2]);
    }
  }

  public int query(int a,int b){
    return query(a,b,0,0,n);
  }

  public int query(int a,int b,int k,int l,int r){
    if(r<=a||b<=l){
      return temp;
    }else if(a<=l&&r<=b){
      return ar[k];
    }
    return func(query(a,b,k*2+1,l,(l+r)/2),query(a,b,k*2+2,(l+r)/2,r));
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
