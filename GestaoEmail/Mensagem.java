public class Mensagem extends Comunicacao{
    private String assunto;
    private String texto;

    public Mensagem(String s1,String s2,String remetente,String destinatario,String remetenteNumero){
        super(remetente,destinatario,remetenteNumero);
        this.assunto =s1;
        this.texto = s2;
    }

    public Mensagem(Mensagem m ){
        super(m);
        this.texto = m.getTexto();
        this.assunto = m.getAssunto();
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append("Assunto: ").append(this.assunto).append("\n")
                .append("Texto: ").append(this.texto).append("\n");
        return sb.toString();
    }

    public Mensagem clone(){return new Mensagem(this);}
}
