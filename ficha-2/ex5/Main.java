import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite o tamanho do array:");
            int a =scan.nextInt();
            Nomes nomes = new Nomes(a);

            scan.nextLine();
            int i=0;
            while(i< nomes.getCapacity()){
                String name = scan.nextLine();
                nomes.insereNome(name);
                i++;
            }
            //Alinea A)
            nomes.print();
            //Alinea B)
            System.out.println(nomes.getmaiorString());
            //Alinea C)
            String [] aux={};
            int j;
            int k=0;
            for(j=0;j< nomes.getSize();j++){
                if(nomes.getFrequencia(nomes.getNome(j))>1){
                    k++;
                }
            }
                System.out.print(k);
    }
}
