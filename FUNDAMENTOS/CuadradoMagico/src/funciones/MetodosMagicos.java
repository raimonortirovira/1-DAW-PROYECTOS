package funciones;

import clases.Matriz;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class MetodosMagicos {
    Random azar = new Random();

    public void rellenarSinRepetir(Matriz m) {
        // aquí creamos una lista para mezclar los números y que no se repitan
        ArrayList<Integer> numeros = new ArrayList<>();
        for (int i = 1; i <= m.n * m.n; i++) {
            numeros.add(i);
        }
        Collections.shuffle(numeros); // desordenamos la lista al azar

        int contador = 0;
        // aquí vamos rellenando el cuadrado con los números de la lista mezclada
        for (int f = 0; f < m.n; f++) {
            for (int c = 0; c < m.n; c++) {
                m.datos[f][c] = numeros.get(contador);
                contador++;
            }
        }
    }

    public boolean esMagico(Matriz m) {
        // aquí calculamos cuánto tienen que sumar las filas y columnas
        int sumaMagica = m.n * (m.n * m.n + 1) / 2;

        // aquí comprobamos si todas las filas suman lo que toca
        for (int f = 0; f < m.n; f++) {
            int sumaFila = 0;
            for (int c = 0; c < m.n; c++) {
                sumaFila += m.datos[f][c];
            }
            if (sumaFila != sumaMagica) {
                return false;
            }
        }

        // aquí comprobamos si las columnas suman lo mismo
        for (int c = 0; c < m.n; c++) {
            int sumaCol = 0;
            for (int f = 0; f < m.n; f++) {
                sumaCol += m.datos[f][c];
            }
            if (sumaCol != sumaMagica) {
                return false;
            }
        }

        // aquí comprobamos la diagonal que va hacia abajo
        int diag1 = 0;
        for (int i = 0; i < m.n; i++) {
            diag1 += m.datos[i][i];
        }
        if (diag1 != sumaMagica) {
            return false;
        }

        // aquí comprobamos la otra diagonal
        int diag2 = 0;
        for (int i = 0; i < m.n; i++) {
            diag2 += m.datos[i][m.n - 1 - i];
        }

        return diag2 == sumaMagica;
    }
}