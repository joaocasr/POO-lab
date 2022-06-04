import java.time.LocalDateTime;

public class SmartDevice implements Comparable<SmartDevice>{
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
        this.id = sd.getId();
        this.on = sd.isOn();
        this.consumoPorHora = sd.getConsumoPorHora();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        return 0;
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

    public int compareTo(SmartDevice s1){
        return (int) (this.consumoPorHora-s1.getConsumoPorHora());
    }
}