package modeloVideojuego;

public class Videojuegos {
    private int id;
    private String nombre;
    private Double precio;
    private String clasificacion;
    private int existencias;
    Videojuegos(int id, String nombre, Double precio,String clasificacion,int existencias){
        this.id=id;
        this.nombre=nombre;
        this.precio=precio;
        this.clasificacion=clasificacion;
        this.existencias=existencias;
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

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}
