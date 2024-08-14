package com.bookutil;

import com.models.Book;
import com.services.Bookstore;
import com.exceptions.InvalidBookException;

import java.util.*;

public class BookUtil {

    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            try {
                System.out.println("Enter details for book " + (i + 1) + ":");
                System.out.print("Book ID: ");
                String bookID = sc.nextLine();
                System.out.print("Title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                System.out.print("Category: ");
                String category = sc.nextLine();
                System.out.print("Price: ");
                float price = sc.nextFloat();
                sc.nextLine(); 

                validateBook(bookID, category, price);

                Book book = new Book(bookID, title, author, category, price);
                bookstore.addBook(book);

            } catch (InvalidBookException e) {
                System.out.println("Error: " + e.getMessage());
                i--; 
            }
        }

        System.out.println("All books in the bookstore:");
        for (Book book : bookstore.getAllBooks()) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }

        sc.close();
    }

    private static void validateBook(String bookID, String category, float price) throws InvalidBookException {
        if (!bookID.startsWith("B") || bookID.length() != 4) {
            throw new InvalidBookException("Book ID must start with 'B' and be 4 characters long.");
        }
        if (!(category.equalsIgnoreCase("science") || category.equalsIgnoreCase("fiction") || 
              category.equalsIgnoreCase("technology") || category.equalsIgnoreCase("others"))) {
            throw new InvalidBookException("Category must be one of the following: science, fiction, technology, others.");
        }
        if (price < 0) {
            throw new InvalidBookException("Price cannot be negative.");
        }
    }
}
