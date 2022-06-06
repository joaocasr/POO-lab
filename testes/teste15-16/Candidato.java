public class Candidato implements Comparable<Candidato>{
    private String nome;
    private int idade;

    public Candidato(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int compareTo(Candidato c){
        return this.nome.compareTo(c.getNome());
    }

    public Candidato clone(){return new Candidato();}
}
