#General part

## Handling persistance

For relational databases, I was firstly implementing my own simple mappers capable of selecting all entities, by id or by condition
Later for the CarPort project in the second semester I used EbeanORM which is a JPA implementation.

For local storage I used my custom FileIO class capable of writing and reading a text file. I also used a pdf generating library for creating PDFs for the CarPort project. I stored those PDFs on the server and kept track of them using database, where I again used EbeanORM.

As for cookies and sessions I used Java Servlet API

## ORM

Orm is a method of mapping data from relational databases to objects in Objected Oriented programming languages like Java.

### pros

* Less code and easier to structure the data layer so you won't repeat your self. (Mappers for selecting from anywhere and Facades for data manipulation)
* Abstracting the actual Data layer (ORM can work with SQL databases (MySQL, PostgreSQL,..) and even with local storage)
* Cleaner for OOP, because you work with data in a form of Objects

### cons

* You are not in full control of what is happening
* Can result in bad database design, especially with Code first approach
* Not easy to master, which can lead to a lot of wasted time searching for bugs and incorrect behaviours

## JPA strategy

For each table you must have a class annotated with @Entity, this tells JPA that this class should be mapped to a table in the database.
The entity classes correspond the tables and one entity object contain data of one row in the table.

Every entity need to have a property with @Id annotation with tells JPA that this property is a primary key of the corresponding table.

## JPA vs JDBC

* In JPA you work with data as Objects whereas in JDBC you work with data in a form of ResultSet, which is not as easy and requires a lot of exception handling.
* In JPA you query using mappers, in JDBC you write raw SQL commands.
* With JDBC you're generally writing a lot more code, but you're in full control, because you communicate with database directly.
* JDBC works only with relational databases whereas JPA can work with local storage as well.