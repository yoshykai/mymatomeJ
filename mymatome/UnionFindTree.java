package mymatome;

public class UnionFindTree{
  private int parent[]; //要素の親
  private int size; //配列サイズ
  private int vol[]; //集合の個数

  public UnionFindTree(int s){
    size = s;
    parent = new int[size]; vol = new int[size];
    for(int i=0;i<size;i++){parent[i]=i;vol[i]=1;}
  }

  //要素の根を求める
  public int root(int n){
    if(parent[n]==n){
      return n;
    }
    parent[n]=root(parent[n]); //経路圧縮
    return parent[n];
  }

  //aの集合とbの集合の併合
  public void unite(int a,int b){
    int ra = root(a),rb = root(b);
    if(ra==rb){return;}
    if(vol[ra]<vol[rb]){
      a=ra;ra=rb;rb=a;
    }
    parent[rb]=ra;
    vol[ra]+=vol[rb];
  }

  //要素aとbが同じ集合に属するかどうか
  public boolean same(int a,int b){
    return root(a)==root(b);
  }
}
