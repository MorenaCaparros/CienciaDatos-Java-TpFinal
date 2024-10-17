package TrabajoPracticoFinal;

import java.util.ArrayList;
import java.util.Scanner;


public class Registro {
    //Crear una lista dinámica de objetos de tipo Pasajero y Vuelos
    private ArrayList<Pasajero> pasajeros;
    private ArrayList<Vuelos> vuelos;
    
    //Constructor
    public Registro() {
        pasajeros = new ArrayList<>();
        vuelos = new ArrayList<>();
    }

    //Método que agrega un objeto Pasajero a la lista de pasajeros.
    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    //Método que agrega un objeto Vuelos a la lista de vuelo.
    public void agregarVuelos(Vuelos vuelo) {
        vuelos.add(vuelo);
    }
    
    //Método que itera sobre la lista de pasajeros y muestra cada uno.
    public void mostrarPasajeros() {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero instanceof PasajeroVIP) {
                System.out.println((PasajeroVIP) pasajero);
            } else {
                System.out.println(pasajero);
            }
        }
    }

    //Método que itera sobre la lista de vuelos y muestra cada uno.
    public void mostrarVuelos() {
        for (Vuelos vuelo : vuelos) {
            System.out.println(vuelo);
        }
    }

    //Método para mostrar las reservas de los pasajeros
    public void mostrarReservas() {
        boolean hayReservas = false;
    
        for (Pasajero pasajero : pasajeros) {
            if (!pasajero.getCodigosVuelosReservados().isEmpty()) {
                hayReservas = true;
                System.out.println("Pasajero: " + pasajero.getNombre() + " " + pasajero.getApellido() + " (" + pasajero.getDni() + ")");
                for (String codigoVuelo : pasajero.getCodigosVuelosReservados()) {
                    Vuelos vuelo = buscarVuelo(codigoVuelo, null, null);
                    if (vuelo != null) {
                        System.out.println("  - Vuelo: " + vuelo.getCodigo() + " de " + vuelo.getOrigen() + " a " + vuelo.getDestino() + " en " + vuelo.getFecha());
                    }
                }
            }
        }
        if (!hayReservas) {
            System.out.println("No hay reservas hechas.");
        }
    }
    
    
    //Método que busca un pasajero en la lista por su DNI y devuelve el  encontrado, o sino null 
    public Pasajero buscarPasajero(String dni) {
        for (Pasajero pasajero : pasajeros) {
            if (pasajero.getDni().equalsIgnoreCase(dni)) { //el equalsIgnoreCase para que si es minuscula/mayuscula se tome igual
                return pasajero;
            }
        }
        return null;
    }
    // Método que busca un vuelo en la lista por su código o su origen y destino y devuelve el encontrado, o sino null 
    public Vuelos buscarVuelo(String codigo, String origen, String destino) {
        for (Vuelos vuelo : vuelos) {
            if ((codigo != null && !codigo.isEmpty() && vuelo.getCodigo().equalsIgnoreCase(codigo)) ||
                (origen != null && destino != null && vuelo.getOrigen().equalsIgnoreCase(origen) && vuelo.getDestino().equalsIgnoreCase(destino))) {
                return vuelo;
            }
        }
        System.out.println("No se encontraron vuelos con esos datos");
        return null;
        }
    //Es utilizando el método anterior pero preguntandole al pasajero los datos
    public Vuelos buscarVueloInteractivo() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Por favor, ingrese el codigo del vuelo, si no lo recuerda puede dejarlo vacío:");
        String codigo = scanner.nextLine();

        String destino = null, origen = null;
        //Si el codigo esta vacio o es null entonces se pide el destino y el origen
        if (codigo == null || codigo.isEmpty()) {
            System.out.println("Por favor, ingrese el destino del vuelo:");
            destino = scanner.nextLine();

            System.out.println("Por favor, ingrese el origen del vuelo:");
            origen = scanner.nextLine();
        }

        return buscarVuelo(codigo, origen, destino);
    }
    //Se busca registrar al pasajero y unirlo con el codigo de su vuelo, en caso de que tenga dos reservas le dara aviso que 
    //no puede realizar mas reservas
    public void registrarReserva() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el DNI del pasajero:");
        String dni = scanner.nextLine();
        Pasajero pasajero = buscarPasajero(dni);

        if (pasajero == null) {
            System.out.println("Pasajero no encontrado. Registre el pasajero primero.");
            registrarPasajero();
            pasajero = buscarPasajero(dni); // Rebuscar el pasajero después de registrarlo
        
            if (pasajero == null) {
                System.out.println("Error al registrar el pasajero. Inténtelo de nuevo.");
                return;
            }
        }
        if (pasajero.getCodigosVuelosReservados().size() >= 2) {
            System.out.println("El pasajero ya tiene dos reservas.");
            return;
        }

        Vuelos vuelo = buscarVueloInteractivo();
        if (vuelo != null) {
            pasajero.agregarCodigoVueloReservado(vuelo.getCodigo());
            System.out.println("Reserva realizada con éxito. Pasajero " + pasajero.getNombre() + " ha reservado el vuelo " + vuelo.getCodigo());
        } else {
            System.out.println("Vuelo no encontrado.");
        }
    }

    public ArrayList<Vuelos> getVuelos() {
        return vuelos;
    }
    //Método que les pide por consola los datos a los pasajeros y  por
    //último llama al método agregar pasajero para agregarlo 

    public void registrarPasajero() {
        Scanner scanner = new Scanner(System.in);
        int tipo = 0;
        while (tipo != 1 && tipo != 2) {
            System.out.println("Ingrese el tipo de pasajero (1 - Normal, 2 - VIP):");
            if (scanner.hasNextInt()) {
                tipo = scanner.nextInt();
                if (tipo != 1 && tipo != 2) {
                    System.out.println("Entrada inválida. Por favor ingrese 1 o 2.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor ingrese un número.");
                scanner.next(); // Limpiar la entrada incorrecta
            }
        }
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese nombre del pasajero:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese apellido del pasajero:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese DNI del pasajero:");
        String dni = scanner.nextLine();

        if (tipo == 1) {
            Pasajero pasajero = new Pasajero(nombre, apellido, dni);
            agregarPasajero(pasajero);
        } else if (tipo == 2) {
            System.out.println("Ingrese beneficios del pasajero VIP:");
            String beneficios = scanner.nextLine();
            PasajeroVIP pasajeroVIP = new PasajeroVIP(nombre, apellido, dni, beneficios);
            agregarPasajero(pasajeroVIP);

        } 
    }
    //Método que les pide por consola los datos a del vuelo y  por
        //último llama al método agregar vuelos para agregarlo 

    public void registrarVuelo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese el codigo del vuelo:");
        String codigo = scanner.nextLine();

        System.out.println("Por favor, ingrese el destino del vuelo:");
        String destino = scanner.nextLine();

        System.out.println("Por favor, ingrese el origen del vuelo:");
        String origen = scanner.nextLine();

        System.out.println("Por favor, ingrese la fecha del vuelo (en formato DD-MM-AAAA):");
        String fecha = scanner.nextLine();
        //Utilizando ArrayList puedo aca agregar vuelos a la lista dinámica
        // Validación simple
        if (codigo.isEmpty() || destino.isEmpty() || origen.isEmpty() || fecha.isEmpty()) {
            System.out.println("Todos los campos son obligatorios. Inténtelo de nuevo.");
            return;
        }
        
        Vuelos vuelo = new Vuelos(codigo, destino, origen, fecha);
        agregarVuelos(vuelo);
        System.out.println("Vuelo agregado exitosamente.");
    }
    //Eliminar pasajero
    public void eliminarPasajero() {
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Ingrese el DNI del pasajero a eliminar:");
        String dni = scanner.nextLine();
        Pasajero pasajero = buscarPasajero(dni);
    
        if (pasajero == null) {
            System.out.println("Pasajero no encontrado.");
            return;
        }
    
        pasajeros.remove(pasajero);
        System.out.println("Pasajero eliminado exitosamente.");
    }
    
    //Método para cancelar un vuelo en donde se solicita el DNI del pasajero y lo busca.
    public void cancelarVueloPasajero() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Ingrese el DNI del pasajero:");
            String dni = scanner.nextLine();
            Pasajero pasajero = buscarPasajero(dni);
        
            if (pasajero == null) {
                System.out.println("Pasajero no encontrado.");
                return;
            }
            
            //Si no tiene reservas da aviso, solicita el codigo o el destino y origen
            if (pasajero.getCodigosVuelosReservados().isEmpty()) {
                System.out.println("No tenés reservas hechas a tu nombre.");
                return;
            }
                
            System.out.println("Ingrese el código del vuelo (o deje vacío para usar destino y origen):");
            String codigo = scanner.nextLine();
                
            String destino = null, origen = null;
            if (codigo == null || codigo.isEmpty()) {
                System.out.println("Ingrese el destino del vuelo:");
                destino = scanner.nextLine();
                
                System.out.println("Ingrese el origen del vuelo:");
                origen = scanner.nextLine();
            }
                
            //Verifica si esta en las resrvas del pasajero
            Vuelos vuelo = buscarVuelo(codigo, origen, destino);
            if (vuelo == null || !pasajero.getCodigosVuelosReservados().contains(vuelo.getCodigo())) {
                System.out.println("Vuelo no encontrado entre tus reservas.");
                return;
            }
                
            //Si se encuentra se pide confirmacion para cancelar 
            System.out.println("Se encontró el vuelo, ¿estás seguro que querés cancelarlo?");
            System.out.println("Ingrese [1] Sí o [2] No:");
            int confirmacion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            if (confirmacion == 1) {
                //Se elimina de las reservas del pasajero
                pasajero.getCodigosVuelosReservados().remove(vuelo.getCodigo());
                System.out.println("Vuelo cancelado con éxito.");
                } else {
                    System.out.println("Cancelación de vuelo abortada.");
                }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }
}

    


