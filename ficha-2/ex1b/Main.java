import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner rd = new Scanner(System.in);
        Operacoes arrop = new Operacoes();

        System.out.println("Digite o nº de elementos do array: ");
        int num = rd.nextInt();
        int [] arr = new int [num];
        int i=0;
        System.out.println("Digite os elementos: ");
        while(num!=0){
            int numA = rd.nextInt();
            arr[i]=numA;
            num--;
            i++;
        }
        System.out.println("Limite inferior: ");
        int num1 = rd.nextInt();
        System.out.println("Limite superior: ");
        int num2 = rd.nextInt();
        arrop.print(arr,num1,num2);
    }
}

