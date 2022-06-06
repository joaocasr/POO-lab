import java.io.Serializable;

public abstract class Hotel implements Comparable <Hotel>, Serializable {
    /** O c´odigo do hotel */
    private String codigo;
    /** O nome do hotel */
    private String nome;
    /**Localidade do hotel */
    private String localidade;
    /**Pre¸co base por quarto */
    private double precoBaseQuarto;
    /**Numero de quartos */
    private int numeroQuartos;
    /**Estrelas **/
    private int estrelas;

    public Hotel(Hotel h){
        this.codigo = h.getCodigo();
        this.nome = h.getNome();
        this.localidade = h.getLocalidade();
        this.precoBaseQuarto = h.getPrecoBaseQuarto();
        this.numeroQuartos = h.getNumeroQuartos();
        this.estrelas = h.getEstrelas();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public double getPrecoBaseQuarto() {
        return precoBaseQuarto;
    }

    public void setPrecoBaseQuarto(double precoBaseQuarto) {
        this.precoBaseQuarto = precoBaseQuarto;
    }

    public int getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(int numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public int getEstrelas() {
        return estrelas;
    }

    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }
}