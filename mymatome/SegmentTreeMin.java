package mymatome;

public class SegmentTreeMin extends SegmentTree{
  public SegmentTreeMin(int x){
    super(x,Integer.MAX_VALUE);
  }

  public int func(int a,int b){
    return Math.min(a,b);
  }
}
