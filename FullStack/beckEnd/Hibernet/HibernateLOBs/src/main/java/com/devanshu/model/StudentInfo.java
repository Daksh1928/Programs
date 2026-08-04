package com.devanshu.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "Student_info")
public class StudentInfo {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer sid;
   private String sName;
   private String sCity;
   @Lob
   @Column(length = 100000)
   private byte[] image;
   @Lob
   @Column(length = 100000)
   private char[] textFile;

   public byte[] getImage() {
      return image;
   }

   public void setImage(byte[] image) {
      this.image = image;
   }

   public char[] getTextFile() {
      return textFile;
   }

   public void setTextFile(char[] textFile) {
      this.textFile = textFile;
   }

   @Override
   public String toString() {
      return "StudentInfo [sid=" + sid + ", sName=" + sName + ", sCity=" + sCity + ", image=" + Arrays.toString(image)
            + ", textFile=" + Arrays.toString(textFile) + "]";
   }

   public StudentInfo() {
      System.out.println("StudnetInfo started and constroctor generated ");
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

   public String getsCity() {
      return sCity;
   }

   public void setsCity(String sCity) {
      this.sCity = sCity;
   }

}
