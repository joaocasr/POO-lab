import java.util.List;

public abstract class Jogador {
    private String numero;
    private String nome;
    private List<Integer> golos; // lista com os golos em cada jogo
    //...
//...

    public Jogador(Jogador j){
        this.numero = j.getNumero();
    }

    public double mediaGolos(){
        return this.golos.stream().mapToInt(a -> a).average().orElse(0);
    }

    public abstract Jogador clone();

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
