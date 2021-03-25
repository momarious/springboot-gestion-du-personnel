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
public class Vacation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Transient
	private String startDateFrench;
	
	private Date startDate;
	
	private Date endDate;
	
	private String duration;

	private String nature;

	@Transient
	private String dateOfDemandFrench;
	private Date dateOfDemand;
	
	@OneToOne(targetEntity = Employee.class)
	private Employee employee;
	
	@Transient
	private String employeeFullname;
	
	@Transient
	private String matriculation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartDateFrench() {
		return startDateFrench;
	}

	public void setStartDateFrench(String startDateFrench) {
		this.startDateFrench = startDateFrench;
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

	public String getNature() {
		return nature;
	}

	public void setNature(String nature) {
		this.nature = nature;
	}

	public String getDateOfDemandFrench() {
		return dateOfDemandFrench;
	}

	public void setDateOfDemandFrench(String dateOfDemandFrench) {
		this.dateOfDemandFrench = dateOfDemandFrench;
	}

	public Date getDateOfDemand() {
		return dateOfDemand;
	}

	public void setDateOfDemand(Date dateOfDemand) {
		this.dateOfDemand = dateOfDemand;
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

	public String getEmployeeFullname() {
		return employeeFullname;
	}

	public void setEmployeeFullname(String employeeFullname) {
		this.employeeFullname = employeeFullname;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
		
	


}
