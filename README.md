# FilmQueryProject


## Description
This project was designed to accept user input to look up information in a SQL database. In this particular project I wanted to look up different films based on a movie id. The id's were between 1 and 1000. As long as a user entered in one of those numbers they were given all the details of said movie:


- Title
- Year it was released
- The language it was made in
- The rating (G, PG, PG-13, R, NC-17)
- the Description
- All of the actors who starred in the film


 If an invalid movie ID was entered a NullPointerException would be thrown and the user would be given an error message asking them to enter a valid movie ID.


The user was also given an option to search for a movie using a keyword. This keyword utilizes bind variables in the SQL statement. The trick I found with this part of the project was to use to "setString" methods. This I realized was for two bind variables. I originally only used one and I kept getting errors. If a user entered a keyword they would find any movies that match said keyword whether it be in the title or the description. The user was then provided with the following information:


- Title
- The language it was made in
- The year released
- The Description
- The rating
- And all the actors who starred in the film


This project made use of Java and how it communicates with a database. This project required me to use many OOP concepts such as creating different classes that describe an actor and a film and the characteristics Java should look for to create an actor object or a film object. This also required me to use the concept of separation of concerns. When this concept was applied there was only one class in Java that knew about the SQL database. This allowed for better testability, clarity, and organization.



[^1]: There is code that I left in that will find actors by the film Id. It is apart of an interface that can be implemented if one wishes

## Technologies Used
- Java
- Eclipse IDE
- Git/GitHub
- SQL
- Apache Maven
- Atom
- Terminal (-zsh)

## Lessons Learned
During this project the most difficult part I found was to be able to generate a SQL statement that encompassed the correct keyword. One of the biggest ideas I learned in this project was to use setString for the amount of bind variables present. Another idea I learned in this project was exactly how to implement Java code to be able to talk to a database. Using a try, catch was also something I learned the value of given the amount of exceptions that could be thrown during the running of this project. Many of the methods required me to throw or catch an exception and when the exception was caught it allowed me to produce a more clear error message rather than writing if statements. To be able to
