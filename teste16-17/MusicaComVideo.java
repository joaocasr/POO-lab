import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MusicaComVideo extends Faixa implements Playable{
    private List<String> videoContent;


    public MusicaComVideo(List<String> l, String nome, String autor, double duracao, int classificacao, List<String> letra, int numeroVezesTocada, LocalDateTime date){
        super(nome,autor,duracao,classificacao,letra,numeroVezesTocada,date);
        this.videoContent= new ArrayList<>(l);
    }

    public MusicaComVideo(MusicaComVideo mv){
        super(mv.getNome(),mv.getAutor(), mv.getDuracao(), mv.getClassificacao(), mv.getLetra(),mv.getNumeroVezesTocada(),mv.getUltimaVez());
        setVideoContent(mv.getVideoContent());
    }

    public void setVideoContent(List<String> l){
        this.videoContent = new ArrayList<>(l);
    }

    public List<String> getVideoContent(){
        return new ArrayList<>(this.videoContent);
    }

    public void play(){
        super.play();
        //System.audio.play(this.videoContent);
    }

}
