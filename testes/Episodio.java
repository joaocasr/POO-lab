import java.time.LocalDateTime;
import java.util.List;

public class Episodio implements PlayableNew{
    private String nome;
    private double duracao;
    private int classificacao; //dada pelos seus ouvintes (valor de 0..100)
    private List<String> conteudo; //corresponde ao texto que e’ dito
    //quando se reproduz o episodio
    private int numeroVezesTocada; //qts vezes e’ que o podcast foi ouvido
    private LocalDateTime ultimaVez; //regista quando foi reproduzido
    private boolean isPlaying;
//ultima vez
//...
//        ...

    public String getNome(){
        return this.nome;
    }

    public boolean getisPlaying(){
        return this.isPlaying;
    }

    public double getDuracao(){
        return this.duracao;
    }

    public int getClassificacao(){
        return this.classificacao;
    }

    public void play(){
       // System.media.play(conteudo);
    }

    public Episodio(){}
    public Episodio clone(){return new Episodio();}
}