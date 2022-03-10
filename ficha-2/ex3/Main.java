import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Localdate localdate = new Localdate(5);

        LocalDate currentDate = LocalDate.now();
        localdate.insereLocaldate(currentDate);

        //Alinea a)
        int j;
        for (j = 0; j < localdate.getSize()-1; j++) {
            System.out.println(localdate.getLocaldate(j));
        }
        //Alinea b)
        LocalDate data = LocalDate.of(2014,1,23);
        System.out.println("A data mais próxima de "+data+" no array date_array é: "+localdate.dataMaisProxima(data));

        //Alinea c)
        System.out.print(localdate.tostring());
    }
}

