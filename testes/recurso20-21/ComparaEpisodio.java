import java.util.Comparator;

public class ComparaEpisodio implements Comparator<Episodio> {
    public int compare(Episodio e1,Episodio e2){
        return (int) (e2.getDuracao()-e1.getDuracao());
    }
}
