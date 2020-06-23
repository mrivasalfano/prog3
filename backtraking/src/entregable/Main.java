package entregable;

import entregable.Backtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String... args) {
        CSVReader reader = new CSVReader("./data/familias-1.csv");

        ArrayList<Familia> familias = reader.read();
        ArrayList<Visita> dias = new ArrayList<>();
        int lugares = 30;
        int cantDias = 10;

        for (int i = 1; i <= cantDias; i++) {
            dias.add(new Visita(i, lugares));
        }

        Backtracking backtracking = new Backtracking(dias, familias);
        ArrayList<Visita> visitas = backtracking.getVisitas();

        for(Visita vis : visitas) {
            System.out.println("--- Día: " + vis.getDia() + " | Lugares restantes: " + vis.getLugares() + " ---");

            Iterator<Familia> itFamilias = vis.iterator();

            while(itFamilias.hasNext()) {
                Familia fam = itFamilias.next();

                System.out.println("   " + fam);
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("Bono compensatorio: " + backtracking.getBono());
        System.out.println("Cantidad de estados: " + backtracking.getEstados());

//        CSVReader reader2 = new CSVReader("./data/familias-2.csv");
//
//        ArrayList<Familia> familias2 = reader2.read();
//
//        for (Familia familia: familias2)
//            System.out.println(familia);
    }
}
