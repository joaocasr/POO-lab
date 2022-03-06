import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ord ordenar = new Ord();
        int x=10;
        int [] array = {19,10,2,23,11,2,7,1,53,5};
        ordenar.sort(array);
        System.out.println("O elemento "+x+" encontra-se no índice "+ordenar.bsearch(array,0,x));

    }
}
