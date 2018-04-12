import org.junit.Test;
import static org.junit.Assert.*;

public class MiCadenaTest {
    
    @Test
    public void testFabrica() {
        System.out.println("fabrica");
        MiCadena result = MiCadena.fabrica("no");
        assertEquals(null, result);
        result = MiCadena.fabrica("nosotros");
        assertEquals("nosotros", result.getCadena());
    }

    @Test
    public void testGetCadena() {
        System.out.println("getCadena");
        String s= "nosotros y ellos";
        assertEquals(s, MiCadena.fabrica(s).getCadena());
    }

    @Test
    public void testDetectaFaltaNB() {
        System.out.println("detectaFaltaNB");
        String s = "enbustero y ANBAR";
        assertEquals(1, MiCadena.detectaFaltaNB(s));
        s= "Nbrosía y ANBAR";
        assertEquals(0, MiCadena.detectaFaltaNB(s));
        s= "Nprosía y ANBAR";
        assertEquals(11, MiCadena.detectaFaltaNB(s));
    }

    @Test
    public void testCorrigeFaltaNB_String() {
        System.out.println("corrigeFaltaNB con arg");
        String s1 = "enbustero y ANBAR";
        String s2 = "embustero y AMBAR";
        assertEquals(s2, MiCadena.corrigeFaltaNB(s1));
        s1 = "Nbrosía y ANBAR";
        s2 = "Mbrosía y AMBAR";
        assertEquals(s2, MiCadena.corrigeFaltaNB(s1));
        s1 = "Nprosía y ANBAR";
        s2 = "Nprosía y AMBAR";
        assertEquals(s2, MiCadena.corrigeFaltaNB(s1));
    }

    @Test
    public void testCorrigeFaltaNB_0args() {
        System.out.println("corrigeFaltaNB sin arg");
        String s1 = "enbustero y ANBAR";
        String s2 = "embustero y AMBAR";
        MiCadena m= MiCadena.fabrica(s1);
        m.corrigeFaltaNB();
        assertEquals(s2, m.getCadena());
        s1 = "canpestre, ENBUSTERO y sin enbargo... fin";
        s2 = "canpestre, EMBUSTERO y sin embargo... fin";
        m= MiCadena.fabrica(s1);
        m.corrigeFaltaNB();
        assertEquals(s2, m.getCadena());
    }
    
    @Test
    public void testEstadistica() {
        System.out.println("estadística");
        String s1 = "cama";
        String s2 = "a-2;c-1;m-1;";
        MiCadena m= MiCadena.fabrica(s1);
        assertEquals(s2, m.estadistica());
        s1 = "cazón";
        s2 = "a-1;c-1;n-1;z-1;ó-1;";
        m= MiCadena.fabrica(s1);
        assertEquals(s2, m.estadistica());
        s1 = "soporífero CAMIÓN ¿dónde?";
        s2 = " -2;?-1;A-1;C-1;I-1;M-1;N-1;d-2;e-2;f-1;n-1;o-3;p-1;r-2;s-1;¿-1;Ó-1;í-1;ó-1;";
        m= MiCadena.fabrica(s1);
        assertEquals(s2, m.estadistica());
    }
    
}
