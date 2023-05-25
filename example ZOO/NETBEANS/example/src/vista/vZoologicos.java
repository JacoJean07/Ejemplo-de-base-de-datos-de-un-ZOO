/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.zoologicos;

/**
 *
 * @author JEAN
 */
public class vZoologicos {
    zoologicos obj = new zoologicos();
    Scanner t = new Scanner(System.in);
    public void ingresarDatos(){
        System.out.println("Ingresar Datos del Zoologico");
        System.out.println("Ingrese los siguientes datos: ");
        System.out.println("Nombre:");
        obj.setNombre(t.nextLine());
        System.out.println("Ciudad:");
        obj.setCiudad(t.nextLine());
        System.out.println("Pais:");
        obj.setPais(t.nextLine());
        System.out.println("Tamaño (En numeros):");
        obj.setTamanio(t.nextLine());
        System.out.println("Presupuesto Anual (En numeros con decimales):");
        obj.setPresupuestoAnual(t.nextLine());
        
        
        obj.mostrarDatos();
        obj.guardar();
        
    }
    
    public void ingresarDatosActualizar(){
        Integer op;
        System.out.println("Ingresar Datos del Zoologico Actualizado");
        System.out.println("Ingrese los siguientes datos: ");
        
        System.out.println("Nombre:");
        obj.setNombre(t.nextLine());
        System.out.println("Ciudad:");
        obj.setCiudad(t.nextLine());
        System.out.println("Pais:");
        obj.setPais(t.nextLine());
        System.out.println("Tamaño (En numeros):");
        obj.setTamanio(t.nextLine());
        System.out.println("Presupuesto Anual (En numeros con decimales):");
        obj.setPresupuestoAnual(t.nextLine());
        System.out.println("idZoologico:");
        obj.setIdZoologico(t.nextInt());
        
        
            saltoDoble();
            
            System.out.println("Desea Actualizar el Registro? ");
            System.out.println(obj.mostrarDatos());
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Actualizar ");
            System.out.println("2. Cancelar");
            op = t.nextInt();
            switch(op){
                case 1:
                    obj.actualizar();
                    break;
                case 2:
                    System.out.println("Salio del menu Actualizar Registro");
                    saltoDoble();
                    break;
                default:
                    System.out.println("La opcion ingresada no es valida");
            
        }
    }
    
    public void menuEliminar(){
        saltoDoble();
        Integer op;
        String criterio="";
        String busqueda;
        
        ArrayList<zoologicos> listaZoo = new ArrayList<>();
        Scanner t = new Scanner(System.in);
        System.out.println("Eliminar registro de zoologicos: ");
        System.out.println("Ingrese el ID del Zoologico");
        criterio = "idZoologico";
        busqueda = t.next();
        
        zoologicos obj1 = new zoologicos();
        
        listaZoo = obj1.listarZoologicosPorParametro(criterio, busqueda);
        System.out.println("Verifique los datos del Zoologico que desea eliminar");
        for(int i = 0; i < listaZoo.size();i++){
            
            obj1.setIdZoologico(listaZoo.get(i).getIdZoologico());
            obj1.setNombre(listaZoo.get(i).getNombre());
            obj1.setCiudad(listaZoo.get(i).getCiudad());
            obj1.setPais(listaZoo.get(i).getPais());
            obj1.setTamanio(listaZoo.get(i).getTamanio());
            obj1.setPresupuestoAnual(listaZoo.get(i).getPresupuestoAnual());
            System.out.println(obj1.mostrarDatos());
        }
        
        obj1.eliminar();
    }
    
    public void menuActualizar(){
        saltoDoble();
        Integer op;
        String criterio="";
        String busqueda;
        
        ArrayList<zoologicos> listaZoo = new ArrayList<>();
        Scanner t = new Scanner(System.in);
        System.out.println("Actualizar registro de zoologicos: ");
        System.out.println("Ingrese el ID del Zoologico");
        criterio = "idZoologico";
        busqueda = t.next();
        
        zoologicos obj1 = new zoologicos();
        
        listaZoo = obj1.listarZoologicosPorParametro(criterio, busqueda);
        System.out.println("Llenar los datos del zoologico ya actualizados");
        for(int i = 0; i < listaZoo.size();i++){
            
            obj1.setIdZoologico(listaZoo.get(i).getIdZoologico());
            obj1.setNombre(listaZoo.get(i).getNombre());
            obj1.setCiudad(listaZoo.get(i).getCiudad());
            obj1.setPais(listaZoo.get(i).getPais());
            obj1.setTamanio(listaZoo.get(i).getTamanio());
            obj1.setPresupuestoAnual(listaZoo.get(i).getPresupuestoAnual());
            System.out.println(obj1.mostrarDatos());
        }
        ingresarDatosActualizar();
       
    }
    
    public void saltoDoble(){
        System.out.println("");
        System.out.println("");
    }
    
}
