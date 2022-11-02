package mymatome;

public class Permutation{
  int n;
  int a[];
  boolean flg;

  public Permu(int n){
    this.n=n;flg=true;
    a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=i;
    }
  }
  public Permu(int aa[]){
    this.n=aa.length;flg=true;
    a=new int[n];
    for(int i=0;i<n;i++){
      a[i]=aa[i];
    }
  }
  public boolean next(){
    for (int i=n-2;i>=0;i--){
      if (a[i]<a[i+1]){
        for (int j=n-1;;j--){
          if (a[i] < a[j]){
            int temp=a[i]; a[i]=a[j]; a[j] = temp;
            i++;
            for (j=n-1;i<j;i++,j--){
              temp=a[i]; a[i] = a[j]; a[j] = temp;
            }
            return true;
          }
    }}}
    flg=false;
    return false;
  }
  public boolean before(){
    for (int i=n-2;i>=0;i--){
      if (a[i]>a[i+1]){
        for (int j=n-1;;j--){
          if (a[i] > a[j]){
            int temp=a[i]; a[i]=a[j]; a[j] = temp;
            i++;
            for (j=n-1;i<j;i++,j--){
              temp=a[i]; a[i] = a[j]; a[j] = temp;
            }
            return true;
          }
    }}}
    flg=false;
    return false;
  }
}
