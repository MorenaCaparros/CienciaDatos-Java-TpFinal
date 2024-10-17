

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

import java.lang.classfile.attribute.LineNumberInfo;
import java.util.ArrayList;
import java.util.Scanner;

import practica.gestionBiblioteca.Libro;


public class Biblioteca {
    private ArrayList<Libro> listaLibrosPrestados; //son listas dinamicas de arrays, de esta amnera es mas fácil manejarlas 
    private ArrayList<Libro> biblioteca;
    private ArrayList<Usuario> listaUsuarios;


    public Biblioteca() {
        biblioteca = new ArrayList<>();
        listaLibrosPrestados = new ArrayList<>();
        listaUsuarios = new ArrayList<>();
    } 

     //Metodo para obtener todos los libros 
     public ArrayList<Libro> getLibros() {
        return biblioteca;
    }
    
    //Metodo para obtener todos los libros prestados
    public ArrayList<Libro> getLibrosPrestados() {
        return listaLibrosPrestados;
    }

    
    //Metodo para obtener todos los usuarios 
    public ArrayList<Usuario> getUsuarios() {
        return listaUsuarios;
    }

    //Método para agregar libros a la lista 
    public void agregarLibros(Libro libros) {
        biblioteca.add(libros);
    }

    //Método para agregar usuarios a la lista 
    public void agregarUsuarios(Usuario usuarios) {
        listaUsuarios.add(usuarios);
    }

    //Método para comprobar si un usuario existe  retornarlo si existe si no devuelve null
    public Usuario comprobarUsuario(String DNI) {
        for  (Usuario user : listaUsuarios) {
            if (user.getDNI().equalsIgnoreCase(DNI)){ // cuando utilizo equalsIgnoreCase es para que no le de importancia a las mayúsculas y minúsculas
                return user;
            } 
        }
        System.out.println("El usuario no existe");
        return null;
    }

    //Método para elegir el libro de la biblioteca
    public Libro elegirLibroBiblioteca(String titulo) {
        for (Libro libro : biblioteca) {
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                return libro;
            }
        } 
        System.out.println("El libro no existe");
        return null;
    }

    //Método para sacar libros a la lista de libros de la biblioteca, y agregarlo a la lista de libros prestados 
    public void prestarLibros(String DNI) {
        Usuario user = comprobarUsuario(DNI);
        if (user != null) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese el título que el usuario quiere pedir prestado:");
            String titulo = scanner.nextLine();
    
            Libro libro = elegirLibroBiblioteca(titulo);
            if (libro != null) {
                if (libro.getGenero() == "infantil") {
                    LibroInfantil libroInfantil = (LibroInfantil) libro;
                    libroInfantil.edadRecomendada(user.getEdad());
                    if (user.getEdad() > 12) {
                        System.out.println("El usuario no tiene con la edad recomendada para este libro infantil.");
                        return;
                    }
                }
                biblioteca.remove(libro);
                listaLibrosPrestados.add(libro);
                user.setListaLibrosPedidos(libro);
                System.out.println("El libro se prestó al usuario.");
            } else {
                System.out.println("El libro no se encuentra disponible.");
            }
        } else {
            System.out.println("El usuario no está registrado.");
        }
        
    }

     //Método para devolver libros a la lista de libros de la biblioteca, y sacarlo de  la lista de libros prestados 
     public void devolverLibros(String DNI) {
        Usuario user = comprobarUsuario(DNI);
        Scanner scanner = new Scanner(System.in);
        if (user != null) {
            System.out.println("Ingrese el título que el usuario quiere devolver:");
            String titulo = scanner.nextLine();
            Libro libro = user.verificarLibroPedido(titulo);
            if (libro != null){
                user.devolverUnLibroPedido(titulo);
                biblioteca.add(libro);
                System.out.println("El libro se devolvió a la biblioteca.");
            } else {
                System.out.println("El libro no se encuentra disponible.");
            } 
        } else {
            System.out.println("El usuario no esta registrado.");
        }
    }

     //Método que itera sobre la biblioteca y muestra cada uno de libros.
     public void mostrarLibrosDisponibles() {
        for (Libro libro : biblioteca) {
            System.out.println(libro);
        }
    } 
    
    //Método que itera sobre los usuarios y muestra cada uno de libros si tienen libros.
    public void mostrarTodosLibrosPrestados() {
        for (Usuario user : listaUsuarios) {    
            user.mostrarLibrosPedidos();
        }
    }

    public void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese DNI del usuario:");
        String dni = scanner.nextLine();

        System.out.println("Ingrese nombre del usuario:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido del usuario:");
        String apellido = scanner.nextLine();
        
        System.out.println("Ingrese la edad del usuario:");
        int edad = scanner.nextInt();

        Usuario user = new Usuario(dni, nombre, apellido, edad);
        
        agregarUsuarios(user);
    }

    public void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese el id del libro:");
        String id = scanner.nextLine();
        
        System.out.println("Por favor, ingrese el titulo del libro:");
        String titulo = scanner.nextLine();
        
        System.out.println("Por favor, ingrese el autor del libro:");
        String autor = scanner.nextLine();
        
        System.out.println("Por favor, ingrese el genero del libro:");
        String genero = scanner.nextLine();
        
        String estado = "disponible";
        //Utilizando ArrayList puedo aca agregar vuelos a la lista dinámica
        Libro libro = new Libro(id, titulo, autor, genero,estado);
        agregarLibros(libro);
        
        System.out.println("Libro agregado exitosamente a la biblioteca.");
    }

    //Método para pedir Libro
    public void registrarPedidoLibro() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el DNI del usuario:");
        String dni = scanner.nextLine();
        Usuario user = comprobarUsuario(dni);
        
        if (user != null) {
            prestarLibros(dni);
            return;
            } 
    }        
    //Método para pedir Libro
    public void registrarDevolucionLibro() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese el DNI del usuario:");
        String dni = scanner.nextLine();
        Usuario user = comprobarUsuario(dni);
        
        if (user != null) {
            devolverLibros(dni);
            return;
            }     
    }


}
