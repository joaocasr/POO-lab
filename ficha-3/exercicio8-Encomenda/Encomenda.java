import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Encomenda {

    private String nome;
    private int nfiscal;
    private String morada;
    private int nencomenda;
    private LocalDate data_encomenda;
    private List<LinhaEncomenda> listaEncomenda;

    public Encomenda() {
        this.nome = "João Castro";
        this.nfiscal = 999999999;
        this.morada = "Rua de Hogsmead, nº87";
        this.nencomenda = 3;
        this.data_encomenda = LocalDate.of(2020, 5, 31);
        this.listaEncomenda = new ArrayList<>();
    }

    public Encomenda(String name, int fisco, String residencia, int numero, LocalDate dia, ArrayList<LinhaEncomenda> encomendas) {
        this.nome = name;
        this.nfiscal = fisco;
        this.morada = residencia;
        this.nencomenda = numero;
        this.data_encomenda = dia;
        this.setListaEncomenda(encomendas);
    }

    public Encomenda(Encomenda l) {
        this.nome = l.getNome();
        this.nfiscal = l.getNfiscal();
        this.morada = l.getMorada();
        this.nencomenda = l.getNencomenda();
        this.data_encomenda = l.getData_encomenda();
        setListaEncomenda(l.getListaEncomendas());
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNfiscal() {
        return nfiscal;
    }

    public void setNfiscal(int nfiscal) {
        this.nfiscal = nfiscal;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public int getNencomenda() {
        return nencomenda;
    }

    public void setNencomenda(int nencomenda) {
        this.nencomenda = nencomenda;
    }

    public LocalDate getData_encomenda() {
        return data_encomenda;
    }

    public void setData_encomenda(LocalDate data_encomenda) {
        this.data_encomenda = data_encomenda;
    }

    public ArrayList<LinhaEncomenda> getListaEncomendas(){
        ArrayList<LinhaEncomenda> aux = new ArrayList<>();
        for(LinhaEncomenda i: this.listaEncomenda){
            aux.add(i.clone());
        }
        return aux;
    }

    public void setListaEncomenda(ArrayList<LinhaEncomenda> aux){
        this.listaEncomenda = new ArrayList<>();//como se fosse para esvaziar o arraylist
        for(LinhaEncomenda i: aux){
            this.listaEncomenda.add(i.clone());//vamos adicionando os novos objetos que estavam no aux na listaEncomenda
        }
    }

    @Override
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || (this.getClass()!=o.getClass())) return false;
        Encomenda aux = (Encomenda) o;

        if(this.listaEncomenda.size()!=aux.getListaEncomendas().size()) return false;

        for(int i=0;i<this.listaEncomenda.size();i++) {
            if (!(this.listaEncomenda.get(i).equals(aux.getListaEncomendas().get(i))))
                return false;
        }

        return(this.nome.equals(aux.getNome())) &&
                (this.nfiscal== aux.getNfiscal()) &&
                (this.morada.equals(aux.getMorada())) &&
                (this.nencomenda==aux.getNencomenda()) &&
                (this.data_encomenda.equals(aux.getData_encomenda()));
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome).append("\n")
                .append("NIF: ").append(this.nfiscal).append("\n")
                .append("Morada: ").append(this.morada).append("\n")
                .append("Nº encomenda: ").append(this.nencomenda).append("\n")
                .append("Data: ").append(this.data_encomenda).append("\n");
        for (LinhaEncomenda linhaEncomenda : this.listaEncomenda) {
            sb.append(linhaEncomenda).append("\n");
        }
        return sb.toString();
    }

    public Encomenda clone(){
        return new Encomenda(this);
    }


}

