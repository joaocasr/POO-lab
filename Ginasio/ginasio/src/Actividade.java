import java.io.Serializable;

public abstract class Actividade implements Serializable,Comparable<Actividade> {
    private String designacao;
    private double caloriasPorUnidadeTreino;


    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public double getCaloriasPorUnidadeTreino() {
        return caloriasPorUnidadeTreino;
    }

    public void setCaloriasPorUnidadeTreino(double caloriasPorUnidadeTreino) {
        this.caloriasPorUnidadeTreino = caloriasPorUnidadeTreino;
    }

    public abstract double caloriasGastas();

    public int compareTo(Actividade a){
        return (int) (this.caloriasGastas()-a.caloriasGastas());
    }
}
