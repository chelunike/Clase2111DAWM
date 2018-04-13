
HashMap <String, String[]> paisCiudades new HashMap <String, String[]>();

//Insertar
paisCiudades.put("España", new String[]{"Granada", "Madrid", "HuertoVega", "Valencia", "Er Zaidin Sity"});
paisCiudades.put("Francia", new String[]{"Paris", "Lyon", "Burdeos"});
paisCiudades.put("Portugal", new String[]{"Lisboa", "Setubal", "Oporto"});
paisCiudades.put("PatataLandia", new String[]{"Tuberculo", "PatataDC", "Huertos en la Vega"});

//Array de las claves
paisCiudades.keySet().toArray(new String[0]);

//Array de los datos al que apunta la clave
paisCiudades.get(pais);

// -------------------------------- JComboBox ------------------------------------

//Para pasar al ComboBox los datos desde el principio se le pasan al constructor.
private JComboBox paisCb, ciudadCb;
paisCb = new JComboBox(datos.damePais());
ciudadCb = new JComboBox(new String[0]);

//Seleccionar en un comboBOx
paisCb.setSelectedItem("España");

//Sacar el elemento Seleccionado de un ComboBox
paisCb.getSelectedItem()

//Rellenar de nuevo un comboBox
//Metodo 1
ciudadCb.removeAllItems();
for(String ciudad: datos.dameCiudades(pais))
    ciudadCb.addItem(ciudad);

//Metodo 2
ciudadCb.setModel(new DefaultComboBoxModel(datos.dameCiudades(pais)));

