import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CHP {
    private Map<String, ClubeNew> clubes;
//...
public EquipaNew getEquipa(String idClube, String idEquipa)
        throws ClubeNaoExisteException, EquipaNaoExisteException{
    EquipaNew res = null;
    ClubeNew c = this.clubes.get(idClube);
    if (c!= null){
        Map<String,EquipaNew > equipas = c.getEquipas();
        if (equipas.containsKey(idEquipa)){
            res = equipas.get(idEquipa).clone() ;
        }
    }else{
        throw new ClubeNaoExisteException();
    }
    if (res == null){
        throw new EquipaNaoExisteException();
    }
    return res;
}
/*
    public List<Equipa> getEquipas(String idClube, String escalao) throws ClubeNaoExisteException {
        List<Equipa> res = new ArrayList<>();
        if (this.clubes.containsKey(idClube)){
            for(Equipa e: this.clubes.get(idClube).getEquipas().values()){
                if(e.getEscalao().equals(escalao)){
                    res.add(e.clone());
                }
            }
        }else{
            throw new ClubeNaoExisteException();
        }
        return res;
    }
*/

    public List<EquipaNew> getEquipas(String idClube, String escalao)
            throws ClubeNaoExisteException{
        List<EquipaNew> l = new ArrayList<>();
        if(clubes.get(idClube)==null) throw new ClubeNaoExisteException();
        else l=clubes.get(idClube).getEquipas().values()
                .stream().map(EquipaNew::clone)
                .filter((e)->e.getEscalao().equals(escalao))
                .collect(Collectors.toList());
    return l;
}

}
