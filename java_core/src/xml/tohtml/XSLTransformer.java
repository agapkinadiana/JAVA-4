package xml.tohtml;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.util.logging.Logger;

public class XSLTransformer {
    private Logger LOG = Logger.getLogger(XSLTransformer.class.toString());
    public static void transform(){
        TransformerFactory xstf = TransformerFactory.newInstance();

        // установка используемого XSL-преобразования
        Transformer transformer = null;

        try {
            transformer = xstf.newTransformer(new StreamSource("src/files/information.xsl"));

            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource("src/files/workersMarsh.xml"),
                    new StreamResult("src/files/information.html"));
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
