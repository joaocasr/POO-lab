import java.util.Comparator;

public class ComparaUltimavez implements Comparator<Faixa> {
    public int compare(Faixa f1,Faixa f2){
        int r=0;
        if(f1.getUltimaVez().isBefore(f2.getUltimaVez())) r=1;
        if(f1.getUltimaVez().isAfter(f2.getUltimaVez())) r=-1;
        return r;
    }
}
