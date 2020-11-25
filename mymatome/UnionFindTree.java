package mymatome;

public class UnionFindTree{
  private int parent[];
  private int size;
  private int vol[];
  public UnionFindTree(int s){
    size = s;
    parent = new int[size]; vol = new int[size];
    for(int i=0;i<size;i++){parent[i]=i;vol[i]=1;}
  }
  public int root(int n){
    int k = n;
    while(parent[k]!=k){
      k = parent[k];
    }
    parent[n]=k;
    return k;
  }
  public void unite(int a,int b){
    int ra = root(a),rb = root(b);
    if(ra==rb){return;}
    if(vol[ra]<vol[rb]){
      a=ra;ra=rb;rb=a;
    }
    parent[rb]=ra;
    vol[ra]+=vol[rb];
  }
  public boolean same(int a,int b){
    return root(a)==root(b);
  }
}
