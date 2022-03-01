import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner rd = new Scanner(System.in);
        Operacoes arrop = new Operacoes();

        System.out.println("Digite o nº de elementos: ");
        int num = rd.nextInt();
        int [] arr = new int [num];
        int i=0;
        while(num!=0){
            System.out.println("Digite o "+(i+1)+"º elemento: ");
            int numA = rd.nextInt();
            arr[i]=numA;
            num--;
            i++;
        }
        int r = arrop.find(arr,arr.length);
        System.out.println("O menor elemento é "+ r);
    }
}
