package com.stg.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Table(name = "tables")
public class RestaurantTables {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableNo;

	@NotEmpty(message = "customer table id is required !")
	private int tableCustomerId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Restaurant restuarant;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Customers customers;

}
