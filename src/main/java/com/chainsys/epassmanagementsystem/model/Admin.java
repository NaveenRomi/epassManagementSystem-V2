package com.chainsys.epassmanagementsystem.model;

import java.sql.Date;
import javax.persistence.*;

@Entity
@Table(name = "epass_admin")
public class Admin {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private String adminId;

	@Column(name = "admin_name")
	private String adminName;

	@Column(name = "admin_email")
	private String adminEmail;

	@Column(name = "admin_password")
	private String adminPassword;

	@Column(name = "date_of_joining")
	private Date dateOfJoining;

	@Column(name = "admin_designation")
	private String adminDesignation;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getAdminDesignation() {
		return adminDesignation;
	}

	public void setAdminDesignation(String adminDesignation) {
		this.adminDesignation = adminDesignation;
	}

}
