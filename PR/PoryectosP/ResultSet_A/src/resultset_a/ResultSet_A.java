package resultset_a;

import java.sql.*;

/**
 * @author profe
 */
public class ResultSet_A {

    // DDBC driver name and database URL
    static final String DDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/empleados";//nombre de la bd
    
    // Database credentials niño la pazzwork
    static final String USER = "pepe";
    static final String PASS = "pepa";

    public static void main(String[] args) {
        Connection conn = null;
        try {
    //STEP 2: Register DDBC driver: que driver vamos a usar
            Class.forName("com.mysql.jdbc.Driver");
    
    //STEP 3: Open a connection: Nos conectamos
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS); //pasamos url, user, pass
    
    //STEP 4: Execute a query to create statment with
            // required arguments for RS example.
            System.out.println("Creating statement...");//Creamos la sentencia
            /*
                Al crear una sentencia le decimos el scroll, como nos movemos
                despues le indicamos como actualizamos
            */
            Statement stmt = conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    
    //STEP 5: Execute a query
            String sql = "SELECT id, age, first, last FROM empleados";
            ResultSet rs = stmt.executeQuery(sql);//Guarda el resultado de la consulta.
            System.out.println("List result set for reference....");
            printRs(rs);//sacamos el resultset
            
    //STEP 6: Loop through result set and add 5 in age //Move to BFR postion so while-loop works properly
            rs.beforeFirst();//nos situamos
            
    //STEP 7: Extract data from result set
            while (rs.next()) {//avanza el puntero al siguiente si puede true sino false
                //Retrieve by column name
                int newAge = rs.getInt("age") - 20;
                rs.updateInt("age", newAge);
                rs.updateRow();
            }
            System.out.println("List result set showing new ages...");
            printRs(rs);
            
// Insert a record into the table.
//Move to insert row and add column data with updateXXX()
            System.out.println("Inserting a new record...");
            rs.moveToInsertRow();
            rs.updateInt("id", 703);
            rs.updateString("first", "Antonio");
            rs.updateString("last", "Paul");
            rs.updateInt("age", 40);
////Commit row
            rs.insertRow();
            System.out.println("List result set showing new set...");
            printRs(rs);
// Delete second record from the table.
// Set position to second record first
            rs.absolute(2);
            System.out.println("List the record before deleting..."); //Retrieve by column name 
            int id = rs.getInt("id");
            int age = rs.getInt("age");
            String first = rs.getString("first");
            String last = rs.getString("last");
//Display values 
            System.out.print("ID: " + id);
            System.out.print(", Age: " + age);
            System.out.print(", First: " + first);
            System.out.println(", Last: " + last);
//Delete row 
            rs.deleteRow();
            System.out.println(
                    "List result set after deleting one records.");
            printRs(rs);

            //STEP 8: Clean-up environment, baremos y nos vamos
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
//Handle errors for DDBC 
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
//finally block used to close resources 
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try }//end try

            System.out.println("Goodbye!");
        }//end main
    }

    public static void printRs(ResultSet rs) throws SQLException {
//Ensure we start with first row 
        rs.beforeFirst();
        while (rs.next()) {
//Retrieve by column name 
            int id = rs.getInt("id");
            int año = rs.getInt("age");
            String nombre = rs.getString("first");
            String apellido = rs.getString("last");
//Display values 
            System.out.print("ID: " + id);
            System.out.print(", Nombre: " + nombre);
            System.out.print(", Age: "+ año);
            System.out.println(", Apellido: " + apellido);
        }
        System.out.println();
    }//end printRs()
}//end DDBCExample

