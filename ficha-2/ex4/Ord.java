public class Ord {
    public void sort(int [] arr){
        int i,j;
        for(i=0;i<arr.length;i++){
            for(j=0;j<arr.length-1;j++){
                if(arr[j]>=arr[j+1]) swap(arr,j,j+1);
            }
        }
        for(i=0;i<arr.length;i++){
             System.out.print(arr[i]+" ");
            }
        System.out.print("\n");
        }
       public void swap(int [] v , int i,int j){
            int temp;
            temp =v[i];
            v[i]=v[j];
            v[j] = temp;
        }
      public int bsearch(int [] v,int inicial,int x){
         while(inicial<v.length-1){
             int m = v.length / 2;
             if(x>v[m]){
                 inicial = m+1;
             }
             else if(x<v[m]){
                 inicial = m-1;
             }
             else{
                 inicial =m;
                 break;
             }
         }
         return inicial;
      }
}

