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


//Esta clase lo que hace es determina todos los atributos del Libro, es decir el id, titulo, genero, autor, estado
package Final.java;

//Establezco la clase libro, declaro los atributos como privados
public class Libro {
    private String ID;
    private String titulo;
    private String genero;
    private String autor;
    private String estado;

    public Libro (String ID, String titulo, String autor, String genero, String estado) {
        this.ID = ID;
        this.titulo = titulo;
        this.genero = genero;
        this.autor = autor;
        this.estado = estado;
    }

    //Para cada uno de los atributos creo un get y un set uno es para obtenerlo y set para modificarlos
    public String getId(){
        return ID;
    }

    public void setId(){
        this.ID = ID;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(){
        this.titulo = titulo;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(){
        this.autor = autor;
    }

    public String getGenero(){
        return genero;
    }

    public void setGenero(){
        this.genero = genero;
    }

    public String getEstado(){
        return estado;
    }

    public void setEstado(){
        this.estado = estado;
    }
//Sobreescribo lo que me trae la clase para que se vea de esta manera, que esta mas estructurado.
    @Override
    public String toString() {
        return "Libro{" +
            "ID='" + ID + '\'' +
            ", titulo='" + titulo + '\'' +
            ", autor='" + autor + '\'' +
            ", genero='" + genero + '\'' +
            ", estado='" + estado + '\'' +
            //", idLibrosNoDisponibles'" + (idLibrosNoDisponibles.isEmpty() ? "Todos los libros están disponibles" : idLibrosNoDisponibles) + '\'' +
            '}';
    }
}

