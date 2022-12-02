package com.skilldistillery.filmquery.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	public DatabaseAccessorObject() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Error loading database Driver");
			e.printStackTrace();
		}
	}
	@Override
	public Film findFilmById(int filmId) {
		return null;
	}

	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		try {
			
		
		String user = "student";
		String password = "student";
		
		String sql = "SELECT id, first_name, last_name FROM actor WHERE id = ?";
		
		Connection conn = DriverManager.getConnection(URL, user, password);
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		
		
		if (actorResult.next()) {
			actor = new Actor(); 
			
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
			//actor.setFilms(findFilmsByActorId(actorId)); // An Actor has Films
			stmt.close();
			conn.close();
		}
		} catch (SQLException e) {
			System.err.println("Database error");
			System.err.println(e);
		}
		return actor;
		
	}
	public List<Actor> findActorsByFilmId(int filmId){
		List<Actor> actors = new ArrayList<>();
		String user = "student";
		String password = "student";
		
		try {
			Connection conn = DriverManager.getConnection(URL, user, password);
			String sql = "SELECT actor.id, actor.first_name, actor.last_name FROM actor JOIN film_actor ON film_actor.actor_id = actor.id JOIN film ON film_actor.film_id = film.id WHERE film.id = ?;";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, filmId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Actor actor = new Actor();
				actor.setId(rs.getInt("id"));
				actor.setFirstName(rs.getString("first_name"));
				actor.setLastName(rs.getString("last_name"));
				actors.add(actor);
				
				
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			System.err.println("Database error actors by film id");
			e.printStackTrace();
		}
		if(actors.size() == 0) {
			return null;
		}
		return actors;
		
	}

}
