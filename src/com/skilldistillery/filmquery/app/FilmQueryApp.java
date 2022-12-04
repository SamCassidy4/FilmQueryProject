package com.skilldistillery.filmquery.app;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
		// app.test();
		app.launch();
	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);
		// instantiating a new scanner after every case is best practice

		input.close();
	}

	private void startUserInterface(Scanner input) {
		System.out.println("What would you like to do?");
		System.out.println("1. Look up a film by its ID?");
		System.out.println("2. Look up a film by a keyword?");
		System.out.println("3. Exit the program");

		int choice = 0;

		try {
			choice = input.nextInt();
			input.nextLine();
		} catch (InputMismatchException e) {
			System.err.println("Please give a number.");
		}

		switch (choice) {
		case 1:
			System.out.println("Please input the ID you are looking for: ");
			int movieId = input.nextInt();
			Film film = db.findFilmById(movieId);
			try {
				System.out.println("Title: " + film.getTitle() + "\nYear: " + film.getReleaseYear() + "\nLanguage: "
						+ film.getLanguage() + "\nRating: " + film.getRating() + "\nDescription: "
						+ film.getDescription() + "\nActors: " + film.getActors());

			} catch (NullPointerException e) {
				System.err.println("Invalid movie ID");
			}

			startUserInterface(new Scanner(System.in));
		case 2:
			System.out.println("Look up a film by a keyword:");
			String keyword = input.nextLine();
			List<Film> movies = db.findFilmByKeyword(keyword);

			if (movies.size() == 0) {
				System.out.println("No movie found with that keyword. Please try again");
				startUserInterface(new Scanner(System.in));
			}

			for (Film f : movies) {
				System.out.println("Title: " + f.getTitle() + "\nLanguage: " + f.getLanguage() + "\nYear: "
						+ f.getReleaseYear() + "\n Description: " + f.getDescription() + "\nRating: " + f.getRating()
						+ "\nActors: " + f.getActors());

			}
			startUserInterface(new Scanner(System.in));

		case 3:
			System.out.println("Goodbye");
			break;

		}
	}
}
