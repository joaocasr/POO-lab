public class Apartamento extends Imovel{
    private String andar;
    private double factorQualidade;

    public double precoDia(){
        return this.factorQualidade * getPrecoBase();
    }
}
