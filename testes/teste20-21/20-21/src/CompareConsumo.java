import java.util.Comparator;

public class CompareConsumo implements Comparator<SmartDevice> {
    public int compare(SmartDevice sd1,SmartDevice sd2){
        return (int) (sd1.getConsumoPorHora()-sd2.getConsumoPorHora());

    }
}
