package com.chainsys.epassmanagementsystem.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "epass_outside_state")
public class OutsideState {
	@Id
	@Column(name = "from_state")
	private String fromState;
	@Column(name = "to_state")
	private String toState;
	@Column(name = "quarantine_from_date")
	private Date quarantineFromDate;
	@Column(name = "quarantine_to_date")
	private Date quarantineToDate;
	@Column(name = "quarantine_location")
	private String quarantineLocation;
	@Column(name = "pcr_result_certificate_date")
	private Date pcrResultCertificateDate;
	@Column(name = "pcr_result_certificate_number")
	private Integer pcrResultCertificateNumber;
	@Column(name = "pcr_certificate_issued_by")
	private String pcrCertificateIssuedBy;
	@Column(name = "epass_id")
	private Integer epassId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "epass_id", insertable = false, updatable = false, nullable = false)
	private EpassForm epassForm;
	
	public String getFromState() {
		return fromState;
	}

	public void setFromState(String fromState) {
		this.fromState = fromState;
	}

	public String getToState() {
		return toState;
	}

	public void setToState(String toState) {
		this.toState = toState;
	}

	public Date getQuarantineFromDate() {
		return quarantineFromDate;
	}

	public void setQuarantineFromDate(Date quarantineFromDate) {
		this.quarantineFromDate = quarantineFromDate;
	}

	public Date getQuarantineToDate() {
		return quarantineToDate;
	}

	public void setQuarantineToDate(Date quarantineToDate) {
		this.quarantineToDate = quarantineToDate;
	}

	public String getQuarantineLocation() {
		return quarantineLocation;
	}

	public void setQuarantineLocation(String quarantineLocation) {
		this.quarantineLocation = quarantineLocation;
	}

	public Date getPcrResultCertificateDate() {
		return pcrResultCertificateDate;
	}

	public void setPcrResultCertificateDate(Date pcrResultCertificateDate) {
		this.pcrResultCertificateDate = pcrResultCertificateDate;
	}

	public Integer getPcrResultCertificateNumber() {
		return pcrResultCertificateNumber;
	}

	public void setPcrResultCertificateNumber(Integer pcrResultCertificateNumber) {
		this.pcrResultCertificateNumber = pcrResultCertificateNumber;
	}

	public String getPcrCertificateIssuedBy() {
		return pcrCertificateIssuedBy;
	}

	public void setPcrCertificateIssuedBy(String pcrCertificateIssuedBy) {
		this.pcrCertificateIssuedBy = pcrCertificateIssuedBy;
	}

	public Integer getEpassId() {
		return epassId;
	}

	public void setEpassId(Integer epassId) {
		this.epassId = epassId;
	}

	public EpassForm getEpassForm() {
		return epassForm;
	}

	public void setEpassForm(EpassForm epassForm) {
		this.epassForm = epassForm;
	}

}