import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

/**
 * Classe Veículo, para utilização na Ficha 6.
 *
 * @author MaterialPOO
 * @version 20210420
 */

public abstract class Veiculo implements Comparable<Veiculo>, Serializable {
    private String marca;
    private String modelo;
    private String matricula;
    private int ano;
    private double velociademedia;
    private double precokm;
    private ArrayList<Integer> classificacao;
    private int kms;
    private int kmsUltimo; // kms da última viagem??

    /**
     * Construtores
     */


    public Veiculo() {
        this.marca = "";
        this.modelo = "";
        this.matricula = "";
        this.ano = 0;
        this.velociademedia = 0;
        this.precokm = 0;
        this.classificacao = new ArrayList<>();
        this.kms = 0;
        this.kmsUltimo = 0;
    }

    public Veiculo(String marca, String modelo, String matricula,
                   int ano, double velociademedia, double precokm,
                   List<Integer> classificacao,
                   int kms, int kmsUltimo) {
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;
        this.ano = ano;
        this.velociademedia = velociademedia;
        this.precokm = precokm;
        this.classificacao = new ArrayList<>(classificacao);
        this.kms = kms;
        this.kmsUltimo = kmsUltimo;
    }



    public Veiculo(Veiculo v){
        this.marca = v.getMarca();
        this.modelo = v.getModelo();
        this.matricula = v.getMatricula();
        this.ano = v.getAno();
        this.velociademedia = v.getVelociademedia();
        this.precokm = v.getPrecokm();
        this.classificacao = v.getClassificacao();
        this.kms = v.getKms();
        this.kmsUltimo = v.getKmsUltimo();

    }

    public String getMarca() {
        return marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getVelociademedia() {
        return velociademedia;
    }

    public double getPrecokm() {
        return precokm;
    }

    public ArrayList<Integer> getClassificacao() {
        return new ArrayList<>(classificacao);
    }

    public int getKms() {
        return kms;
    }

    public int getKmsUltimo() {
        return kmsUltimo;
    }

    public void setVelociademedia(double velociademedia) {
        this.velociademedia = velociademedia;
    }

    public void setPrecokm(double precokm) {
        this.precokm = precokm;
    }

    public void addViagem(int nkms){
        this.kms += nkms;
        this.kmsUltimo = nkms;
    }

    public abstract double custoRealKM();

    public int classificacao(){
        return (int) this.classificacao.stream().mapToInt(k->k.intValue()).average().getAsDouble();
    }

    public void addClassificacao(int v){
        this.classificacao.add(v);
    }

    public abstract Veiculo clone();


    public boolean equals(Object o){
        if (o == this) return true;
        if (o == null || ! o.getClass().equals(this.getClass())) return false;
        Veiculo v = (Veiculo) o;
        return  this.marca.equals(v.getMarca()) &&
                this.modelo.equals(v.getModelo())&&
                this.matricula.equals(v.getMatricula()) &&
                this.ano == v.getAno() &&
                this.velociademedia == v.getVelociademedia() &&
                this.precokm == v.getPrecokm() &&
                this.classificacao.equals(v.getClassificacao()) &&
                this.kms == v.getKms() &&
                this.kmsUltimo == v.getKmsUltimo() ;
    }


    public String toString() {
        return this.getClass().getSimpleName() + " Marca: " + this.marca +
                " Modelo: " + this.modelo +
                " Matricula " + this.matricula +
                " Ano: " + this.ano +
                " Velocidade média: " + this.velociademedia +
                " Preço/km: " + this.precokm +
                " Classificação: " + this.classificacao.toString() +
                " Kms: " + this.kms +
                " Última Viagem: " + this.kmsUltimo;

    }

    public String toString1() {
        return this.getClass().getSimpleName() + " Marca: " + this.marca +
                " Modelo: " + this.modelo +
                " Matricula " + this.matricula +
                " Ano: " + this.ano +
                " Velocidade média: " + this.velociademedia +
                " Preço/km: " + this.precokm +
                " Classificação: " + this.classificacao.toString() +
                " Kms: " + this.kms +
                " Última Viagem: " + this.kmsUltimo;

    }

    public int compareTo(Veiculo v) {
        if(this.marca.compareTo(v.getMarca()) == 0)
            return (this.modelo.compareTo(v.getModelo()));
        else
            return (this.marca.compareTo(v.getMarca()));
    }





}