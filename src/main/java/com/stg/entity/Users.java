package com.stg.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

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
@Table(name = "user")
public class Users {

	@Id
	@Column(name = "userid", updatable = false, nullable = false)
	@Type(type = "uuid-char")
	private UUID userId = UUID.randomUUID();
	/*
	 * @Id
	 * 
	 * @Column(updatable = false, nullable = false) private int userId;
	 */
	@NotEmpty(message = "please providsde a UserName")
	@Column(updatable = false, unique = true, nullable = false)
	private String userName;
	@NotEmpty(message = "please providsde a UserPassword")
	@Column(nullable = false)
	private String userPassword;
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference
	private Restaurant restuarant;

}
