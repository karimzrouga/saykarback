package com.saykar.Model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Contact")
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Idc;
	private String fullname;
	private String email;
	private String country;
	private String message;
	private String phone;
	@Column(updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

}
