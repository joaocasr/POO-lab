import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Operacoes matrixOp = new Operacoes();

        int[][] arr = new int[5][5];

        int i;
        int j = 0;
        for (i = 0; i < arr.length; i++) {
            System.out.println("Digite as notas do " + (i+1) + "ºaluno:");
            while (j < arr[i].length) {
                arr[i][j] = scanner.nextInt();;
                j++;
            }
            j=0;
        }
        /*-------------------EX2-------------------*/
        /*-------------------A)-------------------*/
        matrixOp.print(arr, 0, arr.length);

        /*-------------------C)-------------------*/
        System.out.println("Escolha um aluno :");
        double r = matrixOp.alunoMedia(arr,scanner.nextInt(),arr.length);
        System.out.println("Média : "+r);

        /*-------------------D)-------------------*/
        System.out.println("Escolha uma UC :");
        double n = matrixOp.mediaUc(arr,scanner.nextInt(),arr.length);
        System.out.println("Média : "+n);

        /*-------------------E)-------------------*/
        int max = matrixOp.maxValue(arr,arr.length,arr.length);
        System.out.println("Nota mais alta a todas as UC's : "+max);

        /*-------------------F)-------------------*/
        int min = matrixOp.minValue(arr,arr.length,arr.length);
        System.out.println("Nota mais baixa a todas as UC's : "+min);

        /*-------------------G)-------------------*/
        System.out.println("Nota minima possível : ");
        int minV = matrixOp.maxValues(arr,scanner.nextInt());

        /*-------------------H)-------------------*/
        String string = matrixOp.print2(arr,0,arr.length);
        System.out.println(string);

        /*-------------------I)-------------------*/
        int maxUC= matrixOp.maxMedia(arr,0,arr.length);
        System.out.println("UC COM MAIOR MÉDIA ----> "+maxUC);
    }
}

