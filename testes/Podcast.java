import java.util.List;
import java.util.stream.Collectors;

public class Podcast {
    private String id; //id do Podcast
    private List<Episodio> episodios;

    public Podcast(){
    }

    public String getId(){
        return this.id;
    }


    public List<Episodio> getEpisodios(){
        return this.episodios.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public Podcast clone(){
        return new Podcast();
    }
}
