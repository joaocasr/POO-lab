import java.util.List;
import java.util.stream.Collectors;

public abstract class Poligono {
    private List<Ponto> vertices;

    public Poligono(List<Ponto> pontos) {
        setPontos(pontos);
    }

    public void setPontos(List<Ponto> l) {
        this.vertices = l.stream().map(Ponto::clone).collect(Collectors.toList());
    }

    public void addPonto(Ponto p){
        this.vertices.add(this.vertices.size()-1,p.clone());
        this.vertices.add(this.vertices.get(0).clone());
    }

    public boolean efechada(){
        return (this.vertices.get(0).equals(this.vertices.get(this.vertices.size()-1)));
    }

    public double perimetro(){
        double total=0;
        int i;
        for(i=0;i<this.vertices.size();i++){
            total += this.vertices.get(i).distancia(this.vertices.get(i+1));
        }
        return total;
    }

    public abstract double area();
}
