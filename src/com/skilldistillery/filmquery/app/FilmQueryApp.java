package com.skilldistillery.filmquery.app;

import java.util.Scanner;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {
  
  DatabaseAccessor db = new DatabaseAccessorObject();

  public static void main(String[] args) {
    FilmQueryApp app = new FilmQueryApp();
    app.test();
//    app.launch();
  }

  private void test() {
    Film film = db.findFilmById(1);
    System.out.println(film);
  }

  private void launch() {
    Scanner input = new Scanner(System.in);
    
    startUserInterface(input);
    
    input.close();
  }

  private void startUserInterface(Scanner input) {
	 System.out.println("What would you like to do?");
	 System.out.println("1. Look up a film by its ID?");
	 System.out.println("2. Look up a film by a keyword?");
	 System.out.println("3. Exit the program");
	 
	 int choice = 0;
    
  }
  // if(! findFilmsByActorId(actorId).isEmpty{.....} sysout("no films for that actor)

}
