package com.mobicare.sample.js.dto;

public class SampleDto {

	private Long id;
	private String name;

	public SampleDto() {
		super();
	}

	public SampleDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
