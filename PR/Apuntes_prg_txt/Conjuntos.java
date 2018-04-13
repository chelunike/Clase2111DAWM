// :)

conjunto1 ( 1 ,4, 6, 7)
conjunto2 ( 1, 2, 5, 6)

ArrayList <Elemento> c1;
ArrayList <Elemento> c2;

insterseccion (1, 6) //Elementos comunes en ambos conjuntos.

ArrayList <Elemento> resultado;
for(Elemento ele: c1){
	if(c2.contains(ele))
		resultado.add(ele);
}
return resultado;

union (1, 2, 4, 5, 6, 7) // Elementos comunes y no comunes en ambos conjuntos.

ArrayList <Elemento> resultado = c1;
for(Elemento ele: c2){
	if(!c1.contains(ele))
		resultado.add(ele);
}
return resultado;

diferencia (2, 4, 5, 7) // Elementos no comunes en ambos conjuntos.

ArrayList <Elemento> resultado=c1;
for(Elemento ele: c1){
	if(c2.contains(ele))
		resultado.add(ele);
}
for(Elemento ele: c2){
	if(c1.contains(ele) and !resultado.contains(ele))
		resultado.add(ele);
}
return resultado;
