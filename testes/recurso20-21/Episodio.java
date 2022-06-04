import java.time.LocalDateTime;
import java.util.List;

public class Episodio implements Playable {
    private String nome;
    private double duracao;
    private int classificacao; //dada pelos seus ouvintes (valor de 0..100)
    private List<String> conteudo; //corresponde ao texto que e’ dito
    //quando se reproduz o episodio
    private int numeroVezesTocada; //qts vezes e’ que o podcast foi ouvido
    private LocalDateTime ultimaVez; //regista quando foi reproduzido
//ultima vez
    private boolean isPlaying;

    public Episodio(Episodio e){
        this.nome=e.getNome();
        this.duracao = e.getDuracao();
        this.classificacao = e.getClassificacao();
        setConteudo(e.getConteudo());
        this.numeroVezesTocada = e.getNumeroVezesTocada();
        this.ultimaVez = e.getUltimaVez();
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing) {
        isPlaying = playing;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public int getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public List<String> getConteudo() {
        return conteudo;
    }

    public void setConteudo(List<String> conteudo) {
        this.conteudo = conteudo;
    }

    public int getNumeroVezesTocada() {
        return numeroVezesTocada;
    }

    public void setNumeroVezesTocada(int numeroVezesTocada) {
        this.numeroVezesTocada = numeroVezesTocada;
    }

    public LocalDateTime getUltimaVez() {
        return ultimaVez;
    }

    public void setUltimaVez(LocalDateTime ultimaVez) {
        this.ultimaVez = ultimaVez;
    }

    public void play(){
        this.setPlaying(true);
        System.media.play(this.conteudo);
    }

    public Episodio clone(){
        return new Episodio(this);
    }
}