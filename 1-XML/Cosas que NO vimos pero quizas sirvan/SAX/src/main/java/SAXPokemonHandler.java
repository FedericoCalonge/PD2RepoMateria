import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * Ejemplo extraído modificado desde
 * https://github.com/helicida/Example_SAX
 *
 */
public class SAXPokemonHandler extends DefaultHandler {

    int contador_pokemon = 0;
    boolean pokemon = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("Nombre")){
            contador_pokemon++;
            System.out.print(contador_pokemon + " - El tipo del pokemon es " + attributes.getValue("clase"));
            pokemon = true;
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(pokemon){
            System.out.print(" y su nombre es " + new String(ch, start, length) + "\n");
            pokemon = false;
        }

    }

}