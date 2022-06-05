import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class CasaInteligente {
    private Map<String,Lampada> allLamps;

    public CasaInteligente(CasaInteligente ci){
        setAllLamps(ci.getAllLamps());
    }

    public CasaInteligente(Collection<Lampada> novasLampadas){
        setCAllLamps(novasLampadas);
    }

    public Map<String,Lampada> getAllLamps(){
        return this.allLamps.entrySet()
                .stream()
                .collect(Collectors.toMap(e->e.getKey(),e->e.getValue().clone()));
    }

    public void setCAllLamps(Collection<Lampada> novasLampadas) {
        this.allLamps = new HashMap<>();
        novasLampadas.forEach(x->this.allLamps.put(x.getIdent(),x.clone()));
    }


    public void setAllLamps(Map<String,Lampada> m) {
        this.allLamps = new HashMap<>();
        m.forEach((k,v)->this.allLamps.put(k,v.clone()));
    }

    public int qtEmEco(){
       return (int) this.allLamps.values().stream()
               .map(Lampada::getEstado)
               .filter(x->x==2)
               .count();
    }

    public void removeLampada(String id) throws LampadaInexistenteException{
        if(!this.allLamps.containsKey(id)) throw new LampadaInexistenteException("lampada "+id+" nao existe");
        else this.allLamps.remove(id);
    }

    public double consumoTotal(){
        return this.allLamps.values()
                .stream()
                .mapToDouble(Lampada::getConsumoTotal)
                .sum();
    }

    public Set<String> topConsumo(int x){
        Comparator<Lampada> c =(c1,c2)->(int) (c2.getConsumoTotal()-c1.getConsumoTotal());
        return this.allLamps.values()
                                    .stream()
                                    .sorted(c)
                                        .limit(x)
                                        .map(Lampada::getIdent)
                                        .collect(Collectors.toSet());
    }

    public void gravaEstado(String fich) throws IOException{
        FileOutputStream fos = new FileOutputStream(fich);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        for(Lampada l : this.allLamps.values()){
            if(l instanceof LampLed){
                oos.writeObject(l);
            }
        }
        oos.flush();
        oos.close();
    }
}
