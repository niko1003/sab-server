package org.sab.bsm.model.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.sab.bsm.model._BaseModel;

@Entity
@Table(name = "privacy_levels")
public class PrivacyLevel extends _BaseModel {

	public enum PrivacyEnum {
		PUBLIC, BAND, PRIVATE
	}

	private static final long serialVersionUID = -5487612518125028233L;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private PrivacyEnum name;

	private String description;

	public String getDescription() {
		return description;
	}

	public PrivacyEnum getName() {
		return name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setName(PrivacyEnum name) {
		this.name = name;
	}

}
