import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Main extends JPanel{
  public void paintComponent(Graphics g){
    color(g,255,0,0,100);
		circle(g,100,50,100);
    color(g,0,255,0,100);
		circle(g,150,50,100);
    color(g,0,0,255,100);
		circle(g,125,90,100);
	}

  public static void main(String args[]){
    Test app = new Test();
		app.add(new Main());
    app.visible();
  }

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
      //Print.pl("error : color len="+a.length);
    }
  }

  public static void circle(Graphics g,int x,int y,int r){
    g.fillOval(x,y,r,r);
  }

  public static void line(Graphics g,int x1,int y1,int x2,int y2){
    g.drawLine(x1,y1,x2,y2);
  }
}

class Test extends JFrame{
  Test(){
    setSize(400, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  Test(JPanel p){
    this();
    p.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent evt){
				//m.move(evt.getX(), evt.getY());
				//repaint();
			}
		});
    p.addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent evt){
        //m.release();
        //repaint();
      }
    });
    add(p);
  }

  public void visible(){
    setVisible(!isVisible());
  }
}
