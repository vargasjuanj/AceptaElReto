import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Sumas de Riemann
public class A103 {

    double recorrido = 1, rectangulos, delta;//delta es el ancho de cada rectangulo
    static int cf;
    static Scanner sc = new Scanner(System.in);
    static List<String> resultados = new ArrayList();

    List<Integer> param = new ArrayList();

    public static void main(String[] args) {

        cf = sc.nextInt();

        while (cf > -1 && cf < 20) {
            new A103().calcularTerreno();
            cf = sc.nextInt();

        }
        mostrar(resultados);
    }

    private void calcularTerreno() {

        int aux = 0;
        for (int i = 0; i < (cf + 1); i++) {
            aux = sc.nextInt();
            param.add(aux);
        }
        rectangulos = sc.nextInt();
        delta = recorrido / rectangulos;
        double pos = 0, alto = 0, areaCain = 0;
        for (int i = 0; i < rectangulos; i++) {
            alto = calcularAlto(pos);
            pos += delta;
            if (alto < 0) {
                continue;
            } else if (alto > 1) {
                alto = 1;
            }

            areaCain += (delta * alto);
        }
        reparto(areaCain);

    }

    private double calcularAlto(double pos) { //función
        if (cf == 0) {
            return 1;
        }

        int tam = param.size() - 1, i = 0;
        double alto = 0;
        for (i = 0; i < param.size() - 1; i++) {
            alto += param.get(i) * Math.pow(pos, tam);
            tam -= 1;
        }
        alto += param.get(i);

        return alto; //param.get(0)*Math.pow(pos, tam)+(param.get(1)*Math.pow(pos, tam-=1))+(param.get(2)*pos)+param.get(3);
    }

    private void reparto(double areaCain) {
        String max = "";
        double areaAbel = 1 - areaCain, res = 0;
        if (areaCain < areaAbel) {
            max = "ABEL";
            res = areaAbel - areaCain;

        } else if (areaAbel < areaCain) {
            max = "CAIN";
            res = areaCain - areaAbel;
        } else {
            max = "JUSTO";
        }
        if (res <= 0.001) {
            max = "JUSTO";
        }
        resultados.add(max);

    }

    private static void mostrar(List<String> resultados) {
        for (int i = 0; i < resultados.size(); i++) {
            System.out.println(resultados.get(i));
        }
    }
    
}
