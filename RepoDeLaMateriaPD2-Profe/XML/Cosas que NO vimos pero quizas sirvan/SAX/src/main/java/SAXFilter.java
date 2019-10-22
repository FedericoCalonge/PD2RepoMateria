import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * Juan Lagostena on 06/09/16
 * jlagostena@bitsense.com.ar
 * .
 */
public class SAXFilter extends XMLFilterImpl {

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if (!"venta".equals(localName) &&
                !"street".equals(localName)) {
            super.startElement(uri, localName, qName, atts);
        }
    }
}
