/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import db.conectar;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author JEAN
 */
public class zoologicos implements crud{
    
    // atributos
    private Integer idZoologico;
    private String nombre;
    private String ciudad;
    private String pais;
    private String tamanio;
    private String presupuestoAnual;
    
    // metodos constructores

    public zoologicos(Integer idZoologico, String nombre, String ciudad, String pais, String tamanio, String presupuestoAnual) {
        this.idZoologico = idZoologico;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tamanio = tamanio;
        this.presupuestoAnual = presupuestoAnual;
    }

    public zoologicos(String nombre, String ciudad, String pais, String tamanio, String presupuestoAnual) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.pais = pais;
        this.tamanio = tamanio;
        this.presupuestoAnual = presupuestoAnual;
    }

    public zoologicos() {
    }
    
    // getters y setters

    public Integer getIdZoologico() {
        return idZoologico;
    }

    public void setIdZoologico(Integer idZoologico) {
        this.idZoologico = idZoologico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public String getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(String presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }
    
    // metodos tipo

    @Override
    public void guardar() {
Connection cnn = conectar.getConexion();
        PreparedStatement ps = null;

        String sql = "INSERT INTO `example`.`zoologicos` (`ZooNombre`, `ZooCiudad`, `ZooPais`, `ZooTamanio`, `ZooPresupuestoAnual`) VALUES (?,?,?,?,?)";
        try {
            ps = cnn.prepareStatement(sql);
            ps.setString(1, getNombre());
            ps.setString(2, getCiudad());
            ps.setString(3, getPais());
            ps.setString(4, getTamanio());
            ps.setString(5, getPresupuestoAnual());

            int n = ps.executeUpdate();
            if (n > 0) {
                System.out.println("GrabaciÃ³n Exitosa"+ps);
                JOptionPane.showMessageDialog(null, "Registrado con exito", "Grabar Registro", JOptionPane.INFORMATION_MESSAGE);
            }

            cnn.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("No se logro grabar el Registro.." + e);
        }   
    }
    
    @Override
    public String toString() {
        return "zoologicos{" + "idZoologico=" + idZoologico + ", zooNombre=" + nombre + ", zooCiudad=" + ciudad + ", zooPais=" + pais + ", zooTamanio=" + tamanio + ", zooPresupuestoAnual=" + presupuestoAnual + '}';
    }
    public ArrayList listarZoologicosPorParametro(String criterio, String busqueda) {
        System.out.println("\n\nBuscar Zoologico\nCriterio: "+criterio+"\ntextoBusquda: "+busqueda);
        Connection cnn = conectar.getConexion();
        ArrayList<zoologicos> listaZoologicos = new ArrayList<zoologicos>();
        
        ResultSet rs = null;

        try {
            CallableStatement st = cnn.prepareCall("{call SP_S_ZoologicoParametro(?,?)}");
            st.setString("pcriterio", criterio);
            st.setString("pbusqueda", busqueda);
            System.out.println(""+st);

            rs = st.executeQuery();

            //Llenar el ArrayList con la informacion de acuerdo al criterio y el texto de la busqueda
            while (rs.next()) {
                zoologicos zoo = new zoologicos();
                zoo.setIdZoologico(Integer.parseInt(rs.getString(1))); 
                zoo.setNombre(rs.getString(2)); 
                zoo.setCiudad(rs.getString(3));
                zoo.setPais(rs.getString(4));
                zoo.setTamanio(rs.getString(5));
                zoo.setPresupuestoAnual(rs.getString(6));
                listaZoologicos.add(zoo);
                
            }
            saltoDoble();
           System.out.println("Lista de Zoologicos "+ " Criterio: "+ criterio+ " Texto a buscar: "+busqueda);
            for(int i = 0; i < listaZoologicos.size();i++){
            System.out.println(i+" "+listaZoologicos.get(i).toString());
            saltoDoble();
            }

            return listaZoologicos;
        } catch (SQLException SQLex) {
            System.out.println("No se logro buscar el Registro.." + SQLex);
            return null;
        }
    }

    @Override
    public void buscar() {
        saltoDoble();
        Integer op;
        String criterio="";
        String busqueda;
        Scanner t = new Scanner(System.in);
        System.out.println("Buscar zoologicos por: ");
        System.out.println("Ingrese un numero para establecer el criterio de busquedad");
        System.out.println("1. idZoologico");
        System.out.println("2. Nombre");
        System.out.println("3. Ciudad");
        System.out.println("4. Pais");
        System.out.println("5. Salir");
        op = t.nextInt();
        System.out.println("Ingrese el texto o numero a buscar");
        busqueda = t.next();
        
        
        switch(op){
            case 1 -> criterio = "idZoologico";
            case 2 -> criterio = "Nombre";
            case 3 -> criterio = "Ciudad";
            case 4 -> criterio = "Pais";
            case 5 -> System.out.println("Salio del menu buscar zoologicos...");
            default -> System.out.println("Ingrese una opcion valida");
                
        }
        
        listarZoologicosPorParametro(criterio, busqueda);
        
        
            
        
        
    }

    @Override
    public void actualizar() {
            if (pregunta("¿Esta seguro de Actualizar el registro?") == 1) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "UPDATE Zoologicos SET ZooNombre=?, ZooCiudad=?, ZooPais=?,ZooTamanio=?, ZooPresupuestoAnual=? WHERE idZoologico=?";
            try {
            ps = cnn.prepareStatement(sql);
            
            ps.setString(1, getNombre());
            ps.setString(2, getCiudad());
            ps.setString(3, getPais());
            ps.setString(4, getTamanio());
            ps.setString(5, getPresupuestoAnual());
            ps.setInt(6,getIdZoologico());
            System.out.println(ps);



           
                int r = ps.executeUpdate();
                
                if (r > 0) {
                    System.out.println("Actualizacion Exitosa "+ps);
                    saltoDoble();
                } else {
                    System.out.println("No se pudo grabar el registro "+ps);
                }
                cnn.close();
                ps.close();
            } catch (SQLException e) {
                System.out.println("No se logro actualizar el Registro.." + e);
            }
        } else {
            System.out.println("Actualizacion Cancelada");
        }
    }

    @Override
    public void eliminar() {
if (pregunta("Esta seguro de Eliminar el registro?") == 1) {
            Connection cnn = conectar.getConexion();
            PreparedStatement ps = null;

            String sql = "DELETE FROM Zoologicos WHERE idZoologico = " + getIdZoologico();
            try {
                ps = cnn.prepareStatement(sql);

                int n = ps.executeUpdate();
                if (n > 0) {
                    System.out.println("Se elimino el registro con exito"+ps);
                    saltoDoble();
                }

                cnn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("No se logro Eliminar el Registro..." + ex);
            }

        } else {
            System.out.println("Eliminacion Cancelada");
        }
    }

    @Override
    public String mostrarDatos() {
        saltoDoble();
        System.out.println("Nombre: "+this.nombre);
        System.out.println("Ciudad: "+this.ciudad);
        System.out.println("Pais: "+this.pais);
        System.out.println("Tamaño: "+this.tamanio);
        System.out.println("PresupuestoAnual;: "+this.presupuestoAnual);
        return null;
    }
    
    
    
    public void saltoDoble(){
        System.out.println("");
        System.out.println("");
    }
    
    public Integer pregunta(String msj1) {
        saltoDoble();
        Integer op;
        Scanner t = new Scanner(System.in);
        do{
            System.out.println("Seleccione una opcion: ");
            System.out.println(msj1 );
            System.out.println("1. Aceptar");
            System.out.println("2. Cancelar");
            op = t.nextInt();
            if(op==1){break;}
        }while(op!=2);
        
 
        
        return op;
    }
}
