/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cinemajava;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author halejandro
 */
public class CinemaJava {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Pelicula pelicula = new Pelicula("Orgullo y prejuicio", 90, 16,
                "Joe Wright");
        Cine cine = new Cine(pelicula, 10000.0, 2, 2);
        cine.generarAsientos();
        Random aleatorio = new Random();
        cine.imprimirInfo();

        for (int i = 0; i < 6; i++) {
            String nombre = "Espectador " + (i + 1);
            int edad = aleatorio.nextInt(14, 20);
            double dinero = aleatorio.nextDouble() * 30000.0;
            Espectador espectador = new Espectador(nombre, edad, dinero);

            boolean espectadorSentado = false;
            for (int fila = 0; fila < cine.getAsientos().length
                    && espectadorSentado == false; fila++) {
                for (int columna = 0; columna < cine.getAsientos()[0].length
                        && espectadorSentado == false; columna++) {
                    Asiento asiento = cine.getAsientos()[fila][columna];
                    if (asiento.getOcupado() == false
                            && espectador.puedeEntrar(pelicula, cine)
                            && !cine.todosAsientosOcupados(cine)) {
                        cine.asignarAsiento(espectador);
                        espectador.setAsiento(asiento);
                        espectador.cobrarEntrada(espectador, pelicula, cine);
                        espectadorSentado = true;
                    }
                    break;
                }
            }
            if (espectadorSentado) {

                Scanner input = new Scanner(System.in);
                int opcion;
                do {
                    System.out.println("Menú de opciones");
                    System.out.println("1.Comprar otro asiento");
                    System.out.println("2.Ver asientos disponibles");
                    System.out.println("3.Finalizar programa");
                    System.out.println("Ingrese el número de la opción que desea");

                    opcion = input.nextInt();
                    switch (opcion) {
                        case 1:
                            if (espectador.getDinero() >= cine.getPrecio()) {
                                espectadorSentado = false;
                                for (int fila = 0; fila < cine.getAsientos().length
                                        && !espectadorSentado; fila++) {
                                    for (int columna = 0; columna
                                            < cine.getAsientos()[0].length
                                            && !espectadorSentado; columna++) {
                                        Asiento asiento
                                                = cine.getAsientos()[fila][columna];
                                        if (espectador.puedeEntrar(pelicula, cine)
                                                == true
                                                && !cine.asientosActLlenos(asiento)) {
                                            cine.asignarAsiento(espectador);
                                            espectador.setAsiento(asiento);
                                            espectador.cobrarEntrada(espectador,
                                                    pelicula, cine);
                                            espectadorSentado = true;
                                        } else {
                                            System.out.println("Todos los "
                                                    + "asientos"
                                                    + " estan ocupados");
                                            System.exit(0);
                                        }
                                    }
                                }
                                break;
                            } else {
                                System.out.println(" ");
                                System.out.println("Tu presupuesto no alcanza"
                                        + " para comprar otra entrada");
                                System.out.println(" ");
                                continue;
                            }
                        case 2:
                            cine.imprimir();
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("la opcion ingresada "
                                    + "no es valida");
                    }
                } while (opcion != 3);
            }
        }
    }

}
