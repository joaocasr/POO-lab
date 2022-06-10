import java.util.*;

public class Comunicacao {
    private String remetente;
    private String numeroRemetente;
    private String destinatario;
    private Date data;

    public Comunicacao(Comunicacao c ){
        this.remetente = c.getRemetente();
        this.destinatario = c.getDestinatario();
        this.numeroRemetente = c.getNumeroRemetente();
        this.data = c.getData();
    }

    public Comunicacao(String s1,String s2,String s3 ){
        this.remetente = s1;
        this.destinatario = s2;
        this.numeroRemetente = s3;
        this.data = new GregorianCalendar().getTime();
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getNumeroRemetente() {
        return numeroRemetente;
    }

    public void setNumeroRemetente(String numeroRemetente) {
        this.numeroRemetente = numeroRemetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Remetente: ").append(this.remetente).append("\n")
                .append("Destinatario: ").append(this.destinatario).append("\n")
                .append("Date: ").append(this.data).append("\n");
        return sb.toString();
    }

    public Comunicacao clone(){
        return new Comunicacao(this);
    }

}