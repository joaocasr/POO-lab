public class Ficha1 {
    public double celsiusParaFarenheit(double graus){
        double fahrenheit;
         fahrenheit= (graus*2)+31.8;
         return fahrenheit;
    }
    public int maximoNumeros(int a, int b){
        return Math.max(a, b);

    }
    public String criaDescricaoConta(String nome, double saldo){
         String string;
         string="Nome: "+nome+" Saldo: "+saldo;
         return string;
    }
    public double eurosParaLibras(double valor, double taxaConversao){
       double result;
       result = valor*taxaConversao;
       return result;
    }
    public String maiorNumero(int n1, int n2){
        double media;
        media = (n1*1.0+n2*1.0)/2;
        if(n1<n2) return n2+" "+n1+" Média: "+media; else return n1+" "+n2+" Média: "+media;
    }
    public long factorial(int num){
        long r=1;
        while(num!=0){
            r=r*num;
            num--;
        }
        return r;
    }

}
