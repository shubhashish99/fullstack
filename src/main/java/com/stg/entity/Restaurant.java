package com.stg.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "restuarant")
public class Restaurant {

	@Id
	@Column(name = "restaurantid")
	@Type(type = "uuid-char")
	private UUID restaurantId = UUID.randomUUID();
	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "system-uuid")
	 * 
	 * @GenericGenerator(name = "system-uuid", strategy = "uuid") private String
	 * restaurantId;
	 */

	@NotEmpty(message = "Restaurant name is required !")
	private String restaurntName;

	private String restaurantType;

	private String restaurantDescription;

	@JsonManagedReference
	@OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
	private List<Employees> employees;
	@JsonManagedReference
	@OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
	private List<Customers> customers;
	@JsonManagedReference
	@OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
	private List<Items> items;
	@JsonManagedReference
	@OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
	private List<Sales> sales;
	@JsonManagedReference
	@OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
	private List<RestaurantTables> tables;
	@JsonManagedReference
	@OneToMany(mappedBy = "restuarant", cascade = CascadeType.ALL)
	private List<Users> users;
}