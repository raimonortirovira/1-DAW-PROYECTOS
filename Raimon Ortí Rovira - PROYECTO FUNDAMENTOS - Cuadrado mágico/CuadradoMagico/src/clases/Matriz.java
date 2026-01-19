package clases;

public class Matriz {
    public int[][] datos;
    public int n;

    public Matriz(int tamano) {
        // aquí preparamos el cuadrado con el tamaño que nos han dado
        this.n = tamano;
        this.datos = new int[tamano][tamano];
    }
}