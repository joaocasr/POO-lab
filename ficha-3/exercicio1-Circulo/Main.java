public class Main {
    public static void main(String[] args) {

        Circulo circulo = new Circulo(1,1,10);
        Circulo c1 = new Circulo(1,2,5);
        Circulo c2 = new Circulo(2,3,5);

        System.out.println("Área do círculo c1 -> "+c1.calcularArea()+ "\nÁrea do círculo c2 -> "+c2.calcularArea());
        System.out.println("Perímetro do círculo c1 -> "+c1+"\nPerímetro do círculo c2 -> "+c2.calcularPerimetro());

        if(c2.equals(c1)) System.out.println("Os círculos c1 e c2 são iguais!");
        else System.out.println("Os círculos c1 e c2 são diferentes!");

        circulo.clone();
        System.out.println(circulo.toString());
        }
}

