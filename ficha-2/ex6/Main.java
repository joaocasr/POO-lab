import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Matrix matrix = new Matrix();

        int ncolumns,nrows;

        System.out.print("Nº of rows: ");
        nrows= scan.nextInt();
        System.out.print("Nº of columns: ");
        ncolumns= scan.nextInt();

        int i,j;
        int [][] matrizA = new int[nrows][ncolumns];
        int [][] matrizB = new int[nrows][ncolumns];
        for(i=0;i<nrows;i++){
            for(j=0;j<ncolumns;j++){
                matrizA[i][j]= scan.nextInt();
            }
        }
        matrix.print(matrizA);
        for(i=0;i<nrows;i++){
            for(j=0;j<ncolumns;j++){
                matrizB[i][j]= scan.nextInt();
            }
        }
        matrix.add(matrizA,matrizB);
        if(matrix.igual(matrizA,matrizB)==1) System.out.print("Matrizes iguais\n");
        else System.out.print("Matrizes diferentes\n");
        matrix.oposta(matrizB);
    }
}

