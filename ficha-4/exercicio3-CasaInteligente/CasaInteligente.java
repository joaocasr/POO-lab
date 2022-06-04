import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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

    public boolean exist(Lampada l){
        Iterator<Lampada> it = this.lampList.iterator();
        boolean found =false;
        while(it.hasNext() && !found){
            Lampada lamp = it.next();
            if(lamp.equals(l)) found=true;
        }
        return found;
    }

    public void addLampada(Lampada l){
        if(this.lampList.size()<this.capacidade && !this.lampList.contains(l))
            this.lampList.add(l.clone());
    }

    public void removeLampada(int index){
        this.lampList.remove(index);
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
