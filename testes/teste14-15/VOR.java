import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VOR implements Serializable {
    private Map<String,Equipa> allEquipas;

    public VOR(VOR v){
        setAllEquipas(v.getAllEquipas());
    }

    public Barco getBarco(String idEquipa, String idBarco) throws
            InvalidBoatException{
        if(!this.allEquipas.get(idEquipa).getAllBarcos().containsKey(idBarco))
            throw new InvalidBoatException("Barco "+idBarco+" não existe.");
        return this.allEquipas.get(idEquipa).getAllBarcos().get(idBarco).clone();
    }

    public List<Barco> getBarcos(String idEquipa, double milhas){
        return this.allEquipas.get(idEquipa).getAllBarcos().values()
                .stream().map(x->x.clone()).filter(x->x.getMilhas()>milhas)
                .collect(Collectors.toList());
    }

    public void removeBarco(String idEquipa,
                String idBarco) throws InvalidBoatException{
        if(!this.allEquipas.get(idEquipa).getAllBarcos().containsKey(idBarco))
            throw new InvalidBoatException("Barco "+idBarco+" não existe.");
        this.allEquipas.get(idEquipa).getAllBarcos().remove(idBarco);
    }

    void gravaFicheiroTextoSeguraveis(String fich) throws IOException {
        PrintWriter pw = new PrintWriter(fich);
        for(Equipa e : this.allEquipas.values()){
            for(Barco b : e.getAllBarcos().values()){
                if(b instanceof BarcoCatamaran || b instanceof BarcoHibrido){
                    pw.println(b);
                }
            }
        }
        pw.flush();
        pw.close();
    }

    public Map<String,Equipa> getAllEquipas(){
        return this.allEquipas.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,e->e.getValue().clone()));
    }

    public void setAllEquipas(Map<String,Equipa> m){
        this.allEquipas = m.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,e->e.getValue().clone()));
    }

    public VOR clone(){
        return new VOR(this);
    }
}
