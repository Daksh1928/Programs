package com.oops;

class Telusko{
    private String course;
    private Double price;
    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

}

public class LaunchEncap6 {
public static void main(String[] args) {
    Telusko t1 = new Telusko();
    t1.setCourse("DSA");
    t1.setPrice(100000.3);
    Telusko t2 = new Telusko();
    t2.setCourse("AI devops ");
    t2.setPrice(10000.0);
}
}
