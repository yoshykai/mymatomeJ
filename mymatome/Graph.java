package mymatome;

public class Graph{
  int n;
  ArrayList<ArrayList<Edge>> g;
  public Graph(int nn){
    n=nn;
    g=new ArrayList<ArrayList<Edge>>();
    for(int i=0;i<n;i++){
      g.add(new ArrayList<Edge>());
    }
  }
  public void add(int a,int b,int d){
    g.get(a).add(new Edge(b,d));
    g.get(b).add(new Edge(a,d));
  }
  public void addY(int a,int b,int d){
    g.get(a).add(new Edge(b,d));
  }
  public void add(int a,int b){
    g.get(a).add(new Edge(b,1));
    g.get(b).add(new Edge(a,1));
  }
  public void addY(int a,int b){
    g.get(a).add(new Edge(b,1));
  }
  public int deg(int v){
    return g2.get(v).size();
  }

  public int[] dijkstra(int s){
    int dist[]=new int[n];
    for(int i=0;i<n;i++){dist[i]=Integer.MAX_VALUE;}
    dist[s]=0;
    PriorityQueue<int[]> q = new PriorityQueue<int[]>((a,b)->{
      return a[1]-b[1];
    });
    q.add(new int[]{s,0});
    while(q.size()>0){
      int[] p = q.poll();
      if(dist[p[0]]!=p[1]){continue;}
      for(Edge e:g.get(p[0])){
        if(dist[e.v]>dist[p[0]]+e.d){
          dist[e.v]=dist[p[0]]+e.d;
          q.add(new int[]{e.v,dist[e.v]});
        }
      }
    }
    return dist;
  }

  public void dfs(int v){dfs(v,new boolean[n]);}

  private void dfs(int v,boolean flg[]){
    flg[v]=true;
    for(Edge e:g.get(v)){
      if(!flg[e.v]){
        dfs(e.v,flg);
      }
    }
  }

  public void bfs(int s){
    boolean flg[]=new boolean[n];
    Queue<Integer> q = new ArrayDeque<Integer>();
    q.add(s);
    while(q.size()>0){
      int v = q.poll();
      flg[v]=true;
      for(Edge e:g.get(v)){
        if(!flg[e.v]){
          q.add(e.v);
          flg[e.v]=true;
    }}}
  }

  public int minspantree(){
    PriorityQueue<Edge> q = new PriorityQueue<Edge>(Comparator.comparing(Edge::getD));
    boolean flg[]=new boolean[n];
    int c=1,sum=0;
    for(Edge e:g.get(0)){
      q.add(e);
    }
    flg[0]=true;
    while(c<n){
      Edge e = q.poll();
      if(flg[e.v]){continue;}
      flg[e.v]=true;
      sum+=e.d;
      c++;
      for(Edge i:g.get(e.v)){
        if(!flg[i.v]){
          q.add(i);
        }
      }
    }
    return sum;
  }

  public int[] scc(){
    Graph g2 = new Graph(n);
    for(int i=0;i<n;i++){
      for(Edge e:g.get(i)){
        g2.addY(e.v,i);
      }
    }
    ArrayList<Integer> list = new ArrayList<Integer>();
    boolean flg[]=new boolean[n];
    for(int i=0;i<n;i++){
      if(!flg[i]){
        dfs_scc(i,flg,list);
      }
    }
    return g2.scc2(list);
  }

  public int[] scc2(ArrayList<Integer>list){
    boolean flg[]=new boolean[n];
    int ren[]=new int[n];
    int num=0;
    for(int i=n-1;i>=0;i--){
      int now = list.get(i);
      if(!flg[now]){
        dfs_scc2(now,flg,ren,num);
        num++;
      }
    }
    return ren;
  }

  private void dfs_scc(int v,boolean flg[],ArrayList<Integer>list){
    flg[v]=true;
    for(Edge e:g.get(v)){
      if(!flg[e.v]){
        dfs_scc(e.v,flg,list);
      }
    }
    list.add(v);
  }

  private void dfs_scc2(int v,boolean flg[],int num[],int now){
    flg[v]=true;
    num[v]=now;
    for(Edge e:g.get(v)){
      if(!flg[e.v]){
        dfs_scc2(e.v,flg,num,now);
      }
    }
  }

  public boolean cycle(){
    boolean seen[]=new boolean[n];
    boolean finished[]=new boolean[n];
    for(int i=0;i<n;i++){
      if(!seen[i]){
        boolean flg = cycledfs(i,seen,finished);
        if(!flg){return false;}
      }
    }
    return true;
  }

  private boolean cycledfs(int v,boolean seen[],boolean finished[]){
    seen[v]=true;
    for(Edge e:g.get(v)){
      if(!seen[e.v]){
        boolean flg = cycledfs(e.v,seen,finished);
        if(!flg){return false;}
      }else if(seen[e.v]&&!finished[e.v]){
        return false;
      }
    }
    finished[v]=true;
    return true;
  }

  public ArrayList<Integer> topolo(){
    ArrayDeque<Integer> q = new ArrayDeque<>();
    ArrayList<Integer> list = new ArrayList<>();
    for(int i=0;i<n;i++){
      if(count[i]==0){
        q.add(i);
      }
    }
    while(q.size()>0){
      int v = q.poll();
      list.add(v+1);
      for(Edge e:g.get(v)){
        count[e.v]--;
        if(count[e.v]==0){
          q.add(e.v);
        }
      }
    }
    return list;
  }

  static class Edge{
    int v,d;
    public Edge(int v,int d){
      this.v=v;this.d=d;
    }

    public int getD(){return d;}
  }
}
