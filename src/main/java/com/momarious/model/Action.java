package com.momarious.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Action implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 468943233335922874L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	private String denomination;
	
	private String extension;
	
	@CreationTimestamp
	private Date effectiveDate;
	
	@Transient
	private String effectiveDateFr;
	
	@OneToOne(targetEntity = User.class)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEffectiveDateFr() {
		return effectiveDateFr;
	}

	public void setEffectiveDateFr(String effectiveDateFr) {
		this.effectiveDateFr = effectiveDateFr;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	
	
}
