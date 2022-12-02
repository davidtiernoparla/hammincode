public class Main {
    public static void main(String[] args) {
        Writer escritor = new Writer();
        Sender mensajero = new Sender();
        Noise ruido = new Noise();
        Receiver receptor = new Receiver();

        int[] mensaje = escritor.generarMensaje();

        System.out.println("");
        System.out.println("mensaje en bruto, sin aplicar hamming:  ");
        System.out.println("");

        for (int i = 0; i < mensaje.length; i++) {

        System.out.print(mensaje[i]);

        }

        mensaje = mensajero.generarMensajeConHamming(mensaje, mensaje.length);

        System.out.println("");
        System.out.println("Mensaje de hamming con todos los bits de redundancia:  ");
        System.out.println("");

        for (int i = 0; i < mensaje.length; i++) {

            System.out.print(mensaje[i]);

        }
        
        mensaje = ruido.alterarMensaje(mensaje);

        System.out.println("");
        System.out.println("Mensaje de hamming con 0, 1 o 2 errores:  ");
        System.out.println("");

        for (int i = 0; i < mensaje.length; i++) {

            System.out.print(mensaje[i]);

        }

        receptor.detectarErroresConHamming(mensaje);
        
    }
}
