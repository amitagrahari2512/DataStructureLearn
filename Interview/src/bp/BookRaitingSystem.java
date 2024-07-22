package bp;

/*
Book Rating System
==================

You have been given the task to develop a system that manages ratings of different books from various genres. You need to implement a class, BookRatings, which can perform the following tasks:

Initialise the System : The system should be initialised with three arrays - books (representing the book titles), genres (representing the corresponding genres of the books), and ratings (representing the initial ratings of the books). All arrays will be of length n.

Modify the Rating of a Book : The system should be able to modify the rating of any given book.

Return the Highest Rated Book : The system should be able to return the highest rated book for a given genre. If there is a tie in ratings, return the lexicographically smaller book name.

Your solution should efficiently handle these operations.

Method Signatures
-----------------

BookRatings(String[] books, String[] genres, int[] ratings)
// Initializes the system.

void changeRating(String book, int newRating)
// Changes the rating of the book.

String highestRated(String genre)
// Returns the name of the highest-rated book of the given genre.

Constraints
-----------

n == books.length == genres.length == ratings.length

books[i] consists of English letters, genres[i] consist of lowercase English letters.  

All the strings in books are distinct. 

Book will be the name of a book in the system across all calls to changeRating.

Genre will be a genre of at least one book in the system across all calls to highestRated.

Examples
--------

BookRatings bookRatings = new BookRatings(
  ["Harry Potter", "The Lord of the Rings", "The Hobbit", "Pride and Prejudice", "To Kill a Mockingbird", "The Great Gatsby"],
  ["fantasy", "fantasy", "fantasy", "romance", "classic", "classic"],
  [12, 8, 13, 15, 14, 7]
);

bookRatings.highestRated("fantasy");
// "The Hobbit"

bookRatings.highestRated("classic");
// "To Kill a Mockingbird"

bookRatings.changeRating("The Lord of the Rings", 16);
bookRatings.highestRated("fantasy");
// "The Lord of the Rings"

bookRatings.changeRating("The Lord of the Rings", 13);
bookRatings.highestRated("fantasy");
// "The Hobbit"

// "The Hobbit ..." < "The Lord of ...""
*/

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
	public static void main(String[] args) {
		String[] bookName = { "Harry Potter", "The Lord of the Rings", "The Hobbit", "Pride and Prejudice",
				"To Kill a Mockingbird", "The Great Gatsby" };
		String[] genre = { "fantasy", "fantasy", "fantasy", "romance", "classic", "classic" };
		int[] raitings = { 12, 8, 13, 15, 14, 7 };

		BookRaitings br = new BookRaitings(bookName, genre, raitings);
		String highRatedBookName = br.highestRated("fantasy");
		System.out.println(highRatedBookName);

		highRatedBookName = br.highestRated("classic");
		System.out.println(highRatedBookName);

		br.changeRating("The Lord of the Rings", 16);
		highRatedBookName = br.highestRated("fantasy");
		System.out.println(highRatedBookName);

		br.changeRating("The Lord of the Rings", 13);
		highRatedBookName = br.highestRated("fantasy");
		System.out.println(highRatedBookName);
	}
}

class BookRaitings {
	Map<String, Book> raitingMap = new HashMap<>();
	Map<String, List<Book>> genreMap = new HashMap<>();
	// Map<String, TreeSet<Book>> genreMap = new HashMap<>();

	public BookRaitings(String[] bookName, String[] genre, int[] raitings) {
		for (int i = 0; i < bookName.length; i++) {
			Book book = new Book(bookName[i], genre[i], raitings[i]);
			raitingMap.put(bookName[i], book);
			if (genreMap.containsKey(genre[i])) {
				List<Book> list = genreMap.get(genre[i]);
				list.add(book);
				genreMap.put(genre[i], list);
			} else {
				ArrayList<Book> list = new ArrayList<>();
				list.add(book);
				genreMap.put(genre[i], list);
			}
		}
	}

	// O(n log n)
	// traverse: O(n)
	// TreeSet: O(log n)
	public String highestRated(String genre) {
		List<Book> list = genreMap.get(genre);

		Collections.sort(list, new Comparator<Book>() {
			public int compare(Book b1, Book b2) {
				if (b2.raitings - b1.raitings == 0) {
					return b1.bookName.compareTo(b2.bookName);
				}
				return b2.raitings - b1.raitings;
			}
		});

		return list.get(0).bookName;
	}

	// O(1)
	public void changeRating(String bookName, int raitings) {
		raitingMap.get(bookName).raitings = raitings;
	}
}

class Book {
	String bookName;
	String genre;
	int raitings;

	public Book(String bookName, String genre, int raitings) {
		this.bookName = bookName;
		this.genre = genre;
		this.raitings = raitings;
	}
}
