package com.services;


import java.util.*;
import com.models.Book;

public class Bookstore {
    
    private List<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void searchByTitle(String title) {
    	 for (Book book : books) {
             if (book.getTitle().equals(title)) {
                 System.out.println(book);
               }}
    }
    
    public void searchByAuthor(String author) {
    	 for (Book book : books) {
             if (book.getAuthor().equals(author)) {
                 System.out.println(book);
               }}
    }

    public Book findBookById(String bookID) {
        for (Book book : books) {
            if (book.getBookID().equals(bookID)) {
                return book;
            }
        }
        return null;
    }

   
   public List<Book>getAllBooks() {
        return new ArrayList<>(books);
    }
}
