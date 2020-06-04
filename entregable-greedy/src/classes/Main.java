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

		int bonos = asignarFamilias(familias, dias);
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
		System.out.println("Cantidad a pagar por bonos compensatorios: " + bonos);
	}

	public static int asignarFamilias(LinkedList<Familia> familias, ArrayList<Visita> dias) {
		int bonos = 0;
		Collections.sort(familias);

		while (!familias.isEmpty()) {
			Familia fam = familias.getFirst();
			familias.remove(0);

			//itero los días de la familia como candidatos
			Iterator<Integer> diasFamilia = fam.iterator();
			int cont = 0;
			boolean sigo = true;

			while (diasFamilia.hasNext() && sigo) {
				int numDia = diasFamilia.next();
				Visita dia = dias.get(numDia-1);

				if (dia.aceptaFamilia(fam)) {
					dia.addFamilia(fam);
					sigo = false;
				}

				cont++;
			}

			if (cont > 1)
				bonos += (25 + (10 * fam.getMiembros()) + (5 * (cont-1)));
		}

		return bonos;
	}
}
