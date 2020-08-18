package mymatome;

public class BinaryTree{
  Node root;

  class Node{
    int num;
    Node left,right,parent;
    Node(int n){
      num=n;
      left=null;right=null;parent=null;
    }
  }

  BinaryTree(){
    root=null;
  }

  public void add(int data){
    if(root==null){
      root = new Node(data);
      return;
    }
    Node before=null;
    Node now = root;
    Node newnode = new Node(data);
    while(now!=null){
      before = now;
      if(now.num>data){
        now = now.left;
      }else{
        now = now.right;
      }
    }
    newnode.parent = before;
    if(before.num>data){
      before.left = newnode;
    }else{
      before.right = newnode;
    }
  }

  private Node searchN(int data){
    Node t = root;
    while(t!=null){
      if(t.num>data){
        t = t.left;
      }else if(t.num<data){
        t = t.right;
      }else{
        return t;
      }
    }
    return null;
  }

  public boolean search(int data){
    if(searchN(data)==null){
      return false;
    }
    return true;
  }

  private Node minnode(Node a){
    a = a.right;
    while(a.left!=null){
      a=a.left;
    }
    return a;
  }

  public void delete(int data){
    Node node = searchN(data);
    Node delnode=null,change=null;
    if(node==null){return;}
    if(node.left==null||node.right==null){
      delnode = node;
    }else{
      delnode = minnode(node);
    }
    if(delnode.left!=null){
        change=delnode.left;
    }else{
        change=delnode.right;
    }
    if(change!=null){
      change.parent = delnode.parent;
    }
    if(delnode == root){
      root = change;
    }else if(delnode.parent.left==delnode){
      delnode.parent.left = change;
    }else{
      delnode.parent.right = change;
    }
    if(node!=delnode){
      node.num = delnode.num;
    }
  }

  public void preprint(){
    nodepre(root);
    System.out.println("");
  }
  private void nodepre(Node a){
    if(a==null){return;}
    System.out.print(a.num+" ");
    nodepre(a.left);
    nodepre(a.right);
  }
  public void inprint(){
    nodein(root);
    System.out.println("");
  }
  private void nodein(Node a){
    if(a==null){return;}
    nodein(a.left);
    System.out.print(a.num+" ");
    nodein(a.right);
  }
  public void postprint(){
    nodepost(root);
    System.out.println("");
  }
  private void nodepost(Node a){
    if(a==null){return;}
    nodepost(a.left);
    nodepost(a.right);
    System.out.print(a.num+" ");
  }
}
