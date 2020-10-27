package mymatome;

import javax.swing.*;
import java.awt.*;

public class Framesw extends JFrame{
  public Framesw(int w,int h){
    setSize(w, h);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  public Framesw(int w,int h,JPanel p){
    this(w,h);
    add(p);
  }
  public void visible(){ //表示するか
    setVisible(!isVisible());
  }

  /*add(JPanel p) パネルpを追加する(もとから存在する)*/
}
