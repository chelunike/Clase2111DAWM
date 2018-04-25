package guyform;

import java.util.ArrayList;

/**
 * @author yo
 */
public class GuyForm {

    public static void main(String[] args) {
        // Codijo aki
        
        ArrayList <PaisCapis> paises = new ArrayList();
        
        String[] pais = {"España","Francia","Portugal","Alemania","Noruega","Japon","USA","Patatalandia"};
        String[] capis =  {"Madrid","Paris","Porti4jis","Cataluya","Oslo","Tokio","Washinton DC","Patata DC"};
        
        for(int i=0; i<pais.length; i++){
            PaisCapis tmp = new PaisCapis(pais[i], capis[i]);
            paises.add(tmp);
        }
        
        new FormPaises(paises).setVisible(true);
        
        
        
        
    }
    
}
