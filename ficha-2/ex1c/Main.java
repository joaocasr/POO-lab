import java.util.Scanner;

public class Main {
    public static void main(String [] args){
        Scanner rd = new Scanner(System.in);
        Operacoes arrop = new Operacoes();

        System.out.println("Digite o nº de elementos do array A: ");
        int num1 = rd.nextInt();
        int i=0;
        int [] arrA = new int [num1];
        System.out.println("Digite os elementos: ");
        while(num1!=0){
            int numA = rd.nextInt();
            arrA[i]=numA;
            num1--;
            i++;
        }
        System.out.println("Digite o nº de elementos do array B: ");
        int num2 = rd.nextInt();
        int [] arrB = new int [num2];
        i=0;
        System.out.println("Digite os elementos: ");
        while(num2!=0){
            int numA = rd.nextInt();
            arrB[i]=numA;
            num2--;
            i++;
        }
        arrop.Compara(arrA,arrB,arrA.length,arrB.length);
    }
}

