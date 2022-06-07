import java.io.Serializable;

public class BarcoHibrido extends Barco implements Serializable {
    private double capacidade;
    private double potencia;
    private double autonomiaEletrica;

    public BarcoHibrido(BarcoHibrido b){
        super(b);
        this.capacidade = b.getCapacidade();
        this.potencia = b.getPotencia();
        this.autonomiaEletrica = b.getAutonomiaEletrica();
    }

    public double getCapacidade() {
        return this.capacidade;
    }

    public void setCapacidade(double capacidade) {
        this.capacidade = capacidade;
    }

    public double getPotencia() {
        return this.potencia;
    }

    public void setPotencia(double potencia) {
        this.potencia = potencia;
    }

    public double getAutonomiaEletrica() {
        return this.autonomiaEletrica;
    }

    public void setAutonomiaEletrica(double autonomiaEletrica) {
        this.autonomiaEletrica = autonomiaEletrica;
    }

    public double getAutonomia(){
        return super.getAutonomia()+this.autonomiaEletrica;
    }

    public double seguro(){
        return super.getMilhas()*0.02;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Potencia: ").append(this.potencia)
                .append("Capacidade: ").append(this.capacidade)
                .append("Autonomia Eletrica: ").append(this.autonomiaEletrica);
        return sb.toString();
    }

    public BarcoHibrido clone(){
        return new BarcoHibrido(this);
    }
}
