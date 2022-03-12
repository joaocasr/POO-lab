public class Main {
    public static void main(String[] args) {

        Telemovel telemovel = new Telemovel();
        //System.out.println(telemovel.toString());
        telemovel.clone();
        System.out.println("O meu modelo: "+telemovel.getModelo());
        telemovel.recebeMsg("Khonsupx : @flashgordonbeam, podemos contar contigo para nos salvar?");
        telemovel.recebeMsg("flashgordonbeam: Sim! ");
        telemovel.printMsgs();
        System.out.println(telemovel.tamMedioApps()+"Gb");
        System.out.println("A maior mensagem do chat foi -> "+ telemovel.maiorMsg());
        telemovel.removeApp("Tinder",0.060);
        System.out.println(telemovel.printApss());
    }
}

