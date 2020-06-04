package classes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Collectors;

/* Una familia, con su cantidad de dias, y una arreglo con el top de 4 dias preferidos */
public class Familia implements Comparable<Familia>, Iterable<Integer>{

	private int id;
	private int miembros;
	private int[] diasPreferidos;
	
	public Familia(int id, int miembros, int... diasPreferidos) {
		this.id = id;
		this.miembros = miembros;
		this.diasPreferidos = diasPreferidos;
	}

	/* Id de la familia */
	public int getId() {
		return id;
	}

	public int getMiembros() {
		return this.miembros;
	}

	/* Retorna la cantidad de miembros de la familia. */
	public int miembros() {
		return miembros;
	}

	
	/* Dado un indice entre 0 y 4, retorna el d�a preferido por la familia para ese indice. */
	public int preferenciaEn(int indice) {
		return this.diasPreferidos[indice];
	}
	
	/* Retorna el d�a preferido de la familia */
	public int diaPreferido() {
		return preferenciaEn(0);
	}
	
	/* Dado un dia pasado por parametro, indica el orden de ese dia en el top 5 de preferencias.
	Si el dia no forma parte de las preferencias del usuario, se retorna -1. */ 
	public int indiceDePreferencia(int dia) {
		for (int indice = 0; indice < diasPreferidos.length; indice++)
			if (dia == diasPreferidos[indice])
				return indice;
		return -1;
	}

	@Override
	public String toString() {
		return "Familia: id=" + id + ", miembros=" + miembros + ", preferencias=" + Arrays.toString(diasPreferidos);
	}

	@Override
	public int compareTo(Familia o) {
		return this.miembros - o.getMiembros();
	}

	@Override
	public Iterator<Integer> iterator() {
		return Arrays.stream(this.diasPreferidos).boxed().collect(Collectors.toList()).iterator();
	}
}
