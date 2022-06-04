import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utilizador {
    private String idEmail;
    private String nome;
    private Map<String,Podcast> allSubs; //todos os podcasts subscritos pelo utilizador

    public Utilizador(Utilizador u){
        this.idEmail = u.getIdEmail();
        this.nome = u.getNome();
        setAllSubs(u.getAllSubs());
    }

    public boolean hasPodcast(String podcast){
        boolean has=false;
        if(this.allSubs.containsKey(podcast)) has=true;
        return has;
    }

    public List<Podcast> getAllPodcasts(){
        return this.allSubs.values().stream().map(Podcast::clone).collect(Collectors.toList());
    }

    public void playEpisodio(String idPodCast, String nomeEpisodio)
            throws AlreadyPlayingException{
        if(this.allSubs.get(idPodCast).getAllEpisodios().stream().map(x->x.isPlaying()).anyMatch(x->x.equals(true)))
            throw new AlreadyPlayingException("Um episódio já se encontra em reprodução.");
        else {
             this.allSubs.get(idPodCast)
                    .getAllEpisodios()
                    .stream()
                    .map(Episodio::clone)
                    .filter(x -> x.getNome().equals(nomeEpisodio))
                    .findFirst()
                    .get().play();
        }
    }

    public String getIdEmail() {
        return idEmail;
    }

    public void setIdEmail(String idEmail) {
        this.idEmail = idEmail;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Map<String, Podcast> getAllSubs() {
        return allSubs;
    }

    public void setAllSubs(Map<String, Podcast> allSubs) {
        this.allSubs = allSubs;
    }
}
