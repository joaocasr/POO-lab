import java.util.ArrayList;
import java.util.List;

public class EpisodioVideo extends Episodio{
    private List<Byte> allBytes;

    public EpisodioVideo(EpisodioVideo ev){
        super(ev);
        setAllBytes(ev.getAllBytes());
    }

    public List<Byte> getAllBytes(){
        List<Byte> aux = new ArrayList<>();
        this.allBytes.forEach(x->aux.add(x));
        return aux;
    }

    public void setAllBytes(List<Byte> l){
        l.forEach(x->this.allBytes.add(x));
    }

    public void play(){
        System.media.play(this.allBytes);
        super.play();
    }
}
