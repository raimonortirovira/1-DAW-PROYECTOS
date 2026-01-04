package funciones;

import clases.Coche;
import java.util.ArrayList;
import java.util.Random;

public class Metodos {
    Random azar = new Random();

    public void empezarCarrera(ArrayList<Coche> lista, int meta) {
        boolean finCarrera = false;

        // Aquí hacemos que corran hasta que uno llegue a la meta
        while (finCarrera == false) {
            for (int i = 0; i < lista.size(); i++) {
                int avance = azar.nextInt(31) + 20;
                lista.get(i).sumarAvance(avance);

                if (lista.get(i).kilometrosEnEstaCarrera >= meta) {
                    finCarrera = true;
                }
            }
        }

        // Aquí los ordenamos por km para ver quién gana hoy
        for (int i = 0; i < lista.size(); i++) {
            for (int j = 0; j < lista.size() - 1; j++) {
                if (lista.get(j).kilometrosEnEstaCarrera < lista.get(j + 1).kilometrosEnEstaCarrera) {
                    Coche temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }
}