import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

public class UtilizadorPremium extends Utilizador{
    private List<Episodio> filaEspera;

    public UtilizadorPremium(String id, String nome,
                             List<Podcast> p,List<Episodio> e){
        super(id,nome,p);
        setFilaEspera(e);
    }


    public List<Episodio> getFilaEspera(){
        return this.filaEspera.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public void setFilaEspera(List<Episodio> l){
        this.filaEspera = l.stream().map(Episodio::clone).collect(Collectors.toList());
    }

        public void playEpisodio(String idPodCast, String nomeEpisodio){
            Episodio ep =getSubscricoes().stream()
                    .map(Podcast::clone)
                    .filter(e->e.getId().equals(idPodCast))
                    .map(p->p.getEpisodios())
                    .flatMap(List::stream)
                    .filter(epi->epi.getNome().equals(nomeEpisodio))
                    .findFirst().get().clone();
            if(ep.getisPlaying()) this.filaEspera.add(ep.clone());
            else ep.play();
        }

}

