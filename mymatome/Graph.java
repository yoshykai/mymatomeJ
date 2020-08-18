package mymatome;

public abstract class Graph{
  int n; //頂点の数

  public Graph(int m){ //コンストラクタ
    n=m;
  }

  public int size(){ //グラフの頂点数
    return n;
  }

  abstract public void add(int v1,int v2,int d); //v1,v2間にdのパスを張る
  abstract public void add(int [][]a); //aは辺表示のグラフ
  public void addM(int []a){ //無向辺を追加 a[0]->a[1]に重みa[2]の辺
    add(a[0],a[1],a[2]);
    add(a[1],a[0],a[2]);
  }
  public void addM(int v1,int v2,int d){
    add(v1,v2,d);
    add(v2,v1,d);
  }
  public void addM(int [][]a){
    for(int i[]:a) {
      addM(i);
    }
  }
  public void addY(int []a){ //有向辺を追加
    add(a[0],a[1],a[2]);
  }
  public void addY(int v1,int v2,int d){ //有向辺を追加
    add(v1,v2,d);
  }
  public void addY(int [][]a){
    for(int i[]:a){
      addY(i);
    }
  }

  abstract public void delete(int v1,int v2); //v1->v2の辺を削除
  public void deleteM(int v1,int v2){ //v1,v2間の辺を削除
    delete(v1,v2);
    delete(v2,v1);
  }
  public void deleteY(int v1,int v2){ //v1->v2の辺を削除
    delete(v1,v2);
  }

  abstract public void deleteVer(int v); //頂点vを削除

  public static void printdist(int dist[][]){ //ダイクストラ用 距離の出力
    int len = dist.length;
    for(int i=0;i<len;i++){
      Print.pr(i+":"+dist[i][0]+" ");
      int num=dist[i][1];
      String str=""+i;
      while(num!=-1){
        str=num+"->"+str;
        num=dist[num][1];
      }
      Print.pl(str);
    }
  }

  abstract public int deg(int v); //頂点vの次数
  abstract public boolean isEdge(int v1,int v2); //v1->v2に辺が存在するか
  abstract public int getEdge(int v1,int v2); //v1->v2の辺の重みを返す
  abstract public Graph copy();
  abstract public void print();

  abstract public int[][] dijk(int v); //ダイクストラ法

  public static GraphL atol(GraphA g){ //行列表示からリスト表示へ
    GraphL l = new GraphL(g.size());
    for(int i=0;i<g.size();i++){
      for(int j=0;j<g.size();j++){
        if(g.isEdge(i,j)){
          l.add(i,j,g.getEdge(i,j));
        }
      }
    }
    return l;
  }

  public static GraphA ltoa(GraphL g){ //リスト表示から行列表示へ
    GraphA l = new GraphA(g.size());
    for(int i=0;i<g.size();i++){
      for(Integer j[]:g.g.get(i)){
        l.add(i,j[0],j[1]);
      }
    }
    return l;
  }
}
