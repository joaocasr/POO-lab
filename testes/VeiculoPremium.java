import java.util.*;


public class VeiculoPremium extends Veiculo implements BonificaKms {
    private double taxaLuxo;

    private int pontosKm;
    private int pontosAcumulados;

    public VeiculoPremium(String marca, String modelo, String matricula,
                          int ano, double velocidademedia, double precokm,
                          List<Integer> classificacao,
                          int kms, int kmsUltimo, double taxaLuxo) {

        super(marca, modelo, matricula, ano, velocidademedia, precokm, classificacao, kms, kmsUltimo);
        this.taxaLuxo = taxaLuxo;
    }


    public VeiculoPremium(VeiculoPremium vp) {
        super(vp);
        this.taxaLuxo = vp.getTaxaLuxo();
    }


    public double getTaxaLuxo() {
        return this.taxaLuxo;
    }


    public double custoRealKM() {
        return getPrecokm() * this.taxaLuxo;
    }


    public VeiculoPremium clone() {
        return new VeiculoPremium(this);
    }


    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoPremium v = (VeiculoPremium) o;
        return super.equals(v) && this.taxaLuxo == v.getTaxaLuxo();
    }

    public String toString() {
        return super.toString() + " Taxa Luxo: "+ this.taxaLuxo + " ";
    }

    public void setPontos(int pontos) {
        this.pontosKm = pontos;
    }

    public int getPontos() {
        return this.pontosKm;
    }

    public int getPontosAcumulados() {
        return this.pontosAcumulados;
    }

    public void addViagem(int nkms) {
        super.addViagem(nkms);
        this.pontosAcumulados += nkms*this.pontosKm;

    }

}
