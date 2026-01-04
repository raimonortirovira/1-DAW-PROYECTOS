import clases.Coche;
import funciones.Metodos;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejecutar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Metodos logica = new Metodos();
        ArrayList<Coche> misCoches = new ArrayList<>();

        try {
            System.out.print("¿Cuántos coches van a competir?: ");
            int numCoches = Integer.parseInt(teclado.nextLine());

            // Aquí pedimos los datos y creamos el coche
            for (int i = 0; i < numCoches; i++) {
                System.out.println("Datos del coche " + (i + 1));
                System.out.print("  Marca: ");
                String m = teclado.nextLine();
                System.out.print("  Modelo: ");
                String mod = teclado.nextLine();
                misCoches.add(new Coche(m, mod));
            }

            System.out.print("¿Cuántas carreras tiene el mundial?: ");
            int totalCarreras = Integer.parseInt(teclado.nextLine());
            System.out.print("¿A qué distancia está la meta?: ");
            int meta = Integer.parseInt(teclado.nextLine());

            // Aquí repetimos las carreras que nos han dicho
            for (int i = 1; i <= totalCarreras; i++) {
                System.out.println("\n--- COMIENZA LA CARRERA " + i + " ---");

                // Aquí limpiamos los km de antes
                for (Coche c : misCoches) {
                    c.ponerMarcadorAZero();
                }

                logica.empezarCarrera(misCoches, meta);

                // Aquí solo mostramos la marca del ganador
                System.out.println("El ganador de esta carrera ha sido: " + misCoches.get(0).marcaDelCoche);
            }

            // Aquí ordenamos el ranking por los km totales
            for (int i = 0; i < misCoches.size(); i++) {
                for (int j = 0; j < misCoches.size() - 1; j++) {
                    if (misCoches.get(j).sumaDeTodosLosKilometros < misCoches.get(j + 1).sumaDeTodosLosKilometros) {
                        Coche aux = misCoches.get(j);
                        misCoches.set(j, misCoches.get(j + 1));
                        misCoches.set(j + 1, aux);
                    }
                }
            }

            // Aquí enseñamos el resultado final con mayúsculas
            System.out.println("\n--- PUNTUACION FINAL DE LOS COCHES ---");
            for (int i = 0; i < misCoches.size(); i++) {
                Coche c = misCoches.get(i);
                String nombreCompleto = (c.marcaDelCoche + " " + c.modeloDelCoche).toUpperCase();
                System.out.println((i + 1) + "º " + nombreCompleto + " - " + c.sumaDeTodosLosKilometros + " km totales");
            }

        } catch (Exception e) {
            System.out.println("Error en los datos.");
        }
    }
}