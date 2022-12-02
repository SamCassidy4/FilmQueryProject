package com.skilldistillery.filmquery.entities;

import java.util.List;
import java.util.Objects;

public class Film {
	private int id;
	private String title;
	private String description;
	private short releaseYear;
	private int langId;
	private int rentDur;
	private double rate;
	private int length;
	private double repCost;
	private String rating;
	private String features;
	private List<Actor> actors;
	private String language;
	
	public Film() {
		
	}

	public Film(int id, String title, String description, short releaseYear, int langId, int rentDur, double rate,
			int length, double repCost, String rating, String features, List<Actor> actors, String language) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.releaseYear = releaseYear;
		this.langId = langId;
		this.rentDur = rentDur;
		this.rate = rate;
		this.length = length;
		this.repCost = repCost;
		this.rating = rating;
		this.features = features;
		this.actors = actors;
		this.language = language;
		
		

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(short releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLangId() {
		return langId;
	}

	public void setLangId(int langId) {
		this.langId = langId;
	}

	public int getRentDur() {
		return rentDur;
	}

	public void setRentDur(int rentDur) {
		this.rentDur = rentDur;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public double getRepCost() {
		return repCost;
	}

	public void setRepCost(double repCost) {
		this.repCost = repCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actors, description, features, id, langId, language, length, rate, rating, releaseYear,
				rentDur, repCost, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return Objects.equals(actors, other.actors) && Objects.equals(description, other.description)
				&& Objects.equals(features, other.features) && id == other.id && langId == other.langId
				&& Objects.equals(language, other.language) && length == other.length
				&& Double.doubleToLongBits(rate) == Double.doubleToLongBits(other.rate)
				&& Objects.equals(rating, other.rating) && releaseYear == other.releaseYear && rentDur == other.rentDur
				&& Double.doubleToLongBits(repCost) == Double.doubleToLongBits(other.repCost)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Film id:" + id + " Title: " + title + " \n Description: " + description + " \n Release Year:" + releaseYear
				+ " Language Id: " + langId + " Rent Duration: " + rentDur + " \n Rate: " + rate + " \n Length: " + length + "\n Repair Cost: "
				+ repCost + "\n Rating: " + rating + " \n Features: " + features + "\n Actors: " + actors + " \n Language: "
				+ language;
	}
	
}
