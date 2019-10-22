package equipos;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DOMFormacionQuilmes {

    public static Collection<Node> devolverFormacion() throws IOException, SAXException, ParserConfigurationException {
        //2 lineas para abrir y cargar el XML en un input stream
        ClassLoader classLoader = DOMFormacionQuilmes.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("quilmes_2012.xml");

        // Creamos el parser y parseamos el input stream
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(new InputSource(inputStream));
        //Al hacer lo de arriba (Document doc=...) creamos tod0 el ARBOL DOM.
        //Y despues de eso con doc.algo podemos agarrar cosas.

        //Mostramos SOLO los jugadores de quilmes (los visitantes):
        NodeList nodeList = doc.getElementsByTagName("visitante");
        final Node visitante = nodeList.item(0);  //(0) --> sacamos el 1er item!. De la lista sacamos el item 0 (ya que sabemos que hay 1 solo visitante)
        //NODO=elementos del arbol.
        Node formacion = getUniqueNodeByName(visitante.getChildNodes(), "formacion");       //Con getChildNodes() podemos obtener los hijos de visitante (osea formacion, captain o dt). En este caso "formacion" es el nodo que queremos traer.
        //Creamos una COLECCION ya que es una interfaz ITERABLE con un for:
        Collection<Node> quilmesPlayersNodes = getNodesByName(formacion.getChildNodes(), "jugador");  //le pedimos todos los nodos "jugador" (hijos de formacion)

        return quilmesPlayersNodes; //retornamos la coleccion y la imprimimos en el main.
    }

    //Hecho mas facil:
    static Collection<Node> getNodesByName(NodeList nodeList, String name) {
        List<Node> nodeListToReturn = new ArrayList<>();
        for (int idx = 0 ; idx < nodeList.getLength(); idx++) {
            Node node = nodeList.item(idx);
            if (node.getNodeName().equals(name)) {  //Nos quedamos con los n nodos que en getNodeName sea igual (equals) al name que le pasamos por parametro.
                nodeListToReturn.add(node);
            }
        }
        return nodeListToReturn;
    }

    static Node getUniqueNodeByName(NodeList nodeList, String name) {
        Collection<Node> nodesFound = getNodesByName(nodeList, name);
        if (!nodesFound.isEmpty() && nodesFound.size() > 1) {
            throw new IllegalStateException("Se encontró más de 1 nodo con ese nombre");
        }
        return nodesFound.iterator().next();
    }

}
