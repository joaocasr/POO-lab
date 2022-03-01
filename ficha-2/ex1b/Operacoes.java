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
        if(n1<0 || n2>v.length){
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
}
