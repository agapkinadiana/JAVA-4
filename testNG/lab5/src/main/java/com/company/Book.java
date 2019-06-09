package com.company;

import com.company.enums.BookType;
import com.company.enums.CoverMaterial;

public class Book extends BookProto{

    private BookType bookType;

    public BookType getBookType() {
        return bookType;
    }

    public Book(int pagesCount, CoverMaterial coverMaterial, int cost, BookType type){
        super(pagesCount, coverMaterial, cost);

        bookType = type;

        //log.info("The Book was created");
    }

    public Book(){}
}
