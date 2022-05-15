import java.util.List;
import java.util.stream.Collectors;

public class Utilizador {
    private String id;//email
    private String nome;
    private List<Podcast> subscricoes;

    public Utilizador(String id, String nome, List<Podcast> l){
        this.id = id;
        this.nome = nome;
        setSubscricoes(l);
    }

    public List<Podcast> getSubscricoes(){
        return this.subscricoes.stream().map(Podcast::clone).collect(Collectors.toList());
    }

    public void setSubscricoes(List<Podcast> l){
       this.subscricoes = l.stream().map(Podcast::clone).collect(Collectors.toList());
    }

    public void playEpisodio(String idPodCast, String nomeEpisodio)
            throws AlreadyPlayingException{
         Episodio ep =this.subscricoes.stream()
                .map(Podcast::clone)
                .filter(e->e.getId().equals(idPodCast))
                .map(p->p.getEpisodios())
                .flatMap(List::stream)
                .filter(epi->epi.getNome().equals(nomeEpisodio))
                .findFirst().get().clone();
        if(ep.getisPlaying()) throw new AlreadyPlayingException("Episódio "+nomeEpisodio+" já se encontra a tocar.");
        else ep.play();
    }

}
