package modulo2XML;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;

public class CrearXML {
    public static void main(String[] args) {
        try {
            // Crear un nuevo documento XML
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Crear el elemento raíz
            Element rootElement = doc.createElement("personas");
            doc.appendChild(rootElement);

            // Crear primer elemento persona
            Element persona1 = doc.createElement("persona");
            rootElement.appendChild(persona1);

            // Añadir nombre a la primera persona
            Element nombre1 = doc.createElement("nombre");
            nombre1.appendChild(doc.createTextNode("Juan"));
            persona1.appendChild(nombre1);

            // Añadir edad a la primera persona
            Element edad1 = doc.createElement("edad");
            edad1.appendChild(doc.createTextNode("30"));
            persona1.appendChild(edad1);

            // Crear segundo elemento persona
            Element persona2 = doc.createElement("persona");
            rootElement.appendChild(persona2);

            // Añadir nombre a la segunda persona
            Element nombre2 = doc.createElement("nombre");
            nombre2.appendChild(doc.createTextNode("Ana"));
            persona2.appendChild(nombre2);

            // Añadir edad a la segunda persona
            Element edad2 = doc.createElement("edad");
            edad2.appendChild(doc.createTextNode("25"));
            persona2.appendChild(edad2);

            // Guardar el documento XML en un archivo
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/data/personasCreadas.xml"));
            transformer.transform(source, result);

            System.out.println("Archivo XML creado con éxito: personasCreadas.xml");

        } catch (Exception e) {
            System.out.println("Error al crear el archivo XML: " + e.getMessage());
            e.printStackTrace();
        }
    }
}