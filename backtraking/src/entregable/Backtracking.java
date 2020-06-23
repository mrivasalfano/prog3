package entregable;

import java.util.ArrayList;

public class Backtracking {
    private ArrayList<Visita> dias;
    private ArrayList<Visita> diasOptimos;
    private ArrayList<Familia> familias;
    private int mejorBono;
    private int bonoActual;
    private int estados;

    public Backtracking(ArrayList<Visita> dias, ArrayList<Familia> familias) {
        this.familias = familias;
        this.diasOptimos = new ArrayList<>();
        this.dias = dias;
        this.mejorBono = Integer.MAX_VALUE;
        this.bonoActual = 0;
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
            if(this.bonoActual < this.mejorBono) {
                this.mejorBono = this.bonoActual;
                this.copiarArreglo();
            }
        }
        else {
            Familia fam = familias.get(famIndex);

            for (int i = 0; i < fam.cantDias(); i++) {
                int indexDia = fam.preferenciaEn(i);
                Visita dia = this.dias.get(indexDia-1);

                //calculo el bono siempre y cuando no vaya a su día preferido
                int calcBono = 0;

                if(fam.diaPreferido() != indexDia) {
                    calcBono = 25 + (10 * fam.miembros()) + (5 * (i+1));
                    this.bonoActual += calcBono;
                }

                //si el bono actual no es mayor al mejor bono
                //y si puedo agregar la familia al día
                if(!(this.bonoActual > this.mejorBono) && dia.addFamilia(fam)) {


                    this.getVisitas(famIndex+1);

                    dia.removeFamilia();
                }

                this.bonoActual -= calcBono;
            }
        }
    }
}
