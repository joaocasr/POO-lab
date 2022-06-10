import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PolyAsList implements Poly{
    private List<Double> polinomio;


    public PolyAsList(List<Double> l){
        setPolyasList(l);
    }

    public PolyAsList(PolyAsList pl){
        setPolyasList(pl.getPolyasList());
    }

    public List<Double> getPolyasList(){
       return new ArrayList<>(this.polinomio);
    }

    public void setPolyasList(List<Double> l){
        this.polinomio = new ArrayList<>(l);
    }

    public void addMonomio(double coef, int grau){
        int N = this.polinomio.size();
        if(grau+1<=N){
            this.polinomio.remove(grau);
            this.polinomio.add(grau,coef);
        }
        else{
            while(N<grau){
                this.polinomio.add(0.0);
                N++;
            }
            this.polinomio.add(grau,coef);
        }
    }

    public double calcula(double x){
        Iterator<Double> it = this.polinomio.iterator();
        double res=this.polinomio.get(0);
        it.next();
        int index=1;
        while(it.hasNext()){
            res+= (it.next())*Math.pow(x,index);
            index++;
        }
        return res;
    }

    public Poly derivada(){
        List<Double> l = new ArrayList<>();
        Poly p = new PolyAsList(l);
        Iterator<Double> it = this.polinomio.iterator();
        it.next();
        int index=1;
        while(it.hasNext()){
            p.addMonomio(it.next()*index,index-1 );
            index++;
        }
        return p;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.polinomio).append("\n");
        return sb.toString();
    }

}
