package com.example.demo.dto;

public class RoleDto {

	private int id;

    private String name; // Example: ROLE_ADMIN, ROLE_USER

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
