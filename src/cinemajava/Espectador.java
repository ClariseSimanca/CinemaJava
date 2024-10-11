package cinemajava;

public class Espectador {
private String nombre;
private Integer edad;
private Double dinero;
private Asiento asiento = null;

    public Espectador(String nombre, Integer edad, Double dinero) {
        this.nombre = nombre;
        this.edad = edad;
        this.dinero = dinero;
        this.asiento = null;
    }
    
    public Espectador() {
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }
    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Double getDinero() {
        return dinero;
    }
    public void setDinero(Double dinero) {
        this.dinero = dinero;
    }

    public Asiento getAsiento() {
        return asiento;
    }

    public void setAsiento(Asiento asiento) {
        this.asiento = asiento;
    }
  
    public boolean puedeEntrar(Pelicula pelicula, Cine cine){
        if(this.getDinero()>= cine.getPrecio() && 
                this.getEdad()>= pelicula.getEdadMinima()){
        return true;
        }
    return false;
    }
    
    public void cobrarEntrada(Espectador espectador,
            Pelicula pelicula, Cine cine){
    if(espectador.puedeEntrar(pelicula, cine) == true){
    dinero = dinero - cine.getPrecio();
        System.out.println( "y sus vueltos son $" 
                + dinero);
        System.out.println(" ");         
    }
    }
}
