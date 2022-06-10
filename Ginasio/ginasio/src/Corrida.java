public class Corrida extends Actividade implements ComDistancia{
    private double KmsPercorridos;
    private double elevacao;
    private double velocidade;


    public double caloriasGastas(){
        return this.KmsPercorridos * getCaloriasPorUnidadeTreino();
    }

    public double getKmsPercorridos(){
        return 0;
    }
}
