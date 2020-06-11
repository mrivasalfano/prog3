package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GrafoDirigido {
    private HashMap<Integer, Vertice> vertices;

    public GrafoDirigido() {
        this.vertices = new HashMap<>();
    }

    //La complejidad depende del método put
    //ya que a mi entender realiza una inserción
    //ordenada. Diría que su complejidad puede ser
    //O(log n) donde n es la cantidad de vértices
    public void addVertice(int id) {
        if (!this.vertices.containsKey(id)) {
            Vertice v = new Vertice(id);
            this.vertices.put(id, v);
        }
    }

    //Complejidad: O(1)
    public Iterator<Integer> obtenerVertices() {
       return this.vertices.keySet().iterator();
    }

    //Complejidad: O(1)
    public Iterator<Arco> obtenerArcos(int id) {
        return this.vertices.get(id).iterator();
    }

    //La complejidad es O(v * a) donde
    //v es la cantidad de vértices y a
    //la cantidad de vértices adyacentes
    //(o sea sus arcos)
    public void borrarVertice(int id) {
        this.vertices.remove(id);
        this.vertices.forEach((key, v) -> {
            v.deleteArco(id);
        });
    }

    //La complejidad depende del método addArco()
    //el cual realiza un contains a una LinkedList
    //por lo tanto la complejidad es O(n) donde n
    //es la cantidad de arcos en la lista. En el peor
    //de los casos va hasta el final
    public void addArco(int id1, int id2, int etiqueta) {
        Arco a = new Arco(id1, id2, etiqueta);
        this.vertices.get(id1).addArco(a);
    }

    public void addArco(int id1, int id2) {
        Arco a = new Arco(id1, id2);
        this.vertices.get(id1).addArco(a);
    }

    //Complejidad O(1)
    public int cantidadVertices() {
        return this.vertices.size();
    }

    //Complejidad O(n) donde n
    //es la cantidad de vértices
    public int cantidadArcos() {
        AtomicInteger contador = new AtomicInteger();

        this.vertices.forEach((id, v) -> {
            contador.addAndGet(v.cantidadArcos());
        });

        return contador.get();
    }

    //Complejidad O(n) donde n
    //es la cantidad de arcos que
    //tiene el vértice
    public void borrarArco(int id1, int id2) {
        this.vertices.get(id1).deleteArco(id2);
    }

    //La complejidad depende del containsKey
    public boolean hasVertice(int id) {
        return this.vertices.containsKey(id);
    }

    //Complejidad O(n) donde n es
    //la cantidad de arcos del vértice tmp
    public boolean hasArco(int id1, int id2) {
        Vertice tmp = this.vertices.get(id1);
        if (tmp != null)
            return tmp.hasArco(id2);
        else
            return false;
    }

    //La complejidad des O(|V| + |A|)
    //donde V son todos los vértices
    //y A todos los arcos del grafo
    public boolean hasCiclo() {
        vertices.forEach((id, v) -> v.setStatus(0));
        AtomicBoolean tiene = new AtomicBoolean(false);

        vertices.forEach((id, v) -> {
            if (v.getStatus() == 0) {
                if (!tiene.get())
                    tiene.set(this.hasCiclo(v));
            }
        });

        return tiene.get();
    }

    private boolean hasCiclo(Vertice v) {
        v.setStatus(1);
        LinkedList<Arco> arcos = v.getArcos();

        for (Arco a : arcos) {
            Vertice adyacente = this.vertices.get(a.getDestino());

            if (adyacente.getStatus() == 0) {
                if (this.hasCiclo(adyacente))
                    return true;
            }
            else if (adyacente.getStatus() == 1)
                return true;
        }

        v.setStatus(2);

        return false;
    }

    //La complejidad des O(|V| + |A|)
    //donde V son todos los vértices
    //y A todos los arcos del grafo
    public ArrayList<Integer> DFS() {
        //0 = blanco
        //1 = amarillo
        //2 = negro
        //pongo todos los vértices en 0
        vertices.forEach((id, v) -> v.setStatus(0));

        int tiempo = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        //por cada vértice, si está en 0 lo visito y agrego a la lista
        vertices.forEach((id, v) -> tmp.addAll(this.checkDFS(id, tiempo)));

        return tmp;
    }

    private ArrayList<Integer> checkDFS(int id, int tiempo) {
        ArrayList<Integer> tmp = new ArrayList<>();

        if (this.vertices.get(id).getStatus() == 0) {
            tmp.addAll(this.DFS_Vertice(id, tiempo));
        }
        return tmp;
    }

    private ArrayList<Integer> DFS_Vertice(int id, int tiempo) {
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(id);
        Vertice v = this.vertices.get(id);
        v.setStatus(1);
        tiempo++;
        v.setI(tiempo);
        LinkedList<Arco> arcos = v.getArcos();

        for (Arco a : arcos) {
            Vertice adyacente = this.vertices.get(a.getDestino());

            if (adyacente.getStatus() == 0)
                tmp.addAll(this.DFS_Vertice(a.getDestino(), tiempo));
        }

        v.setStatus(2);
        tiempo++;
        v.setF(tiempo);

        return tmp;
    }

    //La complejidad des O(|V| + |A|)
    //donde V son todos los vértices
    //y A todos los arcos del grafo
    public ArrayList<Integer> BFS() {
        //status 0 es NO visitado
        //status 1 es visitado
        ArrayList<Integer> tmp = new ArrayList<>();

        vertices.forEach((id, v) -> {
            v.setStatus(0);
        });

        vertices.forEach((id, v) -> {
            if (v.getStatus() == 0)
                tmp.addAll(this.BFS(v));
        });

        return tmp;
    }

    private ArrayList<Integer> BFS(Vertice v) {
        ArrayList<Vertice> fila = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();

        v.setStatus(1);
        fila.add(v);

        while (fila.size() > 0) {
            Vertice sacado = fila.get(0);

            tmp.add(sacado.getId());

            LinkedList<Arco> arcos = sacado.getArcos();
            fila.remove(0);

            for (Arco arc : arcos) {
                int id = arc.getDestino();
                Vertice adyacente = this.vertices.get(id);

                if (adyacente.getStatus() == 0) {
                    adyacente.setStatus(1);
                    fila.add(adyacente);
                }
            }
        }

        return tmp;
    }

    
    public LinkedList<Integer> getCaminoLargo(int vi, int vd) {
        //camino a devolver
        LinkedList<Integer> camino = new LinkedList<>();

        //pongo los vértices en 0
        this.vertices.forEach((id, v) -> {
            v.setStatus(0);
        });

        Iterator<Arco> it = this.vertices.get(vi).iterator();

        //recorro los arcos del vertice inicio
        while (it.hasNext()) {
            //agarro cada vértice adyacente a vértice inicio
            //pido su camino hasta vértice destino
            //si es mayor al camino ya guardado lo intercambio
            Vertice v = this.vertices.get(it.next().getDestino());
            LinkedList<Integer> tmp = this.getCaminoLargo(v, vd);
            if (tmp.size() > camino.size())
                camino = tmp;
        }
        
        return camino;
    }

    private LinkedList<Integer> getCaminoLargo(Vertice v, int x) {
        LinkedList<Integer> tmp = new LinkedList<>();

        //si el vértice es el que estoy buscando
        //lo agrego al tmp y devuelvo
        if (v.getId() == x) {
            tmp.add(v.getId());
            return tmp;
        }
        else {
            //si no es el destino lo pongo en 1
            //para saber que ya pasé
            v.setStatus(1);
            Iterator<Arco> it = v.iterator();

            //recorro los adyacentes y si no están pintados
            //les pido el camino hacia el destino que estoy
            //buscando
            while (it.hasNext()) {
                Arco arc = it.next();
                Vertice destino = this.vertices.get(arc.getDestino());

                if (destino.getStatus() == 0) {
                    //me agrego yo y despues agrego
                    //el camino de mis adyacentes
                    LinkedList<Integer> aux = this.getCaminoLargo(destino, x);
                    if ((aux.size() + 1) > tmp.size()) {
                        tmp.clear();
                        tmp.add(v.getId());
                        tmp.addAll(aux);
                    }
                }
            }
        }

        //me pongo en 0 así pueden volver a pasar
        v.setStatus(0);

        //si al final del camino no está
        //el destino que busco devuelvo
        //el camino pero vacío
        if (tmp.size() > 0 && tmp.getLast() == x)
            return tmp;
        else {
            tmp.clear();
            return tmp;
        }
    }

}
