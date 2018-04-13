 // DDBC driver name and database URL
    static final String DDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/empleados";//nombre de la bd

    // Database credentials niño la pazzwork
    static final String USER = "pepe";
    static final String PASS = "pepa";

//STEP 1: Establecemos la conexion 
    Connection conn = null;

//STEP 2: Register DDBC driver: que driver vamos a usar
	Class.forName("com.mysql.jdbc.Driver");

//STEP 3: Open a connection: Nos conectamosç
	conn = DriverManager.getConnection(DB_URL, USER, PASS); 
	//pasamos url, user, pass

//STEP 4: Execute a query to create statment with  required arguments. 
/*
	Al crear una sentencia le decimos el scroll, como nos movemos
    despues le indicamos como actualizamos
*/
	Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

//STEP 5: Execute a query
	String sql = "SELECT * FROM empleados";
	//Guarda el resultado de la consulta.
	ResultSet rs = stmt.executeQuery(sql);
	printRs(rs);

//STEP 6: Update con codigo sql
	System.out.println("-- Update --");
	int update = stmt.executeUpdate("update empleados set age = age - 5 where id = 1");
// Update moviendonos por el ResutlSet :)
    rs.beforeFirst();//nos situamos antes del principio
    while (rs.next()) {//avanza el puntero al siguiente si puede true sino false
        //Retrieve by column name
        int newAge = rs.getInt("age") - 20;
        rs.updateInt("age", newAge);
        rs.updateRow();
    }
            
// Insertamos un nuevo elemento, para ello:
    rs.moveToInsertRow(); // Nos situamos en la fila de insertar
    // Actualizamos los valores
    rs.updateInt("id", 703); 
    rs.updateString("first", "Antonio");
    rs.updateString("last", "Paul");
    rs.updateInt("age", 40);
    //Insertamos la filaa
    rs.insertRow();

// Borrar un elemento
    //Posicionamos el puntero
    rs.absolute(2);
    // Y borramos donde apunta el puntero
    rs.deleteRow();

//STEP 7: Si queremos ver la tabla despues de modificar el stmt
// volvemos a ejecutar la consulta
	rs = stmt.executeQuery(sql);
	printRs(rs);


//STEP 8: Clean-up environment, baremos y nos vamos
    rs.close();
    stmt.close();
    conn.close();


/**
 * Metodo para recorer un RestultSet
 * 
*/
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
            System.out.print(", Age: " + año);
            System.out.println(", Apellido: " + apellido);
        }



public String toStringRS(ResultSet rs) {
    String result ="";
    int nCol = meta.getColumnCount();
    String[] nombreColumnas = new String[nCol];
    String[] tipoColumnas = new String[nCol];
    Object[] valColumnas = new Object[nCol];
    for (int i = 0; i < nCol; i++) {
        nombreColumnas[i] = meta.getColumnName(i + 1);
        tipoColumnas[i] = meta.getColumnTypeName(i + 1);
    }
    for (int i = 0; i < nCol; i++) {
        result += nombreColumnas[i] + "\t";//[" + tipoColumnas[i] + "]
    }
    result += "\n";
    rs.beforeFirst();
    while (rs.next()) {
        for (int i = 0; i < nCol; i++) {
            valColumnas[i] = rs.getObject(i + 1);
        }
        for (int i = 0; i < nCol; i++) {
           result += valColumnas[i].toString()+"\t";
        }
        result += "\n";
    }
}
