package com.oops;

class Employee2 {
    private int id;
    private String name;

    // Setter
    void setId(int id) {
        this.id = id;
    }

    void setname(String name) {
        this.name = name;
    }

    // getter
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }
    
}

public class LaunchEncap4 {
    public static void main(String[] args) {
     Employee2 emp = new Employee2();
     emp.setId(1);
     emp.setname("Samay");
    }
}
