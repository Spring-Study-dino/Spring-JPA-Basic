package jpabook.jpashop.domain;

import jakarta.persistence.Entity;

@Entity
public class Book extends Item{
    private String isbn;
    private  String author;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
