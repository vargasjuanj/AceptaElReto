//Sumas de Riemann


public class A103 {

    double recorrido = 1, rectangulos = 1000, delta = recorrido / rectangulos;//delta es el anchode cada rectangulo

    public static void main(String[] args) {
        new A103().calcularTerreno();
    }

    private void calcularTerreno() {
        double pos = 0, alto = 0, areaCain = 0, areaAbel = 0, res = 0;
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

    private double calcularAlto(double pos) {
        return  Math.pow(pos, 3)+(2*Math.pow(pos, 2))-pos+1;
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