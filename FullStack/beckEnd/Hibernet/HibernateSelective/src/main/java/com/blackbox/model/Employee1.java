package com.blackbox.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "Employee")
public class Employee1 {

	@Id
	@Column(name = "EmpId")
	private Integer eId;
	@Column(name = "EmpName")
	private String eName;
	@Column(name = "EmpCity")
	private String eCity;
	@Column(name = "EmpAge")
	private Integer eAge;
	@Column(name = "EmpPhone")
	private long ePhone;

	@Transient
	private String email;

	public Employee1() {
		super();
		System.out.println("Zero parameter constructor for hibernate ");
	}

	public Integer geteId() {
		return eId;
	}

	public void seteId(Integer eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteCity() {
		return eCity;
	}

	public void seteCity(String eCity) {
		this.eCity = eCity;
	}

	public Integer geteAge() {
		return eAge;
	}

	public void seteAge(Integer eAge) {
		this.eAge = eAge;
	}

	public long getePhone() {
		return ePhone;
	}

	public void setePhone(long ePhone) {
		this.ePhone = ePhone;
	}

	public static void main(String[] args) {

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee1 [eId=" + eId + ", eName=" + eName + ", eCity=" + eCity + ", eAge=" + eAge + ", ePhone="
				+ ePhone + ", email=" + email + ", geteId()=" + geteId() + ", geteName()=" + geteName()
				+ ", geteCity()=" + geteCity() + ", geteAge()=" + geteAge() + ", getePhone()=" + getePhone()
				+ ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
