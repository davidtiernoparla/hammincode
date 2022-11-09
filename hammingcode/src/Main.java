public class Main {
    public static void main(String[] args) {
        Writer escritor = new Writer();

        int[] mensaje = escritor.generarMensaje();

        System.out.println("");
        System.out.println("mensaje en bruto, sin aplicar hamming:  ");
        System.out.println("");

        for (int i = 0; i < mensaje.length; i++) {
        System.out.print(mensaje[i]);
        }
    }
}
