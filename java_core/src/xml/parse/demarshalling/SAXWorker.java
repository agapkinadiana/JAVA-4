package xml.parse.demarshalling;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import java.io.IOException;

public class SAXWorker {
    private static Logger LOG = Logger.getLogger(SAXWorker.class);
    public static void parse(){
        XMLReader reader;
        {
            try {
                //создание SAX-анализатора  из фабрики
                reader = XMLReaderFactory.createXMLReader();
                DemoWorkerParser handler = new DemoWorkerParser();

                // регестрируем
                reader.setContentHandler(handler);
                reader.parse("src/files/workersMarsh.xml");//запускаем
            }
            catch (SAXException e) {
                LOG.error("Error of SAX parser" + e);
            }
            catch (IOException e) {
                LOG.error("Error of I/O Stream" + e);
            }
        }
    }
}
