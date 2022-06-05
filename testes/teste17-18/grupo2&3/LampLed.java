public class LampLed extends Lampada{
    private double percentagem;

    public LampLed(LampLed lamp){
        super(lamp);
        this.percentagem = lamp.getPercentagem();

    }

    public double getPercentagem() {
        return percentagem;
    }

    public void setPercentagem(double percentagem) {
        this.percentagem = percentagem;
    }
}
