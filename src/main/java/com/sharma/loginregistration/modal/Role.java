package com.sharma.loginregistration.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth_role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auth_role_id;
	
	@Column(name = "auth_name")
	private String name;
	@Column(name = "auth_desc")
	private String desc;
	public Role() {
		
	}
	public Role(String name) {
		super();
		this.name = name;
		this.desc = desc;
	}
	public long getId() {
		return auth_role_id;
	}
	public void setId(long auth_role_id) {
		this.auth_role_id = auth_role_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
