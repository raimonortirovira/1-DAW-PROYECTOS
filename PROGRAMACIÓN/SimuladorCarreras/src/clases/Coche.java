package clases;

public class Coche {
    public String marcaDelCoche;
    public String modeloDelCoche;
    public int kilometrosEnEstaCarrera;
    public int sumaDeTodosLosKilometros;

    public Coche(String marcaEntrada, String modeloEntrada) {
        this.marcaDelCoche = marcaEntrada;
        this.modeloDelCoche = modeloEntrada;
        this.kilometrosEnEstaCarrera = 0;
        this.sumaDeTodosLosKilometros = 0;
    }

    // Aquí ponemos los km a cero antes de empezar
    public void ponerMarcadorAZero() {
        this.kilometrosEnEstaCarrera = 0;
    }

    // Aquí iremos sumando lo que avanza el coche
    public void sumarAvance(int kmParaSumar) {
        this.kilometrosEnEstaCarrera = this.kilometrosEnEstaCarrera + kmParaSumar;
        this.sumaDeTodosLosKilometros = this.sumaDeTodosLosKilometros + kmParaSumar;
    }
}