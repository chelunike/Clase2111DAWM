package ejecutasql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author yo
 */
public class EjecutaSql {

    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Hola :) ");
        //MyPatataSql sql = new MyPatataSql("192.168.211.199", "pepe", "pepa");
        MyPatataSql sql = new MyPatataSql();
        Puerta p = new Puerta("Visualizar Base de Datos", sql);
    }
}
