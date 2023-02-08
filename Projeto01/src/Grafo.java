import java.util.ArrayList;


class Grafo{

    private int v;
    private int a=0;
    private ArrayList<Integer>[] lista;

    public Grafo(int v){
        this.v = v;
        setGrafo();
    }
    public void setGrafo(){
        lista = (ArrayList<Integer>[]) new ArrayList[v];
        for(int i=0;i<v;i++){
            lista[i]=new ArrayList<>();
        }
    }
    public int getV(){
        return v;
    }
    public int getA(){
        return a;
    }
    public void adicionaAresta(int u, int v){
        lista[u].add(v);
        lista[v].add(u);
        this.a++;
    }

    public int grau(int v){
        return lista[v].size();
    }

    public ArrayList<Integer> adj(int v){
        return lista[v];
    }

    public String toString(){
        int i;
        for (i=0;i<v-1;i++){
            System.out.print(i + "->" + lista[i].toString()+"\n");
        }
        System.out.print(i + "->");
        return lista[v-1].toString();
    }
}
