public class Abdominais extends Actividade{
    private int numeroRepeticoes;
    private String tipoExercicio;

    public double caloriasGastas(){
        return 40*this.numeroRepeticoes;
    }
}
