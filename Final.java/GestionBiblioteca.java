package Final.java;

import java.util.Scanner;

public class GestionBiblioteca {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in); 
        Biblioteca biblioteca = new Biblioteca();

        // Pantalla de bienvenida
        System.out.println("Bienvenidos al sistema de biblioteca de Morena Caparrós");
        System.out.println("Carrera: Licenciatura en Ciencia de Datos, 1° Año");
        System.out.println("Este programa permite gestionar la biblioteca, los usuarios de la misma y los libros que se agregan o se sacan de la biblioteca.");
        System.out.println("Un bibliotecario necesita un sistema para poder incorporar los libros que tiene, registrar usuarios,poder ver los libros, poder ver los usuarios, poder ver que cantidad de libros se llevo cada usuario, ");

        //Creo libros para que la clase no se encuentre vacía
        biblioteca.agregarLibros(new Libro("1234", "Orgullo y Prejuicio", "Jane Austen", "Romance ", "Disponible"));
        biblioteca.agregarLibros(new Libro("12345", "Las aventuras de Jack", "Julio Lopez", "Infantil", "Disponible"));
        biblioteca.agregarLibros(new Libro("12346", "La casa embrujada", "Stephen King", "Terror", "Disponible"));

        //Creo usuarios para que la clase no se encuentre vacía
        biblioteca.agregarUsuarios(new Usuario("1234", "Carlos", "Lopez", 12));
        biblioteca.agregarUsuarios(new Usuario("12345", "Josefina", "Lopez", 10));
        biblioteca.agregarUsuarios(new Usuario("1234", "Morena", "Rodriguez", 40));

        int num;
        int i = 1;

        //Creo un bucle en donde continua hasta que sea igual a 0 porque es la opción de Salir
        while (i!=0) {
            System.out.println("Bienvenido a la biblioteca \nPor favor elija una de las siguientes opciones del menú:");
            System.out.println("[1] Registrar un libro \n[2] Prestar un libro \n[3] Devolver un libro \n[4] Registrar usuario \n[5] Ver libros disponibles \n[6] Ver libros pedidos \n[0] Salir");
            num = entrada.nextInt(); // se usa nextInt porque es un numero sino se usa nextLine
            entrada.nextLine(); //Lo que hace es limpiar el buffer 
            int j = 1; // voy a inicializar otro bulce para otro while adentro del switch
            //El switch lo que hace es que segun cada numero que se elija se hace algo
            switch (num) {
                case 1:
                while (j!=2){
                    if (biblioteca.getLibros().size() >= 6){ //lo que hago es obtenr los libros y me fijo la longitud, si es mayor a 6 entonces le digo que no se peuden agregar mas libros
                        System.out.println("No se pueden agregar más libros, no hay mas lugar en la biblioteca.");
                        break;
                    } else {
                        biblioteca.registrarLibro(); //sino registra el libro
                        System.out.println("Por favor elija una de las siguientes opciones del menú: \n[1]Agregar un libro nuevo \n[2]Volver al menú anterior");
                    }
                    j = entrada.nextInt();
                    entrada.nextLine();
                }
                break;
                case 2:
                while (j!=8){
                    System.out.println("Por favor elija una de las siguientes opciones del menú: \n[1] Pedir un libro nuevo \n[8] Volver al menú anterior");
                    j = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer

                    if(j==1){
                        biblioteca.registrarPedidoLibro();
                    }else if (j == 8) {
                        System.out.println("Volviendo al menú anterior...");
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                }
                break;
                case 3:
                while (j != 8) {
                    System.out.println("Por favor elija una de las siguientes opciones del menú: \n[1] Devolver un libro \n[8] Volver al menú anterior");
                    j = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer
            
                    if (j == 1) {
                        biblioteca.registrarDevolucionLibro();
                    } else if (j == 8) {
                        System.out.println("Volviendo al menú anterior...");
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                }
                break;

                case 4:
                    biblioteca.registrarUsuario();
                break;
                case 5:
                    biblioteca.mostrarLibrosDisponibles();
                break;
                case 6:
                    biblioteca.mostrarTodosLibrosPrestados();
                break;
                case 0:
                    i = 0;
                    System.out.println("Saliendo...");
                break;

                default:
                    System.out.println("Opción no válida. Por favor, ingrese un número nuevamente");
              }
        }
    }
}
