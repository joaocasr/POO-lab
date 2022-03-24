import java.util.ArrayList;
import java.util.List;

public class ColecaoTriangulos {
    private List<Triangulo> triangulos;
    
    public ColecaoTriangulos(){
        this.triangulos = new ArrayList<>();
        
    }
    
    public void ColecaoTriangulos(List<Triangulo> ntriangulos){
        this.triangulos = new ArrayList<>();
        for(Triangulo t: ntriangulos){
            this.triangulos.add(t.clone());
        }
    }
    public void ColecaoTriangulos(ColecaoTriangulos ct){
        this.triangulos = new ArrayList<>();
        for(Triangulo t: ct.getTriangulos()){
            this.triangulos.add(t.clone());
        }
    }
    
    public void SetTriangulos(List<Triangulo> lt){
        this.triangulos = new ArrayList<>();
        for(Triangulo t : lt){
            this.triangulos.add(t.clone());
        }
    }

    public List<Triangulo> getTriangulos(){
        List<Triangulo> lt = new ArrayList<>();
        for(Triangulo t : this.triangulos){
            lt.add(t.clone());
        }
        return lt;
    }
    
    
}
