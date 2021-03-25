package com.momarious.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8570096998675969591L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private String startDate;
	
	private String endDate;
	
	private String reason;
	
	private String dateOfDemand;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;

	@Transient
	private String matriculation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public String getMatriculation() {
		return matriculation;
	}
	
	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}

	public String getDateOfDemand() {
		return dateOfDemand;
	}

	public void setDateOfDemand(String dateOfDemand) {
		this.dateOfDemand = dateOfDemand;
	}

	@Override
	public String toString() {
		return "Permission [id=" + id + ", startDate=" + startDate + ", endDate=" + endDate + ", reason=" + reason
				+ ", dateOfDemand=" + dateOfDemand + ", employee=" + employee + ", matriculation=" + matriculation
				+ "]";
	}
	
	// private String deductible
	
	
}
