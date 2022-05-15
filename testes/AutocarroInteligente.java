import java.util.List;

public class AutocarroInteligente extends Veiculo implements BonificaKms {
    private int lotacao;
    private int ocupacao;
    private int pontosKm;
    private int pontosAcumulados;

    public AutocarroInteligente(String marca, String modelo, String matricula,
                                int ano, double velocidademedia, double precokm,
                                List<Integer> classificacao,
                                int kms, int kmsUltimo, int lotacao, int ocupacao) {

        super(marca, modelo, matricula, ano, velocidademedia, precokm, classificacao, kms, kmsUltimo);
        this.lotacao = lotacao;
        this.ocupacao = ocupacao;
    }


    public AutocarroInteligente(AutocarroInteligente vp) {
        super(vp);
        this.ocupacao = vp.getOcupacao();
        this.lotacao = vp.getLotacao();
    }


    public int getOcupacao() {
        return this.ocupacao;
    }

    public int getLotacao() {
        return this.lotacao;
    }

    public double custoRealKM() {
        double ratio = lotacao/ocupacao; //ratio de ocupação
        double factor;

        if (ratio < 0.6)
            factor = 0.5;
        else
            factor = 0.75;

        return getPrecokm()*factor;
    }



    public AutocarroInteligente clone() {
        return new AutocarroInteligente(this);
    }


    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        AutocarroInteligente v = (AutocarroInteligente) o;
        return super.equals(v) && this.ocupacao == v.getOcupacao() && this.lotacao == v.getLotacao();
    }

    public String toString() {
        return super.toString() + " Ocupacão: "+ this.ocupacao + " Lotação: "+ this.lotacao;
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
