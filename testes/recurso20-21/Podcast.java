import java.util.List;
import java.util.stream.Collectors;

public class Podcast {
    private String idPodcast;
    private List<Episodio> allEpisodios;

    public Podcast(Podcast p){
        this.idPodcast = p.getIdPodcast();
        setAllEpisodios(p.getAllEpisodios());
    }

    public List<Episodio> getAllEpisodios(){
        return this.allEpisodios.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public void setAllEpisodios(List<Episodio> l){
        this.allEpisodios = l.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public String getIdPodcast() {
        return idPodcast;
    }

    public void setIdPodcast(String idPodcast) {
        this.idPodcast = idPodcast;
    }

    public Podcast clone(){
        return new Podcast(this);
    }
}
