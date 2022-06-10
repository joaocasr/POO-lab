public class Eliptica extends Actividade implements ComDistancia{
    private double KmsPercorridos;
    private double nivelEsforco;
    private double minutos;

    public double caloriasGastas(){
        return this.KmsPercorridos*getCaloriasPorUnidadeTreino();
    }

    public double getKmsPercorridos(){
        return 0;
    }


}
