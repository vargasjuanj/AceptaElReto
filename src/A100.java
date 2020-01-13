
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A100 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int numCasos = sc.nextInt();
        List<String> salidas = new ArrayList(numCasos);
        String num ="", cantidad = "";

        for (int i = 0; i < numCasos; i++) {
            num = sc.next();
            if (num.equals("6174")) {
                salidas.add("0");
           
            }

              else if (valido(num)) {
                salidas.add(operar(num));
            }
            else {
                salidas.add("8");
            }
        }

        mostrar(salidas);

    }
    
/*
    //El compilador de acepta el reto no acepta el paradigma funcional
    private static void mostrar(List lista) {
        lista.forEach(x -> System.out.println(x));
    }
*/
    
     private static void mostrar(List lista) {
         for(int i=0; i<lista.size(); i++){
             System.out.println(lista.get(i));
         }
    }
    private static boolean valido(String n) {
        
        
        if (n.charAt(0) != n.charAt(1)) {
            return true;
        } else if (n.charAt(1) != n.charAt(2)) {
            return true;
        } else if (n.charAt(2) != n.charAt(3)) {
            return true;
        }
        return false;
    }

    private static String operar(String num) {
        int menor = 0;
        int mayor = 0;
      
        int n = Integer.parseInt(num);
        int contador = 0;
        for (int i = 0; i < 7; i++) {
           mayor= numDescendente(n);
            menor = numAscendente(n);

            n = mayor - menor;
            contador++;
            if (n == 6174) {
                return String.valueOf(contador);
            }
        }
        return "";

    }

    private static int numDescendente(int num) {
        int n1 = 0, n2 = 0, aux = 0, res = 0;
        List<Integer> n = separar(num);
        for (int i = 0; i < n.size()-1; i++) {
            for (int j = 0; j < n.size()-1 ; j++) {  
                n1 = n.get(j);
                n2 = n.get(j+1);
                if (n2 > n1) {
                    aux = n1;
                    n.set(j, n2);
                    n.set(j+1, aux);
                }

            }
        }
        
        res=unir(n);
        return res;
    }

    private static int numAscendente(int num) {
       
             int n1 = 0, n2 = 0, aux = 0, res = 0;
        List<Integer> n = separar(num);
        for (int i = 0; i < n.size()-1; i++) {
            for (int j = 0; j < n.size()-1 ; j++) {  
                n1 = n.get(j);
                n2 = n.get(j+1);
                if (n2 < n1) {
                    aux = n1;
                    n.set(j, n2);
                    n.set(j+1, aux);
                }

            }
        }
        
        res=unir(n);
        return res;
    }

    private static List<Integer> separar(int num) {
        String n = String.valueOf(num), aux="";
        List<Integer> res = new ArrayList(4);
for(int i=n.length(); i<4; i++){  //para cuando el número es menor a 4 cifras agrego ceros delanteros.
    aux+="0";
}
n=aux+n;
        for (int i = 0; i < 4; i++) {
            res.add(Integer.parseInt(String.valueOf(n.charAt(i))));
            
        }
        return res;
    }

    private static int unir(List<Integer> n) {
        String aux = "";

        for (int i = 0; i < n.size(); i++) {
            aux += n.get(i);
        }
        return Integer.parseInt(aux);
    }

}

