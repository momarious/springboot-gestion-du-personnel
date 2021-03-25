package com.momarious.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	private String firstname;
	
	private String lastname;

	private String matriculation;
	
	private String dateOfBirth;
	
	private String placeOfBirth;

	private String placeOfResidence;

	private String gender;
	
	private String nationality;

	private String cellphone;

	private String profession;
	
	private String email;
	
	private String numberOfChilds;
	
	private String maritalStatus;
	
	private String diploma;
	
	private String nationalIdentificationNumber;
	
	@OneToOne(targetEntity = Function.class)
	private Function function;
	
	@Transient
	private Integer functionID;
	
	@OneToOne(targetEntity = ServiceDepartment.class)
	private ServiceDepartment serviceDepartment;;
	
	@Transient
	private Integer serviceID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMatriculation() {
		return matriculation;
	}

	public void setMatriculation(String matriculation) {
		this.matriculation = matriculation;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public String getPlaceOfResidence() {
		return placeOfResidence;
	}

	public void setPlaceOfResidence(String placeOfResidence) {
		this.placeOfResidence = placeOfResidence;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumberOfChilds() {
		return numberOfChilds;
	}

	public void setNumberOfChilds(String numberOfChilds) {
		this.numberOfChilds = numberOfChilds;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getDiploma() {
		return diploma;
	}

	public void setDiploma(String diploma) {
		this.diploma = diploma;
	}

	public String getNationalIdentificationNumber() {
		return nationalIdentificationNumber;
	}

	public void setNationalIdentificationNumber(String nationalIdentificationNumber) {
		this.nationalIdentificationNumber = nationalIdentificationNumber;
	}

	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	public Integer getFunctionID() {
		return functionID;
	}

	public void setFunctionID(Integer functionID) {
		this.functionID = functionID;
	}

	public ServiceDepartment getServiceDepartment() {
		return serviceDepartment;
	}

	public void setServiceDepartment(ServiceDepartment serviceDepartment) {
		this.serviceDepartment = serviceDepartment;
	}

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	
}
