package TrabajoPracticoFinal;

//Se crea una clase derivada de Pasajero. En donde se agrega un atributo que es el
public class PasajeroVIP extends Pasajero {
    private String beneficios;


    public PasajeroVIP(String nombre, String apellido, String dni, String beneficios) {
        super(nombre, apellido, dni);
        this.beneficios = beneficios;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String Beneficios) {
        this.beneficios = beneficios;
    }

    @Override
    public String toString() {
        return "PasajeroVIP{" +
                "nombre='" + getNombre() + '\'' + //se utiliza el get que es para obtener el nombre.
                ", apellido='" + getApellido() + '\'' +
                ", dni='" + getDni() + '\'' +
                ", beneficios='" + beneficios + '\'' +
                 ", codigosVuelosReservados=" + getCodigosVuelosReservados() +
                '}';
    }
}
