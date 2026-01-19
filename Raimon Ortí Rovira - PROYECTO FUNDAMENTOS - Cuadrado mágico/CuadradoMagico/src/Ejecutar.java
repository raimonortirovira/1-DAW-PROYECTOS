import clases.Matriz;
import funciones.MetodosMagicos;
import java.util.Scanner;

public class Ejecutar {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        MetodosMagicos logica = new MetodosMagicos();

        try {
            // aquí pedimos el tamaño del cuadrado por teclado
            System.out.print("Introduce el tamaño de la matriz (n): ");
            int n = Integer.parseInt(teclado.nextLine());

            Matriz miCuadrado = new Matriz(n);
            long intentos = 0;

            System.out.println("Buscando cuadrado mágico...");

            // aquí vamos probando combinaciones hasta que salga una buena
            do {
                intentos++;
                logica.rellenarSinRepetir(miCuadrado);
            } while (!logica.esMagico(miCuadrado));

            // aquí enseñamos el cuadrado que hemos encontrado con formato
            System.out.println("\n=== CUADRADO MÁGICO ENCONTRADO ===");
            for (int f = 0; f < n; f++) {
                for (int c = 0; c < n; c++) {
                    System.out.print(miCuadrado.datos[f][c] + "\t");
                }
                System.out.println();
            }

            // aquí mostramos la constante mágica y los intentos totales
            int constante = n * (n * n + 1) / 2;
            System.out.println("\nConstante mágica: " + constante);
            System.out.println("Intentos realizados: " + intentos);

        } catch (Exception e) {
            // aquí avisamos si ha habido algún error al meter los datos
            System.out.println("Error en la entrada de datos.");
        }
    }
}