


// Idea
/*
try {
    System.out.println("hola"+e.getMessage());
    Desktop.getDesktop().browse(new URI("https://stackoverflow.com/search?q="+e.getMessage()));
    System.out.println("hola2");
} catch (IOException | URISyntaxException ee) {
    System.out.println("chungo");
}
*/

/*
 ------ Metodo Final -----------
*/

/**
 * Sistema automatico de resolucion de 
 *  errores infalible :)
 * @param message Mensaje del error
 */
public static void PotatoExceptionHandler(String message){
    try {
        Desktop.getDesktop().browse(new URI("https://stackoverflow.com/search?q="+message));
    } catch (IOException | URISyntaxException e) {
        System.err.println("Error al lanzar la ayuda: \n"+e.getMessage()+"\nPara el error: \n"+message);
    }
}


//Ejemplo

try{
    String hola;
    System.out.println(""+hola);
}catch(Exception e){
    String msg="";
    msg = e.getMessage().replace("-", "+");
    msg = msg.replace(" ", "+");
    ConClase.PotatoExceptionHandler(msg);
}