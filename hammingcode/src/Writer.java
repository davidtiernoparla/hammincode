import java.util.Scanner;

public class Writer {

    public int[] generarMensaje() {

        int tamMensaje = preguntarTamanno();
        int[] mensaje = new int[tamMensaje];

        rellenarMensaje(mensaje);

        return mensaje;

    }

    private int preguntarTamanno() {

        Scanner teclado = new Scanner(System.in);
        int numBits = 0;

        while (numBits <= 0) {
            System.out.println("Introduzca el numero de bits de el mensaje a enviar (deben ser mas de 0 bits)");
            numBits = teclado.nextInt();
        }

        teclado.close();

        return numBits;

    }

    private void rellenarMensaje(int[] mensaje) {
        for (int i = 0; i < mensaje.length; i++) {
            if (Math.random() < Math.random()) {
                mensaje[i] = 0;
            } else {
                mensaje[i] = 1;
            }
        }
    }


}
