import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class A101 {
    
    public static void main(String args[]) {

        A101 test = new A101();
        test.begin();

    }

    int cm, cm2;

    public void begin() {
        List<String> salidas = new ArrayList();
        Integer matriz[][];

        int tam = 0;
        tam = validar();
        while (tam != 0) {
            matriz = new Integer[tam][tam];
            llenar(matriz);
            mostrar(matriz);
            if (isDiabolic(matriz)) {
                if (isEsoterico(matriz)) {
                    salidas.add("ESOTERICO");
                } else {
                    salidas.add("DIABOLICO");

                }

            } else {
                salidas.add("NO");
            }
            cm=0;
            cm2=0;
            tam = validar();

        }
        mostrar(salidas);
    }

    private boolean invalido(int tam) {
        return tam < 0;
    }

    private boolean isDiabolic(Integer[][] matriz) {
        int h = horizontal(matriz), v = vertical(matriz), d = diagonales(matriz);
        return h == v && v == d;
    }

    private boolean isEsoterico(Integer[][] matriz) {
        boolean serie = sigueLaSerie(matriz), esquinas = sumaDeEsquinas(matriz), tipoNum = (matriz.length % 2 != 0) ? impar(matriz) : par(matriz);
        if (serie && esquinas) {
        }
        return serie && esquinas && tipoNum;

    }

    private int horizontal(Integer[][] matriz) {
        int aux = 0, aux2 = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            aux += matriz[0][i];
        }
        for (int i = 1; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                aux2 += matriz[i][j];

            }
            if (aux == aux2) {
                aux2 = 0;
            } else {
                return -1;

            }
        }
        cm = aux;
        return aux;
    }

    private int vertical(Integer[][] matriz) {

        int aux = 0, aux2 = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            aux += matriz[i][0];
        }
        for (int j = 1; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz[0].length; i++) {
                aux2 += matriz[i][j];

            }
            if (cm == aux2) {
                aux2 = 0;
            } else {
                return -2;

            }
        }
        cm = aux;

        return aux;
    }

    private int diagonales(Integer[][] matriz) {
        int res = 0;
        int diag = diagonalPrincipal(matriz), inversa = diagInversa(matriz);
        res = diag;
        cm = diag;

        return diag == inversa ? res : -3;
    }

    private boolean sigueLaSerie(Integer[][] matriz) {
        Integer[] fila = convertirEnArreglo(matriz);
        Arrays.sort(fila);

        int cont = 0;
        for (int i = 0, k = 1; i < matriz[0].length * matriz[0].length; i++, k++) {
            if (fila[i] == k) {
                cont++;
            }

        }
        // rellenar(matriz,fila);
        // System.out.println(" matriz rellenada");
        // mostrar(matriz);
        return cont == matriz.length * matriz.length;
    }

    private boolean sumaDeEsquinas(Integer[][] matriz) {
        Integer[] esquinas = new Integer[4];
        Integer auxCm2 = (4 * cm) / matriz.length;
        esquinas[0] = matriz[0][0];
        esquinas[1] = matriz[0][matriz.length - 1];
        esquinas[2] = matriz[matriz.length - 1][0];
        esquinas[3] = matriz[matriz.length - 1][matriz.length - 1];
        for (int i = 0; i < 4; i++) {
            cm2 += esquinas[i];
        }

        return cm2 == auxCm2;

    }

    private boolean impar(Integer[][] matriz) {
        Integer[] centroLaterales = new Integer[4];
        Integer center = matriz[matriz.length / 2][matriz.length / 2], aux = 0;
        centroLaterales[0] = matriz[0][matriz.length / 2];
        centroLaterales[1] = matriz[matriz.length / 2][0];
        centroLaterales[2] = matriz[matriz.length - 1][matriz.length / 2];
        centroLaterales[3] = matriz[matriz.length / 2][matriz.length - 1];
        for (int i = 0; i < 4; i++) {
            aux += centroLaterales[i];
        }
        return cm2 == aux && aux == (center * 4);

    }

    private boolean par(Integer[][] matriz) {
        Integer[] centroLaterales = new Integer[4];
        Integer[] centro = new Integer[4];
        int sumaCentro = 0, aux = 0, tam = matriz.length - 1, mitad = matriz.length / 2, anteriorC = (matriz.length / 2) - 1;
        centroLaterales[0] = matriz[0][mitad] + matriz[0][anteriorC];
        centroLaterales[1] = matriz[mitad][0] + matriz[anteriorC][0];
        centroLaterales[2] = matriz[tam][mitad] + matriz[tam][anteriorC];
        centroLaterales[3] = matriz[mitad][tam] + matriz[anteriorC][tam];

        centro[0] = matriz[mitad][mitad];
        centro[1] = matriz[mitad][anteriorC];
        centro[2] = matriz[anteriorC][anteriorC];
        centro[3] = matriz[anteriorC][mitad];

        for (int i = 0; i < 4; i++) {
            aux += centroLaterales[i];
            sumaCentro += centro[i];
        }
        return (cm2 * 2) == aux && sumaCentro == cm2;
    }

    private int validar() {
        int tam = 0;
        Scanner sc = new Scanner(System.in);
        do {
            try {
                tam = sc.nextInt();
            } catch (Exception e) {
                validar();
            }
        } while (invalido(tam));
        return tam;
    }

    private int diagonalPrincipal(Integer[][] matriz) {
        int res = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            res += matriz[i][i];
        }
        return res;
    }

    private int diagInversa(Integer[][] matriz) {
        int res = 0;
        for (int j = matriz[0].length - 1, i = 0; j >= 0; j--, i++) {
            res += matriz[i][j];
        }
        return res;
    }

    private void llenar(Integer[][] matriz) {
        Scanner sc = new Scanner(System.in);
        Integer[] fila = new Integer[matriz[0].length];
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                
                matriz[i][j] = sc.nextInt();


            }

        }

    }

    private void mostrar(Integer[][] matriz) {
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
    }

    private void mostrar(Integer[] fila) {
        for (int i = 0; i < fila.length; i++) {
            System.out.println(fila[i]);
        }
    }

    private Integer[] convertirEnArreglo(Integer[][] matriz) {
        Integer[] aux = new Integer[matriz[0].length * matriz[0].length];
        int k = 0;
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {

                aux[k] = matriz[i][j];
                k++;
            }
        }
        return aux;
    }
    /*
    private void rellenar(Integer[][] matriz, Integer[] fila) {
        int k=0;
for (int i=0; i<matriz.length; i++){
    for (int j=0; j<matriz.length; j++){
        matriz[i][j]=fila[k];
        k++;
    }
}
    }
     */

    private void mostrar(List<String> salidas) {
for(String item:salidas){
    System.out.println(item);
}
    }
}