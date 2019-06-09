package xml.validate;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAX {
    private static Logger LOG = Logger.getLogger(ValidatorSAX.class.toString());

    public void valide() {
        DocumentBuilder parser = null;

        try {
            parser = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            LOG.error(e);
            e.printStackTrace();
        }

        Document document = null;

        try {
            document = parser.parse(new File("src/files/information.xml"));
        }
        catch (SAXException e) {
            LOG.error(e);
            e.printStackTrace();
        } catch (IOException e) {
            LOG.error(e);
            e.printStackTrace();
        }
        // 1. Поиск и создание экземпляра фабрики для языка XML Schema
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        // load a WXS schema, represented by a Schema instance
        // 2. Компиляция схемы
        Source schemaFile = new StreamSource(new File("src/files/information.xsd"));
        Schema schema = null;

        try {
            schema = factory.newSchema(schemaFile);
        }
        catch (SAXException e) {
            LOG.error(e);
            e.printStackTrace();
        }

        // 3. Создание валидатора для схемы
        // create a Validator instance, which can be used to validate an instance document
        Validator validator = schema.newValidator();

        // validate the DOM tree
        try {
            validator.validate(new DOMSource(document));
            LOG.info("validation success");
        }
        catch (SAXException e) {
            LOG.error(e);
            // instance document is invalid!
        }
        catch (IOException e) {
            LOG.error(e);
            e.printStackTrace();
        }
    }
}
