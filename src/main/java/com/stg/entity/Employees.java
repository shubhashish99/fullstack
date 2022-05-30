package com.stg.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employees {

	@Id
	@Column(name = "employeeid")
	@Type(type = "uuid-char")
	private UUID employeeId = UUID.randomUUID();
	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "system-uuid")
	 * 
	 * @GenericGenerator(name = "system-uuid", strategy = "uuid") private String
	 * employeeId;
	 */

	private String employeeName;

	private char employeeMobile;

	private String employeeEmail;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Restaurant restuarant;

}