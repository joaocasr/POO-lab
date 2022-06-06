import java.util.*;
public abstract class ParqueComRecusados extends Parque implements IParque {
    private Map<String, Set<String>> recusas;

    public ParqueComRecusados(ParqueComRecusados p){
        this.recusas = p.getRecusas();
    }

    public void entra(String cartao , String matricula ) throws SemPermissaoException{
        try{
            super.entra(cartao,matricula);
        }catch (SemPermissaoException e){
            if(recusas.containsKey(matricula)){
                this.recusas.get(matricula).add(cartao);
            }else{
                Set<String> aux = new TreeSet<>();
                aux.add(cartao);
                this.recusas.put(matricula,aux);
            }
            throw new SemPermissaoException(matricula);
        }
    }

    public HashMap<String,Set<String>> getRecusas(){
        return new HashMap<>(this.recusas);
    }

    public boolean equals(Object o){
        if(o==this) return true;
        if((o==null)||(this.getClass()!=o.getClass())){
            return false;
        }
        ParqueComRecusados p = (ParqueComRecusados) o;
        return super.equals(p) && this.recusas.equals(p.getRecusas());
    }

}
