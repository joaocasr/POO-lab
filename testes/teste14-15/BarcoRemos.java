public class BarcoRemos extends Barco{
    private double largura;

    public BarcoRemos(BarcoRemos b){
        super(b);
        this.largura = b.getLargura();
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public BarcoRemos clone(){
        return new BarcoRemos(this);
    }
}
