package mymatome;

import javax.swing.*;
import java.awt.*;

public class Drawsw{
  public static void color(Graphics gr,int r,int g,int b){
    gr.setColor(new Color(r,g,b));
  }
  public static void color(Graphics gr,int r,int g,int b,int a){
    gr.setColor(new Color(r,g,b,a));
  }
  public static void color(Graphics g,Color c){
    g.setColor(c);
  }
  public static void color(Graphics g,int[] a){
    if(a.length==3){
      color(g,a[0],a[1],a[2]);
    }else if(a.length==4){
      color(g,a[0],a[1],a[2],a[3]);
    }else{
      Print.pl("error : color len="+a.length);
    }
  }

  public static void circle(Graphics g,int x,int y,int r){
    g.fillOval(x,y,r,r);
  }
  public static void circle(Graphics g,int[] a,int r){
    g.fillOval(a[0],a[1],r,r);
  }

  public static void line(Graphics g,int x1,int y1,int x2,int y2){
    g.drawLine(x1,y1,x2,y2);
  }
  public static void line(Graphics g,int a1[],int a2[]){
    g.drawLine(a1[0],a1[1],a2[0],a2[1]);
  }
}
