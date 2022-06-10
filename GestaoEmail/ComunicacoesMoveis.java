import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class ComunicacoesMoveis {
    private HashMap<String, ArrayList<Comunicacao>> comms;

    public void adComunicacao(Comunicacao com) throws ComunicacaoExiste{
        if(this.comms.get(com.getNumeroRemetente()).contains(com))
            throw new ComunicacaoExiste("O cliente "+com.getNumeroRemetente()+" já posui a comunicaçao"+com.getClass().getName());
        this.comms.get(com.getNumeroRemetente()).add(com.clone());
    }

    public double factura(String numeroOriginador, Date inicio, Date fim){
        double totalFatura=0.0;
        for(Comunicacao c : this.comms.get(numeroOriginador)) {
            if (c.getData().after(inicio) && c.getData().before(fim)) {
                if (c instanceof SMS) {
                    totalFatura += ((SMS) c).taxaSMS();
                }
                if (c instanceof Telefonema) {
                    totalFatura += ((Telefonema) c).taxaTelefonema();
                }
                if (c instanceof Email) {
                    totalFatura += ((Email) c).taxaEmail();
                }
            }
        }
        return totalFatura;
    }
}