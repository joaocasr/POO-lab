
public class Main {
    public static void main(String[] args) {

        Triangulo t1 = new Triangulo();
        Triangulo t2 = new Triangulo(3,4,5,1,6,8);
        Triangulo t3 = new Triangulo(14,23,21,34,22,29);
        Triangulo t4 = new Triangulo(45,57,48,56,51,59);

        System.out.println(t1.clone().calculaPerimetroTriangulo());
        System.out.println(t2.clone().calculaAreaTriangulo());
        System.out.print(t3.clone().toString());

        System.out.println("Os triângulos 3 e 4 são iguais? "+t4.clone().equals(t3.clone()));

    }
}

