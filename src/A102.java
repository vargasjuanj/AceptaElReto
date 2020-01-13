

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A102 {
//Nota:: El desplazamiento va cambiando en base a p, puede retroceder o avanzar. Pero para descifrar se basa en la formula de cesar de wikipedia.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String alfabeto = "abcdefghijklmnopqrstuvwxyz", mensaje = "", descifrado = "";
        int x = 0, n = 0, pos = 0, tam = alfabeto.length(), vocales = 0;
        List<Integer> salidas = new ArrayList();
        char ch = ' ';
        while (true) {
            mensaje = sc.nextLine();
            n = alfabeto.indexOf("p") - alfabeto.indexOf(mensaje.charAt(0));

            for (int i = 1; i < mensaje.length(); i++) {
                ch = mensaje.charAt(i);
                if (!alfabeto.contains(String.valueOf(Character.toLowerCase(ch)))) { //comprueba si el caracter en minuscula existe sino concatena y continua
                    descifrado += mensaje.charAt(i);
                    continue;
                }

                x = alfabeto.indexOf(Character.toLowerCase(ch));

                pos = (n + x) % tam;

                if (pos < 0) {
                    pos = tam + x + n;
                }
                if (Character.isUpperCase(ch)) { 
                    ch = Character.toUpperCase(alfabeto.charAt(pos)); //si el caracter pertenece al abecedario y es mayuscula lo transormamos en mayuscula, pero antes sacamos el caracter del alfabeto en minuscula

                } else {
                    ch = alfabeto.charAt(pos);
                }
                if (isVocal(Character.toLowerCase(ch))) {

                    vocales++;
                }
                System.out.println(ch);

                descifrado += ch;

            }
            if (descifrado.equals("FIN")) { //si el mensaje descifrado es FIN, se sale del while
                break;
            } else {
                salidas.add(vocales);
            }
            descifrado="";vocales=0;
        }
        mostrar(salidas); 

    }

    private static boolean isVocal(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static void mostrar(List<Integer> salidas) {
        for (Integer i : salidas) {
            System.out.println(i);
        }
    }
}
