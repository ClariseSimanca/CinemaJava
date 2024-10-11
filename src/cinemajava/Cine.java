package cinemajava;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Cine {

    private Pelicula peliculaAct;
    private Double precio;
    private Asiento asientos[][];
    private Set<String> asientosOcupados;
    Random aleAsiento = new Random();

    public Cine(Pelicula peliculaAct, Double precio, Integer filas,
            Integer columnas) {
        this.peliculaAct = peliculaAct;
        this.precio = precio;
        this.asientos = new Asiento[filas][columnas];
        asientosOcupados = new HashSet<>();
    }

    public Pelicula getPeliculaAct() {
        return peliculaAct;
    }

    public void setPeliculaAct(Pelicula peliculaAct) {
        this.peliculaAct = peliculaAct;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Asiento[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(Asiento[][] asientos) {
        this.asientos = asientos;
    }

    public void generarAsientos() {
        for (int f = 0; f < asientos.length; f++) {
            for (int c = 0; c < asientos[f].length; c++) {
                asientos[f][c] = new Asiento((char) ('A' + c), (f + 1));
            }
        }
    }

    public void imprimirInfo() {
        System.out.println("La pelicula en cartelera es: "
                + this.getPeliculaAct().getTitulo());
        System.out.println("El precio de la entrada es: $"
                + this.getPrecio());
        System.out.println(" ");
    }

    public void imprimir() {
        for (int f = 0; f < this.getAsientos().length; f++) {
            for (int c = 0; c < this.getAsientos()[0].length; c++) {
                Asiento asiento = this.getAsientos()[f][c];
                if (asiento.getOcupado()) {
                    System.out.print(" X ");
                } else {
                    System.out.print(asiento.getFila() + ""
                            + asiento.getLetra() + " ");
                }
            }
            System.out.println(" ");
        }
    }

    public void asignarAsiento(Espectador espectador) {
        boolean asientoAsignado = false;
        while (asientoAsignado == false) {
            int f = aleAsiento.nextInt(this.getAsientos().length);
            int c = aleAsiento.nextInt(this.getAsientos()[0].length);
            String posicion = f + " " + c;
            if (!asientosOcupados.contains(posicion)) {
                Asiento asiento = this.getAsientos()[f][c];
                asiento.ocuparAsiento();
                asiento.setEspectador(espectador);
                asientosOcupados.add(posicion);
                asientoAsignado = true;
                System.out.println(espectador.getNombre()
                        + " el asiento que ha comprado"
                        + " es: " + asiento.getFila() + asiento.getLetra());
            }
        }
    }

    public boolean asientosActLlenos(Asiento asiento) {
        for (int fila = 0; fila < this.getAsientos().length; fila++) {
            for (int columna = 0; columna < 
                    this.getAsientos()[fila].length; columna++) {
                if (!asientos[fila][columna].getOcupado()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean todosAsientosOcupados(Cine cine) {
        for (int fila = 0; fila < cine.getAsientos().length; fila++) {
            for (int columna = 0; columna < 
                    cine.getAsientos()[0].length; columna++) {
                if (!cine.getAsientos()[fila][columna].getOcupado()) {
                    return false;
                }
            }
        }
        return true;
    }
}
