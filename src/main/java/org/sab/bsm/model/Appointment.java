package org.sab.bsm.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.sab.bsm.model.enums.Priority;
import org.sab.bsm.model.enums.PrivacyLevel;

@Entity
@Table(name = "appointments")
public class Appointment extends _BaseModel {

	private static final long serialVersionUID = 5293794675813199058L;

	private String name;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_priority_id")
	private Priority priority;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_location_id")
	private Location location;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_privacy_level_id")
	private PrivacyLevel privacyLevel;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "appointment_id")
	private Set<Interval> intervals;

	private String comment;

	public String getComment() {
		return comment;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public Set<Interval> getIntervals() {
		return intervals;
	}

	public Location getLocation() {
		return location;
	}

	public String getName() {
		return name;
	}

	public Priority getPriority() {
		return priority;
	}

	public PrivacyLevel getPrivacyLevel() {
		return privacyLevel;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public void setIntervals(Set<Interval> intervals) {
		this.intervals = intervals;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public void setPrivacyLevel(PrivacyLevel privacyLevel) {
		this.privacyLevel = privacyLevel;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

}
