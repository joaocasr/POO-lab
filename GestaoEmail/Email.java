public class Email extends Mensagem{
    private String format;

    public Email(Email e){
        super(e);
        this.format=e.getFormat();
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public double taxaEmail(){
        return getTexto().length()*0.01;
    }
}
