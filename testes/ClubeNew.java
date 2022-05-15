import java.util.Map;
import java.util.stream.Collectors;

public class ClubeNew {
    private String nome;
    private Map<String,EquipaNew> equipas;
//...
    public ClubeNew(){
    }

    public ClubeNew clone(){
        return new ClubeNew();
    }

    public Map<String,EquipaNew> getEquipas(){
        return this.equipas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
}
