import java.util.Comparator;

public class compareFaixas implements Comparator<Faixa> {
    public int compare(Faixa f1, Faixa f2) {
        int r=0;
        if(f1.getNumeroVezesTocada()-(f2.getNumeroVezesTocada())>0) r=1 ;
        if(f1.getNumeroVezesTocada()-(f2.getNumeroVezesTocada())<0) r=-1 ;
        return r;
    }
}
