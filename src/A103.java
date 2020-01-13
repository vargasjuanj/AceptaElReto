
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Sumas de Riemann


public class A103 {

    double recorrido = 1, rectangulos, delta;//delta es el ancho de cada rectangulo
int cf;
List<Integer>param= new ArrayList();
    public static void main(String[] args) {
        new A103().calcularTerreno();
    }

    private void calcularTerreno() {
        Scanner sc= new Scanner(System.in);
        cf=sc.nextInt();
        int aux=0;
        for (int i=0; i<(cf+1); i++){
            aux=sc.nextInt();
            param.add(aux);
        }
        rectangulos=sc.nextInt();
        delta=recorrido/rectangulos;
        double pos = 0, alto = 0, areaCain = 0;
        for (int i = 0; i < rectangulos; i++) {
            System.out.println("pos " + pos);
            alto = calcularAlto(pos);
            pos += delta ;
            if(alto<0)continue;
            else if(alto>1)alto=1;
           
            areaCain += (delta * alto);
        }
        reparto(areaCain);
        
    }

    private double calcularAlto(double pos) { //función
        int tam=param.size()-1;
        return  param.get(0)*Math.pow(pos, tam)+(param.get(1)*Math.pow(pos, tam-=1))+(param.get(2)*pos)+param.get(3);
    }
    
 private void reparto(double areaCain){
     String max="";
double areaAbel = 1 - areaCain,res=0;
        System.out.println("Abel " + areaAbel);
        System.out.println("Cain " + areaCain);
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
        System.out.println(max);
 
 }
     
   
}