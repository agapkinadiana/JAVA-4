package com.company;

import com.company.classes.Librarian;
import com.company.classes.Serializer;
import com.company.enums.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        try{
            Date magazineReleaseDate = new Date(2019, 2, 25);
            Date newspaperOutDate = new Date(2019, 1, 8);

            /*String magazineRedactionName = "Deagostiny";
            BookProto book1 = new Book(300, CoverMaterial.LEATHER, 300, BookType.FANTASTIC);
            BookProto magazine1 = new Magazine(20, 3, magazineRedactionName, magazineReleasedate);*/

            List<BookProto> books = new ArrayList<BookProto>();

            Newspaper newspaper1 = new Newspaper(15, 1, newspaperOutDate);
            Newspaper newspaper2 = new Newspaper(12, 1, magazineReleaseDate);
            Newspaper newspaper3 = new Newspaper(13, 2, newspaperOutDate);
            Book book1 = new Book(200, CoverMaterial.LEATHER, 2000, BookType.ADVANTURE);
            Magazine magazine1 = new Magazine(40, 30, "News", magazineReleaseDate);
            books.add(newspaper1);
            books.add(newspaper2);
            books.add(newspaper3);
            books.add(book1);
            books.add(magazine1);


            //Serializer.SerializeBooksToDat(books);
            //Serializer.AnalyzeBooksXML();
            Serializer.SerializeBooksToXML(books);
            books = Serializer.DeserializeXMLToBooks();

        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
    }
}
