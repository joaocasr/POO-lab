import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

            Numeros numeros = new Numeros();

        int min=1;
        int max=50;
        int i=0;
        while(i< numeros.getCapNumsM() || numeros.getSizenumsM()!=numeros.getCapNumsM()) {
            int rand_Num = (int) (Math.random() * (max - min + 1) + min);
            numeros.insereMnum(rand_Num);
            i++;
        }
        int maximum=9;
        int minimum=1;
        i=0;
        while(i< numeros.getCapEstM() || numeros.getSizeestM()!=numeros.getCapEstM()) {
            int rand_est = (int) (Math.random() * (maximum - minimum + 1) + minimum);
            numeros.insereMest(rand_est);
            i++;
        }
        System.out.println("Números(1 a 50):");
        Scanner scan = new Scanner(System.in);
            i=0;
            while(i< numeros.getCapNumsH()){
                int num = scan.nextInt();
                numeros.insereHnum(num);
                i++;
            }
        i=0;
        System.out.println("Estrelas(1 a 9):");
        while(i< numeros.getCapEstM()){
            int num = scan.nextInt();
            numeros.insereHest(num);
            i++;
        }
        System.out.print("*----------Euromilhões----------*\n| Números                       |\n|   ");
        System.out.print(numeros.getnumeros()+"        |\n| Estrelas                      |\n|   ");
        System.out.print(numeros.getestrelas()+"                    |\n*-------------------------------*\n");
        numeros.comparaNums();
        numeros.comparaEsts();
    }
}
