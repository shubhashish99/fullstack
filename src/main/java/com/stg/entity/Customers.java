
package com.stg.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customers")
public class Customers {

	@Id
	@Column(name = "customerid")
	@Type(type = "uuid-char")
	private UUID customerId = UUID.randomUUID();
	/*
	 * @Id
	 * 
	 * @GeneratedValue(generator = "system-uuid")
	 * 
	 * @GenericGenerator(name = "id", strategy = "uuid") private String customerId;
	 */

	private String customerName;

	private String customerOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restuarantId", nullable = false)
	@JsonBackReference
	private Restaurant restuarant;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "CustomerOrders", joinColumns = @JoinColumn(name = "customerId"), inverseJoinColumns = @JoinColumn(name = "order_id"))
	private List<Orders> orders;

	@JsonManagedReference
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private List<RestaurantTables> tables;

	@JsonManagedReference
	@OneToMany(mappedBy = "customers", cascade = CascadeType.ALL)
	private List<Payments> payment;
}
