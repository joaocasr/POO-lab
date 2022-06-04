import java.time.LocalDateTime;
import java.util.Objects;

public class PedidodeSuporte {
    private String cliente;
    private LocalDateTime dataSubmissao;
    private String assunto;
    private String descricao;
    private String funcionario;
    private LocalDateTime dataConclusao;


    public PedidodeSuporte(PedidodeSuporte p){
        this.cliente =p.getCliente();
        this.dataSubmissao = p.getDataSubmissao();
        this.assunto = p.getAssunto();
        this.descricao = p.getDescricao();
        this.funcionario = null;
        this.dataConclusao = null;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDateTime getDataSubmissao() {
        return dataSubmissao;
    }

    public void setDataSubmissao(LocalDateTime dataSubmissao) {
        this.dataSubmissao = dataSubmissao;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidodeSuporte that = (PedidodeSuporte) o;
        return this.dataConclusao.equals(that.getDataConclusao())
                && this.funcionario.equals(that.getFuncionario())
                && this.descricao.equals(that.getDescricao())
                && this.assunto.equals(that.getAssunto())
                && this.dataSubmissao.equals(that.getDataSubmissao())
                && this.cliente.equals(that.getCliente());
    }

    public PedidodeSuporte clone(){
        return new PedidodeSuporte(this);
    }
}
