package com.ibs.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
//@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames = {"userName", "email_id"})})
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "email_id")
	private String emailid;

	@Column(name = "password")
	private String password;

	@Column(name = "designation")
	private String designation;

	@Column(name = "user_type")
	private String usertype;

	@Column(name = "gender")
	private String gender;

	@Column(name = "address")
	private String address;

	@Column(name = "contact_no")
	private String contactno;

}