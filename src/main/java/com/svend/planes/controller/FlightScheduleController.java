package com.svend.planes.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.svend.planes.dao.DBconfig;
import com.svend.planes.domain.FlightSchedule;

public class FlightScheduleController extends DBconfig {

	// To carry out CRUD queries - where we connect to the the db
	// Four main things needed:
	// - open the connection
	// - write your query/statement - CRUD
	// - Execute query.
	// - close connection

	private Connection conn;// has a driver manager class which contains the methods to connect to db
	private Statement stmt;// allows us to prepare the query we want to execute
	private ResultSet rs; // Crucial for when returning multiple rows from a database table

	// open connection in the constructor - initialises everything
	public FlightScheduleController() {
		try {
			conn = DriverManager.getConnection(DBconfig.URL, DBconfig.USER, DBconfig.PASS);
			this.stmt = conn.createStatement();// create a statement object to execute sql queries
			System.out.println("Connection Successful!");
			
		} catch (SQLException e) {
			System.out.println("Incorrect credentials");
			e.printStackTrace();
		}
	}

	// Need a way to run our queries - call specific methods from the Statement
	// class
	// - executeQuery - retrieves info -> READ
	// - executeUpdate - passes into through and returns nothing -> CREATE, UPDATE,
	// DELETE

	// CREATE - INSERT INTO .... -> returns nothing, just says "query ok"
	public FlightSchedule create(FlightSchedule f) {

//	public void create(String model, int mileage, String vehicleType, int doors) {
		// info to collect to pass into the database
//		String model = "xxx";
//		int mileage = 1234;
//		String vehicleType = "Bike";
//		int doors = 2;

		// INSERT INTO vehicle(model, mileage, vehicle_type, doors)
		// VALUES("tbc",30000,"Car",4);
		String createStmt = "INSERT INTO flight_schedule(company, stand, take_off_time) VALUES('" + f.getCompany() + "'," + f.getStand()
				+ ",'" + f.getTakeoffTimeEst() + "');";
		try {
			stmt.executeUpdate(createStmt);
			System.out.println("Create statement executed");
			
			return f;
		} catch (SQLException e) {
			System.out.println("Bad query");
			System.out.println(createStmt);
			e.printStackTrace();
			return null;
			
		}
	}

	// READ - SELECT ..... -> executeQuery
	public String read() {
		String readStmt = "SELECT * FROM flight_schedule;";
		FlightSchedule fl = new FlightSchedule();
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				fl.setId(rs.getInt("id"));
				fl.setCompany(rs.getString("company"));
				fl.setStand(rs.getInt("stand"));
				fl.setTakeoffTimeEst(rs.getString("take_off_time"));
				System.out.println(fl.toString()); 
				
			}
			return readStmt;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}
	}

	// UPDATE - UPDATE ..... -> executeUpdate
	public String update(FlightSchedule f) {
//		UPDATE vehicle SET model = "chevy" WHERE id = 2;
		String updateStmt = "UPDATE flight_schedule SET take_off_time = '" + f.getTakeoffTimeEst() + "' WHERE id = " + f.getId() + ";";
		try {
			stmt.executeUpdate(updateStmt);
			System.out.println("Update statement executed");
			return updateStmt;
			
		}catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}

	}

	// DELETE - DELETE ..... -> executeUpdate
	public String delete(FlightSchedule f) {
		String delStmt = "DELETE FROM flight_schedule WHERE id=" + f.getId() + ";";
		try {
			stmt.executeUpdate(delStmt);
			System.out.println("Delete statement executed");
			return delStmt;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}

	}

	// close the connection
	public Boolean closeConn() {
		Boolean isClosed;
		try {
			conn.close();
			System.out.println("Closed!");
			isClosed=true;
		} catch (SQLException e) {
			System.out.println("Closing connection...");
			e.printStackTrace();
			isClosed=false;
		}
		return isClosed;
		
	}
	
	
	public FlightSchedule readByID(FlightSchedule f) {
		String read = "SELECT * FROM flight_schedule WHERE ID =" + f.getId();
		FlightSchedule fl = new FlightSchedule();
		try {
			rs = stmt.executeQuery(read);
			while (rs.next()) {
				fl.setId(rs.getInt("id"));
				fl.setCompany(rs.getString("company"));
				fl.setStand(rs.getInt("stand"));
				fl.setTakeoffTimeEst(rs.getString("take_off_time"));
				System.out.println(fl.toString()); 
				
				
			}
			return fl;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public FlightSchedule readByName(FlightSchedule f) {
		String read = "SELECT * FROM flight_schedule WHERE company = '" +f.getCompany() + "'" ;
		FlightSchedule fl = new FlightSchedule();
		try {
			rs = stmt.executeQuery(read);
			while (rs.next()) {
				fl.setId(rs.getInt("id"));
				fl.setCompany(rs.getString("company"));
				fl.setStand(rs.getInt("stand"));
				fl.setTakeoffTimeEst(rs.getString("take_off_time"));
				System.out.println(fl.toString()); 

			}
			return fl;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}
	}
	
	

}
