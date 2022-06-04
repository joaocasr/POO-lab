import java.util.List;
import java.util.stream.Collectors;

public class UtilizadorPremium extends Utilizador{
    private List<Episodio> waitingList;

    public UtilizadorPremium(UtilizadorPremium u){
        super(u);
        setWaitingList(u.getWaitingList());
    }

    public List<Episodio> getWaitingList(){
        return this.waitingList.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public void setWaitingList(List<Episodio> l){
        this.waitingList=l.stream().map(Episodio::clone).collect(Collectors.toList());
    }

    public void playEpisodio(String idPodCast, String nomeEpisodio){
        Episodio e =getAllSubs().get(idPodCast)
                .getAllEpisodios()
                .stream()
                .map(Episodio::clone)
                .filter(x -> x.getNome().equals(nomeEpisodio))
                .findFirst()
                .get();
        if(getAllSubs().get(idPodCast).getAllEpisodios().stream().map(x->x.isPlaying()).anyMatch(x->x.equals(true)))
            this.waitingList.add(e.clone());
        else e.play();
    }
}
