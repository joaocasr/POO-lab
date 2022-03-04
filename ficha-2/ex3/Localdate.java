import java.time.LocalDate;

public class Localdate {

    private LocalDate data1 = LocalDate.of(2014, 3, 22);
    private LocalDate data2 = LocalDate.of(2015, 5, 2);
    private LocalDate data3 = LocalDate.of(2013, 12, 12);

    private LocalDate [] date_array;
    private int size;


    public Localdate(int capacidade) {
        this.date_array = new LocalDate[capacidade];
        this.date_array[0]=data1;
        this.date_array[1]=data2;
        this.date_array[2]=data3;
        this.size = 3;
    }

    public void insereLocaldate(LocalDate date) {
        this.date_array[this.size++] = date;
        this.size++;
    }

    public LocalDate getLocaldate(int x) {
        return date_array[x];
    }

    public int getSize() {
        return size;
    }

    public LocalDate dataMaisProxima(LocalDate data){
        long min=Math.abs(data.toEpochDay()-(getLocaldate(0)).toEpochDay());
        int minData=0;
        int i;
        for(i=0;i<getSize()-1;i++){
            if(min>Math.abs(data.toEpochDay()-(getLocaldate(i)).toEpochDay())){
                min=Math.abs(data.toEpochDay()-(getLocaldate(i)).toEpochDay());
                minData=i;
            }
        }
        return getLocaldate(minData);
    }


}
