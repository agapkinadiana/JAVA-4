package com.company.classes;

import com.company.Book;
import com.company.BookProto;
import com.company.Newspaper;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.stream.XMLStreamWriter;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Serializer {

    private static final String DIR_PATH = "D:\\university\\2 curse\\ооп2\\Java-labs\\lab3_4\\files\\";


    public static void AnalyzeBooksXML() throws Exception{

        File inputFile = new File(DIR_PATH + "books.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root element: " + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("book");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node node = nList.item(temp);

            System.out.println();
            System.out.println("Element:" + node.getNodeName());

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println("Pages: " + eElement.getElementsByTagName("pages").item(0).getTextContent());
                System.out.println("Cost: " + eElement.getElementsByTagName("cost").item(0).getTextContent());
                System.out.println("Cover material: " + eElement.getElementsByTagName("material").item(0).getTextContent());
            }
        }

        System.out.println();
    }

    public static void SerializeBooksToDat(List<BookProto> books) throws Exception{
        ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(DIR_PATH + "books.dat"));
        stream.writeObject(books);
        stream.close();
    }

    public static void SerializeBooksToXML(List<BookProto> books) throws Exception{
        FileOutputStream file = new FileOutputStream(DIR_PATH + "NewBooks.xml");
        XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(file));
        encoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.writeObject(books);
        encoder.close();
        file.close();
    }

    public static List<BookProto> DeserializeXMLToBooks() throws Exception{

        List<BookProto> books = new ArrayList<BookProto>();
        FileInputStream file = new FileInputStream(DIR_PATH + "NewBooks.xml");
        XMLDecoder dencoder = new XMLDecoder(file);
        dencoder.setExceptionListener(new ExceptionListener() {
            public void exceptionThrown(Exception e) {
                System.out.println("Exception! :" + e.toString());
            }
        });
        books = (List<BookProto>) dencoder.readObject();
        dencoder.close();
        file.close();
        return books;
    }
}
