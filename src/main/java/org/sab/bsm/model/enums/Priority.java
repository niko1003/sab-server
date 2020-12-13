package org.sab.bsm.model.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.sab.bsm.model._BaseModel;

@Entity
@Table(name = "priorities")
public class Priority extends _BaseModel {

	public enum PriorityEnum {
		CRITICAL, MAJOR, NORMAL, MINOR, TRIVIAL
	}

	private static final long serialVersionUID = -5487612518125028233L;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PriorityEnum name;

	private String description;

	public String getDescription() {
		return description;
	}

	public PriorityEnum getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(PriorityEnum name) {
		this.name = name;
	}

}
