package com.svend.planes.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.svend.planes.domain.Planes;

public class CRUDqueries {

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
	public CRUDqueries() {
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
	public Planes create(Planes p) {

//	public void create(String model, int mileage, String vehicleType, int doors) {
		// info to collect to pass into the database
//		String model = "xxx";
//		int mileage = 1234;
//		String vehicleType = "Bike";
//		int doors = 2;

		// INSERT INTO vehicle(model, mileage, vehicle_type, doors)
		// VALUES("tbc",30000,"Car",4);
		String createStmt = "INSERT INTO planes(company, stand, colour) VALUES('" + p.getCompany() + "'," + p.getStand()
				+ ",'" + p.getColour() + "');";
		try {
			stmt.executeUpdate(createStmt);
			System.out.println("Create statement executed");
			return p;
		} catch (SQLException e) {
			System.out.println("Bad query");
			System.out.println(createStmt);
			e.printStackTrace();
			return null;
			
		}
	}

	// READ - SELECT ..... -> executeQuery
	public String read() {
		String readStmt = "SELECT * FROM planes;";
		Planes pl = new Planes();
		try {
			rs = stmt.executeQuery(readStmt);
			while (rs.next()) {
				pl.setId(rs.getInt("id"));
				pl.setCompany(rs.getString("company"));
				pl.setStand(rs.getInt("stand"));
				pl.setColour(rs.getString("colour"));
				System.out.println(pl.toString()); 
				
			}
			return readStmt;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}
	}

	// UPDATE - UPDATE ..... -> executeUpdate
	public String update(Planes p) {
//		UPDATE vehicle SET model = "chevy" WHERE id = 2;
		String updateStmt = "UPDATE planes SET colour = '" + p.getColour() + "' WHERE id = " + p.getId() + ";";
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
	public String delete(Planes p) {
		String delStmt = "DELETE FROM planes WHERE id=" + p.getId() + ";";
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
	
	
	public Planes readByID(Planes p) {
		String read = "SELECT * FROM planes WHERE ID =" + p.getId();
		Planes pl = new Planes();
		try {
			rs = stmt.executeQuery(read);
			while (rs.next()) {
				pl.setId(rs.getInt("id"));
				pl.setCompany(rs.getString("company"));
				pl.setStand(rs.getInt("stand"));
				pl.setColour(rs.getString("colour"));
				System.out.println(pl.toString()); 
				
				
			}
			return pl;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Planes readByName(Planes p) {
		String read = "SELECT * FROM planes WHERE company = '" +p.getCompany() + "'" ;
		Planes pl = new Planes();
		try {
			rs = stmt.executeQuery(read);
			while (rs.next()) {
				pl.setId(rs.getInt("id"));
				pl.setCompany(rs.getString("company"));
				pl.setStand(rs.getInt("stand"));
				pl.setColour(rs.getString("colour"));
				System.out.println(pl.toString()); 

			}
			return pl;
		} catch (SQLException e) {
			System.out.println("Bad query");
			e.printStackTrace();
			return null;
		}
	}
	
	

}
