package entregable;

import java.util.ArrayList;
import java.util.LinkedList;

public class Backtracking {
    private ArrayList<Visita> dias;
    private ArrayList<Visita> diasOptimos;
    private ArrayList<Familia> familias;
    private int mejorBono;
    private int bono;
    private int estados;

    public Backtracking(ArrayList<Visita> dias, ArrayList<Familia> familias) {
        this.familias = familias;
        this.diasOptimos = new ArrayList<>();
        this.dias = dias;
        this.mejorBono = Integer.MAX_VALUE;
        this.bono = 0;
        this.estados = 0;
    }

    public ArrayList<Visita> getVisitas() {
        this.getVisitas(0);
        return this.diasOptimos;
    }

    public int getBono() {
        return this.mejorBono;
    }

    public int getEstados() {
        return this.estados;
    }

    public void copiarArreglo() {
        this.diasOptimos.clear();

        for (int i = 0; i < this.dias.size(); i++) {
            this.diasOptimos.add(this.dias.get(i).clone());
        }
    }

    private void getVisitas(int famIndex) {
        //contador de estados visitados
        this.estados++;
        
        //si mi indice se pasa es que ya probé con todas las familias
        if(famIndex == this.familias.size()) {
            if(this.bono < this.mejorBono) {
                this.mejorBono = this.bono;
                this.copiarArreglo();
            }
        }
        else {
            Familia fam = familias.get(famIndex);

            for (int i = 0; i < fam.cantDias(); i++) {
                int indexDia = fam.preferenciaEn(i);
                Visita dia = this.dias.get(indexDia-1);

                //si puedo agregar la familia al día
                if(dia.addFamilia(fam)) {
                    //calculo el bono siempre y cuando no vaya a su día preferido
                    int calcBono = 0;

                    if(fam.diaPreferido() != indexDia) {
                        calcBono = 25 + (10 * fam.miembros()) + (5 * (i+1));
                        this.bono += calcBono;
                    }

                    this.getVisitas(famIndex+1);

                    dia.removeFamilia();
                    this.bono -= calcBono;
                }

            }
        }
    }
}
