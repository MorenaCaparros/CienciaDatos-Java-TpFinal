package TrabajoPracticoFinal;
//Creacion de la clase Vuelos con private en cada uno de los datos, restringir el acceso directo a los atributos
//fuera de la clase, para proteger a los datos. Luego para utilizarlos hay que 
// hacer get (para obtenerlos) y set (para configurarlos) 
public class Vuelos {
    private String codigo;
    private String destino;
    private String origen;
    private String fecha;

//Cree el contructor
    public Vuelos(String codigo, String destino,String origen,String fecha) {
        this.codigo=codigo;
        this.destino=destino;
        this.origen=origen;
        this.fecha=fecha;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override // Imprimir la información del objeto pero que sea mas facil de leer por eso se sobreescribe el "toString()"
    public String toString(){
        return "Vuelo{"+
               "codigo='"+codigo+'\'' +
               ", destino='" + destino + '\'' +
               ", origen='" + origen + '\'' +
               ", fecha='" + fecha + '\'' +
               '}';
    }
}