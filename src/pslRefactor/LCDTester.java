package pslRefactor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class LCDTester {

    //Se inicializan las variables necesarias
    static final String CADENA_FINAL = "0,0";
    public static BufferedReader lector = null;
    public static List<String> listaComando = new ArrayList<>();
    public static String comando;
    public static int espacioDig;
        
    public static void main(String[] args) {
        
        lector = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Espacio entre Digitos (0 a 5): ");
            comando = lector.readLine();
            //Valida si es numerico
            try{
               espacioDig=Integer.parseInt(comando);
               if (espacioDig < 0 || espacioDig > 5) {
                    throw new IllegalArgumentException("El espacio entre "
                            + "digitos debe estar entre 0 y 5");
                }
            }catch(NumberFormatException e){
                throw new NumberFormatException("No ingresó un numero :v "+comando);
            }
            //Se realiza la ejecucion de la impresion LCD
            ejecucion();
            //Finaliza
        } catch (Exception e) {
            System.out.println("Error :"+e);
        }
    }

    /**
     * 
     * Metodo encargado de realizar la ejecucion
     * principal
     * 
     * @throws IOException 
     */
    private static void ejecucion() throws IOException {
        System.out.println("Ingrese la cadena con el formato (0<numero<11,numeros)");
        ImpresorLCD impresorLCD = new ImpresorLCD();
        while(!comando.equalsIgnoreCase(CADENA_FINAL)){
            System.out.println("Entrada: ");
            comando=lector.readLine();
            listaComando.add(comando);
        }
        for (String cmd : listaComando) {
            boolean fin=cmd.equalsIgnoreCase(CADENA_FINAL)?true:false;
            if(fin)break;
            impresorLCD.procesar(cmd, espacioDig);
        }
    }
}