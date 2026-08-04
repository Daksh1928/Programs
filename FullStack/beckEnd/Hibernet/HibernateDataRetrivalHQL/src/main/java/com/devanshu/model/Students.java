package com.devanshu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="studnetTable")
public class Students {
	@Id
	private Integer sid;
	private String sName;
	private String scity;
	
	@Override
	public String toString() {
		return "Students [sid=" + sid + ", sName=" + sName + ", scity=" + scity + "]";
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

	public Students()
	{
		System.out.print("Zero patameter constructor for hibernate");
	}
	

}
