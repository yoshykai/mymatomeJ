package mymatome;

public class Compress{
  ArrayList<Integer> a;
  HashMap<Integer,Integer> map;

  public Compress(int[]b){
    HashSet<Integer> temp = new HashSet<>();
    for(int i:b){
      temp.add(i);
    }
    a=new ArrayList<Integer>(temp);
    setup();
  }

  public Compress(ArrayList<Integer>b){
    a=new ArrayList<Integer>(new HashSet<Integer>(b));
    setup();
  }

  private void setup(){
    map = new HashMap<>();
    sortA(a);
    for(int i=0;i<a.size();i++){
      map.put(a.get(i),i);
    }
  }

  public int get(int i){
    return map.get(i);
  }
}
