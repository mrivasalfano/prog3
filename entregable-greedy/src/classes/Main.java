package classes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;

public class Main {
	public static void main(String... args) {
		CSVReader reader = new CSVReader("./data/familias.csv");

		LinkedList<Familia> familias = reader.read();
		ArrayList<Visita> dias = new ArrayList<>();
		int cantDias = 100;

		//creo las visitas para cada día
		for (int i = 1; i <= cantDias; i++) {
			dias.add(new Visita(i, 340));
		}

		int bonos[] = {0};

		asignarFamilias(familias, dias, bonos);
		int cont = 0;

		for (Visita v : dias) {
			int lugares = 340;

			cont+=v.cantFamilias();
			System.out.println("Día: " + v.getDia() + " | Cantidad de familias: " + v.cantFamilias());
			Iterator<Familia> it = v.iterator();

			while (it.hasNext()) {
				Familia f = it.next();

				System.out.println("   Familia: " + f.getId() + " | Miembros: " + f.getMiembros() + " | Lugares restantes: " + (lugares-=f.getMiembros()));
			}
		}

		System.out.println("Cantidad total de familias asignadas: " + cont);
		System.out.println("Cantidad a pagar por bonos compensatorios: " + bonos[0]);
	}

	public static void asignarFamilias(LinkedList<Familia> familias, ArrayList<Visita> dias, int[] bonos) {
//		LinkedList<Visita> seleccionados = new LinkedList<>();

		Collections.sort(familias);
//		Collections.reverse(familias);

		//&& !solucion(familias) saqué eso porque la
		//solución me decía si familia no está vacío
		//y ya lo pregunto al principio
		while (!familias.isEmpty() ) {
			Familia x = seleccionar(familias);
			familias.remove(x);

			factible(x, dias, bonos);
		}

		//como edito los objetos días que paso por parámetro
		//no necesito devolver nada por ahora
//		if (solucion(familias))
//			return seleccionados;
//		else
//			return new LinkedList<Visita>();
	}

	private static void factible(Familia x, ArrayList<Visita> dias, int[] bonos) {
		Visita diaPreferido = dias.get(x.diaPreferido()-1);
		int cantMiembros = x.getMiembros();

		//intento agregar la familia a su dia preferido.
		//En caso de no poder me responde false entonces
		//pruebo con los demás
		if (!diaPreferido.addFamilia(x)) {
			Iterator<Integer> diasPreferidos = x.iterator();
			diasPreferidos.next();

			boolean sigo = true;
			int cont = 0;

			while(diasPreferidos.hasNext() && sigo) {
				int dia = diasPreferidos.next();
				Visita v = dias.get(dia-1);

				if (v.addFamilia(x))
					sigo = false;

				cont++;
			}

			bonos[0] += (25 + (10 * cantMiembros) + (5 * cont));
		}
	}

	private static Familia seleccionar(LinkedList<Familia> familias) {
		return familias.getFirst();
	}

	private static boolean solucion(LinkedList<Familia> familias) {
		return familias.isEmpty();
	}
}
