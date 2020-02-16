import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Juan Lagostena on 04/09/16
 * jlagostena@bitsense.com.ar
 * .
 */
public class SAXEjemploBasico {


    public static void main(String[] args) throws SAXException, IOException {

        ClassLoader classLoader = SAXEjemploBasico.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("propiedades_original.xml");

        SAXBasicHandler handler = new SAXBasicHandler();

        XMLReader reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(handler);
        reader.setErrorHandler(handler);
        reader.setProperty("http://xml.org/sax/properties/lexical-handler", handler);

        reader.parse(new InputSource(inputStream));

        /*SAXFilter saxFilter = new SAXFilter();
        saxFilter.setParent(reader);
        saxFilter.setContentHandler(handler);
        saxFilter.setErrorHandler(handler);*/

        //saxFilter.parse(new InputSource(inputStream));

    }
}
