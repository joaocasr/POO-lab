/**
 * VeiculoOcasião
 *
 * @author (João Castro)
 * @version 15-05-2022
 */
import java.util.ArrayList;
import java.util.List;

public class VeiculoGeral {
    private String identificacao;
    private String marca;
    private String modelo;
    private int ano;
    private double velocidade;
    private double precoKm;
    private List<Integer> classificacoes;
    private double kmPercorridos;


    public VeiculoGeral(String id,String marca, String modelo,
                        int ano, double velociademedia, double precokm,
                        List<Integer> classificacao, int kmsUltimo){
        this.identificacao=id;
        this.marca=marca;
        this.modelo=modelo;
        this.ano=ano;
        this.velocidade=velociademedia;
        this.precoKm=precokm;
        this.kmPercorridos=kmsUltimo;
        setClassificacoes(classificacao);
    }

    public VeiculoGeral(VeiculoGeral vg){
        this.identificacao=vg.getIdentificacao();
        this.marca=vg.getMarca();
        this.modelo=vg.getModelo();
        this.ano=vg.getAno();
        this.velocidade=vg.getVelocidade();
        this.precoKm=vg.getPrecoKm();
        this.kmPercorridos=vg.getKmPercorridos();
        setClassificacoes(vg.getClassificacoes());
    }

    public List<Integer> getClassificacoes(){
        return new ArrayList<>(this.classificacoes);
    }

    public void setClassificacoes(List<Integer> l){
        this.classificacoes = new ArrayList<>(l);
    }


    public double custoReal(){
        return this.kmPercorridos * this.precoKm * 1.1;
    }

    public double getKmPercorridos() {
        return kmPercorridos;
    }

    public void setKmPercorridos(double kmPercorridos) {
        this.kmPercorridos = kmPercorridos;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getPrecoKm() {
        return precoKm;
    }

    public void addClasssificacao(int x){
        this.classificacoes.add(x);
    }

    public void setPrecoKm(double precoKm) {
        this.precoKm = precoKm;
    }

    public VeiculoGeral clone(){
        return new VeiculoGeral(this);
    }
}
