package org.sab.bsm.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bands")
public class Band extends _BaseModel {

	private static final long serialVersionUID = 5714119459490411728L;

	private String name;

}
