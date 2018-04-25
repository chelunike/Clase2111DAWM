/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciafiguras;

/**
 *
 * @author prg
 */
public class Util {

    static void ordenar(IOrdenable lista[]) {
        for (int i = 0; i < lista.length; i++) {
            for (int j = lista.length - 1; j > i; j--) {
                if (lista[j].menor(lista[j - 1])) {
                    intercambiar(lista, j, j - 1);
                }
            }
        }
    }
    
    static void intercambiar(Object[] lista, int k, int l){
        Object aux;
        aux = lista[k];
        lista[k] = lista[l];
        lista[l] =  aux;
        
    }
//     static void intercambiar(IOrdenable[] lista, int k, int l){
//        Object aux;
//        aux = lista[k];
//        lista[k] = lista[l];
//        lista[l] = (IOrdenable) aux;
//        
//    }

}
