import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Faixa implements Comparable<Faixa>,Playable {
    private String nome;
    private String autor;
    private double duracao;
    private int classificacao;
    private ArrayList<String > letra; //letra da m´usica
    private int numeroVezesTocada; //n´umero de vezes que foi tocada
    private LocalDateTime ultimaVez; //regista quando foi tocada pela ´ultima vez
//...

    public Faixa(Faixa f){
        this.nome = f.getNome();
        this.autor = f.getAutor();
        this.duracao = f.getDuracao();
        this.classificacao = f.getClassificacao();
        setLetra(f.getLetra());
        this.numeroVezesTocada = f.getNumeroVezesTocada();
        this.ultimaVez = f.getUltimaVez();
    }

    public List<String> getLetra(){
        return new ArrayList<>(this.letra);
    }

    public void setLetra(List<String> texto){
        this.letra= new ArrayList<>(texto);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setLetra(ArrayList<String> letra) {
        this.letra = letra;
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
        System.audio.play(this);
    }


    public int compareTo(Faixa f){
        return this.numeroVezesTocada-f.getNumeroVezesTocada();
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        Faixa f = (Faixa) o;
        return f.getAutor().equals(this.autor) && f.getClassificacao()==this.classificacao && f.getDuracao()==this.duracao
                && f.getNome().equals(this.nome) && f.getUltimaVez().equals(this.ultimaVez)
                && f.getLetra().equals(this.letra) && f.getNumeroVezesTocada()==this.numeroVezesTocada;
    }

    public Faixa clone(){
        return new Faixa(this);
    }
}