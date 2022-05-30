package com.stg.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "sales")
public class Sales {

	@Id
	@Column(name = "saleid")
	@Type(type = "uuid-char")
	private UUID saleId = UUID.randomUUID();

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int saleId;
	 */

	private String saleType;

	private LocalDateTime orderDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restuarantId", nullable = false)
	@JsonBackReference
	private Restaurant restuarant;

}
