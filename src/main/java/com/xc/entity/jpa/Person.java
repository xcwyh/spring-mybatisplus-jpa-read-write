package com.xc.entity.jpa;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "person")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "person_name")
	private String personName;

	@Column(name = "person_age")
	private Integer personAge;

	@Column(name = "person_desc")
	private String personDesc;

}
