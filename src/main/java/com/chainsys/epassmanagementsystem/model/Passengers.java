package com.chainsys.epassmanagementsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "epass_passengers")
public class Passengers {
	@Id
	@Column(name = "id_proof_number")
	private String idProofNumber;
	@Column(name = "epass_id")
	private Integer epassId;
	@Column(name = "passenger_name")
	private String passengerName;
	@Column(name = "passenger_gender")
	private String passengerGender;
	@Column(name = "covid_symptoms")
	private String covidSymptoms;
	@Column(name = "id_proof_type")
	private String idProofType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "epass_id", insertable = false, updatable = false, nullable = false)
	private EpassForm epassform;

	public Integer getEpassId() {
		return epassId;
	}

	public void setEpassId(Integer epassId) {
		this.epassId = epassId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public String getCovidSymptoms() {
		return covidSymptoms;
	}

	public void setCovidSymptoms(String covidSymptoms) {
		this.covidSymptoms = covidSymptoms;
	}

	public String getIdProofType() {
		return idProofType;
	}

	public void setIdProofType(String idProofType) {
		this.idProofType = idProofType;
	}

	public String getIdProofNumber() {
		return idProofNumber;
	}

	public void setIdProofNumber(String idProofNumber) {
		this.idProofNumber = idProofNumber;
	}

	public EpassForm getEpassform() {
		return epassform;
	}

	public void setEpassform(EpassForm epassform) {
		this.epassform = epassform;
	}
}