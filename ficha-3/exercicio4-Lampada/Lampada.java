public class Lampada{
    public enum Mode {
        ON,
        OFF,
        ECO,
    }
    private Mode mode;
    private double consumoLigada;
    private double consumoEco;
    private double totalConsumo;
    private double periodoConsumo;

    public double getTotalConsumo() {
        return this.totalConsumo;
    }

    public void setTotalConsumo(double totalConsumo) {
        this.totalConsumo = totalConsumo;
    }

    public double getPeriodoConsumo() {
        return this.periodoConsumo;
    }

    public void setPeriodoConsumo(double periodoConsumo) {
        this.periodoConsumo = periodoConsumo;
    }

    public Lampada(){
        this.mode=Mode.ECO;
        this.consumoEco = 0.77;
        this.consumoLigada = 1.30;
        this.periodoConsumo = 12.34;
        this.totalConsumo = 23.2;
    }

    public Lampada(Mode modo , double cEco , double cLigada,double pconsumo, double tconsumo){
        this.mode = modo;
        this.consumoLigada = cLigada;
        this.consumoEco = cEco;
        this.periodoConsumo= pconsumo;
        this.totalConsumo = tconsumo;
    }

    public Lampada(Lampada l){
        this.mode= l.getMode();
        setConsumoEco(l.getConsumoEco());
        setConsumoLigada(l.getConsumoLigada());
        this.periodoConsumo = l.getPeriodoConsumo();
        this.totalConsumo = l.getTotalConsumo();
        //duas formas possiveis de fazer
    }

    public Mode getMode() {
        return this.mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public double getConsumoLigada() {
        return this.consumoLigada;
    }

    public void setConsumoLigada(double consumoLigada) {
        this.consumoLigada = consumoLigada;
    }

    public double getConsumoEco() {
        return this.consumoEco;
    }

    public void setConsumoEco(double consumoEco) {
        this.consumoEco = consumoEco;
    }

    public void calculaEco() {
        this.totalConsumo += (System.currentTimeMillis() - this.periodoConsumo) * this.consumoEco;
        this.periodoConsumo = System.currentTimeMillis();
    }

    public void calculaON() {
        this.totalConsumo += (System.currentTimeMillis() - this.periodoConsumo) * this.consumoEco;
    }

    public void lampON() {
        if(this.mode == Mode.ECO) {
            calculaEco();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.mode = Mode.ON;
    }

    public void  lampOFF() {
        if(this.mode == Mode.ECO) {
            calculaEco();
        }
        if(this.mode == Mode.ON) {
            calculaON();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.mode = Mode.OFF;
    }

    public void lampECO() {
        if(this.mode == Mode.ON) {
            calculaON();
        }
        this.periodoConsumo = System.currentTimeMillis();
        this.mode = Mode.ECO;
    }

    public double totalCOnsumo() {
        return periodoConsumo() + this.totalConsumo;
    }

    public double periodoConsumo() {
        double atual = 0;
        if(mode == Mode.ON) atual = (System.currentTimeMillis() - this.periodoConsumo) * this.consumoLigada;
        else if(mode == Mode.ECO) atual = (System.currentTimeMillis() - this.periodoConsumo) * this.consumoEco;
        return atual;
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        Lampada lamp = (Lampada) o;
        return (this.mode.equals(lamp.getMode()) && this.consumoEco==lamp.getConsumoEco() && this.consumoLigada== lamp.getConsumoLigada() );
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Modo: ").append(this.mode).append("\n")
                .append("Consumo Ligada: ").append(this.consumoLigada).append("\n")
                .append("Consumo Eco: ").append(this.consumoEco).append("\n");
        return sb.toString();
    }

    public Lampada clone(){
        return new Lampada(this);
    }
}
