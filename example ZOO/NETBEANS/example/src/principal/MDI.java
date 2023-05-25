package principal;


import java.util.Scanner;
import vista.*;
import modelo.*;


public class MDI{
    
    public static void saltoDoble(){
        System.out.println("");
        System.out.println("");
    }

    
    public static void menuParametros(){
        saltoDoble();
        Scanner t = new Scanner(System.in);
        Integer op=0;
        do{
            System.out.println("Menu Parametros MDI-Consola");
            System.out.println("Seleccione una opcion ");
            System.out.println("1. Zoologicos ");
            System.out.println("2. Salir ");
            op = t.nextInt();
            switch(op){
                case 1:
                    menuZoologicos();
                case 2:
                    Salir();

        }
        }while(op!=2);
        
        
    }
    
    public static void menuZoologicos(){
        saltoDoble();
        Scanner t = new Scanner(System.in);
        Integer op=0;
        do{
            System.out.println("Menu Zoologicos Consola");
            System.out.println("Seleccione una opcion ");
            System.out.println("1. Nuevo ");
            System.out.println("2. Buscar ");
            System.out.println("3. Actualizar ");
            System.out.println("4. Eliminar ");
            System.out.println("5. Salir ");
            op = t.nextInt();
            switch(op){
                case 1:
                    vZoologicos obj = new vZoologicos();
                    obj.ingresarDatos();
                    break;
                case 2:
                    zoologicos obj1 = new zoologicos();
                    obj1.buscar();
                    break;
                case 3:
                    vZoologicos obj2 = new vZoologicos();
                    obj2.menuActualizar();
                    break;
                case 4:
                    vZoologicos obj3 = new vZoologicos();
                    obj3.menuEliminar();
                    break;
                
        }
        }while(op!=5);
        
        
    }
    
    
    
    public static void Salir(){
        saltoDoble();
            System.out.println("Acaba de salir del menu");
            saltoDoble();
        
    }
    
}