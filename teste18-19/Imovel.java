import java.io.Serializable;

public abstract class Imovel implements Serializable {
    private String codImovel;
    private String morada;
    private String nifProprietario;
    private double area;
    private double precoBase;
    public abstract double precoDia();


    public Imovel(){
        this.codImovel="imovel1";
        this.morada = "rua de trancozelo";
        this.nifProprietario= "883478733";
        this.area = 32.1;
        this.precoBase = 234.2;
    }


    public String getCodImovel() {
        return codImovel;
    }

    public void setCodImovel(String codImovel) {
        this.codImovel = codImovel;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getNifProprietario() {
        return nifProprietario;
    }

    public void setNifProprietario(String nifProprietario) {
        this.nifProprietario = nifProprietario;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(double precoBase) {
        this.precoBase = precoBase;
    }
}
