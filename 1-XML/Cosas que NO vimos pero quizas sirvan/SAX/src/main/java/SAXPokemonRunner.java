import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/**
 * Ejemplo extraído modificado desde
 * https://github.com/helicida/Example_SAX
 *
 */
public class SAXPokemonRunner {


    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, SAXException {

        SAXParserFactory factory = SAXParserFactory.newInstance();  //Creem una instancia d'una factoria de parser SAX

        ClassLoader classLoader = SAXPokemonRunner.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("pokemons.xml");

        SAXParser saxParser = factory.newSAXParser();
        SAXPokemonHandler sh = new SAXPokemonHandler();

        try{
            saxParser.parse(inputStream,sh);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
