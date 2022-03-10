public class Matrix {
    void print(int[][] v) {
        int i, j, l;
        for (l = 0; l < v.length; l++) {
            for (i = 0, j = 0; j < v[i].length; j++) {
                System.out.print(v[l][j] + " ");
            }
            System.out.print("\n");
        }
    }

    void add(int[][] v, int[][] u) {
        int i, j, l;
        int[][] result = new int[v.length][v[0].length];
        for (l = 0; l < v.length; l++) {
            for (i = 0, j = 0; j < v[i].length; j++) {
                result[l][j] = u[l][j] + v[l][j];
            }
        }
        print(result);
    }

    int igual(int[][] v, int[][] u) {
        int l, r;
        int flag=1;
        for (l = 0; l < v.length; l++) {
            for (r = 0; r < v.length; r++) {
                if(v[l][r]!=u[l][r]){
                    flag =0;
                    break;
                }
            }
        }
        return flag;
    }

    void oposta(int[][] v) {
        int l, r;
        for (l = 0; l < v.length; l++) {
            for (r = 0; r < v.length; r++) {
                    v[l][r] = (-1)* v[l][r];
                }
            }
        print(v);
        }

}
