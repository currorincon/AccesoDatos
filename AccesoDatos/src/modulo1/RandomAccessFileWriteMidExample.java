package modulo1;

import java.io.*;

public class RandomAccessFileWriteMidExample {
    public static void main(String[] args) {
    	
    	/*
		 * 
		 * 
		 * 
		 * Resumen:
		 * 
		 * seek(long pos) mueve el puntero del archivo a una posición específica en
		 * bytes desde el inicio del archivo.
		 * 
		 * Los datos se almacenan en archivos como bytes (8 bits), y puedes
		 * interpretarlos o manipularlos a nivel binario si es necesario.
		 * 
		 * La posición de seek debe calcularse en función del tamaño en bytes de los
		 * tipos de datos que estás manejando (por ejemplo, 4 bytes para un int, 8 bytes
		 * para un double).
		 * 
		 * Aunque RandomAccessFile opera a nivel de bytes, puedes convertir los bytes
		 * leídos a su representación binaria para trabajar a nivel de bits si es
		 * necesario.
		 * 
		 */
    	
    	// ejemploByte();
    	// ejemploMitad();
    	// ejemploBIN();
    	
    	
    }
    
    public static void ejemploByte() {
    	 String filePath = "src/data/archivo_byte.txt";

         try {
             // Crear un archivo de acceso aleatorio en modo lectura/escritura
             RandomAccessFile raf = new RandomAccessFile(filePath, "rw");

             // Escribir datos en el archivo en formato de bytes
             raf.write(new byte[]{10, 20, 30, 40, 50});  // Escribimos 5 bytes

             // Mover el puntero a la posición del byte 2 (tercer byte)
             raf.seek(2);

             // Leer el byte en esa posición
             int byteLeido = raf.read();  // Lee un byte y lo devuelve como entero

             // Mostrar el byte leído
             System.out.println("Byte leído: " + byteLeido); // Debería mostrar 30

             // Cerrar el archivo
             raf.close();

         } catch (IOException e) {
             e.printStackTrace();
         }
    }
    
    public static void ejemploMitad() {
    	String filePath = "src/data/archivo_mitad.txt";

        try {
            // Crear un archivo de acceso aleatorio en modo "rw" (lectura/escritura)
            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");

            // Escribir un mensaje inicial en el archivo
            raf.writeUTF("Quizás esta sea la mitad");
            
            // Obtener la longitud del archivo
            long fileLength = raf.length();
            System.out.println("Longitud del archivo antes de escribir: " + fileLength + " bytes.");

            // Mover el puntero a la mitad del archivo
            long midPosition = fileLength / 2;
            raf.seek(midPosition);

            // Escribir un nuevo mensaje a partir de la mitad del archivo
            raf.writeUTF("Mensaje desde la mitad.");

            raf.seek(0);

            // Leer desde la posición especificada
            String textoDesdePosicion = raf.readUTF();

            // Mostrar lo que se leyó
            System.out.println("Texto leído desde la posición 1: " + textoDesdePosicion);

            
            // Mostrar la nueva longitud del archivo
            System.out.println("Longitud del archivo después de escribir: " + raf.length() + " bytes.");

            // Cerrar el archivo
            raf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ejemploBIN() {

    	        String filePath = "src/data/archivo_binario.txt";

    	        try {
    	            // Crear un archivo de acceso aleatorio en modo lectura/escritura
    	            RandomAccessFile raf = new RandomAccessFile(filePath, "rw");

    	            // Escribir algunos bytes en el archivo
    	            raf.write(new byte[]{(byte) 0b00101101, (byte) 0b11001100, (byte) 0b10101010});  // Escribimos 3 bytes en binario

    	            // Mover el puntero al primer byte
    	            raf.seek(0);

    	            // Leer los bytes y mostrarlos en binario
    	            for (int i = 0; i < 3; i++) {
    	                int byteLeido = raf.read();  // Leer un byte
    	                String binario = String.format("%8s", Integer.toBinaryString(byteLeido & 0xFF)).replace(' ', '0');
    	                System.out.println("Byte " + i + " en binario: " + binario);
    	            }

    	            // Cerrar el archivo
    	            raf.close();

    	        } catch (IOException e) {
    	            e.printStackTrace();
    	        }
    	    }
    	

}

