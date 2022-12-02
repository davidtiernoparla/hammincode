public class Receiver {
    public void detectarErroresConHamming(int[] mensajeConRuido) {

        
        int posError = calcularPosError(mensajeConRuido);
        boolean hayDobleError = comprobarDobleError(mensajeConRuido);

        

        if (posError != 0 && hayDobleError == true) {
                System.out.println("");
                System.out.println("Hay doble error");

        } else if (posError !=0){
            System.out.println("");
            System.out.println(" Hay error en la posicion" + posError);

        }else{
            System.out.println("");
            System.out.println("No hay error");
        }
    }

    private boolean esPotenciaDeDos(int num) {

        if (num == 0) {

            return false;

        }
        while (num != 1) {

            if (num % 2 != 0) {

                return false;

            }

            num = num / 2;

        }

        return true;

    }

    private int calcularPosError(int[] mensajeConRuido) {

        String numBinario = "0";
        StringBuilder numBinarioReves = new StringBuilder();
        int[] mensajeDudoso = mensajeConRuido;
        int contUnos = 0;
        int posBinaria = 0;
        int posErronea = 0;
        



        for (int i = 1; i < mensajeDudoso.length; i++) {

            if (esPotenciaDeDos(i) == true && i != 0) {

                for (int j = i + 1; j < mensajeDudoso.length; j++) {

                    numBinario = Integer.toBinaryString(j);
                    numBinarioReves = numBinarioReves.append(numBinario).reverse();

                    // El 1 en unicode es 49, por eso busco el 49, es como buscar el 1
                    if (numBinario.length() > posBinaria && numBinarioReves.charAt(posBinaria) == 49 && mensajeDudoso[j] == 1) {

                        contUnos++;

                    }

                    numBinarioReves.setLength(0);

                }

                posBinaria++;


                if ((contUnos % 2 == 0 && mensajeDudoso[i] == 1) || (contUnos % 2 != 0 && mensajeDudoso[i] == 0)) {
                    posErronea = posErronea + Integer.parseInt(Integer.toBinaryString(i));
                } 

                contUnos = 0;

            }
        }

        return posErronea;
    }

    private boolean comprobarDobleError(int[] mensajeConRuido) {

        String numBinario = "0";
        StringBuilder numBinarioReves = new StringBuilder();
        int[] mensajeDudoso = mensajeConRuido;
        int contUnos = 0;
        int posBinaria = 0;
        boolean hayDobleError = false;



                for (int j = 1; j < mensajeDudoso.length; j++) {

                    numBinario = Integer.toBinaryString(j);
                    numBinarioReves = numBinarioReves.append(numBinario).reverse();

                    // El 1 en unicode es 49, por eso busco el 49, es como buscar el 1
                    if (numBinario.length() > posBinaria && numBinarioReves.charAt(posBinaria) == 49 && mensajeDudoso[j] == 1) {

                        contUnos++;

                    }

                    numBinarioReves.setLength(0);


                if (contUnos % 2 == 0) {

                    mensajeDudoso[0] = 0;

                } else {

                    mensajeDudoso[0] = 1;

                }

                contUnos = 0;

            }


        if (contUnos % 2 == 0 && mensajeDudoso[0] == 1 || contUnos % 2 != 0 && mensajeDudoso[0]  == 0){
            hayDobleError = true;
        }else if (mensajeDudoso[0]  == 0){
            hayDobleError = false;
        }
        return hayDobleError;
    }
}
