import java.time.LocalDateTime;
import java.util.function.Consumer;

public class SmartBulbDimmable extends SmartDevice{
    private double intensidade;

    private static final Consumer<SmartBulbDimmable> c = x -> x.setIntensidade(x.getIntensidade()*0.25);

    public SmartBulbDimmable(SmartBulbDimmable sb){
        super(sb.getId(),sb.getConsumoPorHora());
        this.intensidade = sb.getIntensidade();
    }

    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    public void alteraInfo(Consumer<SmartBulbDimmable> c){
        c.accept(this);
    }

    public void diminuiIntensidade(){
        this.alteraInfo(c);
    }

    public void turnOn() {
        if (getInicio() == null) {
            setInicio(LocalDateTime.now());
            setIntensidade(this.intensidade*0.5);
            setConsumoPorHora(getConsumoPorHora()*0.5);
        }
    }

}
