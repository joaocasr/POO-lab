import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SpotifyPOO {
    private Map<String,Podcast> catalogoPodcasts;
    private Map<String,Utilizador> catalogoUtilizadores;


    public List<Episodio> getEpisodios(String nomePodcast){
        return this.catalogoPodcasts.get(nomePodcast).getEpisodios();
    }

    public void remove(String nomeP) throws PodcastInexistenteException{
        if(!this.catalogoPodcasts.containsKey(nomeP))
            throw new PodcastInexistenteException("Podcast "+nomeP+" não existe.");
        else this.catalogoPodcasts.remove(nomeP);
    }

    public Map<Integer,List<Episodio>> episodiosPorClassf(){
       return this.catalogoPodcasts.values()
               .stream()
               .map((e)->e.getEpisodios())
               .flatMap(List::stream)
               .collect(Collectors.groupingBy(Episodio::getClassificacao));
    }

    public Episodio getEpisodioMaisLongo(String u){
        Comparator<Episodio> c = (c1,c2)-> {
            double d1 = c1.getDuracao();
            double d2 = c2.getDuracao();
            return (int) ((int) d2-d1);
        };
        List<Episodio> l =this.catalogoUtilizadores.get(u).getSubscricoes()
                .stream().map((e)->e.getEpisodios()).flatMap(List::stream).collect(Collectors.toList());
        return l.stream().map(Episodio::clone).sorted(c).findFirst().get().clone();
    }

    public void gravaInfoEpisodiosParaTocarMaisTarde(String fich)
            throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(fich);
        for(Utilizador u: this.catalogoUtilizadores.values()){
            if(u instanceof UtilizadorPremium) {
                pw.println("Nome Utilizador");
                for(Episodio ep : u.getSubscricoes().stream().map(Podcast::getEpisodios).flatMap(List::stream).collect(Collectors.toList())){
                    pw.println(ep.getNome()+"-"+ep.getDuracao());
                }

            }
        }
        pw.flush();
        pw.close();
    }


}
