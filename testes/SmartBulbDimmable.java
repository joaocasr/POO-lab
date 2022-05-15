public class SmartBulbDimmable extends SmartDevice{
    private double intensidade;

    public SmartBulbDimmable( String id, double consumoPorHora,double i){
        super(id,consumoPorHora);
        this.intensidade = i;
    }

    public SmartBulbDimmable(SmartBulbDimmable sbd){
        super(sbd);
        this.intensidade = sbd.getIntensidade();
    }


    public double getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(double intensidade) {
        this.intensidade = intensidade;
    }

    public void turnOn() {
        setOn(true);
        if (this.getInicio() == null) {
            this.intensidade = 0.5;
            setConsumoPorHora(getConsumoPorHora()*0.5);
        }
    }

}
