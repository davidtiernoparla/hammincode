import java.util.Random;

public class Noise {
    public int[] alterarMensaje(int[] mensajeHamming) {

        int[] mensajeConRuido = mensajeHamming;

        mensajeConRuido = hacerRuido(mensajeHamming);

        return mensajeConRuido;

    }

    private int[] hacerRuido(int[] mensajeHamming) {

        Random aleatorio = new Random();
        int[] mensajeConRuido = mensajeHamming;
        int numCambios = aleatorio.nextInt(3);
        int posAleatoria = 0;

        //Evita aplicar un numero de cambios mayor al tamanno del mensaje
        while (numCambios > mensajeHamming.length){

            numCambios--;

        }

        

        while (numCambios != 0) {

            posAleatoria = aleatorio.nextInt(mensajeConRuido.length);

            if (mensajeConRuido[posAleatoria] == mensajeHamming[posAleatoria]) {

                if (mensajeConRuido[posAleatoria] == 1) {

                    mensajeConRuido[posAleatoria] = 0;

                } else {

                    mensajeConRuido[posAleatoria] = 1;

                }

                numCambios--;

            }

        }

        return mensajeConRuido;

    }
}
