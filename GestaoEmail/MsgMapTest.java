import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MsgMapTest {
    public MsgMapTest()
    {}

    @org.junit.jupiter.api.BeforeEach
    public void setUp()
    {}

    @org.junit.jupiter.api.AfterEach
    public void tearDown()
    {}

    @Test
    public void test1(){

        MsgMap m = new MsgMap();

        /** Mensagens+Comunicacoes*/
        Mensagem m1 = new Mensagem("Agradecimento","Obrigado Deus Zaidu!","João","Zaidu","123");
        Mensagem m2 = new Mensagem("Casamento","Parabéns pelo casamento :)","João","Nana Komatsu","123");
        Mensagem m3 = new Mensagem("Agradecimento","Obrigado pelo apoio :))","Zaidu","João","222");
        Mensagem m4 = new Mensagem("Agradecimento","És o rei!","João","Zaidu","123");
        Mensagem m5 = new Mensagem("Casamento","Thanxx.","Nana Komatsu","João","333");

        m.addMsg(m1);
        m.addMsg(m2);
        m.addMsg(m3);
        m.addMsg(m4);
        m.addMsg(m5);

        System.out.println("Número de mensagens do remetente João: "+m.quantosDe("João"));
        System.out.println("Total de mensagens -> "+m.tamanho());
        System.out.println(m.msgDeRemetente());
    }
}