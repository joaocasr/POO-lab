import java.util.Set;

public class EquipaNew {
    private String id;
    private String escalao;
    private Pessoa capitao;
    private Set<Pessoa> atletas;
//...
    public EquipaNew(){
    }

    public String getEscalao(){
        return this.escalao;
    }


    public EquipaNew clone(){
        return new EquipaNew();
    }
}
