import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpotifyPOO implements Serializable {
    private Map<String,Podcast> allPodcasts; //todos os podcasts do sistema
    private Map<String, Utilizador> allUsers;


    public List<Episodio> getEpisodios(String nomePodcast){
        return this.allPodcasts.get(nomePodcast).getAllEpisodios();
    }

    public void remove(String nomeP) throws PodcastInexistenteException,PodcastSubscritoException{
        if(!this.allPodcasts.containsKey(nomeP))
            throw new PodcastInexistenteException("Podcast "+nomeP+" não exite no sistema.");
        if(this.allUsers.values().stream().map(x->x.hasPodcast(nomeP)).anyMatch(x->x.equals(true)))
            throw new PodcastSubscritoException("Podcast "+nomeP+" possui subscritores.");
        this.allPodcasts.remove(nomeP);
    }

    public Episodio getEpisodioMaisLongo(String u){
        return this.allUsers.get(u).getAllPodcasts().stream()
                       .map(Podcast::getAllEpisodios)
                       .flatMap(List::stream)
                       .sorted(new ComparaEpisodio())
                       .findFirst()
                       .get();
    }

    public Map<Integer,List<Episodio>> episodiosPorClassf(){
        return this.allPodcasts.values().stream()
                       .map(x->x.getAllEpisodios())
                       .flatMap(List::stream)
                       .collect(Collectors.groupingBy(Episodio::getClassificacao));
    }

    public void gravaInfoEpisodiosParaTocarMaisTarde(String fich) throws IOException {
        PrintWriter pw = new PrintWriter(fich);
        for (String u : this.allUsers.keySet()) {
            if (this.allUsers.get(u) instanceof UtilizadorPremium) {
                pw.println(u);
                for (Episodio e : ((UtilizadorPremium) this.allUsers.get(u)).getWaitingList()) {
                    pw.println(e.getNome()+" - "+e.getDuracao());
                }
            }
        }
    }
}
