import java.util.LinkedList;

public class LLCandidato {
    private LinkedList<Candidato> allCandidatos;

    public LLCandidato() {
        this.allCandidatos = new LinkedList<>();
    }

    public LinkedList<Candidato> getAllCandidatos() {
        return new LinkedList<>(allCandidatos);
    }

    public void setAllCandidatos(LinkedList<Candidato> allCandidatos) {
        this.allCandidatos = new LinkedList<>(allCandidatos);
    }

    public int size(){
        return this.allCandidatos.size();
    }

    public void add(Candidato c){
        this.allCandidatos.add(c.clone());
    }

    public Candidato get(int i) throws CandidatoException{
        if(this.allCandidatos.get(i)==null) throw new CandidatoException();
        return this.allCandidatos.get(i).clone();
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if(o==null || o.getClass()!=this.getClass()) return false;
        LLCandidato llc = (LLCandidato) o;
        return this.allCandidatos.equals(llc.getAllCandidatos());
    }
}
