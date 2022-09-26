package mymatome;

import java.util.*;

public class Btree{
  class Node{
    Node left,middle,right;
    int num[];
    boolean active;

    public Node(){
      left=null; middle=null; right=null;
      num = new int[]{-1,-1};
      active=true;
    }

    Node remake(int a1,int a2,Node l,Node m,Node r,boolean flg){
      num[0] = a1;
  		num[1] = a2;
  		left = l;
  		middle = m;
  		right = r;
  		active = flg;
  		return this;
    }

    Node remake(int a1,int a2,boolean flg){
  		num[0] = a1;
  		num[1] = a2;
  		active = flg;
  		return this;
  	}
  }

  private Node root;
  private int hojyo;

  public Btree(){
    root=null;
  }

  public boolean search(int n){
		return search(root,n);
	}

	private boolean search(Node t,int n){
		if(t==null){
			return false;
		}else if(t.num[0]==n||t.num[1]==n){
			return true;
		}else if(n<t.num[0]){
			return search(t.left,n);
		}else if(t.num[1]==-1 || n<t.num[1]){
			return search(t.middle,n);
		}else{
			return search(t.right,n);
		}
	}

  public void insert(int n){
		if(search(n)){
			return;
		}
		root = insert(root,n);
		root.active = false;
	}

	private Node insert(Node t,int n){
		if(t==null){
			Node b = new Node();
			b.num[0] = n;
			return b;
		}
		if(n<t.num[0]){
			t.left = insert(t.left,n);
			if(t.left.active){
				if(t.num[1]==-1){
					return t.remake(t.left.num[0],t.num[0],t.left.left,t.left.middle,t.middle,false);
				}else{
					Node r = new Node();
					r.remake(t.num[1],-1, t.middle, t.right, null,false);
					t.left.active = false;
					return t.remake(t.num[0], -1, t.left, r, null, true);
				}
			}else{
				return t;
			}
		}else if(t.num[1]==-1 || n<t.num[1]){
			t.middle = insert(t.middle,n);
			if(t.middle.active){
				if(t.num[1]==-1){
					return t.remake(t.num[0], t.middle.num[0], t.left, t.middle.left, t.middle.middle, false);
				}else{
					Node r = new Node(),s = new Node();
					r.remake(t.num[0],-1, t.left, t.middle.left, null,false);
					s.remake(t.num[1],-1, t.middle.middle, t.right, null, false);
					return t.remake(t.middle.num[0], -1, r, s, null, true);
				}
			}else{
				return t;
			}
		}else{
			t.right = insert(t.right,n);
			if(t.right.active){
				Node r = new Node();
				r.remake(t.num[0],-1, t.left, t.middle, null,false);
				t.right.active = false;
				return t.remake(t.num[1], -1, r, t.right , null, true);
			}else{
				return t;
			}
		}
	}

  public void delete(int n){
		root = delete(root,n);
		if(root.active){
			root = root.left;
		}
	}

	private Node delete(Node t,int n){
		if(t==null){
			return null;
		}
		if(n==t.num[0]){
			t.num[0]=-1;
			if(t.left==null){
				if(t.num[1]==-1){
					t.active = true;
				}else{
					t.num[0] = t.num[1];
					t.num[1] = -1;
				}
				return t;
			}else{
				t.middle = deleteM(t.middle);
				t.num[0] = hojyo;
				return balanceM(t);
			}
		}else if(n==t.num[1]){
			t.num[1]=-1;
			if(t.left==null){
				return t;
			}else{
				t.right= deleteM(t.right);
				t.num[1] = hojyo;
				return balanceR(t);
			}
		}else if(n<t.num[0]){
			t.left = delete(t.left,n);
			if(t.left==null||!t.left.active) return t;
			return balanceL(t);
		}else if(t.num[1]==-1 || n<t.num[1]){
			t.middle = delete(t.middle,n);
			if(t.middle==null||!t.middle.active) return t;
			return balanceM(t);
		}else{
			t.right = delete(t.right,n);
			if(t.right==null||!t.right.active) return t;
			return balanceR(t);
		}
	}

	private Node deleteM(Node t){
		if(t.left!=null){
			t.left = deleteM(t.left);
			return balanceL(t);
		}else{
			hojyo = t.num[0];
			boolean f = false;
			if(t.num[1]==-1){
				f = true;
			}
			return t.remake(-1, t.num[1], f);
		}
	}

  private Node balanceL(Node t){
		if(t.left==null||!t.left.active){return t;}
		else{
			if(t.num[1]==-1){
				if(t.middle.num[1]==-1){
					t.middle.remake(t.num[0], t.middle.num[0], t.left.left , t.middle.left , t.middle.middle, false);
					return t.remake(-1, -1, t.middle,null,null,true);
				}else{
					t.left.remake(t.num[0], -1, t.left.left,t.middle.left,null, false);
					t.num[0] = t.middle.num[0];
					t.middle.remake(t.middle.num[1],-1,t.middle.middle,t.middle.right,null,false);
					return t;
				}
			}else{
				if(t.middle.num[1]==-1){
					t.left.remake(t.num[0], t.middle.num[0],t.left.left,t.middle.left,t.middle.middle,false);
					return t.remake(t.num[1],-1, t.left,t.right,null,false);
				}else{
					t.left.remake(t.num[0], -1, t.left.left,t.middle.left,null,false);
					t.num[0] = t.middle.num[0];
					t.middle.remake(t.middle.num[1], -1, t.middle.middle,t.middle.right,null,false);
					return t;
				}
			}
		}
	}

	private Node balanceM(Node t){
		if(t.middle==null||!t.middle.active){
			return t;
		}else{
			if(t.num[1]==-1){
				if(t.left.num[1]==-1){
					t.left.remake(t.left.num[0], t.num[0],t.left.left,t.left.middle,t.middle.left, false);
					return t.remake(-1, -1,t.left,null,null, true);
				}else{
					t.middle.remake(t.num[0], -1, t.left.right,t.middle.left,null,false);
					t.num[0] = t.left.num[1];
					t.left.remake(t.left.num[0], -1, t.left.left,t.left.middle,null,false);
					return t;
				}
			}else{
				if(t.left.num[1]==-1){
					if(t.right.num[1]==-1){
						t.middle.remake(t.num[1], t.right.num[0],t.middle.left,t.right.left,t.right.middle, false);
						return t.remake(t.num[0], -1, t.left,t.middle,null,false);
					}else{
						t.middle.remake(t.num[1], -1,t.middle.left,t.right.left,null, false);
						t.num[1] = t.right.num[0];
						t.right.remake(t.right.num[1], -1,t.right.middle,t.right.right,null,false);
						return t;
					}
				}else{
					t.middle.remake(t.num[0], -1, t.left.right,t.middle.left,null,false);
					t.num[0] = t.left.num[1];
					t.left.remake(t.left.num[0], -1, t.left.left,t.left.middle,null,false);
					return t;
				}
			}
		}
	}

	private Node balanceR(Node t){
		if(t.right==null||!t.right.active){
			return t;
		}else{
			if(t.middle.num[1]==-1){
				t.middle.remake(t.middle.num[0], t.num[1], t.middle.left,t.middle.middle,t.right.left,false);
				return t.remake(t.num[0], -1,t.left,t.middle,null, false);
			}else{
				t.right.remake(t.num[1], -1,t.middle.right,t.right.left,null,false);
				t.num[1] = t.middle.num[1];
				t.middle.remake(t.middle.num[0], -1,t.middle.left,t.middle.middle,null,false);
				return t;
			}
		}
	}

  public String print(){
		ArrayList<Node> array = new ArrayList<Node>();
		String str = "";
		array.add(root);
		while(array.size()!=0){
			Node t = array.get(0);
			array.remove(0);
			if(t.left!=null){
				array.add(t.left);
			}
			if(t.middle!=null){
				array.add(t.middle);
			}
			if(t.right!=null){
				array.add(t.right);
			}
			str += "(" + t.num[0]+" "+t.num[1] + ") ";
		}
		return str;
	}
}
