/**
 * VeiculoOcasião
 *
 * @author (João Castro)
 * @version 15-05-2022
 */

import java.util.List;

public class VeiculoOcasiao extends VeiculoGeral{
    private boolean emPromocao;

    public VeiculoOcasiao(String id,String marca, String modelo,
                          int ano, double velociademedia, double precokm,
                          List<Integer> classificacao, int kmsUltimo, boolean emPromocao) {

        super(id,marca, modelo, ano, velociademedia, precokm, classificacao, kmsUltimo);
        this.emPromocao = emPromocao;
    }

    public VeiculoOcasiao(VeiculoOcasiao vo){
        super(vo);
        this.emPromocao = vo.getPromocao();
    }

    public boolean getPromocao() {
        return this.emPromocao;
    }

    public double custoRealKM(){
        double valor = getPrecoKm()*getKmPercorridos();
        return this.emPromocao ? 0.75 * valor : valor;
    }

    public void setPromocao(boolean promocao) {
        this.emPromocao = promocao;
    }

    public VeiculoOcasiao clone() {
        return new VeiculoOcasiao(this);
    }

    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        VeiculoOcasiao v = (VeiculoOcasiao) o;
        return super.equals(v) && this.emPromocao == v.getPromocao();
    }

    public String toString() {
        return super.toString() + " Em Promoção: "+ this.emPromocao;
    }
}
