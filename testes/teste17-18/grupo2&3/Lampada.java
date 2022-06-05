import java.time.LocalDateTime;

public class Lampada {
    private String ident;
    private LocalDateTime inicio;
    private LocalDateTime parcial;
    private double consumoLigada;
    private double consumoEco;
    private double consumoTotal;
    private double consumoParcial;
    private int estado; // 0-desligada 1-ligada 2-eco


    public Lampada(String ident,double consumoLigada, double consumoEco) {
        //...
    }

    public Lampada(Lampada l){
        this.ident = l.getIdent();
        this.inicio=l.getInicio();
        this.parcial = l.getParcial();
        this.consumoLigada = l.getConsumoLigada();
        this.consumoEco = l.getConsumoLigada();
        this.consumoTotal = l.getConsumoTotal();
        this.consumoParcial = l.getConsumoParcial();
        this.estado = l.getEstado();
    }

    public void lampON(){
        //...liga a lampada em modo consumo maximo
    }

    public void lampECO(){
        //liga lampada em modo eco
    }

    public void lampOFF(){
        //desliga a lampada
    }

    public double totalConsumo(){
        //...devolve o consumo desde o inicio
        return 0;
    }
    //devolve o consumo desde o ultimo reset

    public double periodoConsumo(){
        return 0;
    }

    public void efetuarResetConsumo(){
        //...
    }


    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    public LocalDateTime getParcial() {
        return parcial;
    }

    public void setParcial(LocalDateTime parcial) {
        this.parcial = parcial;
    }

    public double getConsumoLigada() {
        return consumoLigada;
    }

    public void setConsumoLigada(double consumoLigada) {
        this.consumoLigada = consumoLigada;
    }

    public double getConsumoEco() {
        return consumoEco;
    }

    public void setConsumoEco(double consumoEco) {
        this.consumoEco = consumoEco;
    }

    public double getConsumoTotal() {
        return consumoTotal;
    }

    public void setConsumoTotal(double consumoTotal) {
        this.consumoTotal = consumoTotal;
    }

    public double getConsumoParcial() {
        return consumoParcial;
    }

    public void setConsumoParcial(double consumoParcial) {
        this.consumoParcial = consumoParcial;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Lampada clone(){
        return new Lampada(this);
    }
}


