package com.svend.planes.domain;

public class Planes {


	private int id;
	private String company;
	private int stand;
	private String colour;
	

	public Planes() {
		super();
	}
	
	

	public Planes(String company) {
		super();
		this.company = company;
	}



	public Planes(int id) {
		super();
		this.id = id;
	}



	public Planes(int id, String company, int stand, String colour) {
		super();
		this.id = id;
		this.company = company;
		this.stand = stand;
		this.colour = colour;
		
	}

	public Planes(String company, int stand, String colour) {
		super();
		this.company = company;
		this.stand = stand;
		this.colour = colour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getStand() {
		return stand;
	}

	public void setStand(int stand) {
		this.stand = stand;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return "Planes [id=" + id + ", company=" + company + ", stand=" + stand + ", colour=" + colour + "]";
	}

	

}
