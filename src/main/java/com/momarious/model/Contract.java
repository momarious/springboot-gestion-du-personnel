package com.momarious.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Contract implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String nature;
	
	private String startDate;
	
	private int duration;
	
	@Transient
	private int netSalary;
	
	private int diversBonus;
	
	private int baseSalary;
	
	private int seniorityBonus;
	
	private int transportationAllowance;
	
	private int housingAllowance;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;
	
	@Transient
	private Integer employeeID;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the nature
	 */
	public String getNature() {
		return nature;
	}

	/**
	 * @param nature the nature to set
	 */
	public void setNature(String nature) {
		this.nature = nature;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the netSalary
	 */
	public int getNetSalary() {
		return netSalary;
	}

	/**
	 * @param netSalary the netSalary to set
	 */
	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}

	/**
	 * @return the diversBonus
	 */
	public int getDiversBonus() {
		return diversBonus;
	}

	/**
	 * @param diversBonus the diversBonus to set
	 */
	public void setDiversBonus(int diversBonus) {
		this.diversBonus = diversBonus;
	}

	/**
	 * @return the baseSalary
	 */
	public int getBaseSalary() {
		return baseSalary;
	}

	/**
	 * @param baseSalary the baseSalary to set
	 */
	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}

	/**
	 * @return the seniorityBonus
	 */
	public int getSeniorityBonus() {
		return seniorityBonus;
	}

	/**
	 * @param seniorityBonus the seniorityBonus to set
	 */
	public void setSeniorityBonus(int seniorityBonus) {
		this.seniorityBonus = seniorityBonus;
	}

	/**
	 * @return the transportationAllowance
	 */
	public int getTransportationAllowance() {
		return transportationAllowance;
	}

	/**
	 * @param transportationAllowance the transportationAllowance to set
	 */
	public void setTransportationAllowance(int transportationAllowance) {
		this.transportationAllowance = transportationAllowance;
	}

	/**
	 * @return the housingAllowance
	 */
	public int getHousingAllowance() {
		return housingAllowance;
	}

	/**
	 * @param housingAllowance the housingAllowance to set
	 */
	public void setHousingAllowance(int housingAllowance) {
		this.housingAllowance = housingAllowance;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the employeeID
	 */
	public Integer getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(Integer employeeID) {
		this.employeeID = employeeID;
	}

	

}
