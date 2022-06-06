import java.util.ArrayList;
import java.util.List;

public class MusicaComVideo extends Faixa{
    private List<String> conteudo;

    public MusicaComVideo(MusicaComVideo m){
        super(m);
        setConteudo(m.getConteudo());
    }

    public List<String> getConteudo() {
        return new ArrayList<>(this.conteudo);
    }

    public void setConteudo(List<String> l) {
        this.conteudo = new ArrayList<>(l);
    }

    public void play(){
        super.play();
        System.image.play(this);
    }
}
