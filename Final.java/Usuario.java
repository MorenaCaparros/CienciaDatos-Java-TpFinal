/*
 * UCASAL - PROGRAMACION I
 * Autor/a: Morena Caparrós
 * Carrera: Licenciatura en Ciencia de Datos
 * Año: 2024
 * ==========================
 * Enunciado: 
 * Un bibliotecario necesita un sistema para poder incorporar los libros que tiene, registrar usuarios, 
 * poder ver los libros, poder ver los usuarios, poder ver que cantidad de libros se llevo cada usuario, 
 * y si se llevo mas de 3 que detecte que no puede pedir mas prestados. 
 * ==================================================
 */


package Final.java;

//Creo la clase usuario que va a ser la que se registre y la que vaya a tomar prestados libros.

import java.util.ArrayList;

public class Usuario {
    private String DNI;
    private String nombre;
    private String apellido;
    private int edad;
    private ArrayList<Libro> librosPedidos; // Necesito como atributo saber cuantos libros pidió cada usuario


    public Usuario (String DNI, String nombre, String apellido, int edad){
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad; 
        this.librosPedidos = new ArrayList()<>;
    }
    
    public String getDNI(){
        return DNI;
    }

    public void setDNI(){
        this.DNI = DNI;
    }

    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(){
        this.nombre = nombre;
    }
    public String getApellido(){
        return apellido;
    }
    public void setApellido(){
        this.apellido = apellido;
    }

    public int getEdad(){
        return edad; 
    }

    public void setEdad(){
        this.edad = edad; 
    }
    public ArrayList<Libro> getListaLibrosPedidos() {
        return librosPedidos;
    }
    
    public void setListaLibrosPedidos(Libro libroPedido) {
        if (librosPedidos.size() < 3) {
            librosPedidos.add(libroPedido);
        } else {
                System.out.println("El usuario ya se llevo 3 libros. Para retirar otro libro, debe devolver por lo menos uno de los que retiró.");
        }
    }
    
    //Metodo para verificar si el libro lo pidio este user
    public Libro verificarLibroPedido (String titulo) {
        Libro libroEncontrado = null;
        for (Libro libro : librosPedidos){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                libroEncontrado = libro;
                return libroEncontrado;
            }
        } 
        return null;
    }
    
    //Metodo para remover un libro de los pedidos por el user
    public void devolverUnLibroPedido (String titulo) {
        Libro libroEncontrado = null;
        for (Libro libro : librosPedidos){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                libroEncontrado = libro;
                librosPedidos.remove(libroEncontrado);
            }
        } if(librosPedidos == null) { 
            System.out.println("No hay libros pedidos.");
        }
    }    

    //Método que itera sobre la librosPedidos y muestra cada uno.
    public void mostrarLibrosPedidos() {
        for (Libro libro : librosPedidos) {
            if (librosPedidos != null){
                System.out.println("El usuarios de DNI " + DNI + " y de Nombre y Apellido " + nombre + " " + apellido);
                System.out.println("Pidió los siguientes libros: " + libro.getTitulo());
            }  
        }  
    }

    @Override
    public String toString(){
        return "Usuario{" +
        "DNI='" + DNI + '\'' +
        ", nombre='" + nombre + '\'' +
        ", apellido='" + apellido + '\'' +
        ", edad='" + edad + '\'' +
        ", librosPedidos=" + (librosPedidos.isEmpty() ? "No tiene libros pedidos" : librosPedidos) +
        "}";

    }

}
