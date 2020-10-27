package mymatome;

import java.util.*;
import java.io.*;

public class FileRW {
  public static File makeFile(String str){
    return new File(str);
  }

  public static String input(String name){
    try{
      File file = makeFile(name);
      if(cheakReadFile(file)){
        BufferedReader brf = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String str=brf.readLine();
        while(str!=null){
          sb.append(str+"\n");
          str = brf.readLine();
        }
        brf.close();
        return sb.toString();
      }else{
        System.out.println("ファイルが存在しないか開けません");
        System.exit(0);
      }
    }catch(IOException e){
      e.printStackTrace();
      System.exit(0);
    }
    return null;
  }

  public static void output(String name,String str){
    try{
      File file = makeFile(name);
      if(cheakWriteFile(file)){
        BufferedWriter bwf = new BufferedWriter(new FileWriter(file));
        bwf.write(str);
        bwf.newLine();
        bwf.close();
      }else{
        System.out.println("ファイルが開けません");
        System.exit(0);
      }
    }catch(IOException e){
      e.printStackTrace();
      System.exit(0);
    }
  }

  private static boolean cheakReadFile(File file){
    if (file.exists()){
      if (file.isFile() && file.canRead()){
        return true;
      }
    }
    return false;
  }

  private static boolean cheakWriteFile(File file){
    if (file.exists()){
      if (file.isFile() && file.canWrite()){
        return true;
      }
    }else{
      try{
        if(file.createNewFile()){
          return cheakWriteFile(file);
        }
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    return false;
  }

  private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  public static String readL(){
    try{
      return br.readLine();
    }catch(IOException e){
      e.printStackTrace();
      return "";
    }
  }
  public static String readS(){
    StringBuilder sb = new StringBuilder();
    while(true){
      try{
        int k = br.read();
        if(k==-1||(char)k==' '||(char)k=='\n'){break;}
        sb.append((char)k);
      }catch(IOException e){
        e.printStackTrace();
      }
    }
    return sb.toString();
  }
  public static int readI(){
    return Trans.stoi(readS());
  }
  public static long readLong(){
    return Trans.stol(readS());
  }
  public static String[] readSs(){
    return readL().split(" ");
  }
  public static int[] readIs(){
    return Trans.sstoi(readSs());
  }
  public static long[] readLongs(){
    return Trans.stol(readSs());
  }
  public static int readII(){
    String str="";
    while(true){
      str = readS();
      if(Trans.isNumber(str)){return Trans.stoi(str);}
    }
  }
  public static long readLL(){
    String str="";
    while(true){
      str = readS();
      if(Trans.isNumber(str)){return Trans.stol(str);}
    }
  }
}
