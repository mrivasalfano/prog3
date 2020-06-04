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

				System.out.println("   Familia: " + f.getId() + " | Día preferido: " + f.diaPreferido() + " | Miembros: " + f.getMiembros() + " | Lugares restantes del día: " + (lugares-=f.getMiembros()));
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

			if (cont > 1) {
				int formula = (25 + (10 * fam.getMiembros()) + (5 * (cont-1)));
				bonos += formula;
				fam.setBono(formula);
			}
		}

		int bonoMejorado = mejorarAsignacion(dias, bonos);

		return bonoMejorado;
	}

	public static int mejorarAsignacion(ArrayList<Visita> dias, int bonos) {
		//por cada día
		for (Visita visita : dias) {
			//recorro sus familias
			int index = 0;

			while (index < visita.cantFamilias()) {
				Familia fam = visita.getFamilia(index);

				//si el día es distinto al día preferido que deseaba
				if (fam.diaPreferido() != visita.getDia()) {
					//busco el día preferido
					Visita diaPreferido = dias.get(fam.diaPreferido()-1);

					//veo con qué familia podría
					//cambiarla la cual su día preferido tampoco sea
					//en el que está
					Iterator<Familia> familias2 = diaPreferido.iterator();

					boolean sigo = true;

					while (familias2.hasNext() && sigo) {
						Familia fam2 = familias2.next();

						//si el dia preferido de esta familia es igual
						//al dia en el que estaba la familia original
						//hago un intercambio siempre que quepan
						//en los lugares. O también
						//si la familia 2 está en un día
						//que tampoco es su preferido
						//puedo intercambiarla ya que
						//no me afecta tanto y la familia 1
						//va a ir a su dia preferido
						if (fam2.diaPreferido() != diaPreferido.getDia() && fam2.indiceDePreferencia(visita.getDia()) != -1) {
							int nuevoBono = calcularBono(fam2, visita.getDia());

							if (
									((diaPreferido.getLugares() - fam2.getMiembros() + fam.getMiembros()) >= 0) &&
									((visita.getLugares() - fam.getMiembros() + fam2.getMiembros()) >= 0) &&
									(fam.getBono() + fam2.getBono()) > (nuevoBono)
							) {
								//remuevo la familia original
								visita.removeFamilia(index);
								//remuevo la familia a intercambiar
								familias2.remove();
								//agrego la familia a intercambiar
								//al dia en el que esta la original
								visita.addFamilia(fam2);
								//agrego la familia original a su
								//dia preferido
								diaPreferido.addFamilia(fam);
								bonos -= fam.getBono();
								bonos -= fam2.getBono();
								bonos += nuevoBono;
								fam.setBono(0);
								fam2.setBono(nuevoBono);
								sigo = false;
							}
						}
					}
				}

				index++;
			}
		}

		return bonos;
	}

	private static int calcularBono(Familia fam, int dia) {
		return (25 + (10 * fam.getMiembros()) + (5 * fam.indiceDePreferencia(dia)));
	}
}
