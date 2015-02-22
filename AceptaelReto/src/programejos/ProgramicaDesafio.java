package programejos;

import java.util.Scanner;

/**
 *
 * @author Julian Gawron
 * El matemático indio Dattaraya Ramchandra Kaprekar descubrió en 1949 una 
 * curiosa característica del número 6174. Hoy, se conoce a dicho número como ç
 * constante de Kaprekar en honor a él.
 * El número es notable por la siguiente propiedad:
 * Elige un número de cuatro dígitos que tenga al menos dos diferentes 
 * (es válido colocar el dígito 0 al principio, por lo que el número 0009 es 
 * válido).
 * Coloca sus dígitos en orden ascendente y en orden descendente para formar 
 * dos nuevos números. Puedes añadir los dígitos 0 que necesites al principio.
 * Resta el menor al mayor.
 * Vuelve al paso 2.
 * A este proceso se le conoce como la rutina de Kaprekar, y siempre llegará al 
 * número 6174 en, como mucho, 7 iteraciones. Una vez en él, el proceso no 
 * avanzará, dado que 7641 − 1467 = 6174.
 * Por ejemplo, el número 3524 alcanzará la constante de Kaprekar en 3 
 * iteraciones:
 * 5432 − 2345 = 3087 
 * 8730 − 0378 = 8352
 * 8532 − 2358 = 6174
 * Los únicos dígitos de cuatro cifras para los que la rutina de Kaprekar 
 * no alcanza el número 6174 son los repdigits, es decir aquellos cuyas cuatro 
 * cifras son iguales (como 1111), pues en la primera iteración se alcanzará el 
 * valor 0 y no podrá salirse de él. Es por esto que en el paso 1 se pedía 
 * explícitamente que el número inicial tuviera al menos dos dígitos diferentes.
 * 
 * El resto de los números de cuatro cifras terminarán siempre en el número 6174.
 * 
 * A continuación se muestran dos ejemplos más:
 * 
 * El número 1121 necesita 5 iteraciones:
 * 2111 − 1112 = 0999 
 * 9990 − 0999 = 8991 
 * 9981 − 1899 = 8082 
 * 8820 − 0288 = 8532
 * 8532 − 2358 = 6174
 * 
 * El número 1893 necesita 7:
 * 9831 − 1389 = 8442 
 * 8442 − 2448 = 5994 
 * 9954 − 4599 = 5355 
 * 5553 − 3555 = 1998 
 * 9981 − 1899 = 8082 
 * 8820 − 0288 = 8532
 * 8532 − 2358 = 6174

* Entrada
* La primera linea de la entrada contendrá el número de casos de prueba. 
* Cada uno contendrá, en una única línea, un número a comprobar.

* Salida
* Para cada caso de prueba, el programa indicará el número de vueltas que se 
* debe dar a la rutina de Kaprekar para alcanzar el 6174. Para los números 
* repdigits deberá escribir 8. Para la propia constante de Kaprekar deberá 
* indicar 0.

* Entrada de ejemplo
* 5
* 3524
* 1111
* 1121
* 6174
* 1893
* Salida de ejemplo
* 3
* 8
* 5
* 0
* 7
 */
public class ProgramicaDesafio {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        //Pedida de datos
        System.out.print("¿Cuantos numeros quiere verificar?");
        int numeroPedidos = entrada.nextInt();
        int losNumeros[] = new int[numeroPedidos];
        for (int i = 0; i < losNumeros.length ; i++) {
            System.out.println("Inserte numero de 4 cifras:");
            losNumeros[i] = entrada.nextInt();
        }
        
        //MuestraResultados
        for (int i = 0; i < losNumeros.length ; i++) {
            System.out.println(cuentaVueltas(losNumeros[i]));
        }
    }
    
    public static int cuentaVueltas (int EsteNumero){
        if(esTodoIgual(EsteNumero)){
          return 8;
        }
        
        int contador = 0;
        while(EsteNumero != 6174){ 
           EsteNumero = (deMayorAmenor(EsteNumero) - deMenorAMayor(EsteNumero));
          // System.out.println(EsteNumero);
           contador++;
        }
        return contador;
    }
    
   public static boolean esTodoIgual(int numero){
       int MisCifras[] = desarma(numero);
       if((MisCifras[0] == MisCifras[1])&&(MisCifras[2]==MisCifras[3])
               &&(MisCifras[3] == MisCifras[0])){
        return true;
       }else {
        return false;
       }  
   }
   
   public static int deMayorAmenor(int numero){
       int MisCifras[] = desarma(numero);
       int aux = 0;
       for (int i = 0; i < MisCifras.length ; i++) {
           for (int j = 0; j < MisCifras.length - 1; j++) {
             if(MisCifras[j]>MisCifras[j+1]){
                 aux = MisCifras[j+1];
                 MisCifras[j+1] = MisCifras[j];
                 MisCifras[j] = aux;
             }   
           }
       }
       //rearmando el numero
       aux = MisCifras[3] * 1000;
       aux = aux + MisCifras[2] * 100;
       aux = aux + MisCifras[1] * 10;
       aux = aux + MisCifras[0];
    return aux;
   }
   
   public static int deMenorAMayor(int numero){
      int MisCifras[] = desarma(numero);
       int aux = 0;
       for (int i = 0; i < MisCifras.length ; i++) {
           for (int j = 0; j < MisCifras.length - 1; j++) {
             if(MisCifras[j]>MisCifras[j+1]){
                 aux = MisCifras[j+1];
                 MisCifras[j+1] = MisCifras[j];
                 MisCifras[j] = aux;
             }   
           }
       }
       //rearmando el numero
       aux = MisCifras[0] * 1000;
       aux = aux + MisCifras[1] * 100;
       aux = aux + MisCifras[2] * 10;
       aux = aux + MisCifras[3];
      return aux;
   }
   
   public static int[] desarma(int EsteNumero){

    int cifras [] = new int[4];
    
    cifras[0] = EsteNumero / 1000;
    EsteNumero = EsteNumero - (cifras[0] * 1000);
    cifras[1] = EsteNumero /100;
    EsteNumero = EsteNumero - (cifras[1] * 100);
    cifras[2] = EsteNumero / 10;
    cifras[3] = EsteNumero - (cifras[2] * 10);
   return cifras; 
   }
}
