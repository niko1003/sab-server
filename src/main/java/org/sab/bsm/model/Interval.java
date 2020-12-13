package org.sab.bsm.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity(name = "interval")
@Table(name = "intervals")
public class Interval extends _BaseModel {

	private static final long serialVersionUID = -1602094123997373474L;

	@NotBlank
	private String cronInterval;

	@NotBlank
	private LocalDate startDate;

	private LocalDate endDate;

	public String getCronInterval() {
		return cronInterval;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setCronInterval(String cronInterval) {
		this.cronInterval = cronInterval;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

}
