/**
 * VeiculoOcasião
 *
 * @author (João Castro)
 * @version 15-05-2022
 */
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class DriveIT implements Serializable {
    private Map<String,VeiculoGeral> allVeiculos;

    public DriveIT(Map<String,VeiculoGeral> allVeiculos){
        setAllVeiculos(allVeiculos);
    }

    public DriveIT(DriveIT dit){
        setAllVeiculos(dit.getAllVeiculos());
    }

    public boolean existeVeiculo(String cod){
        boolean exists= false;
        if(allVeiculos.containsKey(cod)) exists=true;
        return exists;
    }

    public int quantos(){
       return (int) this.allVeiculos.values().stream().map(VeiculoGeral::clone).count();
    }

    public int quantos(String marca){
        return (int) this.allVeiculos.values().stream().filter((e)->e.getMarca().equals(marca)).count();
    }

    public VeiculoGeral getVeiculo(String cod){
        return this.allVeiculos.get(cod).clone();
    }

    public void adiciona(VeiculoGeral v){
        this.allVeiculos.put(v.getIdentificacao(),v.clone());
    }

    public int quantosT(String tipo){
        int quantos=0;
        if(tipo.equals("VeiculoOcasiao"))
            quantos = (int) this.allVeiculos.values().stream().map(VeiculoGeral::clone).filter(e-> e instanceof VeiculoOcasiao).count();
        //...
        return quantos;
    }

    public List<VeiculoGeral> veiculosOrdenadosCusto(){
      Comparator<VeiculoGeral> c =  (c1,c2)-> (c1.custoReal()!=c2.custoReal()) ? (int) ((int) c2.custoReal() - c1.custoReal()) :c1.getIdentificacao().compareTo(c2.getIdentificacao());
      return getVeiculos().stream().sorted(c).collect(Collectors.toList());
    }

    public VeiculoGeral veiculoMaisBarato(){
        Comparator<VeiculoGeral> c = (c1,c2)-> (c1.custoReal()!=c2.custoReal()) ? (int) (c1.custoReal() - c2.custoReal()) : c1.getIdentificacao().compareTo(c2.getIdentificacao());
        return this.allVeiculos.values().stream().map(VeiculoGeral::clone).sorted(c).findFirst().get().clone();
    }


    public VeiculoGeral veiculoMenosUtilizado(){
        Comparator<VeiculoGeral> c = (c1,c2)-> (c1.getKmPercorridos()!=c2.getKmPercorridos()) ? (int) (c1.getKmPercorridos() - c2.getKmPercorridos()) : c1.getIdentificacao().compareTo(c2.getIdentificacao());
        return this.allVeiculos.values().stream().map(VeiculoGeral::clone).sorted(c).findFirst().get().clone();
    }

    public Iterator<VeiculoGeral> ordenarVeiculo(){
        Comparator<VeiculoGeral> c = (c1,c2)-> (c1.getKmPercorridos()!=c2.getKmPercorridos()) ? (int) (c1.getKmPercorridos() - c2.getKmPercorridos()) : c1.getIdentificacao().compareTo(c2.getIdentificacao());
        return this.allVeiculos.values().stream().map(VeiculoGeral::clone).sorted(c).collect(Collectors.toList()).iterator();
    }

    public List<VeiculoGeral> getVeiculos(){
        return this.allVeiculos.values().stream().map(VeiculoGeral::clone).collect(Collectors.toList());
    }

    public void adicionaConjunto(Set<VeiculoGeral> vs){
        vs.forEach(v->this.allVeiculos.put(v.getIdentificacao(),v.clone()));
    }

    public void registarAluguer(String codVeiculo, int numKms){
       double kmsPassados =  this.allVeiculos.get(codVeiculo).getKmPercorridos();
       double total = kmsPassados+numKms;
       this.allVeiculos.get(codVeiculo).setKmPercorridos(total);
    }

    public void classificarVeiculo(String cod, int classificacao){
        this.allVeiculos.get(cod).addClasssificacao(classificacao);
    }

    public Map<String,VeiculoGeral> getAllVeiculos(){
        return this.allVeiculos.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    public List<BonificaKms> daoPontos(){
       return this.allVeiculos.values().stream()
                .filter((e)->e instanceof BonificaKms).map((e)->(BonificaKms) e).collect(Collectors.toList());
    }

    public void escreveFicheiroCSV(String filename) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(filename);
        pw.println(this);
        pw.flush();
        pw.close();
    }

    public void guardaEstado(String filename) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.flush();
        oos.close();
    }

    public static VeiculoGeral carregarEstado(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        VeiculoGeral vg = (VeiculoGeral) ois.readObject();
        return vg.clone();
    }



    public void setAllVeiculos(Map<String,VeiculoGeral> aux){
        this.allVeiculos = new HashMap<>();
        aux.forEach((String,VeiculoGeral)->this.allVeiculos.put(String,VeiculoGeral.clone()));
    }

    public DriveIT clone(){
        return new DriveIT(this);
    }
}
