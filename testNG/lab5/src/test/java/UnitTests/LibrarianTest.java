package UnitTests;

import com.company.Book;
import com.company.BookProto;
import com.company.Magazine;
import com.company.Newspaper;
import com.company.classes.Librarian;
import com.company.enums.BookType;
import com.company.enums.CoverMaterial;
import org.junit.After;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class LibrarianTest {

    private final static int PAGE_COUNT = 10;
    private final static String REDACTION = "Test";
    private final static CoverMaterial COVER_MATERIAL = CoverMaterial.LEATHER;
    private final static int COST = 100;
    private final static BookType BOOK_TYPE = BookType.DRAMA;
    private final static Date DATE = new Date(2019, 1, 8);
    private final static Date DATE1 = new Date(2019, 2, 1);
    private final static Date DATE2 = new Date(2019, 3, 2);
    private final static Date DATE3 = new Date(2019, 4, 3); //мет вып подг

    private static List<BookProto> Library = new ArrayList<BookProto>();

    @BeforeSuite
    public static void FillLibrary(){

        Book book = new Book(PAGE_COUNT, COVER_MATERIAL, COST, BOOK_TYPE);
        Newspaper newspaper = new Newspaper(PAGE_COUNT * PAGE_COUNT, COST * 2, DATE);
        Magazine magazine = new Magazine(PAGE_COUNT - PAGE_COUNT / 2, COST, REDACTION, DATE);

        Library.add(book);
        Library.add(newspaper);
        Library.add(magazine);
        System.out.println("BeforeSuite");
    }

    @Test (enabled = false)
    public static void testGetGeneralCostOfLibrary(){
        int expectedCost = 0;
        for (BookProto bk : Library) {
            expectedCost += bk.cost;
        }
        int actualCost = Librarian.GetGeneralCostOfLibrari(Library);
        Assert.assertEquals(expectedCost, actualCost);
    }

    @BeforeTest
    @AfterMethod
    @Test
    public static void testMakeSortNewspapersByRelease(){
        Newspaper newspaper1 = new Newspaper(PAGE_COUNT, COST, DATE1);
        Newspaper newspaper2 = new Newspaper(PAGE_COUNT, COST, DATE2);
        Newspaper newspaper3 = new Newspaper(PAGE_COUNT, COST, DATE3);

        List<Newspaper> newspapers = new ArrayList<Newspaper>();
        newspapers.add(newspaper1);
        newspapers.add(newspaper2);
        newspapers.add(newspaper3);

        List<Newspaper> actualNewspaper = Librarian.MakeSortNewspapersByRelease(newspapers);
        Collections.sort(newspapers);
        Assert.assertEquals(newspapers.get(0).getOutDate(), actualNewspaper.get(0).getOutDate());
        System.out.println("AfterMethod");
        System.out.println("BeforeTest");
    }

    @Test (timeOut = 1000)
    public static void testGetBookByPagesCount() throws Exception{
        Newspaper newspaper = new Newspaper(PAGE_COUNT / 2, COST, DATE);

        Library.add(newspaper);
        BookProto actualBook = Librarian.GetBookByPagesCount(Library, newspaper.pagesCount);
        Assert.assertEquals(newspaper.pagesCount, actualBook.pagesCount);
    }

}
