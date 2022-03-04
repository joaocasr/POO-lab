import java.util.Arrays;

public class Operacoes {
    public void print(int [][] v, int n1, int n2){
        int i,j;
        for(i=n1;i<n2;i++) {
            System.out.print("Aluno "+(i+1)+" : ");
            for(j=n1;j<n2;j++){
            System.out.print(v[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
    public String print2(int [][] v, int n1, int n2) {
        int i, j;
        String string = new String();
        for (i = n1; i < n2; i++) {
            string = string+"Aluno "+(i+1)+": ";
            for (j = n1; j < n2; j++) {
                string = string+v[i][j]+" ";
            }
        }
        return string;
    }
    
    public double alunoMedia(int [][] arr, int i,int N){
        int j;
        int soma=0;
        for(j=0;j<N;j++) {
            soma += arr[i-1][j];
        }
        double media = soma*1.0 / N;
        return media;
    }
    public double mediaUc(int [][] arr, int j,int N){
        int soma=0;
        for(int i=0;i<N;i++) {
            soma += arr[i][j-1];
        }
        double media = soma*1.0 / N;
        return media;
    }
    public int maxValue(int [][] arr, int N1,int N2){
        int i,j;
        int max=-1;
        for(i=0;i<N1;i++) {
            for(j=0;j<N2;j++){
                if(arr[i][j]>max) max= arr[i][j];
            }
        }
       return max;
    }
    public int minValue(int [][] arr, int N1,int N2){
        int i,j;
        int min=arr[0][0];
        for(i=0;i<N1;i++) {
            for(j=0;j<N2;j++){
                if(arr[i][j]<min) min= arr[i][j];
            }
        }
        return min;
    }
    public int maxValues(int [][] arr, int x){
        int i,j;
        int min=arr[0][0];
        for(i=0;i< arr.length;i++) {
            System.out.print("Aluno "+(i+1)+" :");
            for(j=0;j<arr[i].length;j++){
                if(arr[i][j]<x) System.out.print("X ");
                else System.out.print(arr[i][j]+" ");
            }
            System.out.print("\n");
        }
        return min;
    }

    public double mediaIUc(int [][] arr, int j,int N){
        int soma=0;
        for(int i=0;i<N;i++) {
            soma += arr[i][j];
        }
        double media = soma*1.0 / N;
        return media;
    }
    public int maxMedia(int [][] arr, int i,int N) {
        double maxMedia=0.0;
        int ucID=0;
        int k;
        for(k=0;k<N;k++){
            double media = mediaIUc(arr,k,N);
            if(maxMedia<media) {
                maxMedia = media;
                ucID=k+1;
            }
        }
        return ucID;
    }

}
