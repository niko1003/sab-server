package org.sab.bsm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role extends _BaseModel {

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