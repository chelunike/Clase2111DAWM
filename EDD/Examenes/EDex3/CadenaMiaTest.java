import org.junit.Test;
import static org.junit.Assert.*;

public class CadenaMiaTest {
    
    @Test
    public void testFactoria() {
        System.out.println("factoria");
        CadenaMia result = CadenaMia.factoria("no");
        assertEquals(null, result);
        result = CadenaMia.factoria("nosotros");
        assertEquals("nosotros", result.cogerCadena());
    }

    @Test
    public void testCogerCadena() {
        System.out.println("cogerCadena");
        String s= "nosotros y ellos";
        assertEquals(s, CadenaMia.factoria(s).cogerCadena());
    }

    @Test
    public void testSituaFaltaNP() {
        System.out.println("situaFaltaNP");
        String s = "enprende y ANPA";
        assertEquals(1, CadenaMia.situaFaltaNP(s));
        s= "Nprosía y ANPA";
        assertEquals(0, CadenaMia.situaFaltaNP(s));
        s= "Nbrosía y ANPA";
        assertEquals(11, CadenaMia.situaFaltaNP(s));
    }

    @Test
    public void testarreglaFaltaNP_String() {
        System.out.println("arreglaFaltaNP con arg");
        String s1 = "enprende y ANPA";
        String s2 = "emprende y AMPA";
        assertEquals(s2, CadenaMia.arreglaFaltaNP(s1));
        s1 = "Nprosía y ANBAR";
        s2 = "Mprosía y ANBAR";
        assertEquals(s2, CadenaMia.arreglaFaltaNP(s1));
        s1 = "Nbrosía y ANPA";
        s2 = "Nbrosía y AMPA";
        assertEquals(s2, CadenaMia.arreglaFaltaNP(s1));
    }

    @Test
    public void testArreglaFaltaNP_0args() {
        System.out.println("arreglaFaltaNP sin arg");
        String s1 = "enpustero y ANPAR";
        String s2 = "empustero y AMPAR";
        CadenaMia m= CadenaMia.factoria(s1);
        m.arreglaFaltaNP();
        assertEquals(s2, m.cogerCadena());
        s1 = "canpestre, ENBUSTERO y sin enpezar... fin";
        s2 = "campestre, ENBUSTERO y sin empezar... fin";
        m= CadenaMia.factoria(s1);
        m.arreglaFaltaNP();
        assertEquals(s2, m.cogerCadena());
    }
    
    @Test
    public void testCuenta() {
        System.out.println("cuenta");
        String s1 = "cama";
        String s2 = "a-2;c-1;m-1;";
        CadenaMia m= CadenaMia.factoria(s1);
        assertEquals(s2, m.cuenta());
        s1 = "cazón";
        s2 = "a-1;c-1;n-1;z-1;ó-1;";
        m= CadenaMia.factoria(s1);
        assertEquals(s2, m.cuenta());
        s1 = "soporífero CAMIÓN ¿dónde?";
        s2 = " -2;?-1;A-1;C-1;I-1;M-1;N-1;d-2;e-2;f-1;n-1;o-3;p-1;r-2;s-1;¿-1;Ó-1;í-1;ó-1;";
        m= CadenaMia.factoria(s1);
        assertEquals(s2, m.cuenta());
    }
    
}
