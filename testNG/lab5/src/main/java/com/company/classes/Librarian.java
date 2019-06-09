package com.company.classes;

import com.company.BookProto;
import com.company.Newspaper;
import java.util.Collections;
import java.util.List;

public class Librarian{

    public static int GetGeneralCostOfLibrari(List<BookProto> library){
        int result = 0;
        for (BookProto book : library) {
            result += book.cost;
        }

        return result;
    }

    public static List<Newspaper> MakeSortNewspapersByRelease(List<Newspaper> newspapers){
        Collections.sort(newspapers);
        return newspapers;
    }


    public static BookProto GetBookByPagesCount(List<BookProto> library, int pages){
        for (BookProto book : library){
            if (book.pagesCount == pages){
                return  book;
            }
        }
        return null;
    }
}
