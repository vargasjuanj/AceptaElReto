package AceptaElReto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class A480 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
int numCasos=sc.nextInt();
int salidas[]=new int[numCasos];
int compra=0, grupoDe=0, malasPorGrupo=0,resultado=0,modulo=0;

for(int i=0; i<numCasos; i++){
   compra =sc.nextInt();

 malasPorGrupo=sc.nextInt();
  grupoDe=sc.nextInt();
 resultado=compra/grupoDe;
 modulo=compra%grupoDe;
 
 
 
if(compra%grupoDe==0){
    resultado*=malasPorGrupo;
salidas[i]=resultado;


  
}else if(modulo<=malasPorGrupo){
        resultado*=malasPorGrupo;
        resultado+=modulo;
           salidas[i]=resultado;

    }else{
        resultado+=1;
        resultado*=malasPorGrupo;
   salidas[i]=resultado;
   
        
    }


List<String>a= new ArrayList();

}

for (int i=0; i<numCasos; i++){
    System.out.println(salidas[i]);
}


    }

}