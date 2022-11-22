public class Sender {

    public int[] generarMensajeConHamming(int[] bitsInfo, int tamannoMensaje) {

        final int tamannoMensajeHamming = calcularNumBitsParidad(bitsInfo.length) + bitsInfo.length;
        int[] mensajeConHamming = meterBits(bitsInfo, tamannoMensajeHamming);

        return mensajeConHamming;

    }

    // Este metodo ya funciona, no tocar
    private int calcularNumBitsParidad(int numBitsInfo) {

        int numBitsParidad = 0;
        boolean esCorrecto = false;

        while (esCorrecto == false) {

            // (m + r + 1) ≤ 2^r m == bitInfo r = bit paridad
            if ((numBitsInfo + numBitsParidad + 1) <= (int) Math.pow(2, numBitsParidad)) {

                esCorrecto = true;

            } else {

                numBitsParidad++;

            }
        }

        numBitsParidad++;
        return numBitsParidad;

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

    private int[] meterBits(int[] bitsInfo, int tamannoMensaje) {

        int[] mensajeConHamming = new int[tamannoMensaje];

        /* Relleno el array de int de 2 para futuras comprobaciones (Por defecto java
        rellena de 0s)*/
        for (int i = 0; i < mensajeConHamming.length; i++) {

            mensajeConHamming[i] = 2;

        }

        mensajeConHamming = meterBitsInfo(bitsInfo, mensajeConHamming, tamannoMensaje);

        /* 
        System.out.println("");
        System.out.println("Mensaje de hamming con solo bits de datos");
        for (int i = 0; i < mensajeConHamming.length; i++) {
            System.out.print(mensajeConHamming[i]);
        }
        */

        mensajeConHamming = meterBitsParidad(mensajeConHamming);

        return mensajeConHamming;

    }

    private int[] meterBitsInfo(int[] bitsInfo, int[] mensajeConHamming, int tamannoMensaje) {

        int[] tablaBitsTotal = mensajeConHamming;
        int contBitsInfoMetidos = 0;

        for (int i = 0; i < tablaBitsTotal.length; i++) {

            if ((i != 0 && esPotenciaDeDos(i) == false && tablaBitsTotal[i] == 2)) {

                tablaBitsTotal[i] = bitsInfo[contBitsInfoMetidos];
                contBitsInfoMetidos++;

            }
        }

        return tablaBitsTotal;

    }

    private int[] meterBitsParidad(int[] mensajeSoloBitsDatos) {

        int[] mensajeCompleto = mensajeSoloBitsDatos;

        mensajeCompleto = meterBitsParidadNoGeneral(mensajeSoloBitsDatos);
        mensajeCompleto = meterBitParidadGeneral(mensajeCompleto);

        return mensajeCompleto;

    }

    private int[] meterBitsParidadNoGeneral(int[] mensajeCompleto) {

        String numBinario = "0";
        StringBuilder numBinarioReves = new StringBuilder();
        int[] mensajeBitsParidadNoGeneral = mensajeCompleto;
        int contUnos = 0;
        int posBinaria = 0;



        for (int i = 0; i < mensajeBitsParidadNoGeneral.length; i++) {

            if (esPotenciaDeDos(i) == true && i != 0) {

                for (int j = 1; j < mensajeBitsParidadNoGeneral.length; j++) {

                    numBinario = Integer.toBinaryString(j);
                    numBinarioReves = numBinarioReves.append(numBinario).reverse();

                    // El 1 en unicode es 49, por eso busco el 49, es como buscar el 1
                    if (numBinario.length() > posBinaria && numBinarioReves.charAt(posBinaria) == 49 && mensajeBitsParidadNoGeneral[j] == 1) {

                        contUnos++;

                    }

                    numBinarioReves.setLength(0);

                }

                posBinaria++;


                if (contUnos % 2 == 0) {

                    mensajeBitsParidadNoGeneral[i] = 0;

                } else {

                    mensajeBitsParidadNoGeneral[i] = 1;

                }

                contUnos = 0;

            }
        }

        return mensajeBitsParidadNoGeneral;

    }

    private int[] meterBitParidadGeneral(int[] mensajeCasiCompleto) {

        int contUnos = 0;
        int[] mensajeConBitParidadGeneral = mensajeCasiCompleto;

        for (int i = 0; i < mensajeCasiCompleto.length; i++) {

            if (mensajeCasiCompleto[i] == 1) {

                contUnos++;

            }
            if (contUnos % 2 == 0) {

                mensajeConBitParidadGeneral[0] = 0;

            } else {

                mensajeConBitParidadGeneral[0] = 1;

            }

        }

        return mensajeConBitParidadGeneral;
    }
}