public class Telefonema extends Comunicacao{
    private int duracao;

    public Telefonema(Telefonema t){
        super(t);
        this.duracao = t.getDuracao();

    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public double taxaTelefonema(){
        return this.duracao*0.05;
    }
}
