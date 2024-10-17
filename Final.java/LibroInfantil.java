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

//Esta clase es heradada de Libro, pero haciendo libro infantil porque tiene todos los atributos pero lo que hace es recomendarle la edad
package Final.java;

public class LibroInfantil extends Libro{
    private String generoInfantil;

    public LibroInfantil(String ID, String titulo, String autor, String genero, String estado) {
        super(ID, titulo,genero,autor,estado);
        this.generoInfantil = generoInfantil;
    }

    public String getlibroInfantil() {
        return generoInfantil;
    }
    
    public void setlibroInfantil() {
        this.generoInfantil = generoInfantil;
    }

    //Metodo para sugerencia de edad recomendada
    public void edadRecomendada(int edad) {
        if (edad <= 12){
            System.out.println("El usuario tiene la edad recomendada para leer este libro");
        } else {
            System.out.println("El usuario no tiene la edad recomendada para leer este libro, pero lo puede leer igual!");
        }

    }

    @Override
    public String toString() {
        return "LibroInfantil{" +
                "ID='" + getID() + '\'' + //se utiliza el get que es para obtener el nombre.
                ", titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", genero='" + getGenero() + '\'' +
                ", estado='" + getEstado()+ '\'' +
                ", generoInfantil='" + generoInfantil + '\'' +
                '}';
    }
}
