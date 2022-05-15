import java.util.Comparator;

public class CompareConsumo implements Comparator<SmartDevice> {
    public int compare(SmartDevice sd1,SmartDevice sd2){
        int r=0;
        if(sd1.getConsumoPorHora()- sd2.getConsumoPorHora()<0) r=-1;
        else if(sd1.getConsumoPorHora()- sd2.getConsumoPorHora()>0) r=1;
        return r;
    }
}
