package com.oops;


class Alien 
{
    private int id;
    private String name;

    void setid(int id){
      this.id = id;
    }
    void setname(String name){
      this.name = name;
    }
    int getId(){
      return id;
    }
    String getName(){
      return name;
    }
}
public class LaunchEncap3 {
  public static void main(String[] args) {
     Alien al = new Alien();
     al.setid(1);
     al.setname("Devanshu Rana");
     System.out.println(al.getId());
     System.out.println(al.getName());
  }
}
