package com.oozeander.model.embedded_attributeOverrides;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class GamerId implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	private String id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
}