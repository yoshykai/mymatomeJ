package mymatome;

public class GraphA extends Graph{
  int g[][];

  public GraphA(int m){
    super(m);
    g=new int[n][n];
  }

  public GraphA(int a[][]){
    super(a.length);
    g = Copy.copy(a);
  }

  public void add(int v1,int v2,int d){
    g[v1][v2]=d;
  }

  public void add(int[][]a){
    for(int i=0;i<n;i++){
      for(int j=0;j<n;j++){
        if(a[i][j]>0){
          g[i][j]=a[i][j];
        }
      }
    }
  }

  public void delete(int v1,int v2){
    g[v1][v2]=0;
  }

  public void deleteVer(int v){ //点vを削除
    int a[][] = new int[n-1][n-1];
    for(int i=0;i<v;i++){
      for(int j=0;j<v;j++){
        a[i][j]=g[i][j];
      }
      for(int j=v+1;j<n;j++){
        a[i][j-1]=g[i][j];
      }
    }
    for(int i=v+1;i<n;i++){
      for(int j=0;j<v;j++){
        a[i-1][j]=g[i][j];
      }
      for(int j=v+1;j<n;j++){
        a[i-1][j-1]=g[i][j];
      }
    }
    g = Copy.copy(a);
    n--;
  }

  public int getEdge(int v1,int v2){
    return g[v1][v2];
  }

  public int deg(int v){
    int count=0;
    for(int i=0;i<n;i++){
      if(g[v][i]>0){
        count++;
      }
    }
    return count;
  }

  public void print(){
    Print.pr(g);
  }

  public boolean isEdge(int v1,int v2){
    if(g[v1][v2]>0){
      return true;
    }
    return false;
  }

  public Graph copy(){
    return new GraphA(g);
  }

  public boolean connection(){
    boolean flg[]=new boolean[n];
    connect(0,flg);
    for(boolean b:flg){
      if(!b){return false;}
    }
    return true;
  }

  private void connect(int v,boolean flg[]){
    flg[v]=true;
    for(int i=0;i<n;i++){
      if(g[v][i]>0&&!flg[i]){
        connect(i,flg);
      }
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
      for(int i=0;i<n;i++){
        if(g[num][i]!=0&&dist[i][0]>dist[num][0]+g[num][i]){
            dist[i][0]=dist[num][0]+g[num][i];
            dist[i][1]=num;
          }
      }
    }
    return dist;
  }
}
