import java.util.GregorianCalendar;

public class RegistoEtapa {
    private String nomeEtapa;
    private GregorianCalendar inicio;
    private GregorianCalendar fim;
    private double milhasPercorridas;

    public RegistoEtapa(){}

    public String getNomeEtapa() {
        return nomeEtapa;
    }

    public void setNomeEtapa(String nomeEtapa) {
        this.nomeEtapa = nomeEtapa;
    }

    public GregorianCalendar getInicio() {
        return inicio;
    }

    public void setInicio(GregorianCalendar inicio) {
        this.inicio = inicio;
    }

    public GregorianCalendar getFim() {
        return fim;
    }

    public void setFim(GregorianCalendar fim) {
        this.fim = fim;
    }

    public double getMilhasPercorridas() {
        return milhasPercorridas;
    }

    public void setMilhasPercorridas(double milhasPercorridas) {
        this.milhasPercorridas = milhasPercorridas;
    }

    public RegistoEtapa clone(){
        return new RegistoEtapa();
    }
}
