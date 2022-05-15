import java.time.LocalDateTime;

public class SmartDevice {
    private String id;
    private boolean on;
    private double consumoPorHora;
    private LocalDateTime inicio;

    public SmartDevice( String id, double consumoPorHora) {
        this.id = id;
        this.on = false;
        this.consumoPorHora = consumoPorHora;
    }

    public SmartDevice( SmartDevice sd) {
        this.id = id;
        this.on = false;
        this.consumoPorHora = consumoPorHora;
    }

    public String getID(){
        return this.id;
    }

    public void setID(String id){
        this.id=id;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getConsumoPorHora() {
        return consumoPorHora;
    }

    public void setConsumoPorHora(double consumoPorHora) {
        this.consumoPorHora = consumoPorHora;
    }

    public LocalDateTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalDateTime inicio) {
        this.inicio = inicio;
    }

    // devolve o consumo desde o inicio
     public double totalConsumo() {
        return this.consumoPorHora*(LocalDateTime.now().getHour()-this.inicio.getHour());
    }

    //liga o device. Se for a primeira vez inicializa o tempo de inicio
    public void turnOn() {
        this.on = true;
        if (this.inicio == null)
            this.inicio = LocalDateTime.now();
    }

    public SmartDevice clone(){
        return new SmartDevice(this);
    }
}
