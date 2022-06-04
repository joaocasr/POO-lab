public class LinhaEncomenda {

    private String codigo;
    private String descricao;
    private double precoantes;
    private int quantidade;
    private double desconto;

    private static final double imposto = 0.23;

    public LinhaEncomenda() {
        this.codigo = "A0364";
        this.descricao = "Latas de Ananás com prazo de validade expirado";
        this.desconto = 0.05;
        this.precoantes = 2.99;
        this.quantidade = 31;
    }

    public LinhaEncomenda(String codex, String description, double desconto, double preco, int quantos) {
        this.codigo = codex;
        this.descricao = description;
        this.desconto = desconto;
        this.precoantes = preco;
        this.quantidade = quantos;
    }

    public LinhaEncomenda(LinhaEncomenda l) {
        this.codigo = l.getCodigo();
        this.descricao = l.getDescricao();
        this.desconto = l.getDesconto();
        this.precoantes = l.getPrecoantes();
        this.quantidade = l.quantidade;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoantes() {
        return this.precoantes;
    }

    public void setPrecoantes(double precoantes) {
        this.precoantes = precoantes;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getDesconto() {
        return this.desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double calculaValorLinhaEnc(){
        double preco = (this.precoantes- (this.precoantes*this.desconto))*this.quantidade;
        return preco + (preco*imposto);
    }

    public double calculaValorDesconto(){
        double preco = (this.precoantes- (this.precoantes*imposto))*this.quantidade;
        return calculaValorLinhaEnc()-preco;
    }

    @Override
    public boolean equals(Object o) {
        if(o==this) return true;
        if(o==null || (this.getClass()!=o.getClass())) return false;
        LinhaEncomenda aux = (LinhaEncomenda) o;
        return(this.codigo.equals(aux.getCodigo())) &&
                (this.quantidade== aux.getQuantidade()) &&
                (this.precoantes==aux.getPrecoantes()) &&
                (this.descricao.equals(aux.getDescricao())) &&
                (this.desconto==aux.getDesconto());
    }

    @Override
    public LinhaEncomenda clone(){
        return new LinhaEncomenda(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Código: ").append(this.codigo).append( "\n")
                .append("Descrição: ").append(this.descricao).append( "\n")
                .append("Preço anterior: ").append(this.precoantes).append( "\n")
                .append("Quantidade: ").append(this.quantidade).append( "\n")
                .append( "Desconto: ").append(this.desconto).append( "\n");
        return sb.toString();
    }
}




