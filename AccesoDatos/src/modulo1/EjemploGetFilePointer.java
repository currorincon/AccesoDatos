package modulo1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class EjemploGetFilePointer {
    public static void main(String[] args) {
        String nombreArchivo = "archivo_ejemplo.txt";

        try {
            // Abrir archivo en modo lectura/escritura
            RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw");

            // Escribir algunos datos en el archivo
            raf.writeUTF("Hola Mundo");

            // Mostrar la posición del puntero después de escribir
            System.out.println("Posición del puntero después de escribir 'Hola Mundo': " + raf.getFilePointer());

            // Mover el puntero al inicio del archivo
            raf.seek(0);
            System.out.println("Posición del puntero después de seek(0): " + raf.getFilePointer());

            // Leer el contenido del archivo
            String contenido = raf.readUTF();
            System.out.println("Contenido leído: " + contenido);

            // Mostrar la posición del puntero después de leer
            System.out.println("Posición del puntero después de leer: " + raf.getFilePointer());

            // Escribir más datos al final del archivo
            raf.writeUTF("¡Adiós Mundo!");
            System.out.println("Posición del puntero después de escribir '¡Adiós Mundo!': " + raf.getFilePointer());

            // Cerrar el archivo
            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
