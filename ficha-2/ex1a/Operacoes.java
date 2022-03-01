public class Operacoes {
    public int find(int [] v, int N){
        int min = v[0];
        int i;
        for(i=0;i<N;i++) {
            if(min>v[i]) min = v[i];
        }
        return min;
    }
}

