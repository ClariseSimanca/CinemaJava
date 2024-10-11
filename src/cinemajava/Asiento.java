package cinemajava;

public class Asiento {
    private char letra;
    private Integer fila;
    private boolean ocupado = false;
    private Espectador espectador;

    public Asiento(char letra, Integer fila) {
        this.letra = letra;
        this.fila = fila;
        this.ocupado = false;
        this.espectador = null;
    }

    public Asiento() {
    }
    
    
    public char getLetra() {
        return letra;
    }
   

    public Integer getFila() {
        return fila;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }
   

    public boolean getOcupado() {
        return ocupado;
    }

    public Espectador getEspectador() {
        return espectador;
    }

    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }
    
    public boolean ocuparAsiento(){
     return this.ocupado = true;
    }

   
    }

    

