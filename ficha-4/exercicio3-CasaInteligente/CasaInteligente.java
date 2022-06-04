import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    private List<Lampada> lampList;
    private int capacidade;

    public CasaInteligente(){
        this.lampList = new ArrayList<>();
        this.capacidade = 50;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public CasaInteligente(List<Lampada> list, int cap){
        this.lampList = new ArrayList<>();
        for(Lampada l : list){
            this.lampList.add(l.clone());
        }
        this.capacidade = cap;
    }

    public CasaInteligente(CasaInteligente smartHome){
        setLampList(smartHome.getLampList());
        this.capacidade = smartHome.getCapacidade();
    }


    public List<Lampada> getLampList(){
        return this.lampList.stream().map(Lampada::clone).collect(Collectors.toList());
    }

    public void setLampList(List<Lampada> listlamp){
        this.lampList = new ArrayList<>();
        Iterator<Lampada> it = listlamp.iterator();
        while(it.hasNext()){
            Lampada l = it.next();
            this.lampList.add(l.clone());
        }
    }

    public void ligaLampadaNormal(int index){
        this.lampList.get(index).setMode(Lampada.Mode.ON);
    }

    public void ligaLampadaEco(int index){
        this.lampList.get(index).setMode(Lampada.Mode.ECO);
    }

    public int qtEmEco(){
        return (int) this.lampList.stream().filter(a-> a.getMode().equals(Lampada.Mode.ECO)).count();
    }

    public double consumoTotal(){
        return this.lampList.stream().mapToDouble(Lampada::getTotalConsumo).sum();
    }

    public void ligaTodasEco(){
        Iterator<Lampada> it = this.lampList.iterator();
        while(it.hasNext()){
            Lampada l = it.next();
            if(!(l.getMode().equals(Lampada.Mode.ECO))) l.setMode(Lampada.Mode.ECO);
        }
    }

    public Lampada maisGastadora(){
        Comparator<Lampada> c = (c1,c2)-> (int)(c2.getTotalConsumo()-c1.getTotalConsumo());
        return this.lampList.stream().map(Lampada::clone).sorted(c).findFirst().get();
    }

    public Set<Lampada> podiumEconomia(){
        Comparator<Lampada> c = (c1,c2)-> (int)(c1.getTotalConsumo()-c2.getTotalConsumo());
        return this.lampList.stream().map(Lampada::clone).sorted(c).limit(3).collect(Collectors.toSet());
    }

    public boolean exist(Lampada l){
        Iterator<Lampada> it = this.lampList.iterator();
        boolean found =false;
        while(it.hasNext() && !found){
            Lampada lamp = it.next();
            if(lamp.equals(l)) found=true;
        }
        return found;
    }

    public void ligaTodasMax(){
        this.lampList.forEach(x->x.setMode(Lampada.Mode.ON));
    }

    public void addLampada(Lampada l){
        if(this.lampList.size()<this.capacidade && !this.lampList.contains(l))
            this.lampList.add(l.clone());
    }

    public void removeLampada(int index){
        this.lampList.remove(index);
    }
    public void reset(){
        this.lampList.forEach(x->x.setTotalConsumo(0.0));
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Lampada l : this.lampList) {
            sb.append(l).append(" \n");
        }
        sb.append("Capacidade: ").append(this.capacidade);
        return sb.toString();
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || this.getClass()!=o.getClass()) return false;
        CasaInteligente casaInteligente = (CasaInteligente) o;
        return ( this.lampList.equals(casaInteligente.getLampList()) && this.capacidade == casaInteligente.getCapacidade() );
    }

    public CasaInteligente clone(){
        return new CasaInteligente(this);
    }
}

