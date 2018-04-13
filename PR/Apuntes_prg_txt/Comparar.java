public class numeros implements Comparable <Tipo> {
	private int num;

	// ... Demas cosas 

	public int Comparable(Tipo o){
		return Integer.compareTo(this.num, o.getNum());
	}

}


public class comparaFecha implements Comparator <ClaseCadenas> {

	public int Comparator(ClaseCadenas c1, ClaseCadenas c2) {
		return c1.compareTo(c2);
	}

}

public class principal {

	public static void main(Args[] arg){
		
		ArrayList lista = new ArrayList(),

		lista.add(new numeros(5));
		lista.add(new numeros(3));
		lista.add(new numeros(6));
		lista.add(new numeros(1));
		lista.add(new numeros(0));

		lista.sort(null); // Se ordena segun el Comparable

		lista.sort(new comparaFecha()); // Se ordena segun el Comparator de la clase

	}

}