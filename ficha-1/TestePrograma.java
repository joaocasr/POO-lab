import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class TestePrograma {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        Ficha1 ficha = new Ficha1();//cria objeto ficha da Classe Ficha1

        //PERGUNTA 6
        if(args.length==1){
           int fac = Integer.parseInt(args[0]);
           long a = ficha.factorial(fac);
           System.out.println(a);
            return;
        }
        System.out.println("Digite o exercício:");
        int ex = ler.nextInt();
        ler.nextLine();
        switch(ex) {

            //PERGUNTA 1
        case 1:     double num1, num2;
                    System.out.print("Digite o valor em Celsius:");
                    num1 = ler.nextDouble();
                    num2 = ficha.celsiusParaFarenheit(num1);//acede ao metodo celsiusParaFarenheit com resultado
                    System.out.println(num1 + "ºC corresponde a " + num2 + "ºF");
                    break;
            //Pergunta 2
        case 2:    int num3, num4, num5;
                    System.out.println("Digite primeiro número:");
                    num3 = ler.nextInt();
                    System.out.println("Digite o segundo número:");
                    num4 = ler.nextInt();
                    num5 = ficha.maximoNumeros(num3, num4);
                    System.out.println("O maior número é " + num5);
                    break;

            //Pergunta 3
        case 3:
                    String nome;
                    double num6;
                    System.out.println("Digite nome:");
                    nome = ler.nextLine();
                    System.out.println("Digite o saldo:");
                    num6 = ler.nextDouble();
                    System.out.println(ficha.criaDescricaoConta(nome, num6));
                    break;
        case 4:
                    double valor,taxaConversao,r;
                    System.out.println("Digite o valor em Eur:");
                    valor = ler.nextDouble();
                    System.out.println("Digite a taxa de conversao %:");
                    taxaConversao = ler.nextDouble();
                    r=ficha.eurosParaLibras(valor,taxaConversao);
                    System.out.println("Libras -> "+r);
                    break;
        case 5:
                    int n1,n2;
                    String maior;
                    System.out.println("Digite o primeiro valor:");
                    n1 = ler.nextInt();
                    System.out.println("Digite o segundo valor:");
                    n2 = ler.nextInt();
                    maior=ficha.maiorNumero(n1,n2);
                    System.out.println(maior);
                    break;
        case 7:
                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    System.out.println(formatter.format(calendar.getTime()));
                    long start = System.currentTimeMillis();
                    ficha.factorial(5000);
                    long end = System.currentTimeMillis();
                    System.out.println("Execution time: "+(end-start)+" milisecs");
                    System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE));
                    break;
        default:
        		System.out.println("Exercício inexistente!");
        }
        ler.close();

    }


}
