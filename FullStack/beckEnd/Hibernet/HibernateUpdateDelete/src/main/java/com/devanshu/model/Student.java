package com.devanshu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "StudentInfo")
public class Student {

    @Id
    @Column(name = "SID")
    private Integer sid;
    @Column(name = "SNAME")
    private String sName;
    @Column(name = "SCITY")
    private String scity;
    public Student(){
        super();
        System.out.print("Zero param constructor for hibernate ");
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getScity() {
        return scity;
    }

    public void setScity(String scity) {
        this.scity = scity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("sid=").append(sid);
        sb.append(", sName=").append(sName);
        sb.append(", scity=").append(scity);
        sb.append('}');
        return sb.toString();
    }

}
