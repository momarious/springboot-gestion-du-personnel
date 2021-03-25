package com.momarious.form;

import java.util.Date;

public class ContractForm {

	private String id;
	
	private String employeeID;
	
	private String nature;
	
	private Date startDate;
	
	private String startDateUS;
	
	private String duration;
		
	private String baseSalary;
	
	private String seniorityBonus;
	
	private String transportationAllowance;
	
	private String housingAllowance;

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(String baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getSeniorityBonus() {
		return seniorityBonus;
	}

	public void setSeniorityBonus(String seniorityBonus) {
		this.seniorityBonus = seniorityBonus;
	}

	public String getTransportationAllowance() {
		return transportationAllowance;
	}

	public void setTransportationAllowance(String transportationAllowance) {
		this.transportationAllowance = transportationAllowance;
	}

	public String getHousingAllowance() {
		return housingAllowance;
	}

	public void setHousingAllowance(String housingAllowance) {
		this.housingAllowance = housingAllowance;
	}
	
	public String getStartDateUS() {
		return startDateUS;
	}

	public void setStartDateUS(String startDateUS) {
		this.startDateUS = startDateUS;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ContractForm [id=" + id + ", employeeID=" + employeeID + ", nature=" + nature + ", startDate="
				+ startDate + ", startDateUS=" + startDateUS + ", duration=" + duration + ", baseSalary=" + baseSalary
				+ ", seniorityBonus=" + seniorityBonus + ", transportationAllowance=" + transportationAllowance
				+ ", housingAllowance=" + housingAllowance + "]";
	}

	
}
