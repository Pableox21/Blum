package modeloVideojuego;

public class Videojuegos {
    private int id;
    private String nombre;
    private Double precio;
    private int existencias;
    String nombreDesarrolladora;
    Videojuegos(int id, String nombre, Double precio, int existencias, String nombreDesarrolladora){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.existencias=existencias;
        this.nombreDesarrolladora=nombreDesarrolladora;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    public String getNombreDesarrolladora() {
        return nombreDesarrolladora;
    }

    public void setNombreDesarrrolladora(String nombreDesarrolladora) {
        this.nombreDesarrolladora = nombreDesarrolladora;
    }
}
