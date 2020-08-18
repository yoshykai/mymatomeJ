package mymatome;

import java.util.*;

public class GraphL extends Graph{
  ArrayList<ArrayList<Integer[]>> g;
  ArrayList<HashMap<Integer,Integer>> g2;

  public GraphL(int m){
    super(m);
    g2 = new ArrayList<HashMap<Integer,Integer>>();
    for(int i=0;i<n;i++){
      g2.add(new HashMap<>());
    }
  }

  public GraphL(ArrayList<ArrayList<Integer[]>>m){
    super(m.size());
  }

  public void add(int v1,int v2,int d){
    g2.get(v1).put(v2,d);
  }
  public void add(int[][]a){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(a[i][j]>0){
          g2.get(i).put(j,a[i][j]);
        }
      }
    }
  }

  public void delete(int v1,int v2){
    int k = indexOf(g.get(v1),v2);
    if(k!=-1){
      g2.get(v1).remove(v2);
    }
  }

  public void deleteVer(int v){ //点vを削除
    for(int i=0;i<n;i++){
      if(i==v){continue;}
      int now=0; boolean flg=true;
      while(flg){
        flg=false;
        for(int j:g2.get(i).keySet()){
          if(now<=j){
            now=j+1;
            if(j==v){
              g2.get(i).remove(j);
              flg=true;
              break;
            }else if(j>v){
              g2.get(i).put(j-1,g2.get(i).get(j));
              g2.get(i).remove(j);
              flg=true;
              break;
            }
          }
        }
      }
    }
    g2.remove(v);
    n--;
  }

  public int getEdge(int v1,int v2){
    Integer k = g2.get(v1).get(v2);
    int r=0;
    if(k==null){
      return 0;
    }
    return k;
  }

  public int deg(int v){
    return g2.get(v).size();
  }

  public boolean isEdge(int v1,int v2){
    return g2.get(v1).get(v2)!=null;
  }

  public Graph copy(){
    return new GraphL(g);
  }

  public void print(){
    for(int i=0;i<n;i++){
      Print.pr(i+": ");
      for(int j:g2.get(i).keySet()){
        Print.pr("("+j+" "+g2.get(i).get(j)+") ");
      }
      Print.n();
    }
  }

  public int[][] dijk(int v){
    int dist[][]=new int[n][2];
    boolean flg[]=new boolean[n];
    for(int i=0;i<n;i++){
      dist[i][0]=10000000;
      dist[i][1]=-1;
    }
    dist[v][0]=0;
    for(int co=0;co<n-1;co++){
      int min = 10000001,num=-1;
      for(int i=0;i<n;i++){
        if(!flg[i]&&min>dist[i][0]){
          num=i;min=dist[i][0];
        }
      }
      if(num==-1){break;}
      flg[num]=true;
      for(Integer i[]:g.get(num)){
        if(dist[i[0]][0]>dist[num][0]+i[1]){
            dist[i[0]][0]=dist[num][0]+i[1];
            dist[i[0]][1]=num;
          }
      }
    }
    return dist;
  }

  private int indexOf(ArrayList<Integer[]> list,int v){
    for(int i=0;i<list.size();i++){
      if(list.get(i)[0]==v){
        return i;
      }
    }
    return -1;
  }

  private boolean contains(ArrayList<Integer[]> list,int v){
    if(indexOf(list,v)==-1){
      return false;
    }
    return true;
  }
}
