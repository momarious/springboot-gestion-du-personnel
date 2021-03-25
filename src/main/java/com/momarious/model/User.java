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
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
    private String username;
    
    private String password;
    
    @Transient
    private String passwordConfirm;
    
    @Transient
    private String passwordCurrent;
    
	@CreationTimestamp
	private Date creationDate;
    
    @OneToOne(targetEntity = Role.class)
	private Role role;

    @Transient
    private Integer roleID;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	
	public String getPasswordCurrent() {
		return passwordCurrent;
	}

	public void setPasswordCurrent(String passwordCurrent) {
		this.passwordCurrent = passwordCurrent;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", passwordConfirm="
				+ passwordConfirm + ", passwordCurrent=" + passwordCurrent + ", creationDate=" + creationDate
				+ ", role=" + role + ", roleID=" + roleID + "]";
	}
	
	
}
