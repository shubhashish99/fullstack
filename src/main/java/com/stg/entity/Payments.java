package com.stg.entity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Table(name = "payment")
public class Payments {

	@Id
	@Column(name = "paymentid")
	@Type(type = "uuid-char")
	private UUID paymentUuid = UUID.randomUUID();

	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "system-uuid")
	 * 
	 * @GenericGenerator(name = "system-uuid", strategy = "uuid")
	 * 
	 * @NotEmpty(message = "customer payment id is required !") private String
	 * paymentCustomerId;
	 */

	private Date paymentDate;

	private float paymentAmount;

	private String paymentMode;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	@JsonBackReference
	private Customers customers;

}
