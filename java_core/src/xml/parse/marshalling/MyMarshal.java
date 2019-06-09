package xml.parse.marshalling;

import director.Director;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

// Маршаллизация — преобразование данных из java-объекта в XML
public class MyMarshal {
    public static void marshal(Director director) {
        try {
            JAXBContext context = JAXBContext.newInstance(Director.class);
            Marshaller marshal = context.createMarshaller();
            marshal.marshal(director, new FileOutputStream("src/files/workersMarsh.xml"));
        }
        catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
