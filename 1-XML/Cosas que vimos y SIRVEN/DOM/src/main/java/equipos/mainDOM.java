package equipos;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Collection;

//Me devuelve la formacion del visitante (usando DOMFormacionQuilmes) y la figura del partido (usando DOMFiguraEquipo).
public class mainDOM {

    public static void main(String [] args) throws IOException, SAXException, ParserConfigurationException {
        Collection<Node> quilmesPlayersNodes = DOMFormacionQuilmes.devolverFormacion();  //guardamos en nuestra variable quilmesPlayersNodes de tipo Collection a la formacion de Quilmes.
        //Imprimimos la formacion:
        for (Node player : quilmesPlayersNodes) {  //Aca en el for recorremos desde el 1ER HIJO, osea desde Emanuel Tripodi (el cual es un nodo TEXTO en el DOM).
            System.out.println(player.getFirstChild().getNodeValue());
        }

        //Imprimimos la figura del partido:
        String figura = DOMFiguraEquipo.dameFiguraDelPartido("quilmes_2012.xml"); //le pasamos el archivo xml.
        System.out.println("Figura:"+ figura);
    }
}
