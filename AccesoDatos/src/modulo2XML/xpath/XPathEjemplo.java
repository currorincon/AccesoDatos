package modulo2XML;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathConstants;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.io.File;

public class XPathEjemplo {

	 public static void main(String[] args) {
	      
		 try {
	         
	            // Obtenemos la ruta del proyecto
	            String rutaProyecto = System.getProperty("user.dir");
	            

	            // Ruta de la imagen original dentro de la carpeta 'src'
	            String rutaXMLOriginal = rutaProyecto + "/src/data/libros.xml";
	            
	            // Cargar el archivo XML
	            File archivoXML = new File(rutaXMLOriginal);
	            
	            
	            
	            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	            
	            Document documento = dBuilder.parse(archivoXML);

	            
	            // ENFATIZO NORMALIZAR SIEMPRE 
	            // Normalizar el documento XML (opcional pero recomendado)
	            documento.getDocumentElement().normalize();

	            // Crear el objeto XPath
	            XPath xPath = XPathFactory.newInstance().newXPath();
	            
	            // Ejemplo: 
	            String expresion4 = "/";
	            String titulo = xPath.compile(expresion4).evaluate(documento);
	            System.out.println("\nResultado: " + titulo);

	            // Ejemplo: Obtener todos los títulos de los libros
	            String expresion1 = "/libros/libro/titulo";
	            XPathExpression expr1 = xPath.compile(expresion1);
	            NodeList nodos = (NodeList) expr1.evaluate(documento, XPathConstants.NODESET);

	            System.out.println("Títulos de los libros:");
	            for (int i = 0; i < nodos.getLength(); i++) {
	                System.out.println(nodos.item(i).getTextContent());
	            }

	            // Ejemplo: Obtener el título del libro cuyo autor es "Ana García"
	            String expresion2 = "/libros/libro[autor='Ana García']/titulo";
	            String titulo1 = xPath.compile(expresion2).evaluate(documento);
	            System.out.println("\nLibro de Ana García: " + titulo1);

	            // Ejemplo: Contar cuántos libros hay
	            String expresion3 = "count(/libros/libro)";
	            Double cantidadLibros = (Double) xPath.compile(expresion3).evaluate(documento, XPathConstants.NUMBER);
	            System.out.println("\nNúmero de libros: " + cantidadLibros.intValue());

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

}
