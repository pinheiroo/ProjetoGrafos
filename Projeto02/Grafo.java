import java.util.*;


class Grafo{

    private int v;
    private int a=0;
    private ArrayList<Vertice> listaVertices;
    private ArrayList<Aresta> listaArestas;
    


    public Grafo(int v){
        this.v = v;
        setGrafo();
    }
    public void setGrafo(){
        listaVertices = new ArrayList<Vertice>();
        for(int i=0;i<v;i++){
            listaVertices.add(new Vertice(i));
        }
    }
    public int getV(){
        return v;
    }
    public int getA(){
        return a;
    }
    public void adicionaAresta(int u, int v, int peso){
        listaArestas.add(new Aresta(u,v,peso));
        listaVertices.get(u).
    }
    
    // public String toString(){
    //     int i;
    //     for (i=0;i<v-1;i++){
    //         System.out.print(i + "->" + lista[i].toString()+"\n");
    //     }
    //     System.out.print(i + "->");
    //     return lista[v-1].toString();
    // }
}


