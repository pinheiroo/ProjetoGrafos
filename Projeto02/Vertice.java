import java.util.*;
public class Vertice {
    private int num;
    private int excentricidade;
    private ArrayList<Vertice> adjacencias;
    private int pi;
    private int d;
    private boolean visitado;

    public Vertice(int num){
        this.num = num;
        visitado = false;
    }

    public int getGrau(){
        return adjacencias.size();
    }

    public ArrayList<Vertice> getAdjacencias(){
        return adjacencias;
    }
    public 

}
