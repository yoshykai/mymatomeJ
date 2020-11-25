package mymatome;

public class SegmentTreeS extends SegmentTree{
  public SegmentTreeS(int x){
    super(x,0);
  }

  public int func(int a,int b){
    return a+b;
  }
}
