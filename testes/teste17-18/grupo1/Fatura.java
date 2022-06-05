import java.time.LocalDate;

public class Fatura implements Comparable<Fatura>{
    private String numero;
    private LocalDate data;
    private double valor;
    private Actividade actividade;
    public double getValor;


    public Fatura(Fatura f){
        this.numero = f.getNumero();
        this.data = f.getData();
        this.valor = f.getValor();
        this.actividade = f.getActividade();
        this.getValor = f.getValor();
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Actividade getActividade() {
        return actividade;
    }

    public void setActividade(Actividade actividade) {
        this.actividade = actividade;
    }

    public double getGetValor() {
        return getValor;
    }

    public void setGetValor(double getValor) {
        this.getValor = getValor;
    }

    //compareTo
    public int compareTo(Fatura f){
        int r=0;
        if(this.data.isBefore(f.getData())) r=1;
        if(this.data.isAfter(f.getData())) r=-1;
        return r;
    }

    public Fatura clone(){
        return new Fatura(this);
    }
}
