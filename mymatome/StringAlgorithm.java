package mymatome;

import java.util.*;

public class StringAlgorithm{
  int n;
  int[]str;
  Integer[]suffix;
  int[]lcp;
  int[]zlcp;
  public StringAlgorithm(String s){
    n=s.length();
    stois(s);
  }

  public void makeSuffix(){
    suffix = new Integer[n];
    int rnk[]=new int[n],tmp[]=new int[n];
    for(int i=0;i<n;i++){suffix[i]=i;rnk[i]=str[i];}
    for(int k=1;k<n;k*=2){
      int k2=k;
      Arrays.sort(suffix,(x, y) -> {
        if (rnk[x] != rnk[y]) {
          return Integer.compare(rnk[x], rnk[y]);
        }
        int rx = x + k2 < n ? rnk[x + k2] : -1;
        int ry = y + k2 < n ? rnk[y + k2] : -1;
        return Integer.compare(rx, ry);
      });
      tmp[suffix[0]]=0;
      for(int i=1;i<n;i++){
        int kk=0;
        if(rnk[suffix[i-1]]<rnk[suffix[i]]){
          kk=1;
        }else{
          int rx = suffix[i-1] + k < n ? rnk[suffix[i-1] + k] : -1;
          int ry = suffix[i] + k < n ? rnk[suffix[i] + k] : -1;
          if(rx<ry){kk=1;}
        }
        tmp[suffix[i]] = tmp[suffix[i - 1]] + kk;
      }
      for(int i=0;i<n;i++){rnk[i]=tmp[i];}
    }
  }

  public void makeLCP(){
    int rnk[] = new int[n];
    lcp = new int[n-1];
    for(int i=0;i<n;i++){
      rnk[suffix[i]] = i;
    }
    int h=0;
    for(int i=0;i<n;i++){
      if(h>0){h--;}
      if(rnk[i]==0){continue;}
      int j = suffix[rnk[i]-1];
      for(;j+h<n&&i+h<n;h++){
        if(str[j+h]!=str[i+h]){
          break;
        }
      }
      lcp[rnk[i]-1] = h;
    }
  }

  public void zAlgorithm(){
    zlcp=new int[n];
    zlcp[0]=n;
    int i=1,j=0,k=1;
    while(i<n){
      while(i+j<n&&str[j]==str[i+j]){j++;}
      zlcp[i]=j;
      if(j==0){i++;continue;}
      k=1;
      while(i+k<n&&k+zlcp[k]<j){
        zlcp[i+k]=zlcp[k];k++;
      }
      i+=k;j-=k;
    }
  }

  private void stois(String s){
    str=new int[n];
    for(int i=0;i<n;i++){
      str[i]=s.charAt(i);
    }
  }
}
