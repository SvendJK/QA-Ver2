package com.svend.planes.domain;

public class FlightSchedule{
	private int id;
	private String company;
	private int stand;
	private String takeoffTimeEst;
	
	
	
	public FlightSchedule(String company, int stand, String takeoffTimeEst) {
		super();
		this.company = company;
		this.stand = stand;
		this.takeoffTimeEst = takeoffTimeEst;
	}
	
	
	
	public FlightSchedule(String company) {
		super();
		this.company = company;
	}



	public FlightSchedule(int id) {
		super();
		this.id = id;
	}



	public FlightSchedule(int id, String takeoffTimeEst) {
		super();
		this.id = id;
		this.takeoffTimeEst = takeoffTimeEst;
	}



	public FlightSchedule() {
		super();
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
	public String getTakeoffTimeEst() {
		return takeoffTimeEst;
	}
	public void setTakeoffTimeEst(String takeoffTimeEst) {
		this.takeoffTimeEst = takeoffTimeEst;
	}



	@Override
	public String toString() {
		return "FlightSchedule [id=" + id + ", company=" + company + ", stand=" + stand + ", takeoffTimeEst="
				+ takeoffTimeEst + "]";
	}
	
	
	
}
