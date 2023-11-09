package Controlador;

/**
 * @author Luis David Peralta Gonzalez
 * 
 * Programa para obtener las posibles combinaciones de n experimientos simples.
 * 
 */

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Compuesto {
   private List <List <String>>simples;             //  Arreglo de experimentos simples
   private List <String> combinaciones;             //  Arreglo de combinaciones
   private int eventos,n,posibilidades;

    public Compuesto(int elementos) {               //  Constructor que recibira los conjuntos de exp. simples
        simples = new ArrayList<List <String>>();   //  Matriz que guardara los n exp. simples
        combinaciones = new ArrayList <String>();   //  Vector que guardara las n combinaciones posibles
        eventos = elementos;                        //  entero que guardara el total de posibles combinaciones
        n=1;                                        //  Auxiliar para imprimir las combinaciones
    }
       
    public void conteo(){
        //Variables
        posibilidades=1;
        
        try{
            //Creacion de los eventos simples
            for (int i=0; i<eventos;i++)
                simples.add(new ArrayList<String>()) ;

            //Solicitud de datos
            for (int i = 0; i < eventos; i++) {
              //Variable 
              int opcion=0;

              while(opcion!=1){            
                simples.get(i).add(JOptionPane.showInputDialog(null,"Ingresa un evento","Experimento "+(i+1),JOptionPane.INFORMATION_MESSAGE));
                opcion = JOptionPane.showConfirmDialog(null, "Ingresar otro evento?","Experimento "+(i+1),JOptionPane.YES_NO_OPTION);                        
              }
            }

            //Proceso iterativo y recursivo para las combinaciones        
            for (int i = 0; i < eventos; i++) {//Se imprime el numero de combinaciones
                int size=simples.get(i).size();            
                posibilidades*=size;
            }

            for (int i=0;i<simples.get(0).size();i++){ //se encuentran las combinaciones
                String opcion="(";
                opcion+=simples.get(0).get(i);
                combinar(1,opcion);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Algo salio mal, reinicia el programa", "Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }   
    
    private void combinar(int indice, String opcion){
        if((indice)!=eventos){//Si el indice + 1 es diferente al numero de eventos sigue la recursividad
            for (int i = 0; i < simples.get(indice).size(); i++) {
                String aux = opcion;
                aux+=", "+simples.get(indice).get(i);
                combinar(indice+1,aux);
            }
        }else{
            opcion+=(")");
            combinaciones.add("["+String.valueOf(n)+"] \t"+opcion);
            n++;
        }
    }
    
    public List<List<String>> getSimples() { return simples; }
    public List<String> getCombinaciones() { return combinaciones; }
    public int getEventos() { return eventos; }
    public int getPosibilidades() { return posibilidades; }   
}