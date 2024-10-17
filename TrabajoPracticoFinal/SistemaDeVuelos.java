package TrabajoPracticoFinal;

import java.util.Scanner;

public class SistemaDeVuelos {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Registro registro = new Registro();
        
        // Pantalla de bienvenida
        System.out.println("Bienvenido al sistema de gestión de vuelos de Morena Caparrós");
        System.out.println("Carrera: Licenciatura en Ciencia de Datos, 1° Año");
        System.out.println("Este programa permite gestionar la reserva de vuelos de una aerolínea.");

        //Creo algunos pasajeros
        // Llamo al método creado en registro que es para agregar pasajeros y vuelos
        
        registro.agregarPasajero(new Pasajero("Juan", "Garcia", "23456789"));
        registro.agregarPasajero(new Pasajero("Maria", "Garcia", "30456790"));
        registro.agregarPasajero(new Pasajero("Carlos", "Lopez", "34567890"));
        
        //Creo algunos vuelos
        registro.agregarVuelos(new Vuelos("J7689", "Buenos Aires", "Mar del Plata","10-07-2024"));
        registro.agregarVuelos(new Vuelos("LP191915", "Cordoba", "Tucuman","11-08-2024"));
        registro.agregarVuelos(new Vuelos("RM5500", "Buenos Aires", "Salta","30-06-2024"));

        
        int num;
        int i = 1;
        //Se continua hasta que sea igual a 0 porque es la opcion de Salir
        while (i != 0) {
            System.out.println("Bienvenido al sistema de vuelos \nPor favor elija una de las siguientes opciones del menú:");
            System.out.println("[1] Ingresar un vuelo \n[2] Reservar un vuelo \n[3] Cancelar un vuelo \n[4] Registrar pasajero \n[5] Ver vuelos disponibles \n[6] Ver reservas \n[7] Eliminar un pasajero\n[0] Salir");
            num = entrada.nextInt();
            entrada.nextLine();//Limpiar el buffer
            int j = 1;
            //segun cada numero que se elija se hace algo 
            switch (num) { 
                case 1:
                while (j != 2) {
                    if (registro.getVuelos().size() >= 5) {
                        System.out.println("No se pueden agregar más destinos, inténtelo más tarde.");
                        break;
                    } else {
                        registro.registrarVuelo();
                        System.out.println("Por favor elija una de las siguientes opciones del menú: \n[1]Agregar un vuelo nuevo \n[2]Volver al menú anterior");
                    }
                    j = entrada.nextInt();
                    entrada.nextLine();//Limpiar el buffer
                }
                break;
                case 2:
                while (j != 8) {
                    System.out.println("Por favor elija una de las siguientes opciones del menú: \n[1] Reservar un vuelo nuevo \n[8] Volver al menú anterior");
                    j = entrada.nextInt();
                    entrada.nextLine(); // Limpiar el buffer
            
                    if (j == 1) {
                        registro.registrarReserva();
                    } else if (j == 8) {
                        System.out.println("Volviendo al menú anterior...");
                    } else {
                        System.out.println("Opción no válida. Intente nuevamente.");
                    }
                }
                break;
                case 3:
                    registro.cancelarVueloPasajero();
                break;

                case 4:
                    registro.registrarPasajero();
                break;
                case 5:
                    registro.mostrarVuelos();
                break;
                case 6:
                    registro.mostrarReservas();
                break;
                case 7:
                    registro.eliminarPasajero();
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

