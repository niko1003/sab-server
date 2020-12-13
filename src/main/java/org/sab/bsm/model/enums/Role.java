package org.sab.bsm.model.enums;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.sab.bsm.model._BaseModel;

@Entity
@Table(name = "roles")
public class Role extends _BaseModel {

	public enum RoleEnum {
		ROLE_USER, ROLE_MODERATOR, ROLE_ADMIN
	}

	private static final long serialVersionUID = 80078374558149629L;

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private RoleEnum name;

	public RoleEnum getName() {
		return name;
	}

	public void setName(RoleEnum name) {
		this.name = name;
	}


}