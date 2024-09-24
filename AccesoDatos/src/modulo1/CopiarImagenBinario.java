package modulo1;

import java.io.*;

public class CopiarImagenBinario {
	
	public static void main(String[] args) {
        // Obtenemos la ruta del proyecto
        String rutaProyecto = System.getProperty("user.dir");

        // Ruta de la imagen original dentro de la carpeta 'src'
        String rutaImagenOriginal = rutaProyecto + "/src/data/grancapitan.jpg";

        // Ruta donde se guardará la copia de la imagen
        String rutaImagenCopia = rutaProyecto + "/src/data/copiaImagenBinario.jpg";

        // Llamamos al método para copiar la imagen en binario
        copiarImagenBinario(rutaImagenOriginal, rutaImagenCopia);
    }

    public static void copiarImagenBinario(String rutaOriginal, String rutaCopia) {
        File archivoOriginal = new File(rutaOriginal);
        File archivoCopia = new File(rutaCopia);

        try (FileInputStream fis = new FileInputStream(archivoOriginal);
             FileOutputStream fos = new FileOutputStream(archivoCopia)) {
        	

                byte[] bytes = new byte[(int) rutaOriginal.length()]; // Crea un arreglo de bytes
                fis.read(bytes); // Lee los bytes del archivo
                
                // Imprime cada byte en formato binario
                for (byte b : bytes) {
                    // Convierte el byte a binario y lo imprime
                    System.out.print(String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0') + " ");
                }
           

            // Creamos un buffer para leer los datos en bloques
            byte[] buffer = new byte[1024];  // 1 KB de buffer
            int bytesLeidos;

            // Leer y escribir el archivo en bloques
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
            }

            System.out.println("Imagen copiada correctamente en formato binario: " + archivoCopia.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
