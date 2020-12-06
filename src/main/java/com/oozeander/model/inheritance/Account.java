package com.oozeander.model.inheritance;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Entity @Table(name = "accounts", schema = "default_schema",
	uniqueConstraints = {@UniqueConstraint(columnNames = {"account_id"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type")
public class Account {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @Column(name = "account_id", unique = true,
		nullable = false) private Long id;
	
	@NonNull
	@Column(name = "account_balance")
	private BigDecimal accountBalance;
}