import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Created by Juan Lagostena on 04/09/16
 * jlagostena@bitsense.com.ar
 * .
 */
public class SAXBasicHandler extends DefaultHandler implements LexicalHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Comienza el documento");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println(uri + " - " + localName + " - " + qName + " - " + attributes);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Termina el documento");
    }


    public void startDTD(String name, String publicId, String systemId) throws SAXException {

    }

    public void endDTD() throws SAXException {

    }

    public void startEntity(String name) throws SAXException {

    }

    public void endEntity(String name) throws SAXException {

    }

    public void startCDATA() throws SAXException {

    }

    public void endCDATA() throws SAXException {

    }

    public void comment(char[] ch, int start, int length) throws SAXException {
        System.out.print("comment --> ");
        String comment = new String(ch);
        System.out.println(comment.substring(start, start + length));
    }
}
