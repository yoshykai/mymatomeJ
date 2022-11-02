public class WeightUnionFindTree{
  int parent[];
  int size;
  int vol[];
  int diff[];

  public WeightUnionFindTree(int s){
    size = s;
    parent = new int[size]; vol = new int[size]; diff = new int[size];
    for(int i=0;i<size;i++){parent[i]=i;vol[i]=1;diff[i]=0;}
  }

  public int root(int n){
    if(parent[n]==n){
      return n;
    }
    int r = root(parent[n]);
    diff[n] += diff[parent[n]];
    parent[n]=r;
    return parent[n];
  }

  public int weight(int n){
    root(n);
    return diff[n];
  }

  public void unite(int a,int b,int w){
    int ra = root(a),rb = root(b);
    if(ra==rb){return;}
    w+=weight(a);w-=weight(b);
    if(vol[ra]<vol[rb]){
      a=ra;ra=rb;rb=a;w=-w;
    }
    parent[rb]=ra;
    vol[ra]+=vol[rb];
    diff[rb]=w;
  }

  public int differ(int a,int b){
    return weight(a)-weight(b);
  }

  public boolean same(int a,int b){
    return root(a)==root(b);
  }
}
