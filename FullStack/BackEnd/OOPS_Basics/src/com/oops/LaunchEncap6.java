package com.oops;

class Telusko2{
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
    Telusko2 t1 = new Telusko2();
    t1.setCourse("DSA");
    t1.setPrice(100000.3);
    Telusko2 t2 = new Telusko2();
    t2.setCourse("AI devops ");
    t2.setPrice(10000.0);
}
}
