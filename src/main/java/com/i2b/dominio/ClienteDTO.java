package com.i2b.dominio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTO {

	private String id;
	private String name;
	private String lastname;
	private String email;
	private String phone;
	private String address;
	private String password;
}
