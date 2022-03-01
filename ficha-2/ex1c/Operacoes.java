import java.util.Arrays;

public class Operacoes {
    public int find(int [] v, int N){
        int min = v[0];
        int i;
        for(i=0;i<N;i++) {
            if(min>v[i]) min = v[i];
        }
        return min;
    }
    public void print(int [] v, int n1, int n2){
        int i;
        if(n1<0 || n2>=v.length){
            System.out.print("Indices inválidos!");
            return;
        }
        System.out.print("{");
        for(i=n1;i<=n2;i++) {
            if(i==n2){
                System.out.print(v[i]);
                break;
            }
            System.out.print(v[i] + ",");
        }
        System.out.print("}");
    }
    public int contaPositivos(int [] v, int N){
        int i=1;
        while(i<N && v[i]>0) i++;
        return i;
    }

    public void Compara(int [] v, int [] u, int Nv, int Nu){
       int i,j;
       int k=0;
       int [] aux = new int [Nv];
       Arrays.fill(aux,-1);
       for(i=0;i<Nv;i++){
        for(j=0;j<Nu;j++){
                int r=Arrays.binarySearch(aux,u[j]);
                if(v[i]==u[j] && r<0){
                    aux[k]=u[j];
                    k++;
                }
           }
       }
       int N= contaPositivos(aux,aux.length);
       print(aux,0,N-1);
    }
}

