import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Faixa implements Playable{
    private String nome;
    private String autor;
    private double duracao;
    private int classificacao;
    private ArrayList<String> letra;
    private int numeroVezesTocada;
    private LocalDateTime ultimaVez;

    public Faixa(String nome,String autor, double duracao,int classificacao,List<String> letra,int numeroVezesTocada,LocalDateTime date){
        this.nome = nome;
        this.autor = autor;
        this.duracao = duracao;
        this.classificacao = classificacao;
        this.ultimaVez = date;
        this.numeroVezesTocada = numeroVezesTocada;
        setLetra(letra);
    }

    public Faixa(Faixa f){
        this.nome = f.getNome();
        this.autor = f.getAutor();
        this.duracao = f.getDuracao();
        this.classificacao = f.getClassificacao();
        this.nome = f.getNome();
        this.numeroVezesTocada = f.getNumeroVezesTocada();
        this.ultimaVez = f.getUltimaVez();
        setLetra(f.getLetra());
    }

    public List<String> getLetra(){
        return new ArrayList<>(this.letra);
    }

    public void setLetra(List<String> l){
        this.letra=  new ArrayList<>(l);
    }


    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void play(){
        //System.audio.play(this.letra);
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        Faixa f = (Faixa) o;
        return this.nome.equals(f.getNome()) && this.autor.equals(f.getAutor()) && this.duracao== f.getDuracao()
        && this.classificacao == f.getClassificacao() && this.letra.equals(f.getLetra());
    }

    public Faixa clone(){
        return new Faixa(this);
    }
}
