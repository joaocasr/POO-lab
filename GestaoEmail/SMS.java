public class SMS extends Mensagem {
    private static int MAX_SIZE = 160;
    private long numberId;
    private int totalParts;
    // um SMS com mais caracteres que MAX_SIZE ́e partido
    // em v ́arios de at ́e esse tamanho e custa o valor dos v ́arios
    // SMS de tamanho normalprivate int number;

    public SMS(SMS sms){
        super(sms);
        this.numberId = sms.getNumberId();
        this.totalParts = sms.getTotalParts();

    }

    public long getNumberId() {
        return numberId;
    }

    public void setNumberId(long numberId) {
        this.numberId = numberId;
    }

    public int getTotalParts() {
        return totalParts;
    }

    public void setTotalParts(int totalParts) {
        this.totalParts = totalParts;
    }

    public double taxaSMS(){
       return this.totalParts*0.07;
    }
}
