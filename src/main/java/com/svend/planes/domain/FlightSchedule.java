package com.svend.planes.domain;

public class FlightSchedule{
	private int id;
	private String company;
	private int runway;
	private String takeoffTimeEst;
	
	
	
	public FlightSchedule(int id, String company, int runway, String takeoffTimeEst) {
		super();
		this.id = id;
		this.company = company;
		this.runway = runway;
		this.takeoffTimeEst = takeoffTimeEst;
	}



	public FlightSchedule(String company, int runway, String takeoffTimeEst) {
		super();
		this.company = company;
		this.runway = runway;
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
	public int getRunway() {
		return runway;
	}
	public void setRunway(int runway) {
		this.runway = runway;
	}
	public String getTakeoffTimeEst() {
		return takeoffTimeEst;
	}
	public void setTakeoffTimeEst(String takeoffTimeEst) {
		this.takeoffTimeEst = takeoffTimeEst;
	}



	@Override
	public String toString() {
		return "FlightSchedule [id=" + id + ", company=" + company + ", runway=" + runway + ", takeoffTimeEst="
				+ takeoffTimeEst + "]";
	}
	
	
	
}
