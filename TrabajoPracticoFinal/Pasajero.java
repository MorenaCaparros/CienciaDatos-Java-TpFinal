package TrabajoPracticoFinal;
//Creacion de la clase Pasajero con private en cada uno de los datos, restringir el acceso directo a los atributos
//fuera de la clase, para proteger a los datos. luego para utilizarlos hay que 
// hacer get y set 

import java.util.ArrayList;

public class Pasajero {
    private String nombre;
    private String apellido;
    private String dni;
    private ArrayList<String> codigosVuelosReservados;
    private static final int MAX_RESERVAS = 2; // Usar una constante para el máximo de reservas


    public Pasajero(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.codigosVuelosReservados  = new ArrayList<>();  
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<String> getCodigosVuelosReservados() {
        return codigosVuelosReservados;
    }

    public void agregarCodigoVueloReservado(String codigoVueloReservado) {
        if (codigosVuelosReservados.size() < MAX_RESERVAS) { // Usar la constante
            codigosVuelosReservados.add(codigoVueloReservado);
        } else {
            System.out.println("El pasajero ya tiene " + MAX_RESERVAS + " reservas.");
        }
    }
    @Override // Se quiere imprimir información del objeto pero que sea mas facil de leer por eso se sobreescribe el "toString()"
    public String toString() {
        return "Pasajero{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", codigosVuelosReservados=" + (codigosVuelosReservados.isEmpty() ? "No reservado" : codigosVuelosReservados) +
                '}';
    }
}



    
